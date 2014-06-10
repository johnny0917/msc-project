package kieras.rafal.mgr.repository.hibernate.mapper;

import static junit.framework.Assert.assertEquals;
import kieras.rafal.mgr.repository.entity.Department;
import kieras.rafal.mgr.repository.hibernate.entity.HbDepartment;
import org.junit.Test;
import org.modelmapper.ModelMapper;

public class DepartmentMappingTest {
    @Test
    public void BusinessToDomainTest() {
        ModelMapper mapper = new ModelMapper();
        
        Department dep = new Department();
        dep.setId(1L);
        dep.setName("Dep1");
        
        HbDepartment entity = mapper.map(dep, HbDepartment.class);
        
        assertEquals(entity.getId(), dep.getId());
        assertEquals(entity.getName(), dep.getName());
    }
}
