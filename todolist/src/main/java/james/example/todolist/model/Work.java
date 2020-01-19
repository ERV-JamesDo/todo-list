package james.example.todolist.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import james.example.todolist.enums.STATUS;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author james-do
 *
 */
@Entity
@Table(name = "works")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "startingDate",
"endingDate" }, allowGetters = true)
public class Work {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long workId;

    @NotBlank
    @Getter
    @Setter
    private String workName;

    @NotBlank
    @Getter
    @Setter
    private String status;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Getter
    @Setter
    private Date startingDate;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    @Getter
    @Setter
    private Date endingDate;

    public Work() {

    }

    public Work(String workName, Date startingDate) {
        this.workName = workName;
        this.startingDate = startingDate;
        this.status = STATUS.PLANNING.getValue();
    }

    public Work(String workName, Date startingDate, Date endingDate, STATUS status) {
        this.workName = workName;
        this.startingDate = startingDate;
        this.endingDate = endingDate;
        this.status = status.getValue();
    }
}
