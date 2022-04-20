/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author cristina
 */
public class Ejercicio4 {

    public static void main(String[] args) {
        // Fichero a crear. Ruta relativa a la carpeta raíz del proyecto
        String idFichero = "coches.txt";
        ArrayList<Vehiculo> lista = new ArrayList();
        //Turismos
        lista.add(new Turismo(345674L, "4060 TUR", "Skoda", "Fabia", "Blanco", 90.0, 2, false));
        lista.add(new Turismo(345674L, "4060 TUU", "Seat", "Leon", "Negro", 90.0, 2, false));
        lista.add(new Turismo(345674L, "4060 TRR", "Skoda", "Fabia", "Dorado", 90.0, 2, false));
        lista.add(new Turismo(345674L, "4060 TTT", "Seat", "Ibiza", "Blanco", 90.0, 2, false));
        lista.add(new Turismo(345674L, "4062 TUR", "Porshe", "Panamera", "Negro", 90.0, 2, false));
        lista.add(new Turismo(345674L, "4067 TUR", "Seat", "Leon", "Blanco", 90.0, 2, false));
        lista.add(new Turismo(345674L, "4068 TUR", "Seat", "Ibiza", "Blanco", 90.0, 2, false));
        lista.add(new Turismo(345674L, "4061 TUR", "Skoda", "Fabia", "Blanco", 90.0, 2, false));
        lista.add(new Turismo(345674L, "4063 TUR", "Skoda", "Fabia", "Blanco", 90.0, 2, false));
        lista.add(new Turismo(345674L, "4060 TYR", "Porshe", "Panamera", "Blanco", 90.0, 2, false));

        //Deportivos
        lista.add(new Deportivo(78654L, "4070 DEP", "Ford", "Mustang", "Rojo", 150.0, 2000));
        lista.add(new Deportivo(78654L, "4070 DEP", "Ford", "Mustang", "Rojo", 150.0, 2000));
        lista.add(new Deportivo(78654L, "4070 DEP", "Ford", "Mustang", "Rojo", 150.0, 2000));
        lista.add(new Deportivo(78654L, "4070 DEP", "Ford", "Mustang", "Rojo", 150.0, 2000));
        lista.add(new Deportivo(78654L, "4070 DEP", "Ford", "Mustang", "Rojo", 150.0, 2000));
        lista.add(new Deportivo(78654L, "4070 DEP", "Ford", "Mustang", "Rojo", 150.0, 2000));
        lista.add(new Deportivo(78654L, "4070 DEP", "Ford", "Mustang", "Rojo", 150.0, 2000));
        lista.add(new Deportivo(78654L, "4070 DEP", "Ford", "Mustang", "Rojo", 150.0, 2000));
        lista.add(new Deportivo(78654L, "4070 DEP", "Ford", "Mustang", "Rojo", 150.0, 2000));
        lista.add(new Deportivo(78654L, "4070 DEP", "Ford", "Mustang", "Rojo", 150.0, 2000));

        //Furgonetas
        lista.add(new Furgoneta(4333L, "4080 FUR", "Fiat", "Ducato", "Azul", 80.0, 1200, 8));
        lista.add(new Furgoneta(4333L, "4080 FUR", "Fiat", "Ducato", "Azul", 80.0, 1200, 8));
        lista.add(new Furgoneta(4333L, "4080 FUR", "Fiat", "Ducato", "Azul", 80.0, 1200, 8));
        lista.add(new Furgoneta(4333L, "4080 FUR", "Fiat", "Ducato", "Azul", 80.0, 1200, 8));
        lista.add(new Furgoneta(4333L, "4080 FUR", "Fiat", "Ducato", "Azul", 80.0, 1200, 8));
        lista.add(new Furgoneta(4333L, "4080 FUR", "Fiat", "Ducato", "Azul", 80.0, 1200, 8));
        lista.add(new Furgoneta(4333L, "4080 FUR", "Fiat", "Ducato", "Azul", 80.0, 1200, 8));
        lista.add(new Furgoneta(4333L, "4080 FUR", "Fiat", "Ducato", "Azul", 80.0, 1200, 8));
        lista.add(new Furgoneta(4333L, "4080 FUR", "Fiat", "Ducato", "Azul", 80.0, 1200, 8));
        lista.add(new Furgoneta(4333L, "4080 FUR", "Fiat", "Ducato", "Azul", 80.0, 1200, 8));

        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {

            for (int i = 0; i < lista.size(); i++) {
                flujo.write(lista.get(i).toString() + ";");
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
