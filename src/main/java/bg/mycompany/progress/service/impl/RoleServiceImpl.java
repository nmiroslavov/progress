package bg.mycompany.progress.service.impl;

import bg.mycompany.progress.model.entity.RoleEntity;
import bg.mycompany.progress.model.entity.RoleEnum;
import bg.mycompany.progress.repository.RoleRepository;
import bg.mycompany.progress.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service @AllArgsConstructor @Transactional
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;


    @Override
    public void initRoles() {
        if (roleRepository.count() == 0) {
            RoleEntity userRole = new RoleEntity();
            userRole.setName(RoleEnum.ROLE_USER);
            RoleEntity adminRole = new RoleEntity();
            adminRole.setName(RoleEnum.ROLE_ADMIN);
            roleRepository.saveAll(List.of(userRole, adminRole));
        }
    }

    @Override
    public RoleEntity getUserRole() {
        return roleRepository.findByName(RoleEnum.ROLE_USER);
    }

}
