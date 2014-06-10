package kieras.rafal.mgr.repository.spring.mongo.entity;

import java.util.HashSet;
import java.util.Set;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class SpringMongoOffice {
    @Id
    private Long id;
    
    private SpringMongoAddress address;
    
    @DBRef
    private Set<SpringMongoCourse> courses = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SpringMongoAddress getAddress() {
        return address;
    }

    public void setAddress(SpringMongoAddress address) {
        this.address = address;
    }

    public Set<SpringMongoCourse> getCourses() {
        return courses;
    }

    public void setCourses(Set<SpringMongoCourse> courses) {
        this.courses = courses;
    }
}
