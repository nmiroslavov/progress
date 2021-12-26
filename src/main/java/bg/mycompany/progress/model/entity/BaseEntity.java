package bg.mycompany.progress.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@MappedSuperclass @Data @NoArgsConstructor
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
