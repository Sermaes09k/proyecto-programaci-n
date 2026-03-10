package org.example;

public class Jugador {
    private String nombre;
    private int creditos;
    private Mano mano;
    private Apuesta apuesta;
    private boolean plantado;



    private jugador(String nombre, int creditos){
        this.nombre = nombre;
        this.creditos = creditos;
        this.mano = new Mano();
        this.apuesta = apuesta;
        this.plantado = false;
    }

    public Mano getMano() {
        return mano;
    }

    public Apuesta getApuesta() {
        return apuesta;
    }

    public int getCreditos() {
        return creditos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setApuesta(Apuesta apuesta) {
        if (apuesta.getCantidad() <= creditos){
            this.apuesta = apuesta;
            this.creditos -= apuesta.getCantidad();
        } else {
            System.out.println("No tienes suficientes créditos para doblar.");
        }
        this.apuesta = apuesta;
    }

    public void pedirCarta(Baraja baraja) {
        Carta carta = baraja.repartirCarta();
        mano.agregarCarta(carta);
    }

    public void plantarse() {
        plantado = true;
    }

    public boolean estaPlantado() {
        return plantado;
    }

    public void doblar(Baraja baraja) {
        if (Objects.isNull(apuesta)) {
            throw new IllegalStateException("Debes apostar antes de doblar.");
        }
        // Duplicamos la apuesta
        int cantidad = apuesta.getCantidad();
        if (cantidad > creditos) {
            throw new IllegalArgumentException("No tienes suficientes créditos para doblar.");
        }
        creditos -= cantidad;
        apuesta = new Apuesta(cantidad * 2);
        // Pedimos una carta extra y automáticamente se planta
        pedirCarta(baraja);
        plantarse();
    }

    // Reiniciar mano y estado entre rondas
    public void reiniciarMano() {
        mano = new Mano();
        plantado = false;
        apuesta = null;
    }
}

}
