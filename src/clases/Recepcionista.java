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
public class Recepcionista extends Trabajador{
    private String nivelTecnologico;
    private String idiomas;
    
    public Recepcionista(){
        super();
        nivelTecnologico = "Sin informacion";
        idiomas = "Sin idiomas";
    }
    public Recepcionista(String nombres, String apellidos, String dni, int edad, String sexo, String celular,
            double sueldo, String idCorporativo, String nivelTecnologico, String idiomas){
        super(nombres,apellidos,dni,edad,sexo,celular,sueldo,idCorporativo);
        this.nivelTecnologico = nivelTecnologico;
        this.idiomas = idiomas;
    }

    public String getNivelTecnologico() {
        return nivelTecnologico;
    }

    public void setNivelTecnologico(String nivelTecnologico) {
        this.nivelTecnologico = nivelTecnologico;
    }

    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }
    
    @Override
    public double obtenerGratificacion(){
        return 5;
    }
    @Override
    public void mostrarDatos(){
        super.mostrarDatos();
        System.out.println("Nivel Tecnologico: "+nivelTecnologico);
        System.out.println("Idiomas: "+idiomas);
        System.out.println("###########################");
    }
}
