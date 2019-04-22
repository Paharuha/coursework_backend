package coursework.repository;

import coursework.model.Contracts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractsRepo extends JpaRepository<Contracts, Integer> {
}
