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

    @Query(value = "SELECT * " +
            "FROM contracts " +
            "WHERE contracts.date_start >= :start_date AND contracts.date_end <= :end_date BETWEEN contracts.date_end <= :end_date", nativeQuery = true)
    Iterable<Contracts> getContractsValue(@Param("start_date")LocalDate startDate, @Param("end_date") LocalDate endDate);

    @Query(value = "SELECT * FROM contracts \n" +
            "INNER JOIN subcontracting ON contracts.id_subcontracting = subcontracting.id\n" +
                "WHERE subcontracting.name = :name", nativeQuery = true)
    Iterable<Contracts> getSubcontracting(@Param("name") String name);

    @Query(value = "SELECT * FROM contracts \n" +
            "INNER JOIN projects ON contracts.id_projects = projects.id\n" +
            "INNER JOIN group_people ON contracts.id_group = group_people.id\n" +
            "WHERE projects.name_projects =:name", nativeQuery = true)
    Iterable<Contracts> getPeopleProject(@Param("name") String name);

    @Query(value = "SELECT * FROM contracts \n" +
            "INNER JOIN projects ON contracts.id_projects = projects.id\n" +
            "INNER JOIN group_people ON contracts.id_group = group_people.id\n" +
            "WHERE contracts.date_start > :date_start AND contracts.date_end < :date_end", nativeQuery = true)
    Iterable<Contracts> getPeopleDate(@Param("date_start")LocalDate startDate, @Param("date_end")LocalDate endDate );

    @Query(value = "SELECT " +
            "contracts.value/DATEDIFF(contracts.date_end, contracts.date_start) " +
            "AS 'Вартість/дні',\n" +
            "contracts.value/4 AS 'Вартість/людино'\n" +
            "FROM contracts " +
            "WHERE contracts.id = :id", nativeQuery = true)
    Iterable<Double> getRah(@Param("id") int id);
}
