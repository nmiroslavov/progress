package bg.mycompany.progress.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "tasks") @Data @NoArgsConstructor
public class TaskEntity extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "start_date_time")
    private Instant startDateTime;

    @Enumerated(EnumType.STRING)
    private PriorityEnum priority;

    @ManyToOne
    private UserEntity creator;
}
