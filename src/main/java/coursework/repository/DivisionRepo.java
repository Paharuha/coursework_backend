package coursework.repository;

import coursework.model.Division;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DivisionRepo extends JpaRepository <Division, Integer> {
}
