/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio4;

/**
 *
 * @author cristina
 */
public class Deportivo extends Vehiculo {

    private int cilindrada; // Atributo específico para Deportivo

    public Deportivo(Long bastidor, String matricula, String marca, String modelo, String color, double tarifa, int cilindrada) {
        super(bastidor, matricula, marca, modelo, color, tarifa); // Constructor padre
        this.cilindrada = cilindrada;
    }
// métodos ‘get’ de la subclase Deportivo. Se omiten setters 

    public int getCilindrada() {
        return this.cilindrada;
    }

    @Override
    public String getAtributos() {
        return super.getAtributos() + "; " + this.cilindrada;
    }

}
