package coursework.repository;

import coursework.model.Contracts;
import coursework.model.Division;
import coursework.model.Technician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface TechnicianRepo extends JpaRepository<Technician, Integer> {
    Iterable<Technician> findByDivision(Division division);

    @Query(value = "SELECT technician.* FROM contracts " +
            "INNER JOIN group_people ON contracts.id_group = group_people.id " +
            "INNER JOIN technician ON group_people.id = technician.id " +
            "WHERE :date1 BETWEEN contracts.date_start AND contracts.date_end " +
            "AND technician.surname = :surname", nativeQuery = true)
    Iterable<Technician> getTechnician(@Param("surname") String name, @Param("date1") LocalDate localDate);
}
