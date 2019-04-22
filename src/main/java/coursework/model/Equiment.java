package coursework.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "equiment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Equiment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name_equiment")
    private String nameEquiment;

    @Column(name = "number")
    private  int number;
}

