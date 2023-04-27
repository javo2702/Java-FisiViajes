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
public class Asiento {
    //Atributos
    private int nAsiento;
    private int pisoAsiento;
    private boolean statusVenta;
    
    //Constructores
    public Asiento(){
    }

    public Asiento(int nAsiento, int pisoAsiento, boolean statusVenta) {
        this.nAsiento = nAsiento;
        this.pisoAsiento = pisoAsiento;
        this.statusVenta = statusVenta;
    }

    public void setNAsiento(int numA){
        nAsiento = numA;
    }
    public void setPisoAsiento(int pAsiento){
        pisoAsiento = pAsiento;
    }
    public void actualizarStatusVenta(boolean estado){
        statusVenta = estado;
    }
    public int getnAsiento(){
        return nAsiento;
    }
    public int getPisoAsiento(){
        return pisoAsiento;
    }
    public boolean getStatusVenta(){
        return statusVenta;
    }
}
