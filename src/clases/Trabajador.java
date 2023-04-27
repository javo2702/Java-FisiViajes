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
public abstract class Trabajador extends Persona{
    private double sueldo;
    private String idCorporativo;
    
    public Trabajador(){
        super();
        sueldo = 0;
        idCorporativo = "---";
    }
    public Trabajador(String nombres, String apellidos, String dni, int edad, String sexo, String celular, double sueldo, String idCorporativo){
        super(nombres,apellidos,dni,edad,sexo,celular);
        this.sueldo = sueldo;
        this.idCorporativo = idCorporativo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String getIdCorporativo() {
        return idCorporativo;
    }

    public void setIdCorporativo(String idCorporativo) {
        this.idCorporativo = idCorporativo;
    }
    abstract double obtenerGratificacion();
    
    @Override
    public void mostrarDatos(){
        super.mostrarDatos();
        System.out.println("Sueldo: "+sueldo);
        System.out.println("IdCorporativo: "+idCorporativo);
    }
}
