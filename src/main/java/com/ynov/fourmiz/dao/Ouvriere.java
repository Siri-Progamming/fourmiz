package com.ynov.fourmiz.dao;

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
        return "Je suis une ouvrière, j'ai " + this.getAge() + " an(s) et je suis super forte : " + this.getForce() + " !";
    }

    //TODO : On est pas prête pour les proba :(
    public void construire(Fourmiliere fourmiliere) {
        float chanceReussite = (0.1f / this.getAge()) * 100;

    }
}
