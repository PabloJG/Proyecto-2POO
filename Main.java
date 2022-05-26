import View.Enemigo;
import View.Personaje;
import View.View;

public class Main {
    public static void main(String[] args) throws Exception {
        View matriz = new View();
        Personaje pers = new Personaje();
        Enemigo[] enemigos = new Enemigo[3];
        for(int i = 0; i<3; i++){
            enemigos[i] = new Enemigo(i);
        }
    }
}