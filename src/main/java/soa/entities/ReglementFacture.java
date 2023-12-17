package soa.entities;

import jakarta.persistence.*;

@Entity

public class ReglementFacture {
    @Id
    @GeneratedValue
    private Long idRF;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "idFacture",updatable = true)
    private Facture facture;
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "id",updatable = true)
    private Reglement reglement;

    private double mp;
    public ReglementFacture() {

    }

    public Reglement getReglement() {
        return reglement;
    }

    public void setReglement(Reglement reglement) {
        this.reglement = reglement;
    }

    public ReglementFacture(Facture facture, Reglement reglement, double mp) {
        this.facture = facture;
        this.reglement = reglement;
        this.mp = mp;
    }

    public Facture getfacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }



    public double getMp() {
        return mp;
    }

    public void setMp(double mp) {
        this.mp = mp;
    }

    @Override
    public String toString() {
        return "ReglementFacture{" +
                "idF=" + facture +
                ", reglement=" + reglement +
                ", mp=" + mp +
                '}';
    }


}
