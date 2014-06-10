package kieras.rafal.mgr.repository.hibernate.mongo.test;

import java.util.Date;
import kieras.rafal.mgr.repository.CourseRepository;
import kieras.rafal.mgr.repository.DepartmentRepository;
import kieras.rafal.mgr.repository.EnrollmentRepository;
import kieras.rafal.mgr.repository.InstructorRepository;
import kieras.rafal.mgr.repository.OfficeRepository;
import kieras.rafal.mgr.repository.StudentRepository;
import kieras.rafal.mgr.repository.entity.Address;
import kieras.rafal.mgr.repository.entity.Course;
import kieras.rafal.mgr.repository.entity.Department;
import kieras.rafal.mgr.repository.entity.Enrollment;
import kieras.rafal.mgr.repository.entity.Instructor;
import kieras.rafal.mgr.repository.entity.Office;
import kieras.rafal.mgr.repository.entity.Student;
import kieras.rafal.mgr.util.PrimaryKeyGenerator;
import kieras.rafal.mgr.util.test.SpringContextRule;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.springframework.beans.factory.annotation.Autowired;

public class CrudTest {
    @Rule
    public TestRule springRule = new SpringContextRule(this);

    @Autowired
    CourseRepository courseRepository;
    
    @Autowired
    DepartmentRepository departmentRepository;
    
    @Autowired
    EnrollmentRepository enrollmentRepository;
    
    @Autowired
    InstructorRepository instructorRepository;

    @Autowired
    OfficeRepository officeRepository;
    
    @Autowired
    StudentRepository studentRepository;
    
    @Autowired
    PrimaryKeyGenerator primaryKeyGenerator;

    @Test
    public void CourseCrudTest() {
        Course course = new Course();
        course.setId(primaryKeyGenerator.generateId());
        course.setName("Course1");
        course.setDate(new Date());

        courseRepository.add(course);
        Course found = courseRepository.find(course.getId());
        assertNotNull(found);
        assertEquals(course.getName(), found.getName());

        found.setName("CourseUpdated");
        courseRepository.update(found);
        Course foundUpdated = courseRepository.find(found.getId());

        assertEquals(found.getName(), foundUpdated.getName());
        
        courseRepository.remove(foundUpdated.getId());
        Course removed = courseRepository.find(foundUpdated.getId());
        assertNull(removed);
    }

    @Test
    public void DepartmentCrudTest() {
        Department department = new Department();
        department.setId(primaryKeyGenerator.generateId());
        department.setName("Department 1");

        departmentRepository.add(department);

        Department found = departmentRepository.find(department.getId());
        assertNotNull(found);
        assertEquals(department.getName(), found.getName());
        
        found.setName("Department 2");
        departmentRepository.update(found);
        
        Department foundUpdated = departmentRepository.find(found.getId());
        assertNotNull(foundUpdated);
        assertEquals(found.getName(), foundUpdated.getName());
        
        departmentRepository.remove(foundUpdated.getId());
        Department foundRemoved = departmentRepository.find(foundUpdated.getId());
        assertNull(foundRemoved);
    }
    
    @Test
    public void OfficeCrudTest() {
        Office office = new Office();
        Address address = new Address();
        address.setCity("Krakow");
        address.setPostCode("36-772");
        address.setStreet("Czarnowiejska");
        office.setAddress(address);
        office.setId(1L);
        
        officeRepository.add(office);
        Office found = officeRepository.find(office.getId());
        assertNotNull(found);
        assertEquals(office.getId(), found.getId());
        
        found.getAddress().setPostCode("35-654");
        officeRepository.update(found);
        
        Office foundUpdated = officeRepository.find(found.getId());
        assertNotNull(foundUpdated);
        assertEquals(found.getAddress().getPostCode(), foundUpdated.getAddress().getPostCode());
        
        officeRepository.remove(found.getId());
        Office officeRemoved = officeRepository.find(found.getId());
        assertNull(officeRemoved);
    }
    
    @Test
    public void EnrollmentCrudTest() {
        Enrollment enrollment = new Enrollment();
        enrollment.setId(primaryKeyGenerator.generateId());
        enrollment.setGrade(5);
        enrollment.setEnrollmentDate(new Date());
        
        enrollmentRepository.add(enrollment);
        
        Enrollment found = enrollmentRepository.find(enrollment.getId());
        assertNotNull(found);
        assertEquals(enrollment.getGrade(), found.getGrade());
        
        found.setGrade(6);
        enrollmentRepository.update(found);
        Enrollment foundUpdated = enrollmentRepository.find(found.getId());
        assertNotNull(foundUpdated);
        assertEquals(found.getGrade(), foundUpdated.getGrade());
        
        enrollmentRepository.remove(found.getId());
        Enrollment removed = enrollmentRepository.find(found.getId());
        assertNull(removed);
    }
    
    @Test
    public void InstructorCrudTest() {
        Instructor instructor = new Instructor();
        instructor.setFirstName("Jan");
        instructor.setLastName("Kowalski");
        instructor.setId(primaryKeyGenerator.generateId());
        
        instructorRepository.add(instructor);
        Instructor found = instructorRepository.find(instructor.getId());
        assertEquals(instructor.getFirstName(), found.getFirstName());
        
        found.setFirstName("Marek");
        instructorRepository.update(found);
        
        Instructor foundUpdated = instructorRepository.find(found.getId());
        assertEquals(found.getFirstName(), foundUpdated.getFirstName());
        
        instructorRepository.remove(found.getId());
        Instructor removed = instructorRepository.find(found.getId());
        assertNull(removed);
    }
    
    @Test
    public void StudentCrudTest() {
        Student student = new Student();
        student.setFirstName("Jan");
        student.setLastName("Kowalski");
        student.setId(primaryKeyGenerator.generateId());
        
        studentRepository.add(student);
        Student found = studentRepository.find(student.getId());
        assertEquals(student.getFirstName(), found.getFirstName());
        
        found.setFirstName("Marek");
        studentRepository.update(found);
        
        Student foundUpdated = studentRepository.find(found.getId());
        assertEquals(found.getFirstName(), foundUpdated.getFirstName());
        
        studentRepository.remove(found.getId());
        Student removed = studentRepository.find(found.getId());
        assertNull(removed);
    }
}
