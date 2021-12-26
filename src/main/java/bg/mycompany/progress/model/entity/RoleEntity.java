package bg.mycompany.progress.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "roles") @Data @NoArgsConstructor
public class RoleEntity extends BaseEntity{

    @Column(name = "name", nullable = false)
    private String name;
}
