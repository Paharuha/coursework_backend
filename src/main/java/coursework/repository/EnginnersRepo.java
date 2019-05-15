package coursework.repository;

import coursework.model.Contracts;
import coursework.model.Division;
import coursework.model.Enginners;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface EnginnersRepo extends JpaRepository<Enginners, Integer> {
    Iterable<Enginners> findByDivision(Division division);

    @Query(value = "SELECT enginners.* FROM contracts " +
            "INNER JOIN group_people ON contracts.id_group = group_people.id " +
            "INNER JOIN enginners ON group_people.id = enginners.id " +
            "WHERE :date1 BETWEEN contracts.date_start AND contracts.date_end " +
            "AND enginners.surname = :surname", nativeQuery = true)
    Iterable<Enginners> getEnginners(@Param("surname") String name, @Param("date1") LocalDate localDate);
}
