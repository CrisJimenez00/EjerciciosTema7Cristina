/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Cris
 */
public class Ejercicio10 {

    //Método de clase el cual crea un archivo pasándole la dirección donde se quiere ubicar-
    public static void crearDirectorio(String ruta) {

        //Esto hace que se indique la ruta donde se quiere ubicar
        Path directory = Paths.get(ruta);

        //try/catch para controlar posibles excepciones
        try {
            //Crea el directorio
            Files.createDirectory(directory);

            //Si ya existe sale esta excepción
        } catch (FileAlreadyExistsException faee) {

            //Lo cual hace que salga un mensaje específico
            System.out.println("No se puede crear " + ruta + " porque ya existe");

            //Si el usuario no tiene permisos para crear archivos en el ordenador
            //(lo pongo para usos futuros o pruebas)
        } catch (AccessDeniedException ade) {

            System.out.println("No tiene permisos para crear " + ruta);

            //Si la ruta está mal escrita o si hay algún problem creando el directorio
        } catch (IOException ioe) {

            System.out.println("Problema creando el directorio " + ruta);
            System.out.println("Seguramente la ruta está mal escrita o no existe");

        }

    }

    //Método el cual copia los ficheros introduciendo una ruta origen y lo copia en la rutaDestino
    public static void copiarFicheros(String rutaOrigen, String rutaDestino) {

        Path origen = Paths.get(rutaOrigen);
        Path destino = Paths.get(rutaDestino);

        try {

            //Copia los archivos de la ruta origen a una ruta de destino
            Files.copy(origen, destino);

        } catch (IOException e) {
            System.out.println("Problema copiando el archivo.");
            System.out.println(e.toString());

        }
    }

    //metodo el cual dice si los directorios existen o no y aparece su nombre
    public static void listarDirectorio(String ruta) {

        File file = new File(ruta);

        //Si existe lo guarda en una lista
        if (file.exists()) {

            File[] ficheros = file.listFiles();

            for (File file2 : ficheros) {

                System.out.println(file2.getName());

            }
        } else {
            System.out.println("El directorio a listar no existe");
        }
    }

    //Método el cual lee los ficheros y guarda los vehiculos en una lista de objetos
    public static ArrayList<Vehiculo> leerFicheros(String idFichero) {

        System.out.println("Leyendo el fichero: " + idFichero);

        String[] tokens;
        String linea;
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();

        try (Scanner datosFichero = new Scanner(new File(idFichero), "UTF-8")) {

            datosFichero.nextLine();

            while (datosFichero.hasNextLine()) {

                linea = datosFichero.nextLine();
                tokens = linea.split(";");

                switch (Integer.parseInt(tokens[0])) {

                    case 0:
                        Turismo t1 = new Turismo();
                        t1.setBastidor(Long.parseLong(tokens[1]));
                        t1.setMatricula(tokens[2]);
                        t1.setMarca(tokens[3]);
                        t1.setModelo(tokens[4]);
                        t1.setColor(tokens[5]);
                        t1.setTarifa(Double.parseDouble(tokens[6]));
                        t1.setDisponible(Boolean.parseBoolean(tokens[7]));
                        t1.setPuertas(Integer.parseInt(tokens[8]));
                        t1.setMarchaAutomatica(Boolean.parseBoolean(tokens[9]));
                        vehiculos.add(t1);
                        break;

                    case 1:
                        Deportivo d1 = new Deportivo();
                        d1.setBastidor(Long.parseLong(tokens[1]));
                        d1.setMatricula(tokens[2]);
                        d1.setMarca(tokens[3]);
                        d1.setModelo(tokens[4]);
                        d1.setColor(tokens[5]);
                        d1.setTarifa(Double.parseDouble(tokens[6]));
                        d1.setDisponible(Boolean.valueOf(tokens[7]));
                        d1.setCilindrada(Integer.parseInt(tokens[8].substring(0, tokens[8].length() - 1)));
                        vehiculos.add(d1);
                        break;

                    case 2:
                        Furgoneta f1 = new Furgoneta();
                        f1.setBastidor(Long.parseLong(tokens[1]));
                        f1.setMatricula(tokens[2]);
                        f1.setMarca(tokens[3]);
                        f1.setModelo(tokens[4]);
                        f1.setColor(tokens[5]);
                        f1.setTarifa(Double.parseDouble(tokens[6]));
                        f1.setDisponible(Boolean.valueOf(tokens[7]));
                        f1.setCarga(Integer.parseInt(tokens[8]));
                        f1.setVolumen(Integer.parseInt(tokens[9].substring(0, tokens[9].length() - 1)));
                        vehiculos.add(f1);
                        break;

                }
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return vehiculos;
    }

    public static void borrarElemento(String ruta) {
        Path file = Paths.get(ruta);
        try {
            Files.delete(file);
        } catch (NoSuchFileException nsfe) {
            System.out.println("No se puede borrar " + ruta + " porque no existe");
        } catch (DirectoryNotEmptyException dnee) {
            System.out.println("No se puede borrar el directorio porque no estÃ¡ vacÃ­o");
        } catch (IOException e) {
            System.out.println("Problema borrando el elemento " + ruta);
        }
    }

    public static void main(String[] args) {

        ArrayList<Vehiculo> lista = new ArrayList<>();

        // Creo el directorio
        crearDirectorio("./copias");
        // Copio los archivos a la nueva ruta
        copiarFicheros("./Turismos.csv", "./copias/Turismos.csv");
        copiarFicheros("./Deportivos.csv", "./copias/Deportivos.csv");
        copiarFicheros("./Furgonetas.csv", "./copias/Furgonetas.csv");

        listarDirectorio("./copias");

        leerFicheros("./copias/Turismos.csv");
        leerFicheros("./copias/Deportivos.csv");
        leerFicheros("./copias/Furgonetas.csv");

        borrarElemento("./Turismos.csv");
        borrarElemento("./Deportivos.csv");
        borrarElemento("./Furgonetas.csv");

        //PREGUNTAR SOBRE ESTO A VICO DE POR QUÉ NO SE RELLENA DE OBJETOS
        // Imprimir la lista por pantalla. 
        for (Vehiculo vehiculo : lista) {
            
            System.out.println(vehiculo.toString());
        }

    }

}
