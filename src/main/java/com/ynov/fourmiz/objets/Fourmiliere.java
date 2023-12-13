package com.ynov.fourmiz.objets;

import com.ynov.fourmiz.exceptions.NourritureException;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
@Setter
public class Fourmiliere {
    private int oeufs;
    private int stockNourriture;
    private int salles;
    private List<Fourmi> fourmis;

    public Fourmiliere() {
        Random r = new Random();
        this.oeufs = r.nextInt(10, 21);
        this.stockNourriture = r.nextInt(15, 21);
        this.salles = r.nextInt(3, 8);
        this.setFourmis(new ArrayList<>());
    }

    public String toString() {
        String retourLigne = "\n";
        String delimiter = "------------------------------------" + retourLigne;
        String fourmiliere = "             FOURMIZ 🐜"+retourLigne;
        String nourriture = "Nourriture : " + this.stockNourriture + retourLigne;
        String oeufs = "Oeufs : " + this.oeufs + retourLigne;
        String salles = "Salles : " + this.salles + retourLigne;
        StringBuilder fourmis = new StringBuilder();

        if(!this.fourmis.isEmpty()) {
            for (Fourmi fourmi : this.fourmis) {
                fourmis.append(fourmi.toString()).append(retourLigne);
            }
        }else{
            fourmis.append("Il n'y a aucune fourmi dans la fourmilière.").append(retourLigne);
        }
        return delimiter + fourmiliere + delimiter + nourriture + oeufs + salles + delimiter + fourmis + delimiter;
    }

    public void action() {
        Random r = new Random();
        int nbrFourmis = this.fourmis.size();

        this.setOeufs(this.getOeufs() + r.nextInt(0, 5));
        this.setStockNourriture(this.getStockNourriture() - nbrFourmis);

        if(!this.fourmis.isEmpty()){
            List<Fourmi> fourmisActuelles = new ArrayList<>(this.getFourmis());
            for (Fourmi fourmi : fourmisActuelles) {
                System.out.println("Action de "+fourmi.getClass().getSimpleName()+" :");
                switch (fourmi.getClass().getSimpleName()) {
                    case "Nourrice" -> ((Nourrice) fourmi).nurse(this);
                    case "Ouvriere" -> ((Ouvriere) fourmi).agrandir(this);
                    case "Chasseresse" -> {
                        try{
                            ((Chasseresse) fourmi).chasser(this);
                            if(this.getStockNourriture() > (10*this.getSalles())){
                                throw new NourritureException("La chasseresse n°"+ ((Chasseresse) fourmi).getId() +" a travaillé pour rien");
                            }
                        }catch (NourritureException ne){
                            System.out.println(ne.getMessage());
                        }
                    }
                }
            }
        }
    }
}
