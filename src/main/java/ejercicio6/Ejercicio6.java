/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author cristina
 */
public class Ejercicio6 {

    public static void main(String[] args) {
        // Fichero a leer con datos de ejemplo
        String idFichero = "letras.txt";
        System.out.println("Leyendo el fichero: " + idFichero);
        //Ruta
        String route = "letras.txt";

        //Datos archivos
        String data = "";
        ArrayList<Integer> lineasOcurrencia = new ArrayList<>();
        int contador = 0;
        //Lectura
        try (Scanner sc = new Scanner(new FileReader(route))) {
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                data += linea + "\n";
                contador++;
                if (linea.contains("w;e;b") || linea.contains("W;E;B")) {
                    lineasOcurrencia.add(contador);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(data);
        lineasOcurrencia.forEach(valor -> {
            System.out.println(valor);
        });
    }

}
