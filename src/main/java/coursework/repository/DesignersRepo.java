package coursework.repository;

import coursework.model.Contracts;
import coursework.model.Designers;
import coursework.model.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface DesignersRepo extends JpaRepository<Designers,Integer> {
    Iterable<Designers> findByDivision(Division division);

    @Query(value = "SELECT designers.* FROM contracts " +
            "INNER JOIN group_people ON contracts.id_group = group_people.id " +
            "INNER JOIN designers ON group_people.id = designers.id " +
            "WHERE :date BETWEEN contracts.date_start AND contracts.date_end " +
            "AND designers.surname = :name", nativeQuery = true)
    Iterable<Designers> getDesigners(@Param("name") String name,
                                     @Param("date")LocalDate localDate);

}
