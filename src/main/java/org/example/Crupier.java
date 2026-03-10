package org.example;

public class Crupier {
    private Mano mano;

    // Constructor
    public Crupier() {
        this.mano = new Mano();
    }

    // Getter de la mano
    public Mano getMano() {
        return mano;
    }

    // Lógica del turno del crupier
    public void jugarTurno(Baraja baraja) {
        // El crupier pide cartas mientras tenga menos de 17
        while (mano.calcularValor() < 17) {
            Carta carta = baraja.repartirCarta();
            mano.agregarCarta(carta);
        }
    }

    // Reinicia la mano para una nueva ronda
    public void reiniciarMano() {
        this.mano = new Mano();
    }
}
