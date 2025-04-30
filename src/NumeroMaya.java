import java.util.*;// Importa utilidades como List, ArrayList, Collections para manejar listas y entradas.

public class NumeroMaya {
    private List<Integer> cifras; // Lista que almacena las cifras del número maya (una por nivel)

    public NumeroMaya(List<Integer> cifras) {
        for (int valor : cifras) {
            if (valor < 0 || valor > 19) {
                throw new IllegalArgumentException("Cifra Invalida: " + valor); // Las cifras deben estar entre 0 y 19
            }
        }
        this.cifras = new ArrayList<>(cifras);// Crea una copia de la lista para evitar modificar la original
    }

    // Constructor: Convierte decimal a lista de cifras mayas
    public NumeroMaya(int decimal) {
        this.cifras = convertirDecimalAMaya(decimal);
    }

    //obtiene las cifras
    public List<Integer> getCifras() {
        return cifras;
    }

    //Metodo para convertir en decimal
    public int aDecimal() {
        int decimal = 0;
        int potencia = cifras.size() - 1; // Posición más alta (nivel más alto)
        for (int valor : cifras) {
            decimal += valor * Math.pow(20, potencia--); // Multiplica cada cifra por 20^posición
        }
        return decimal;
    }

    //Convierte un decimal en una lista de cifras mayas
    private List<Integer> convertirDecimalAMaya(int numeroDecimal) {
        List<Integer> resultado = new ArrayList<>();
        if (numeroDecimal == 0) {
            resultado.add(0); // Caso especial: el cero se representa con un solo 0
        } else {
            while (numeroDecimal > 0) {
                resultado.add(numeroDecimal % 20);// Obtiene el resto (cifra actual)
                numeroDecimal /= 20; // Divide para ir al siguiente nivel
            }
            Collections.reverse(resultado); // Invierte la lista para que quede de arriba a abajo
        }
        return resultado;
    }

    //Convierte una cifra de 0-19 a simbolos mayas (Barras-Puntos)
    private String simboloMaya(int valor) {
        if (valor == 0) return "o"; // Concha para el 0
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < valor / 5; i++) sb.append("—"); // Una barra = 5
        for (int i = 0; i < valor % 5; i++) sb.append("•"); // un punto = 1
        return sb.toString();
    }

    //Imprime el número en forma visual (de arriba hacia abajo)
    public void imprimirComoSimbolos() {
        System.out.println("Número maya (de arriba hacia abajo): ");
        for (int i = 0; i < cifras.size(); i++) {
            System.out.println(simboloMaya(cifras.get(i)));// Convierte cada cifra a su símbolo
        }
    }

    //Representación textual básica (solo lista de cifras)
    @Override
    public String toString() {
        return cifras.toString();
    }  // Ej: [12, 5, 3]

}
