package kieras.rafal.mgr.repository.spring.neo4j.entity;

import java.util.HashSet;
import java.util.Set;
import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

@NodeEntity
public class SpringNeo4jOffice {

    @GraphId
    private Long id;

    private String phone;
    
    @Fetch
    @RelatedTo
    private SpringNeo4jAddress address;

    @RelatedTo(type = "office", direction = Direction.INCOMING)
    private Set<SpringNeo4jCourse> courses = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SpringNeo4jAddress getAddress() {
        return address;
    }

    public void setAddress(SpringNeo4jAddress address) {
        this.address = address;
    }

    public Set<SpringNeo4jCourse> getCourses() {
        return courses;
    }

    public void setCourses(Set<SpringNeo4jCourse> courses) {
        this.courses = courses;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
}
