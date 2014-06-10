package kieras.rafal.mgr.repository.hibernate.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class HbStudent {
    @Id
    private Long id;
    
    private String firstName;

    private String lastName;
    
    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<HbEnrollment> enrollments = new HashSet<>();

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

    public Set<HbEnrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(Set<HbEnrollment> enrollments) {
        this.enrollments = enrollments;
    }
}
