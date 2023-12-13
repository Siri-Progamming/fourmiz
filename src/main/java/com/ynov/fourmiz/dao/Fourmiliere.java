package com.ynov.fourmiz.dao;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Random;

@Getter
@Setter
public class Fourmiliere {
    private int oeufs;
    private int stockNourriture;
    private int salles;
    @Getter
    private List<Fourmi> fourmis;

    public Fourmiliere() {
        Random r = new Random();
        this.oeufs = r.nextInt(10, 20);
        this.stockNourriture = r.nextInt(15, 20);
        this.salles = r.nextInt(3, 7);
    }

}
