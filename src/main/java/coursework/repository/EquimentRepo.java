package coursework.repository;

import coursework.model.Equiment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface EquimentRepo extends JpaRepository<Equiment, Integer> {
    @Query(value = "SELECT * FROM contracts \n" +
            "INNER JOIN projects ON contracts.id_projects = projects.id\n" +
            "INNER JOIN equiment ON projects.equiment = equiment.id\n" +
            "WHERE :date1 BETWEEN  contracts.date_start AND contracts.date_end", nativeQuery = true)
    Iterable<Equiment> getEquimnet(@Param("date1") LocalDate startDate);

    @Query(value = "SELECT * FROM contracts \n" +
            "INNER JOIN projects ON contracts.id_projects = projects.id\n" +
            "INNER JOIN equiment ON projects.id = equiment.id\n" +
            "WHERE contracts.name_contract = :name", nativeQuery = true)
    Iterable<Equiment> getEquimnetByName(@Param("name") String name);
}
