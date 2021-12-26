package bg.mycompany.progress.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data @NoArgsConstructor
public class UserRegisterDto {

    @NotNull
    @Size(min = 4, max = 20, message = "Username must be between 4 and 20 characters")
    private String username;

    @NotNull
    @Size(min = 6, max = 20, message = "Password must be between 6 and 20 characters")
    private String password;

}
