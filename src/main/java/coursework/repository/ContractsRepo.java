package coursework.repository;

import coursework.model.Contracts;
import coursework.model.Projects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface ContractsRepo extends JpaRepository<Contracts, Integer> {
    @Query(value = "SELECT * " +
            "FROM contracts " +
            "WHERE contracts.date_start >= :start_date AND contracts.date_end <= :end_date", nativeQuery = true)
    Iterable<Contracts> getContracts(@Param("start_date")LocalDate startDate, @Param("end_date") LocalDate endDate);

    @Query(value = "SELECT *FROM contracts INNER JOIN projects ON projects.id = contracts.id_projects " +
            "WHERE projects.name_projects = :name_contract", nativeQuery = true)
    Iterable<Contracts> getProjects(@Param("name_contract") String projects);

    @Query(value = "SELECT *" +
            "FROM contracts " +
            "WHERE contracts.date_start >= :start_date AND contracts.date_end <= :end_date BETWEEN contracts.date_end <= :end_date", nativeQuery = true)
    Iterable<Contracts> getValue(@Param("start_date")LocalDate startDate, @Param("end_date") LocalDate endDate);

    @Query(value = "SELECT * FROM contracts \n" +
            "INNER JOIN subcontracting ON contracts.id_subcontracting = subcontracting.id\n" +
            "WHERE subcontracting.name = :name", nativeQuery = true)
    Iterable<Contracts> getSubcontracting(@Param("name") String name);
}
