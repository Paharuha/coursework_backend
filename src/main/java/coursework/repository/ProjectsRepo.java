package coursework.repository;

import coursework.model.Projects;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectsRepo extends JpaRepository<Projects, Integer> {
}
