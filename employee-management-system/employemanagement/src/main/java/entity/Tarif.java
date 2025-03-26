package entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Tarif {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String typeJour;
    private float tarif;
}
