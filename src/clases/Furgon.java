/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author jvall
 */
public class Furgon extends Vehiculo{
    private int capacidadMaxima;
    public Furgon() {
        super();
        capacidadMaxima = 100;
    }
    public Furgon(String placa, String marca, boolean mantenimiento, int capacidadMaxima) {
        super(placa,marca,mantenimiento);
        this.capacidadMaxima = capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {this.capacidadMaxima=capacidadMaxima;}
    
    public int getCapacidadMaxima() {return capacidadMaxima;}
    
    public void ActualizarCapacidad(int capOcup){
        capacidadMaxima = capacidadMaxima - capOcup;
    }
}
