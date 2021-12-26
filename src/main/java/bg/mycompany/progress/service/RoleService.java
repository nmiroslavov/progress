package bg.mycompany.progress.service;

import bg.mycompany.progress.model.entity.RoleEntity;

public interface RoleService {

    void initRoles();

    RoleEntity getUserRole();
}
