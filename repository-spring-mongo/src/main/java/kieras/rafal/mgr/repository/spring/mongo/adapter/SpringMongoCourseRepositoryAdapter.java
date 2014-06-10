package kieras.rafal.mgr.repository.spring.mongo.adapter;

import java.util.Set;
import kieras.rafal.mgr.repository.CourseRepository;
import kieras.rafal.mgr.repository.entity.Course;
import kieras.rafal.mgr.repository.spring.mongo.SpringMongoCourseRepository;
import kieras.rafal.mgr.repository.spring.mongo.SpringMongoEnrollmentRepository;
import kieras.rafal.mgr.repository.spring.mongo.entity.SpringMongoCourse;
import kieras.rafal.mgr.repository.spring.mongo.entity.SpringMongoEnrollment;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SpringMongoCourseRepositoryAdapter implements CourseRepository {
    private static final ModelMapper mapper = new ModelMapper();

    @Autowired
    SpringMongoCourseRepository courseRepository;
    
    @Autowired
    SpringMongoEnrollmentRepository enrollmentRepository;

    @Override
    public void add(Course entity) {
        courseRepository.save(mapper.map(entity, SpringMongoCourse.class));
    }

    @Override
    public Course find(Long key) {
        SpringMongoCourse course = courseRepository.findOne(key);
        if(course == null) return null;
        Set<SpringMongoEnrollment> enrollments = enrollmentRepository.findByCourse(course);
        course.setEnrollments(enrollments);
        return mapper.map(course, Course.class);
    }

    @Override
    public void remove(Long key) {
        courseRepository.delete(key);
    }

    @Override
    public void update(Course entity) {
        courseRepository.save(mapper.map(entity, SpringMongoCourse.class));
    }
}
