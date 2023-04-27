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
public class Cliente extends Persona{
    private String listaSolicitud[];
    
    public Cliente(){
        super();
        listaSolicitud = new String[0];
    }
    public Cliente(String nombres, String apellidos, String dni, int edad, String sexo, String celular){
        super(nombres,apellidos,dni,edad,sexo,celular);
        listaSolicitud = new String[0];
    }
}
