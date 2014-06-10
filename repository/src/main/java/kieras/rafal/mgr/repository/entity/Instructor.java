package kieras.rafal.mgr.repository.entity;

import java.util.HashSet;
import java.util.Set;

public class Instructor {
    private String firstName;
    
    private String lastName;
    
    private Long id;
    
    private Set<Course> courses = new HashSet<>();
    
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
