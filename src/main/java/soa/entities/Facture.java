package soa.entities;



import jakarta.persistence.*;
import org.springframework.context.annotation.EnableMBeanExport;

import java.util.List;

@Entity
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFacture")
    private Long idFacture;
    private int num;


    public Facture( ) {

    }
    public Facture( Long idFacture, int num) {
        this.idFacture = idFacture;
        this.num = num;
    }


    public Long getIdF() {
        return idFacture;
    }

    public void setIdF(Long idF) {
        this.idFacture = idF;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
