package coursework.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "contracts_projects")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContractsProjects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_contracts")
    private Contracts contracts;

    @ManyToOne
    @JoinColumn(name = "id_projects")
    private Projects projects;

}
