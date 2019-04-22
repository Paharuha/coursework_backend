package coursework.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "division")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name_divisions")
    private String nameDivision;

    @ManyToOne
    @JoinColumn(name = "id_manager")
    private HeadDepartment headDepartment;
}
