package kieras.rafal.mgr.repository.hibernate.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class HbOffice {

    @Id
    private Long id;

    @Embedded
    private HbAddress address;
    
    @OneToMany(mappedBy = "office", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<HbCourse> courses = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public HbAddress getAddress() {
        return address;
    }

    public void setAddress(HbAddress address) {
        this.address = address;
    }

    public Set<HbCourse> getCourses() {
        return courses;
    }

    public void setCourses(Set<HbCourse> courses) {
        this.courses = courses;
    }

}
