package kieras.rafal.mgr.repository.spring.neo4j.entity;

import java.util.HashSet;
import java.util.Set;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;
import org.springframework.data.neo4j.annotation.RelatedToVia;

@NodeEntity
public class SpringNeo4jStudent {

    @GraphId
    private Long id;

    private String firstName;

    private String lastName;

    @RelatedToVia
    private Set<SpringNeo4jEnrollment> enrollments = new HashSet<>();

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

    public Set<SpringNeo4jEnrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(Set<SpringNeo4jEnrollment> enrollments) {
        this.enrollments = enrollments;
    }
}
