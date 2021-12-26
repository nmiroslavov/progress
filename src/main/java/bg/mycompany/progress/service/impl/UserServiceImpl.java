package bg.mycompany.progress.service.impl;

import bg.mycompany.progress.model.dto.UserRegisterDto;
import bg.mycompany.progress.model.entity.UserEntity;
import bg.mycompany.progress.repository.UserRepository;
import bg.mycompany.progress.service.RoleService;
import bg.mycompany.progress.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service @RequiredArgsConstructor @Transactional
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final RoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository
                .findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles()
                .forEach(roleEntity ->
                        authorities.add(new SimpleGrantedAuthority(roleEntity.getName().name())));

        return new User(user.getUsername(), user.getPassword(), authorities);
    }

    @Override
    public UserEntity registerUser(UserRegisterDto userRegisterDto) {

        UserEntity user = new UserEntity();
        user.setUsername(userRegisterDto.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(userRegisterDto.getPassword()));
        user.setRoles(List.of(roleService.getUserRole()));
        user.setTasks(new ArrayList<>());
        userRepository.save(user);
        return null;
    }
}
