package com.ynov.fourmiz.objets;

import java.util.Random;

public class Ouvriere extends Fourmi {
    public Ouvriere(int age, int force) {
        super(age, force);
    }

    @Override
    public float seDeplacer(String env) {
        if (env.equalsIgnoreCase("sable")) {
            return 2.0f;
        } else return 1.0f;
    }

    @Override
    public String toString() {
        return "Ouvrière | 🎂 "+ this.getAge() + " | 💪" + this.getForce();
    }

    public void agrandir(Fourmiliere fourmiliere) {
        if (this.getAge() > 0) {
            Random r = new Random();
            float chanceReussite = (0.1f / this.getAge()) * 100;
            float randomValue = r.nextFloat() * 100;
            if (randomValue <= chanceReussite) {
                int nbrSallesActuelles = fourmiliere.getSalles();
                fourmiliere.setSalles(nbrSallesActuelles + 1);
                System.out.println("La fourmilière est passée de " + nbrSallesActuelles + " à " + fourmiliere.getSalles() + " salles");
            } else {
                System.out.println("L'agrandissement de la fourmilière a échoué... Try again later !");
            }
        } else {
            System.out.println("L'ouvrière est trop jeune pour agrandir la fourmilière, le travail des enfants c'est pas bien !");
        }
    }
}
