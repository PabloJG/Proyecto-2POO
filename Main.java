import View.*;
import Model.*;
import Controller.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Controller controlador = new Controller();
        View matriz = new View();
        Personaje pers = new Personaje();
        Model modelo = new Model();
        Factory fact = new Factory();

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