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
public class ItinerarioBus extends Itinerario{
    private String placaBus;
    private String horarioSalida;
    private String terramozaDNI;
    private double costoSegundoPiso;
    private double costoPrimerPiso;
    
    public ItinerarioBus(){
        super();
        placaBus = "----";
        horarioSalida= "----";
        terramozaDNI = "----";
        costoPrimerPiso = 0.0;
        costoSegundoPiso = 0.0;
    }
    public ItinerarioBus(String ruta, String conductorDni, String placaBus, String horarioSalida, String terramozaDNI, double costoPrimerPiso, double costoSegundoPiso){
        super(ruta,conductorDni);
        this.placaBus = placaBus;
        this.horarioSalida = horarioSalida;
        this.terramozaDNI = terramozaDNI;
        this.costoPrimerPiso = costoPrimerPiso;
        this.costoSegundoPiso = costoSegundoPiso;
    }
    public String getPlacaBus() {
        return placaBus;
    }

    public void setPlacaBus(String placaBus) {
        this.placaBus = placaBus;
    }

    public String getHorarioSalida(){
        return horarioSalida;
    }

    public void setHorarioSalida(String horarioSalida) {
        this.horarioSalida = horarioSalida;
    }

    public String getTerramozaDNI() {
        return terramozaDNI;
    }

    public void setTerramozaDNI(String terramozaDNI) {
        this.terramozaDNI = terramozaDNI;
    }

    public double getCostoSegundoPiso() {
        return costoSegundoPiso;
    }

    public void setCostoSegundoPiso(double costoSegundoPiso) {
        this.costoSegundoPiso = costoSegundoPiso;
    }

    public double getCostoPrimerPiso() {
        return costoPrimerPiso;
    }

    public void setCostoPrimerPiso(double costoPrimerPiso) {
        this.costoPrimerPiso = costoPrimerPiso;
    }
    @Override
     public void mostrarItinerario(){
        System.out.println("Placa: "+placaBus);
        System.out.println("Hora de salida: "+horarioSalida);
        
    }
}
