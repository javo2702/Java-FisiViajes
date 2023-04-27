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
public class Persona {
    private String nombres;
    private String apellidos;
    private String dni;
    private int edad;
    private String sexo;
    private String celular;

    public Persona(){
        nombres = "Sin nombre";
        apellidos = "Sin apellidos";
        dni = "000000";
        edad = 0;
        sexo = "Sin especificar";
        celular = "Sin numero";
    }
    public Persona(String nombres, String apellidos, String dni, int edad, String sexo, String celular){
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dni = dni;
        this.edad = edad;
        this.sexo = sexo;
        this.celular = celular;
    }
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
    
    public void mostrarDatos(){
        System.out.println("###########################");
        System.out.println("\t Datos Personales ");
        System.out.println("Nombres: "+nombres);
        System.out.println("Apellidos: "+apellidos);
        System.out.println("DNI "+dni);
        System.out.println("Edad: "+edad);
        System.out.println("Sexo: "+sexo);
        System.out.println("Celular: "+celular);
    }
}
