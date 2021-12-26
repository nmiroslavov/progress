package bg.mycompany.progress.web;

import bg.mycompany.progress.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping("/api") @AllArgsConstructor
public class UserController {

    private final UserService userService;



}
