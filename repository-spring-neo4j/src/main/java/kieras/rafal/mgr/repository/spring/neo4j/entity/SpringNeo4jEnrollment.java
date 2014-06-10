package kieras.rafal.mgr.repository.spring.neo4j.entity;

import java.util.Date;
import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

@RelationshipEntity(type = "ENROLLMENT")
public class SpringNeo4jEnrollment {
    @GraphId
    private Long id;
    
    @EndNode
    private SpringNeo4jCourse course;

    @StartNode
    private SpringNeo4jStudent student;

    private int grade;

    private Date enrollmentDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SpringNeo4jCourse getCourse() {
        return course;
    }

    public void setCourse(SpringNeo4jCourse course) {
        this.course = course;
    }

    public SpringNeo4jStudent getStudent() {
        return student;
    }

    public void setStudent(SpringNeo4jStudent student) {
        this.student = student;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Date getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }
}
