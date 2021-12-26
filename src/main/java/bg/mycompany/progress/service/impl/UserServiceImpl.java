package bg.mycompany.progress.service.impl;

import bg.mycompany.progress.model.entity.UserEntity;
import bg.mycompany.progress.repository.UserRepository;
import bg.mycompany.progress.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service @AllArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository
                .findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles()
                .forEach(roleEntity ->
                        authorities.add(new SimpleGrantedAuthority(roleEntity.getName())));

        return new User(user.getUsername(), user.getPassword(), authorities);
    }
}
