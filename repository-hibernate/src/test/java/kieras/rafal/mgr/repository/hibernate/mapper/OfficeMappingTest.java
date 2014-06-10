package kieras.rafal.mgr.repository.hibernate.mapper;

import static junit.framework.Assert.assertEquals;
import kieras.rafal.mgr.repository.entity.Address;
import kieras.rafal.mgr.repository.entity.Course;
import kieras.rafal.mgr.repository.entity.Office;
import kieras.rafal.mgr.repository.hibernate.entity.HbOffice;
import org.junit.Test;
import org.modelmapper.ModelMapper;

public class OfficeMappingTest {

    @Test
    public void BusinessToDomainTest() {
        ModelMapper mapper = new ModelMapper();

        Address address = new Address();
        address.setCity("London");
        address.setPostCode("33-159");
        address.setStreet("Broadgate");
        
        Office office = new Office();
        office.setId(1L);
        office.setAddress(address);
        
        Course course = new Course();
        course.setId(1L);
        course.setName("C# Programming");
        course.setOffice(office);
        
        office.getCourses().add(course);

        HbOffice hbOffice = mapper.map(office, HbOffice.class);

        assertEquals(hbOffice.getId(), office.getId());
        assertEquals(hbOffice.getAddress().getCity(), office.getAddress().getCity());
        assertEquals(hbOffice.getCourses().size(), 1);
    }
}
