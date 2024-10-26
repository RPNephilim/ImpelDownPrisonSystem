package com.rp.imps.security.config;

import com.rp.imps.security.domain.PrisonUser;
import com.rp.imps.security.domain.repository.PrisonUserRepository;
import com.rp.imps.security.model.request.PrisonUserRequest;
import com.rp.imps.security.model.response.PrisonUserResponse;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Component
@Slf4j
public class PrisonUserDetailsService implements UserDetailsService {

    @Autowired
    private PrisonUserRepository prisonUserRepository;

    @Inject
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return prisonUserRepository.findByUsername(username)
                .orElseThrow(()->new UsernameNotFoundException("User does not exists with username = "+ username));
    }

    public PrisonUserResponse registerUser(PrisonUserRequest userRequest) {
        boolean existingUser = prisonUserRepository.findByUsername(userRequest.getUsername()).isPresent();
        if(existingUser){
            log.error("User already exists by username = {}", userRequest.getUsername());
            throw new RuntimeException("User already exists");
        }

        Set<GrantedAuthority> authorities = new HashSet<>();
        for (String role : userRequest.getRoles()) {
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role);
            authorities.add(authority);
        }
        PrisonUser user = PrisonUser.builder()
                .name(userRequest.getName())
                .username(userRequest.getUsername())
                .password(passwordEncoder.encode(userRequest.getPassword()))
                .authorities(authorities)
                .build();

        prisonUserRepository.save(user);

        return PrisonUserResponse.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(userRequest.getRoles())
                .build();
    }

    public String deleteUser(String username){
        PrisonUser user = prisonUserRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User does not exists with username = "+ username));

        prisonUserRepository.delete(user);
        return "Deleted user with username " + username;
    }

    public PrisonUserResponse getUser(String username){
        PrisonUser user = prisonUserRepository.findByUsername(username)
                .orElseThrow(()->new RuntimeException("User does not exists with username = "+ username));
        return PrisonUserResponse.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .build();
    }

    public PrisonUserResponse updateUser(PrisonUserRequest userRequest){
        PrisonUser user = prisonUserRepository.findByUsername(userRequest.getUsername())
                .orElseThrow(()->new RuntimeException("User does not exists with username = "+ userRequest.getUsername()));
        prisonUserRepository.save(user);

        return PrisonUserResponse.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .build();
    }
}
