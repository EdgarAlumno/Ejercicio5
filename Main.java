import java.util.Scanner;
public class Main{
    public static void main (String[] upiiz){
        int opcion = 0;
        float num1;
        float num2;
        float resultado;
        String operacion;

        while (opcion != 5){
            opcion = menu();
            switch (opcion) {
            case 1: 
                muestraResultado("SUMA", suma(teclado(),teclado()));
                break;
            case 2: 
                operacion = "RESTA";
                num1 = teclado();
                num2 = teclado();
                resultado = resta(num1, num2);
                muestraResultado(operacion, resultado);
                break;
            case 3: 
                muestraResultado("MULTIPLICACION", multiplicacion(teclado(),teclado()));
                break;
            case 4: 
                operacion = "DIVISION";
                num1 = teclado();
                num2 = teclado();
                resultado = division(num1, num2); 
                muestraResultado(operacion, resultado);
                break;
            default: System.out.println("No existe esa opcion");
            }
        }

    }

    public static int menu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nMenu:");
        System.out.println("    1 Suma");
        System.out.println("    2 Resta");
        System.out.println("    3 Multiplicacion");
        System.out.println("    4 Division");
        System.out.println("    5 Salir\n");
        System.out.print("Elige la opcion: ");
        int opcion = sc.nextInt();
        return opcion;
    }

    public static float teclado(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingresa un nuemro: ");
        float num = sc.nextFloat();
        return num;
    }

    public static void muestraResultado(String operacion, float resultado){
        System.out.println("El resultado de la "+ operacion +" es: "+ resultado);
    }

    public static float suma(float a, float b){
        return a+b;
    }

    public static float resta(float a, float b){
        return a-b;
    }

    public static float multiplicacion(float a, float b){
        return a*b;
    }

    public static float division(float a, float b){
        return a/b;
    }
}