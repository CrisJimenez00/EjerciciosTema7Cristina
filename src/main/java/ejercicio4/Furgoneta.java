/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio4;

/**
 *
 * @author cristina
 */
public class Furgoneta extends Vehiculo {
    // Atributos específicos

    private int carga;
    private int volumen;

    public Furgoneta(Long bastidor, String matricula, String marca, String modelo, String color, double tarifa, int carga, int volumen) {
        super(bastidor, matricula, marca, modelo, color, tarifa); // Constructor padre
        this.carga = carga;
        this.volumen = volumen;
    }
// métodos ‘get’ de la subclase Furgoneta. Se omiten setters

    public int getCarga() {
        return this.carga;
    }

    public int getVolumen() {
        return this.volumen;
    }

    @Override
    public String getAtributos() {
        return "2-" + super.getAtributos() + "; " + this.carga + "; " + this.volumen;
    }

    @Override
    public String toString() {
        return "2-" + super.toString() + ":" + carga + ":" + volumen;
    }

}
