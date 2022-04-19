/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author cristina
 */
public class ejercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Fichero a crear. Ruta relativa a la carpeta raíz del proyecto
//     eof
        Scanner teclado = new Scanner(System.in);
        String idFichero = "texto.txt";
        String tmp = "";
        // Array a escribir
        int matrizNumeros[][] = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}};

        // Si se utiliza el constructor FileWriter(idFichero, true) entonces se anexa información
        // al final del fichero idFichero
        // Estructura try-with-resources. Instancia el objeto con el fichero a escribir
        // y se encarga de cerrar el recurso "flujo" una vez finalizadas las operaciones
        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {

            do {
                //Primero hacemos que el usuario ponga por teclado el texto
                System.out.println("Escriba el texto que desea que esté en el txt:");
                tmp = teclado.next();

                //cada vez que le da enter se va a escribir en el txt el texto introducido por teclado
                flujo.write(tmp);

                //Después de cada iteración habrá un salto de linea
                flujo.newLine();

                //Hasta que no ponga eof no se parará de solicitar datos
            } while (!tmp.equalsIgnoreCase("eof"));
            // Metodo fluh() guarda cambios en disco 
            flujo.flush();
            System.out.println("Fichero " + idFichero + " creado correctamente.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}
