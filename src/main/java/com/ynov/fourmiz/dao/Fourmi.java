package com.ynov.fourmiz.dao;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Fourmi {
    private int age;
    private int force;

    public Fourmi(int age, int force) {
        this.age = age;
        this.force = force;
    }

    /**
     * Cette méthode permet à la fourmi de communiquer avec une autre fourmi
     *
     * @param fourmi : la fourmi avec laquelle la fourmi communique
     * @return : le message de communication
     */
    public String communiquer(Fourmi fourmi) {
        return "Je fredonne par mes mandibules une chanson nulle";
    }

    /**
     * Cette méthode permet à la fourmi de se déplacer dans son environnement.
     * Elle est abstraite car le résultat dépend de la spécialisation de la fourmi
     *
     * @param env : l'environnement dans lequel la fourmi se déplace, il fait varier sa vitesse -> "sable", "roche", "herbe"
     * @return : la vitesse de déplacement de la fourmi
     */
    public abstract float seDeplacer(String env);

    /**
     * Cette méthode permet de retourner les informations générales de la fourmi
     *
     * @return : Des informations sur la fourmi
     */
    public String toString() {
        return "Je suis une fourmi, j'ai " + this.age + " an(s) et je suis super forte : " + this.force + " !";
    }

}
