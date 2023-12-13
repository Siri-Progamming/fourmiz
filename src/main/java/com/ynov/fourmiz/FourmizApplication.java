package com.ynov.fourmiz;

import com.ynov.fourmiz.objets.Chasseresse;
import com.ynov.fourmiz.objets.Fourmiliere;
import com.ynov.fourmiz.objets.Nourrice;
import com.ynov.fourmiz.objets.Ouvriere;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class FourmizApplication {

    public static void main(String[] args) {
        SpringApplication.run(FourmizApplication.class, args);
        Random r = new Random();

        Fourmiliere fourmiliere = new Fourmiliere();

        List<Nourrice> nourrices = new ArrayList<Nourrice>();
        for (int i = 0; i < r.nextInt(1, 11); i++) {
            nourrices.add(new Nourrice(r.nextInt(0, 6), 4));
        }

        List<Ouvriere> ouvrieres = new ArrayList<Ouvriere>();
        for (int i = 0; i < r.nextInt(1, 11); i++) {
            ouvrieres.add(new Ouvriere(r.nextInt(0, 6), 5));
        }

        List<Chasseresse> chasseresses = new ArrayList<Chasseresse>();
        for (int i = 0; i < r.nextInt(1, 11); i++) {
            chasseresses.add(new Chasseresse(r.nextInt(0, 6), r.nextInt(6, 10)));
        }

        fourmiliere.getFourmis().addAll(nourrices);
        fourmiliere.getFourmis().addAll(ouvrieres);
        fourmiliere.getFourmis().addAll(chasseresses);
        System.out.println(fourmiliere.toString());

        fourmiliere.action();
        System.out.println(fourmiliere.toString());
    }
}
