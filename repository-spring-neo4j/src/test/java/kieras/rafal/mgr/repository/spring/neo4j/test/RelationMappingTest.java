package kieras.rafal.mgr.repository.spring.neo4j.test;

import java.util.Date;
import kieras.rafal.mgr.repository.CourseRepository;
import kieras.rafal.mgr.repository.DepartmentRepository;
import kieras.rafal.mgr.repository.EnrollmentRepository;
import kieras.rafal.mgr.repository.InstructorRepository;
import kieras.rafal.mgr.repository.OfficeRepository;
import kieras.rafal.mgr.repository.StudentRepository;
import kieras.rafal.mgr.repository.entity.Address;
import kieras.rafal.mgr.repository.entity.Course;
import kieras.rafal.mgr.repository.entity.Enrollment;
import kieras.rafal.mgr.repository.entity.Instructor;
import kieras.rafal.mgr.repository.entity.Office;
import kieras.rafal.mgr.repository.entity.Student;
import kieras.rafal.mgr.util.PrimaryKeyGenerator;
import kieras.rafal.mgr.util.test.SpringContextRule;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.springframework.beans.factory.annotation.Autowired;

public class RelationMappingTest {

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
    public void EnrollStudentToCourseTest() {
        Student student = new Student();
        student.setId(primaryKeyGenerator.generateId());
        student.setFirstName("Jan");
        student.setLastName("Nowak");
        
        Course course = new Course();
        course.setDate(new Date());
        course.setId(primaryKeyGenerator.generateId());
        course.setName("Coruse 1");
        
        courseRepository.add(course);
        studentRepository.add(student);
        
        Enrollment enrollment = new Enrollment();
        enrollment.setEnrollmentDate(new Date());
        enrollment.setCourse(course);
        enrollment.setStudent(student);
        enrollment.setId(primaryKeyGenerator.generateId());
        
        enrollmentRepository.add(enrollment);
        
        Student foundStudent = studentRepository.find(student.getId());
        Course foundCourse = courseRepository.find(course.getId());
        
        assertEquals(foundStudent.getEnrollments().size(), 1);
        assertEquals(foundCourse.getEnrollments().size(), 1);        
    }
    
    @Test
    public void CourseWithOfficeAndInstructorTest() {
        Office office = new Office();
        Address address = new Address();
        address.setCity("Krakow");
        address.setPostCode("36-772");
        address.setStreet("Czarnowiejska");
        office.setAddress(address);
        office.setId(primaryKeyGenerator.generateId());
        officeRepository.add(office);
        
        Instructor instructor = new Instructor();
        instructor.setFirstName("Jan");
        instructor.setLastName("Kowalski");
        instructor.setId(primaryKeyGenerator.generateId());
        instructorRepository.add(instructor);
        
        Course course = new Course();
        course.setOffice(office);
        course.setInstructor(instructor);
        course.setName("Course 1");
        course.setDate(new Date());
        course.setId(primaryKeyGenerator.generateId());
        
        courseRepository.add(course);
        
        Instructor foundInstructor = instructorRepository.find(instructor.getId());
        Office foundOffice = officeRepository.find(office.getId());
        
        assertEquals(foundInstructor.getCourses().size(), 1);
        assertEquals(foundOffice.getCourses().size(), 1);
    }
}
