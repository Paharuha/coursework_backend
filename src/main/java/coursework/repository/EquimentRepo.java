package coursework.repository;

import coursework.model.Equiment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquimentRepo extends JpaRepository<Equiment, Integer> {
}
