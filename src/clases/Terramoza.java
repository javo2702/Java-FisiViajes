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
public class Terramoza extends Trabajador{
    private String nombreInstitucion;
    private String idiomas;
    
    public Terramoza(){
        super();
        nombreInstitucion = "Sin nombre";
        idiomas = "Sin idiomas";
    }
    public Terramoza(String nombres, String apellidos, String dni, int edad, String sexo, String celular,
            double sueldo, String idCorporativo, String nombreInstitucion, String idiomas){
        super(nombres,apellidos,dni,edad,sexo,celular,sueldo,idCorporativo);
        this.nombreInstitucion = nombreInstitucion;
        this.idiomas = idiomas;
    }

    public String getNombreInstitucion() {
        return nombreInstitucion;
    }

    public void setNombreInstitucion(String nombreInstitucion) {
        this.nombreInstitucion = nombreInstitucion;
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
        System.out.println("Institucion de procedencia: "+nombreInstitucion);
        System.out.println("Idiomas: "+idiomas);
        System.out.println("###########################");
    }
}
