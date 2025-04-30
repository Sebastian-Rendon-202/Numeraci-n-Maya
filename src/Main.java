import java.util.*; // Importa utilidades como List, ArrayList, Collections para manejar listas y entradas.

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.Maya a Decimal");
        System.out.println("2.Decimal a Maya");
        System.out.println("Seleccione una opcion: ");
        int opcion = scanner.nextInt();

        //Opción 1: Maya a Decimal
        if (opcion == 1) {
            System.out.println("Ingrese cifras mayas separadas por espacio (de abajo a arriba): ");
            scanner.nextLine();
            String[] entrada = scanner.nextLine().trim().split("\\s+"); // Divide la entrada en un arreglo de strings
            List<Integer> cifas = new ArrayList<>();
            for (String s : entrada) {
                cifas.add(Integer.parseInt(s)); // Convierte cada string a número y lo agrega a la lista
            }
            Collections.reverse(cifas);// Invierte la lista para que esté de arriba a abajo (orden maya)
            NumeroMaya numeroMaya = new NumeroMaya(cifas);// Crea un objeto maya con esas cifras
            System.out.println("Decimal: " + numeroMaya.aDecimal()); // Muestra el número en decimal
            numeroMaya.imprimirComoSimbolos();

        } else if (opcion == 2) { //Opción 2: Decimal a Maya
            System.out.println("ingrese numero decimal: ");
            int numeroDecimal = scanner.nextInt();
            NumeroMaya numeroMaya = new NumeroMaya (numeroDecimal); // Crea un objeto a partir del decimal
            numeroMaya.imprimirComoSimbolos(); // Imprime el número en símbolos mayas
            System.out.println("Cifras internas: " + numeroMaya); // Muestra las cifras (lista de enteros)

        } else {
            System.out.println("Opcion Invalida."); // Si no es 1 ni 2
        }
    }
}