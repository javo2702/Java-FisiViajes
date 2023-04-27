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
public class ItinerarioFurgon extends Itinerario {
    private String placaFurgon;
    private double precioPorKilo;
    
    public ItinerarioFurgon(){
        super();
        placaFurgon="---";
        precioPorKilo = 0.0;
    }
    public ItinerarioFurgon(String ruta, String conductorDni, String placaFurgon, double precioPorKilo){
        super(ruta,conductorDni);
        placaFurgon = placaFurgon;
        this.precioPorKilo = precioPorKilo;
    }
    public String getPlacaFurgon(){
        return placaFurgon;
    }
    public void setPlacaFurgon(String placa){
        placaFurgon = placa;
    }
    public double getPrecioPorKilo() {
        return precioPorKilo;
    }

    public void setPrecioPorKilo(double precioPorKilo) {
        this.precioPorKilo = precioPorKilo;
    }
}
