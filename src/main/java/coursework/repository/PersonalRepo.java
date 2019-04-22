package coursework.repository;

import coursework.model.Personal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalRepo extends JpaRepository<Personal, Integer> {
}
