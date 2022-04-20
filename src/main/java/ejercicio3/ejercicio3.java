/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author cristina
 */
public class ejercicio3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String idFichero = "letras.txt";
        String tmp;
        Random random = new Random();
        String letra = "ABCDEFGHIJKLMNOPRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        // Si se utiliza el constructor FileWriter(idFichero, true) entonces se anexa información
        // al final del fichero idFichero
        // Estructura try-with-resources. Instancia el objeto con el fichero a escribir
        // y se encarga de cerrar el recurso "flujo" una vez finalizadas las operaciones
        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {

            for (int i = 0; i < 75; i++) {

                //Cogemos una posición aleatoria del String de letras
                int posi = random.nextInt(letra.length());
                char letrilla = letra.charAt(posi);

                //tmp se convierte en la letra
                tmp = String.valueOf(letrilla);

                if (tmp.equalsIgnoreCase("g")) {
                    //cada vez que le da enter se va a escribir en el txt el texto introducido por teclado
                    flujo.write(tmp + ";");
                    //Después de cada iteración habrá un salto de linea
                    flujo.newLine();

                } else {
                    flujo.write(tmp + ";");
                    i--;//no es recomendable trabajar con la variable i(lo suyo sería un do while)
                }
            }
            // Metodo fluh() guarda cambios en disco 
            flujo.flush();
            System.out.println("Fichero " + idFichero + " creado correctamente.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
