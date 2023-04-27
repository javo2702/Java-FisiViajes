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
public abstract class Vehiculo {
    protected String placa;
    protected String marca;
    protected boolean mantenimiento;
    
    public Vehiculo() {
        placa = "-----";
        marca = "-----";
        mantenimiento = false;
    }
    
    public Vehiculo(String placa, String marca, boolean mantenimiento) {
        this.placa = placa;
        this.marca = marca;
        this.mantenimiento = mantenimiento;
    }
    
    public void setPlaca(String placa) {
        this.placa=placa;
    }
    
    public String getPlaca() {
        return placa;
    }

    public void setMarca(String marca) {
        this.marca=marca;
    }
    public String getMarca(){
        return marca;
    }
    public void setMantenimiento(boolean mantenimiento) {
        this.mantenimiento = mantenimiento;
    }
    public boolean getMantenimiento() {
        return mantenimiento;
    }
}
