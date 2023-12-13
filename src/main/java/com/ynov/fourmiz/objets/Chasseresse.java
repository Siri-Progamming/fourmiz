package com.ynov.fourmiz.objets;

import com.ynov.fourmiz.exceptions.NourritureException;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Chasseresse extends Fourmi {
    private static int nbrChasseresse = 0;
    private int id;

    public Chasseresse(int age, int force) {
        super(age, force);
        nbrChasseresse++;
        this.id = nbrChasseresse;
    }

    @Override
    public float seDeplacer(String env) {
        return super.getForce();
    }

    @Override
    public String toString() {
        return "Chasseresse | 🆔 " + this.getId() + "| 🎂 " + this.getAge() + " | 💪" + this.getForce();
    }

    public void chasser(Fourmiliere fourmiliere) throws NourritureException{
        int stockNourritureActuel = fourmiliere.getStockNourriture();
        fourmiliere.setStockNourriture(stockNourritureActuel + this.getForce());
        System.out.println("La fourmilière est passée de " + stockNourritureActuel + " à " + fourmiliere.getStockNourriture() + " de nourriture");
    }
}
