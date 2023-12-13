package com.ynov.fourmiz.objets;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
public class Nourrice extends Fourmi {

    public Nourrice(int age, int force) {
        super(age, force);
    }

    @Override
    public float seDeplacer(String env) {
        if (env.equalsIgnoreCase("herbe")) {
            return 0.5f;
        } else return 1.0f;
    }

    public void nurse(Fourmiliere fourmiliere) {
        if (fourmiliere.getOeufs() > 0) {
            fourmiliere.setOeufs(fourmiliere.getOeufs() - 1);
            Fourmi nouvelleFourmi = randomSpecialisation();
            fourmiliere.getFourmis().add(nouvelleFourmi);
            System.out.println("Une nouvelle fourmi est née ! \n" + nouvelleFourmi.toString());
        }
    }

    public Fourmi randomSpecialisation() {
        Random r = new Random();
        int random = r.nextInt(1, 4);
        return switch (random) {
            case 1 -> new Chasseresse(0, r.nextInt(6,10));
            case 2 -> new Ouvriere(0, 5);
            default -> new Nourrice(0, 4);
        };
    }

    @Override
    public String toString() {
        return "Nourrice | 🎂 "+ this.getAge() + " | 💪" + this.getForce();
    }

}
