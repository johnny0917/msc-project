package kieras.rafal.mgr.repository.hibernate.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class HbEnrollment {

    @Id
    private Long id;

    @ManyToOne
    private HbCourse course;

    @ManyToOne
    private HbStudent student;

    private int grade;

    private Date enrollmentDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public HbCourse getCourse() {
        return course;
    }

    public void setCourse(HbCourse course) {
        this.course = course;
    }

    public HbStudent getStudent() {
        return student;
    }

    public void setStudent(HbStudent student) {
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
