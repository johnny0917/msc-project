package kieras.rafal.mgr.repository.hibernate.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class HbCourse {

    @Id
    private Long id;

    private String name;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<HbEnrollment> enrollments = new HashSet<>();

    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToOne
    private HbOffice office;
    
    @ManyToOne
    private HbInstructor instructor;

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

    public HbOffice getOffice() {
        return office;
    }

    public void setOffice(HbOffice office) {
        this.office = office;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Set<HbEnrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(Set<HbEnrollment> enrollments) {
        this.enrollments = enrollments;
    }

    public HbInstructor getInstructor() {
        return instructor;
    }

    public void setInstructor(HbInstructor instructor) {
        this.instructor = instructor;
    }
}
