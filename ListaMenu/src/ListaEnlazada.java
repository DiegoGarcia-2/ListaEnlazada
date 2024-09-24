import java.util.Scanner;

class ListaEnlazada<T extends Comparable<T>> {
    private Nodo<T> cabeza;
    private int tamaño;

    public ListaEnlazada() {
        cabeza = null;
        tamaño = 0;
    }

    public boolean estaVacia() {
        return tamaño == 0;
    }

    public void agregarNodo(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo<T> temp = cabeza;
            while (temp.siguiente != null) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevoNodo;
        }
        tamaño++;
    }

    public void eliminarNodo(T dato) {
        if (estaVacia()) return;

        if (cabeza.dato.equals(dato)) {
            cabeza = cabeza.siguiente;
            tamaño--;
            return;
        }

        Nodo<T> actual = cabeza;
        Nodo<T> anterior = null;

        while (actual != null && !actual.dato.equals(dato)) {
            anterior = actual;
            actual = actual.siguiente;
        }

        if (actual != null) {
            anterior.siguiente = actual.siguiente;
            tamaño--;
        }
    }

    public int obtenerNumeroDeNodos() {
        return tamaño;
    }

    public void mostrarElementos() {
        Nodo<T> temp = cabeza;
        while (temp != null) {
            System.out.print(temp.dato + " -> ");
            temp = temp.siguiente;
        }
        System.out.println("null");
    }

    public void posicionDeNodo(T dato) {
        Nodo<T> temp = cabeza;
        int posicion = 0;
        while (temp != null) {
            if (temp.dato.equals(dato)) {
                System.out.println("El nodo " + dato + " está en la posición: " + posicion);
                return;
            }
            temp = temp.siguiente;
            posicion++;
        }
        System.out.println("El nodo " + dato + " no se encontró en la lista.");
    }

    public String consultarOrden() {
        if (estaVacia()) {
            return "La lista está vacía.";
        }

        Nodo<T> actual = cabeza;
        boolean ascendente = true;
        boolean descendente = true;

        while (actual.siguiente != null) {
            if (actual.dato.compareTo(actual.siguiente.dato) > 0) {
                ascendente = false;
            }
            if (actual.dato.compareTo(actual.siguiente.dato) < 0) {
                descendente = false;
            }
            actual = actual.siguiente;
        }

        if (ascendente) {
            return "La lista está ordenada en orden ascendente.";
        } else if (descendente) {
            return "La lista está ordenada en orden descendente.";
        } else {
            return "La lista no está ordenada.";
        }
    }
}
