/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author jvall
 */
public class VentaPasaje extends Venta {
    //Atributos
    private int numAsiento;
    private int piso;
    private String ruta;
    private String horarioSalida;  
    private double montoTotalPagado;
    //Metodos
    public VentaPasaje(){
        
    }

    public VentaPasaje(int idVenta, String clienteDNI, String fechaPago, String hora, double montoTotalPagado, int numPasajes, int listaAsientos, String ruta, String horarioSalida) {
        super(idVenta, clienteDNI, fechaPago,hora);
        this.montoTotalPagado = montoTotalPagado;
        this.numAsiento = listaAsientos;
        this.ruta = ruta;    
        this.horarioSalida = horarioSalida;
    }
  
    /*public int getNumPasajes() {
        return numPasajes;
    }

    public void setNumPasajes(int numPasajes) {
        this.numPasajes = numPasajes;
    }

    public int[] getListaAsientos() {
        return listaAsientos;
    }

    public void setListaAsientos(int[] listaAsiento) {
        this.listaAsientos = listaAsiento;
    }
     */
    public int getPiso(){
        return piso;
    }
    public void setPiso(int p){
        piso = p;
    }
    public int getNumAsiento(){
        return numAsiento;
    }
    public void setNumAsiento(int num){
        numAsiento = num;
    }
    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getHorarioSalida() {
        return horarioSalida;
    }

    public void setHorarioSalida(String horarioSalida) {
        this.horarioSalida = horarioSalida;
    }
 
    public void setMontoTotalPagado(double monto){
        this.montoTotalPagado = monto;
    }

    public double getMontoTotalPagado(){
        return montoTotalPagado;
    }

    //Boleta de ventaPasaje
    /*public void mostrarBoleta(Empresa emp){
        Date fechaPago=new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); dateFormat.format(fechaPago);
        System.out.println("==============FISI INTERPROVINCIAL S.A.===================");
        System.out.println("--------------------------------------------------------");
        System.out.println("############----------BOLETA ELECTRONICA--------###########");
        System.out.println("---------------------------------------------------");
        System.out.println("RUC: "+emp.getRuc());
        System.out.println("Origen: LIMA");
        System.out.println("Destino: "+ ruta);
        System.out.println("Numero de pasajes comprados: " + numPasajes);
        System.out.println("Hora de partida: " + horarioSalida);
        System.out.println("==========================================================");
        System.out.println("DATOS DEL PASAJERO: ");
        System.out.println("DNI: "+ this.getClienteDNI()); 
        System.out.println("==========================================================");
        System.out.print("\tCONDICION DE PAGO: EFECTIVO");
        System.out.println("==========================================================");
        System.out.println("COSTO TOTAL: "+ this.getMontoTotalPagado());
    }*/
}
