package kieras.rafal.mgr.repository.spring.mongo.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class SpringMongoCourse {
    @Id
    private Long id;
    
    private String name;
    
    //@DBRef -> Doesn't work, you need to update on your own
    @Transient
    private Set<SpringMongoEnrollment> enrollments = new HashSet<>();
    
    @DBRef
    private SpringMongoOffice office;

    private Date date;
    
    @DBRef
    private SpringMongoInstructor instructor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<SpringMongoEnrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(Set<SpringMongoEnrollment> enrollments) {
        this.enrollments = enrollments;
    }

    public SpringMongoOffice getOffice() {
        return office;
    }

    public void setOffice(SpringMongoOffice office) {
        this.office = office;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public SpringMongoInstructor getInstructor() {
        return instructor;
    }

    public void setInstructor(SpringMongoInstructor instructor) {
        this.instructor = instructor;
    }
}
