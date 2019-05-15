package coursework.repository;

import coursework.model.Contracts;
import coursework.model.Division;
import coursework.model.Personal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface PersonalRepo extends JpaRepository<Personal, Integer> {
    Iterable<Personal> findByDivision(Division division);

    @Query(value = "SELECT personal.* FROM contracts " +
            "INNER JOIN group_people ON contracts.id_group = group_people.id " +
            "INNER JOIN personal ON group_people.id = personal.id " +
            "WHERE :date1 BETWEEN contracts.date_start AND contracts.date_end " +
            "AND personal.surname = :surname", nativeQuery = true)
    Iterable<Personal> getPersonal(@Param("surname") String name, @Param("date1") LocalDate localDate);
}
