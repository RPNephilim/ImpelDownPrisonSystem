package com.rp.imps.security.model.request;

import com.rp.imps.security.annotation.ValidPassword;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PrisonUserRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String username;
    @NotBlank
    @ValidPassword
    private String password;
    @NotEmpty
    private List<String> roles;
}
