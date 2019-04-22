package coursework.repository;

import coursework.model.Technician;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnicianRepo extends JpaRepository<Technician, Integer> {
}
