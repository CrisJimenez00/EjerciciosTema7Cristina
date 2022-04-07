/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package ejercicio1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author cristina
 */
public class Ejercicio1Cristina {

    public static void main(String[] args) {
        // Fichero a crear. Ruta relativa a la carpeta raíz del proyecto
        String idFichero = "array.txt";
        String aux;

        // Array a escribir
        int matrizNumeros[][] = new int[4][4];

        int valorNumerico;

        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {

            //recorremos la matriz
            for (int i = 0; i < matrizNumeros.length; i++) {

                // Con esto hacemos que haga 100, 200, 300, etc
                valorNumerico = 100 * (i + 1);

                //añadimos el número a la matriz numérica
                matrizNumeros[i][0] = valorNumerico;

                //Controlamos las columnas con este for
                for (int j = 0; j < matrizNumeros[i].length; j++) {

                    //Con esto hacemos que haga 100, 101, 102, etc
                    matrizNumeros[i][j] = valorNumerico + j;

                    //Lo convertimos en String
                    aux = String.valueOf(matrizNumeros[i][j]);

                    //Lo separamos por tabulaciones
                    flujo.write(aux + "\t");

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
