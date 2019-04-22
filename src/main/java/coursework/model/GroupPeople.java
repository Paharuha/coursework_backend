package coursework.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "group_people")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GroupPeople {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name_group")
    private  String nameGroup;

    @ManyToOne
    @JoinColumn(name = "id_designers")
    private Designers designers;

    @ManyToOne
    @JoinColumn(name = "id_enginners")
    private Enginners enginners;

    @ManyToOne
    @JoinColumn(name = "id_technician")
    private Technician technician;

    @ManyToOne
    @JoinColumn(name = "id_lab_asistant")
    private LabAsistant labAsistant;
}
