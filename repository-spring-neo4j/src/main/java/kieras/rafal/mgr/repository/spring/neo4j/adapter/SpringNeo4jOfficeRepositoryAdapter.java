package kieras.rafal.mgr.repository.spring.neo4j.adapter;

import kieras.rafal.mgr.repository.OfficeRepository;
import kieras.rafal.mgr.repository.entity.Office;
import kieras.rafal.mgr.repository.spring.neo4j.SpringNeo4jOfficeRepository;
import kieras.rafal.mgr.repository.spring.neo4j.entity.SpringNeo4jAddress;
import kieras.rafal.mgr.repository.spring.neo4j.entity.SpringNeo4jOffice;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class SpringNeo4jOfficeRepositoryAdapter  implements OfficeRepository {
    private static final ModelMapper mapper = new ModelMapper();

    @Autowired
    SpringNeo4jOfficeRepository officeRepository;
    

    @Override
    public void add(Office entity) {
        entity.setId(null);
        SpringNeo4jOffice saved = officeRepository.save(mapper.map(entity, SpringNeo4jOffice.class));
        entity.setId(saved.getId());
    }

    @Override
    public Office find(Long key) {
        SpringNeo4jOffice office = officeRepository.findOne(key);
        if(office == null) return null;
        return mapper.map(office, Office.class);
    }

    @Override
    public void remove(Long key) {
        officeRepository.delete(key);
    }

    @Override
    public void update(Office entity) {
        officeRepository.save(mapper.map(entity, SpringNeo4jOffice.class));
    }
}
