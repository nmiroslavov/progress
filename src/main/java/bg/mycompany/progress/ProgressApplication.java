package bg.mycompany.progress;

import bg.mycompany.progress.model.entity.UserEntity;
import bg.mycompany.progress.service.RoleService;
import bg.mycompany.progress.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ProgressApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProgressApplication.class, args);
    }


    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(RoleService roleService) {
        return args -> {
            roleService.initRoles();
        };
    }
}
