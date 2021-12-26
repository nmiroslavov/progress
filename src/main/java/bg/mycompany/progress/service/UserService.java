package bg.mycompany.progress.service;

import bg.mycompany.progress.model.dto.UserRegisterDto;
import bg.mycompany.progress.model.entity.UserEntity;

public interface UserService {
    UserEntity registerUser(UserRegisterDto userRegisterDto);
}
