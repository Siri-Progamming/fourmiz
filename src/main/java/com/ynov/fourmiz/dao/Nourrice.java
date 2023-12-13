package com.ynov.fourmiz.dao;

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
        if (env.equals("herbe")) {
            return 0.5f;
        } else return 1.0f;
    }

    public void nurse(Fourmiliere fourmiliere) {
        if (fourmiliere.getOeufs() > 0) {
            fourmiliere.setOeufs(fourmiliere.getOeufs() - 1);
            Fourmi nouvelleFourmi = randomSpecialisation();
            fourmiliere.getFourmis().add(nouvelleFourmi);
            System.out.println("Une nouvelle fourmi est née ! Écoutons ce qu'elle a à dire :\n" + nouvelleFourmi.toString());
        }
    }

    public Fourmi randomSpecialisation() {
        Random r = new Random();
        int random = r.nextInt(1, 3);
        return switch (random) {
            case 1 -> new Chasseresse(0, 9);
            case 2 -> new Ouvriere(0, 5);
            default -> new Nourrice(0, 4);
        };
    }

    @Override
    public String toString() {
        return "Je suis une nourrice, j'ai " + this.getAge() + " an(s) et je suis super forte : " + this.getForce() + " !";
    }

}
