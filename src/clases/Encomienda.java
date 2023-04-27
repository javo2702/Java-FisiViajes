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
public class Encomienda {
    private int idEncomienda;
    private String nombreObjeto;
    private boolean fragilidad; 
    private double peso;
    //agregar un objeto que guarde los datos para luego compararlos
    
    
    public Encomienda(){
    }

    public Encomienda(boolean fragilidad, String nombreObjeto, double peso){
        this.fragilidad=fragilidad;
        this.nombreObjeto=nombreObjeto;
        this.peso=peso;
    }
    public String getNombreObjeto() {
        return nombreObjeto;
    }

    public void setNombreObjeto(String nombreObjeto) {
        this.nombreObjeto = nombreObjeto;
    }
    
    public int getIdEncomienda() {
        return idEncomienda;
    }

    public void setIdEncomienda(int idEncomienda) {
        this.idEncomienda = idEncomienda;
    }

    public boolean isFragilidad() {
        return fragilidad;
    }

    public void setFragilidad(boolean fragilidad) {
        this.fragilidad = fragilidad;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
}
