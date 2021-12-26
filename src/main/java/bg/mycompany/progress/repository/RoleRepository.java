package bg.mycompany.progress.repository;

import bg.mycompany.progress.model.entity.RoleEntity;
import bg.mycompany.progress.model.entity.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

    RoleEntity findByName(RoleEnum name);
}
