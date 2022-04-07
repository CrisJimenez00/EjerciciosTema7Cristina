/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author cristina
 */
public class Ejercicio1CristinaJ {

    public static void main(String[] args) {
        // Fichero a crear. Ruta relativa a la carpeta raíz del proyecto
        String idFichero = "arraySecondForma.txt";
        String tmp;
        // Array a escribir
        int matrizNumeros[][] = {{100, 101, 102, 103}, {200, 201, 202, 203},
         {300, 301, 302, 303}, {400, 401, 402, 403}};

        // Si se utiliza el constructor FileWriter(idFichero, true) entonces se anexa información
        // al final del fichero idFichero
        // Estructura try-with-resources. Instancia el objeto con el fichero a escribir
        // y se encarga de cerrar el recurso "flujo" una vez finalizadas las operaciones
        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {

            for (int i = 0; i < matrizNumeros.length; i++) {

                for (int j = 0; j < matrizNumeros[i].length; j++) {

                    // Obtengo en un String el elemento int de la matriz
                    tmp = String.valueOf(matrizNumeros[i][j]);

                    // Si es el último de la fila no pone la coma
                    if (j == matrizNumeros[i].length - 1) {

                        // Usamos metodo write() para escribir en el buffer
                        flujo.write(tmp);

                    } else {

                        flujo.write(tmp + "\t");

                    }
                }

                // Metodo newLine() añade salto de línea después de cada fila
                flujo.newLine();
            }
            // Metodo fluh() guarda cambios en disco 
            flujo.flush();

            System.out.println("Fichero " + idFichero + " creado correctamente.");

        } catch (IOException e) {

            System.out.println(e.getMessage());

        }

    }
}
