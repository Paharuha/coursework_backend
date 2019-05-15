package coursework.repository;

import coursework.model.Contracts;
import coursework.model.Division;
import coursework.model.LabAsistant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface LabAsistantRepo extends JpaRepository<LabAsistant, Integer> {
    Iterable<LabAsistant> findByDivision(Division division);

    @Query(value = "SELECT lab_asistant.* FROM contracts " +
            "INNER JOIN group_people ON contracts.id_group = group_people.id " +
            "INNER JOIN lab_asistant ON group_people.id = lab_asistant.id " +
            "WHERE :date1 BETWEEN contracts.date_start AND contracts.date_end " +
            "AND lab_asistant.surname = :surname", nativeQuery = true)
    Iterable<LabAsistant> getLabAsistant(@Param("surname") String name, @Param("date1") LocalDate localDate);
}
