package kieras.rafal.mgr.repository.spring.neo4j.adapter;

import kieras.rafal.mgr.repository.CourseRepository;
import kieras.rafal.mgr.repository.entity.Course;
import kieras.rafal.mgr.repository.spring.neo4j.SpringNeo4jCourseRepository;
import kieras.rafal.mgr.repository.spring.neo4j.entity.SpringNeo4jCourse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class SpringNeo4jCourseRepositoryAdapter  implements CourseRepository {
    private static final ModelMapper mapper = new ModelMapper();

    @Autowired
    SpringNeo4jCourseRepository courseRepository;

    @Override
    public void add(Course entity) {
        entity.setId(null);
        SpringNeo4jCourse saved = courseRepository.save(mapper.map(entity, SpringNeo4jCourse.class));
        entity.setId(saved.getId());
    }

    @Override
    public Course find(Long key) {
        SpringNeo4jCourse course = courseRepository.findOne(key);
        if(course == null) return null;
        return mapper.map(course, Course.class);
    }

    @Override
    public void remove(Long key) {
        courseRepository.delete(key);
    }

    @Override
    public void update(Course entity) {
        courseRepository.save(mapper.map(entity, SpringNeo4jCourse.class));
    }
}
