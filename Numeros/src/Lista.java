import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Random;

public class Lista {
    public ArrayList<Integer> generarNumeros(int N) {
        ArrayList<Integer> numeros = new ArrayList<>();
        Random random = new Random();
        while (numeros.size() < N) {
            int numero = random.nextInt(100) + 1;
            if (!numeros.contains(numero)) {
                numeros.add(numero);
            }
        }
        return numeros;
    }
    public int sumarNumeros(Enumeration<Integer> numeros) {
        if (!numeros.hasMoreElements()) {
            return 0;
        }
        int next = numeros.nextElement();
        return next + sumarNumeros(numeros);
    }
}
