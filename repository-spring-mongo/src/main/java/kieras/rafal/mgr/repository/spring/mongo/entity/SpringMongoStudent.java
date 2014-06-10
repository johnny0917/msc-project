package kieras.rafal.mgr.repository.spring.mongo.entity;

import java.util.HashSet;
import java.util.Set;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class SpringMongoStudent {
    @Id
    private Long id;
    
    private String firstName;
    
    private String lastName;
    
    //@DBRef -> Doesn't work, you need to update on your own
    @Transient
    private Set<SpringMongoEnrollment> enrollments = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<SpringMongoEnrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(Set<SpringMongoEnrollment> enrollments) {
        this.enrollments = enrollments;
    }
}
