

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        do {
            mostrarMenu();
            System.out.print("Seleccione una opción: ");
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                switch (opcion) {
                    case 1:
                        leerDato(lista, scanner);
                        break;
                    case 2:
                        mostrarPares(lista);
                        break;
                    case 3:
                        mostrarCuadrados(lista);
                        break;
                    case 4:
                        sumarElementos(lista);
                        break;
                    case 5:
                        buscarElemento(lista, scanner);
                        break;
                    case 6:
                        encontrarMaximo(lista);
                        break;
                    case 7:
                        System.out.println("¡Saliendo del programa!");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } else {
                System.out.println("Por favor ingrese un número válido.");
                scanner.next();
            }
            System.out.println();
        } while (opcion != 7);

        scanner.close();
    }


    public static void mostrarMenu() {
        System.out.println("--- MENÚ DE OPCIONES ---");
        System.out.println("1.- Leer dato");
        System.out.println("2.- Muestre números pares");
        System.out.println("3.- Muestre los cuadrado de los valores");
        System.out.println("4.- Suma de los elementos de la lista");
        System.out.println("5.- Buscar un elementos de la lista");
        System.out.println("6.- Encontrar valor maximo");
        System.out.println("7.- Salir");
    }

    public static void leerDato(ArrayList<Integer> lista, Scanner scanner) {
        System.out.print("Ingrese un número entero para agregar a la lista: ");
        if (scanner.hasNextInt()) {
            Integer numero = scanner.nextInt(); // Uso de tipo no primitivo Integer
            lista.add(numero);
            System.out.println("Número " + numero + " agregado con éxito.");
        } else {
            System.out.println("Entrada no válida.");
            scanner.next();
        }
    }

    public static void mostrarPares(ArrayList<Integer> lista) {
        if (lista.isEmpty()) {
            System.out.println("La lista está vacía.");
            return;
        }
        System.out.print("Números pares en la lista: ");
        boolean hayPares = false;
        for (Integer num : lista) {
            if (num % 2 == 0) {
                System.out.print(num + " ");
                hayPares = true;
            }
        }
        if (!hayPares) {
            System.out.print("No hay números pares.");
        }
        System.out.println();
    }

    public static void mostrarCuadrados(ArrayList<Integer> lista) {
        if (lista.isEmpty()) {
            System.out.println("La lista está vacía.");
            return;
        }
        System.out.println("Cuadrado de los valores:");
        for (Integer num : lista) {
            System.out.println(num + " -> " + (num * num));
        }
    }

    public static void sumarElementos(ArrayList<Integer> lista) {
        if (lista.isEmpty()) {
            System.out.println("La lista está vacía.");
            return;
        }
        int suma = 0;
        for (Integer num : lista) {
            suma += num;
        }
        System.out.println("La suma de todos los elementos es: " + suma);
    }

    public static void buscarElemento(ArrayList<Integer> lista, Scanner scanner) {
        if (lista.isEmpty()) {
            System.out.println("La lista está vacía.");
            return;
        }
        System.out.print("Ingrese el número que desea buscar: ");
        if (scanner.hasNextInt()) {
            Integer valorBuscado = scanner.nextInt();
            if (lista.contains(valorBuscado)) {
                System.out.println("El elemento " + valorBuscado + " SÍ se encuentra en la lista.");
            } else {
                System.out.println("El elemento " + valorBuscado + " NO se encuentra en la lista.");
            }
        } else {
            System.out.println("Entrada no válida.");
            scanner.next();
        }
    }

    public static void encontrarMaximo(ArrayList<Integer> lista) {
        if (lista.isEmpty()) {
            System.out.println("La lista está vacía.");
            return;
        }
        Integer maximo = lista.get(0);
        for (Integer num : lista) {
            if (num > maximo) {
                maximo = num;
            }
        }
        System.out.println("El valor máximo de la lista es: " + maximo);
    }
}