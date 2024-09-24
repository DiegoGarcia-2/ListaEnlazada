import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        int opcion;

        do {
            System.out.println("\nMenú:");
            System.out.println("1. Agregar nodo");
            System.out.println("2. Eliminar nodo");
            System.out.println("3. Mostrar elementos");
            System.out.println("4. Consultar si la lista está vacía");
            System.out.println("5. Obtener número de nodos");
            System.out.println("6. Mostrar posición de un nodo");
            System.out.println("7. Consultar orden de la lista");
            System.out.println("8. Salir");
            System.out.print("Elija una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese un número entero: ");
                    int dato = scanner.nextInt();
                    lista.agregarNodo(dato);
                    break;
                case 2:
                    System.out.print("Ingrese el número a eliminar: ");
                    int eliminar = scanner.nextInt();
                    lista.eliminarNodo(eliminar);
                    break;
                case 3:
                    lista.mostrarElementos();
                    break;
                case 4:
                    System.out.println("¿La lista está vacía? " + (lista.estaVacia() ? "Sí" : "No"));
                    break;
                case 5:
                    System.out.println("Número de nodos en la lista: " + lista.obtenerNumeroDeNodos());
                    break;
                case 6:
                    System.out.print("Ingrese el número del nodo a buscar: ");
                    int buscar = scanner.nextInt();
                    lista.posicionDeNodo(buscar);
                    break;
                case 7:
                    System.out.println(lista.consultarOrden());
                    break;
                case 8:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (opcion != 8);

        scanner.close();
    }
}
