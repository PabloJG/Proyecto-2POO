import View.*;
import Model.*;
import Controller.*;

public class Main { //Aquí donde se da inicio al juego
    public static void main(String[] args) throws Exception {
        Controller controlador = new Controller();
        View matriz = new View();
        Model modelo = new Model();
        Personaje pers = new Personaje();
        Factory fact = new Factory(pers);

        pers.setCoordinador(controlador);
        modelo.setCoordinador(controlador);

        controlador.setModelo(modelo);
        controlador.setFactory(fact);

    }
}