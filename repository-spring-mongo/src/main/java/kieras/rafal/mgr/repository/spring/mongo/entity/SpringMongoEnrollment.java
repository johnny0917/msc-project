package kieras.rafal.mgr.repository.spring.mongo.entity;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class SpringMongoEnrollment {
    @Id
    private Long id;
    
    @DBRef
    private SpringMongoCourse course;

    @DBRef
    private SpringMongoStudent student;

    private int grade;

    private Date enrollmentDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SpringMongoCourse getCourse() {
        return course;
    }

    public void setCourse(SpringMongoCourse course) {
        this.course = course;
    }

    public SpringMongoStudent getStudent() {
        return student;
    }

    public void setStudent(SpringMongoStudent student) {
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
