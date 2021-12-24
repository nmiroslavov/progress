package bg.mycompany.progress.model.entity;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "tasks")
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

    public TaskEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Instant getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(Instant startDateTime) {
        this.startDateTime = startDateTime;
    }

    public PriorityEnum getPriority() {
        return priority;
    }

    public void setPriority(PriorityEnum priority) {
        this.priority = priority;
    }

    public UserEntity getCreator() {
        return creator;
    }

    public void setCreator(UserEntity creator) {
        this.creator = creator;
    }
}
