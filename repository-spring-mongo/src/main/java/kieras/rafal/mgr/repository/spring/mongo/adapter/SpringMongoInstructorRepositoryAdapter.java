package kieras.rafal.mgr.repository.spring.mongo.adapter;

import java.util.Set;
import kieras.rafal.mgr.repository.InstructorRepository;
import kieras.rafal.mgr.repository.entity.Instructor;
import kieras.rafal.mgr.repository.spring.mongo.SpringMongoCourseRepository;
import kieras.rafal.mgr.repository.spring.mongo.SpringMongoInstructorRepository;
import kieras.rafal.mgr.repository.spring.mongo.entity.SpringMongoCourse;
import kieras.rafal.mgr.repository.spring.mongo.entity.SpringMongoInstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SpringMongoInstructorRepositoryAdapter implements InstructorRepository {
    private static final ModelMapper mapper = new ModelMapper();

    @Autowired
    SpringMongoInstructorRepository instructorRepository;
    
    @Autowired
    SpringMongoCourseRepository courseRepository;

    @Override
    public void add(Instructor entity) {
        instructorRepository.save(mapper.map(entity, SpringMongoInstructor.class));
    }

    @Override
    public Instructor find(Long key) {
        SpringMongoInstructor instructor = instructorRepository.findOne(key);
        if(instructor == null) return null;
        Set<SpringMongoCourse> courses = courseRepository.findByInstructor(instructor);
        instructor.setCourses(courses);
        return mapper.map(instructor, Instructor.class);
    }

    @Override
    public void remove(Long key) {
        instructorRepository.delete(key);
    }

    @Override
    public void update(Instructor entity) {
        instructorRepository.save(mapper.map(entity, SpringMongoInstructor.class));
    }
}
