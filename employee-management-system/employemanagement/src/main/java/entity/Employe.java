package entity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String prenom;
    private String poste;
}