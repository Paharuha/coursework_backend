package coursework.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "contracts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contracts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name_contract")
    private  String nameContracts;

    @Column(name = "date_start")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateStart;

    @Column(name = "date_end")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateEnd;

    @ManyToOne
    @JoinColumn(name = "id_projects")
    private Projects projects;

    @Column (name = "value")
    private int value;

    @ManyToOne
    @JoinColumn(name = "id_division")
    private Division division;

    @ManyToOne
    @JoinColumn(name = "id_subcontracting")
    private Subcontracting subcontracting;

    @ManyToOne
    @JoinColumn(name = "id_group")
    private GroupPeople groupPeople;
}
