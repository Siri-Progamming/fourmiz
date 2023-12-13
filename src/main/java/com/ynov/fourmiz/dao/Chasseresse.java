package com.ynov.fourmiz.dao;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Chasseresse extends Fourmi{
    private static int nbrChasseresse = 0;
    private int id;
    public Chasseresse(int age, int force) {
        super(age, force);
        nbrChasseresse++;
        this.id = nbrChasseresse;
    }

    @Override
    public float seDeplacer() {
       return super.getForce();
    }

    @Override
    public String toString() {
        return "Je suis une chasseresse, j'ai " + this.getAge() + " an(s) et je suis plus forte que les autres : " + this.getForce() + " 🏋️!";
    }


}
