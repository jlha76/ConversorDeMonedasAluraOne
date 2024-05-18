import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.Scanner;

public class Principal {

    public  static int opcion;
    public static String opciones = """ 
                **********************************************************
                Sea bienvenido al conversor de monedas
                
                1) Dolares =>> Pesos Mexicanos
                2) Pesos Mexicanos =>> Dolares
                3) Dolares =>> Reales Brasilenos
                4) Reales Brasilenos =>> Dolares
                5) Dolares =>> Pesos Colombianos
                6) Pesos Colombianos =>> Dolares
                7) Salir
                
                Elija una opcion valida:
                **********************************************************
                """;

    public static void main(String[] args) {

        //Scanner lectura = new Scanner(System.in);
        ConsultaMoneda consulta = new ConsultaMoneda();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
        Scanner teclado = new Scanner(System.in);

        while (true) {

            System.out.println(opciones);
            opcion = teclado.nextInt();
            int cantidad;

            try {
                if (opcion == 7) {
                    break;
                } else if (opcion == 1) {

                    System.out.println("Cual es la cantidad de Dolares que deseas convertir?");
                    cantidad = teclado.nextInt();
                    Moneda moneda = consulta.buscaMoneda("USD", "MXN", cantidad);
                    System.out.println("La cantidad de " + cantidad + " " + moneda.base_code().toString() +
                            " son equivalentes a " + moneda.conversion_result() + " " + moneda.target_code());
                } else if (opcion == 2) {

                    System.out.println("Cual es la cantidad de Pesos que deseas convertir?");
                    cantidad = teclado.nextInt();
                    Moneda moneda = consulta.buscaMoneda("MXN", "USD", cantidad);
                    System.out.println("La cantidad de " + cantidad + " " + moneda.base_code().toString() +
                            " son equivalentes a " + moneda.conversion_result() + " " + moneda.target_code());
                } else if (opcion == 3) {

                    System.out.println("Cual es la cantidad de Dolares que deseas convertir?");
                    cantidad = teclado.nextInt();
                    Moneda moneda = consulta.buscaMoneda("USD", "BRL", cantidad);
                    System.out.println("La cantidad de " + cantidad + " " + moneda.base_code().toString() +
                            " son equivalentes a " + moneda.conversion_result() + " " + moneda.target_code());
                } else if (opcion == 4) {

                    System.out.println("Cual es la cantidad de Reales Brasilenos que deseas convertir?");
                    cantidad = teclado.nextInt();
                    Moneda moneda = consulta.buscaMoneda("BRL", "USD", cantidad);
                    System.out.println("La cantidad de " + cantidad + " " + moneda.base_code().toString() +
                            " son equivalentes a " + moneda.conversion_result() + " " + moneda.target_code());
                } else if (opcion == 5) {

                    System.out.println("Cual es la cantidad de Dolares que deseas convertir?");
                    cantidad = teclado.nextInt();
                    Moneda moneda = consulta.buscaMoneda("USD", "COP", cantidad);
                    System.out.println("La cantidad de " + cantidad + " " + moneda.base_code().toString() +
                            " son equivalentes a " + moneda.conversion_result() + " " + moneda.target_code());
                    System.out.println(moneda.conversion_rate());

                } else if (opcion == 6) {

                    System.out.println("Cual es la cantidad de Pesos que deseas convertir?");
                    cantidad = teclado.nextInt();
                    Moneda moneda = consulta.buscaMoneda("COP", "USD", cantidad);
                    System.out.println("La cantidad de " + cantidad + " " + moneda.base_code().toString() +
                            " son equivalentes a " + moneda.conversion_result() + " " + moneda.target_code());
                    System.out.println(moneda.conversion_rate());
                }

            } catch (NumberFormatException e) {
                System.out.println("Numero no encontrado " + e.getMessage());
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                System.out.println("Finalizando la aplicacion.");
            }

        }

        System.out.println("Finalizo la ejecucion del programa!.");
    }
}


