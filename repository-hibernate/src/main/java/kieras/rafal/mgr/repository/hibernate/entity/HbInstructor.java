package kieras.rafal.mgr.repository.hibernate.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class HbInstructor {
    @Id
    private Long id;
    
    private String firstName;

    private String lastName;

    @OneToMany(mappedBy = "instructor", fetch = FetchType.EAGER)
    private Set<HbCourse> courses = new HashSet<>();
    
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

    public Set<HbCourse> getCourses() {
        return courses;
    }

    public void setCourses(Set<HbCourse> courses) {
        this.courses = courses;
    }
}
