package pietakiewicz.sylwester.ZajavkaMed.business.dao;

import pietakiewicz.sylwester.ZajavkaMed.domain.Specialization;

import java.util.List;

public interface SpecializationDAO {

    List<Specialization> getAll();

    List<Specialization> getAllDoctors(Long specializationId);
}
