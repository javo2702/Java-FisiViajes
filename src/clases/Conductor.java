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
public class Conductor extends Trabajador{
    private boolean licencia;
    private boolean brevete;
    private String categoria;
    private String experiencia;
    
    public Conductor(){
        super();
        licencia = false;
        brevete = false;
        categoria = "Sin categoria";
        experiencia = "Sin informacion";
    }
    public Conductor(String nombres, String apellidos, String dni, int edad, String sexo, String celular, double sueldo, String idCorporativo,
            boolean licencia, boolean brevete, String categoria, String experiencia){
        super(nombres,apellidos,dni,edad,sexo,celular,sueldo,idCorporativo);
        this.licencia = licencia;
        this.brevete = brevete;
        this.categoria = categoria;
        this.experiencia = experiencia;
    }

    public boolean getLicencia() {
        return licencia;
    }

    public void setLicencia(boolean licencia) {
        this.licencia = licencia;
    }

    public boolean getBrevete() {
        return brevete;
    }

    public void setBrevete(boolean brevete) {
        this.brevete = brevete;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }
    
    public void asignarVehiculo(String placa){
        //asignarvehiculo
    }
    
    @Override
    public double obtenerGratificacion(){
        return 5;
    }
    @Override
    public void mostrarDatos(){
        super.mostrarDatos();
        System.out.println("Licencia: "+licencia);
        System.out.println("Categoria: "+categoria);
        System.out.println("Experiencia: "+experiencia);
        System.out.println("###########################");
    }
}
