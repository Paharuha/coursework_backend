package coursework.repository;

import coursework.model.Projects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProjectsRepo extends JpaRepository<Projects, Integer> {
    @Query(value = "SELECT * FROM contracts \n" +
            "INNER JOIN projects ON contracts.id_projects = projects.id\n" +
            "INNER JOIN group_people ON contracts.id_group = group_people.id\n" +
            "WHERE projects.name_projects = :name", nativeQuery = true)
    Iterable<Projects> getProjects(@Param("name") String name);

    @Query(value = "SELECT * FROM projects \n" +
            "INNER JOIN equiment ON projects.equiment = equiment.id\n" +
            "WHERE equiment.number = :number", nativeQuery = true)
    Iterable<Projects> getEquimentNum(@Param("number") int number);
}
