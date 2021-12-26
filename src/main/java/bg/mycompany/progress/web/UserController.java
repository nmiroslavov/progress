package bg.mycompany.progress.web;

import bg.mycompany.progress.model.dto.UserRegisterDto;
import bg.mycompany.progress.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController @RequestMapping("/api") @AllArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody @Valid UserRegisterDto userRegisterDto) {
        userService.registerUser(userRegisterDto);
        return ResponseEntity.ok().build();
    }

}
