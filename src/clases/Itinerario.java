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
public abstract class Itinerario {
    private String ruta;
    private String conductorDNI;

    public Itinerario(){
        ruta = "---";
        conductorDNI = "----";  
        
    }

    public Itinerario(String ruta, String conductorDNI) {
        this.ruta = ruta;
        this.conductorDNI = conductorDNI;
    }
    
    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getConductorDNI() {
        return conductorDNI;
    }

    public void setConductorDNI(String conductorDNI) {
        this.conductorDNI = conductorDNI;
    }


    public void mostrarItinerario(){
        System.out.println("Ruta: "+ruta);
        System.out.println("Conductor: "+conductorDNI);
    }
}
