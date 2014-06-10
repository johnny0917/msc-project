package kieras.rafal.mgr.repository.spring.neo4j.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;
import org.springframework.data.neo4j.annotation.RelatedToVia;

@NodeEntity
public class SpringNeo4jCourse {

    @GraphId
    private Long id;

    private String name;

    @RelatedToVia(type = "ENROLLMENT", direction = Direction.INCOMING)
    private Set<SpringNeo4jEnrollment> enrollments = new HashSet<>();

    @RelatedTo
    @Fetch
    private SpringNeo4jOffice office;

    private Date date;

    @RelatedTo
    @Fetch
    private SpringNeo4jInstructor instructor;

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

    public Set<SpringNeo4jEnrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(Set<SpringNeo4jEnrollment> enrollments) {
        this.enrollments = enrollments;
    }

    public SpringNeo4jOffice getOffice() {
        return office;
    }

    public void setOffice(SpringNeo4jOffice office) {
        this.office = office;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public SpringNeo4jInstructor getInstructor() {
        return instructor;
    }

    public void setInstructor(SpringNeo4jInstructor instructor) {
        this.instructor = instructor;
    }
}
