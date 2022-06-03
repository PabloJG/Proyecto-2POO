import View.*;
import Model.*;
import Controller.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Controller controlador = new Controller();
        View matriz = new View();
        Model modelo = new Model();
        Personaje pers = new Personaje();
        Factory fact = new Factory(pers);

        matriz.setCoordinador(controlador);
        pers.setCoordinador(controlador);
        modelo.setCoordinador(controlador);
        fact.setCoordinador(controlador);

        controlador.setMatriz(matriz);
        controlador.setPersonaje(pers);
        controlador.setModelo(modelo);
        controlador.setFactory(fact);

    }
}