package org.example;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baraja {
    private List<Carta> cartas;

    public Baraja() {
        cartas = new ArrayList<>();

        String[] palos = {"Corazones", "Diamantes", "Treboles", "Picas"};
        String[] valores = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        for (String palo : palos) {
            for (String valor : valores) {
                cartas.add(new Carta(palo, valor));
            }
        }
    }

    public void barajar(){
        Collections.shuffle(cartas);
    }

    public Carta repartirCarta(){
        return cartas.remove(0);
    }
}
