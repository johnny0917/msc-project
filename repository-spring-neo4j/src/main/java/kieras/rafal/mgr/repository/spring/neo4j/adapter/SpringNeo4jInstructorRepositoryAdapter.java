package kieras.rafal.mgr.repository.spring.neo4j.adapter;

import kieras.rafal.mgr.repository.InstructorRepository;
import kieras.rafal.mgr.repository.entity.Instructor;
import kieras.rafal.mgr.repository.spring.neo4j.SpringNeo4jInstructorRepository;
import kieras.rafal.mgr.repository.spring.neo4j.entity.SpringNeo4jInstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class SpringNeo4jInstructorRepositoryAdapter  implements InstructorRepository {
    private static final ModelMapper mapper = new ModelMapper();

    @Autowired
    SpringNeo4jInstructorRepository instructorRepository;

    @Override
    public void add(Instructor entity) {
        entity.setId(null);
        SpringNeo4jInstructor saved = instructorRepository.save(mapper.map(entity, SpringNeo4jInstructor.class));
        entity.setId(saved.getId());
    }

    @Override
    public Instructor find(Long key) {
        SpringNeo4jInstructor instructor = instructorRepository.findOne(key);
        if(instructor == null) return null;
        return mapper.map(instructor, Instructor.class);
    }

    @Override
    public void remove(Long key) {
        instructorRepository.delete(key);
    }

    @Override
    public void update(Instructor entity) {
        instructorRepository.save(mapper.map(entity, SpringNeo4jInstructor.class));
    }
}
