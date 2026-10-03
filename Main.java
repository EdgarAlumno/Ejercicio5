import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        // Uso de Listas con tipos de datos NO primitivos (Integer, Double, String)
        List<Integer> numeros = Arrays.asList(16, -3, 21, 82, 67, 5, 4, 98, 31, 10);
        List<Double> temperaturasCelsius = Arrays.asList(6.7, 23.0, 30.5, 67.0);
        List<String> nombres = Arrays.asList("Zohet", "Luis", "Angel", "Anais", "Oscar", "Pablo");

        System.out.println("Lista original de números: " + numeros);
        System.out.println("==========================================");

        // Nivel 1 — Operaciones básicas
        System.out.println("\n--- Nivel 1 — Operaciones básicas ---");

        // 1. Sumar elementos (Utilizando BinaryOperator a través de reduce)
        int suma = numeros.stream()
                .reduce(0, (a, b) -> a + b);
        System.out.println("1. Suma de elementos: " + suma);

        // 2. Obtener el máximo (Utilizando Comparator)
        int maximo = numeros.stream()
                .max(Integer::compareTo)
                .orElse(0);
        System.out.println("2. Valor máximo: " + maximo);

        // 3. Obtener el mínimo
        int minimo = numeros.stream()
                .min(Integer::compareTo)
                .orElse(0);
        System.out.println("3. Valor mínimo: " + minimo);

        // 4. Contar elementos
        long cantidad = numeros.stream().count();
        System.out.println("4. Cantidad de elementos: " + cantidad);


        // Nivel 2 — filter (Utilizando Predicate: Recibe algo, regresa True/False)
        System.out.println("\n--- Nivel 2 — filter ---");

        // 5. Números pares
        List<Integer> pares = numeros.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("5. Números pares: " + pares);

        // 6. Números mayores que 50
        List<Integer> mayores50 = numeros.stream()
                .filter(n -> n > 50)
                .collect(Collectors.toList());
        System.out.println("6. Mayores que 50: " + mayores50);

        // 7. Contar números positivos
        long positivos = numeros.stream()
                .filter(n -> n > 0)
                .count();
        System.out.println("7. Cantidad de números positivos: " + positivos);

        // 8. Obtener números dentro de un rango (ej. entre 10 y 50)
        List<Integer> rango = numeros.stream()
                .filter(n -> n >= 10 && n <= 50)
                .collect(Collectors.toList());
        System.out.println("8. Números en rango [10, 50]: " + rango);


        // Nivel 3 — map (Utilizando Function: Recibe algo, regresa algo)
        System.out.println("\n--- Nivel 3 — map ---");

        // 9. Elevar al cuadrado
        List<Integer> cuadrados = numeros.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println("9. Números elevados al cuadrado: " + cuadrados);

        // 10. Multiplicar por 10
        List<Integer> multiplicados = numeros.stream()
                .map(n -> n * 10)
                .collect(Collectors.toList());
        System.out.println("10. Números multiplicados por 10: " + multiplicados);

        // 11. Convertir temperaturas (Celsius a Fahrenheit)
        List<Double> fahrenheit = temperaturasCelsius.stream()
                .map(c -> (c * 9 / 5) + 32)
                .collect(Collectors.toList());
        System.out.println("11. Temperaturas en Fahrenheit: " + fahrenheit);


        // Nivel 4 — combinar operaciones
        System.out.println("\n--- Nivel 4 — combinar operaciones ---");

        // 12. Pares elevados al cuadrado
        List<Integer> paresCuadrado = numeros.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println("12. Pares al cuadrado: " + paresCuadrado);

        // 13. Suma de números pares
        int sumaPares = numeros.stream()
                .filter(n -> n % 2 == 0)
                .reduce(0, Integer::sum);
        System.out.println("13. Suma de números pares: " + sumaPares);

        // 14. Promedio de números mayores que 50
        OptionalDouble promedioMayores50 = numeros.stream()
                .filter(n -> n > 50)
                .mapToDouble(Integer::doubleValue)
                .average();
        System.out.println("14. Promedio de mayores a 50: " +
                (promedioMayores50.isPresent() ? promedioMayores50.getAsDouble() : 0));

        // 15. Máximo de números pares
        int maximoPares = numeros.stream()
                .filter(n -> n % 2 == 0)
                .max(Integer::compareTo)
                .orElse(0);
        System.out.println("15. Máximo de los pares: " + maximoPares);


        // Nivel 5 — ordenamiento
        System.out.println("\n--- Nivel 5 — ordenamiento ---");

        // 16. Ordenar de menor a mayor
        List<Integer> menorMayor = numeros.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("16. Orden menor a mayor: " + menorMayor);

        // 17. Ordenar de mayor a menor
        List<Integer> mayorMenor = numeros.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println("17. Orden mayor a menor: " + mayorMenor);

        // 18. Tres números más grandes
        List<Integer> tresMasGrandes = numeros.stream()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("18. Tres números más grandes: " + tresMasGrandes);


        // Nivel 6 — String (Utilizando List<String> en lugar de String[])
        System.out.println("\n--- Nivel 6 — String ---");
        System.out.println("Lista de nombres: " + nombres);

        // 19. Filtrar nombres (ej. que empiecen con 'A')
        List<String> nombresConA = nombres.stream()
                .filter(nombre -> nombre.startsWith("A"))
                .collect(Collectors.toList());
        System.out.println("19. Nombres que empiezan con 'A': " + nombresConA);

        // 20. Nombres con más de 5 caracteres
        List<String> nombresLargos = nombres.stream()
                .filter(nombre -> nombre.length() > 5)
                .collect(Collectors.toList());
        System.out.println("20. Nombres con más de 5 caracteres: " + nombresLargos);

        // 21. Convertir a mayúsculas
        List<String> mayusculas = nombres.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("21. Nombres en mayúsculas: " + mayusculas);

        // 22. Ordenar nombres alfabéticamente
        List<String> nombresOrdenados = nombres.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("22. Nombres ordenados: " + nombresOrdenados);


        // Nivel 7 — Matchers (Utilizando Predicate para evaluar booleanos)
        System.out.println("\n--- Nivel 7 ---");

        // 23. Buscar un número (ej. buscar el 20)
        Integer buscado = numeros.stream()
                .filter(n -> n == 67)
                .findFirst()
                .orElse(null);
        System.out.println("23. Buscar el número 67: " + (buscado != null ? "Encontrado" : "No encontrado"));

        // 24. Determinar si TODOS cumplen una condición (ej. todos son menores a 200)
        boolean todosMenores200 = numeros.stream()
                .allMatch(n -> n < 200);
        System.out.println("24. ¿Todos los números son menores a 200?: " + todosMenores200);

        // 25. Determinar si ALGUNO cumple una condición (ej. alguno es negativo)
        boolean algunoNegativo = numeros.stream()
                .anyMatch(n -> n < 0);
        System.out.println("25. ¿Existe algún número negativo en la lista?: " + algunoNegativo);
    }
}
