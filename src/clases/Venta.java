/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;
import java.util.Date;
/**
 *
 * @author jvall
 */
public abstract class Venta {
    //Atributos
    private int idVenta;
    protected String clienteDNI;
    protected String fechaPago;
    protected String horaPago;

    //Metodos
    public Venta(){
        idVenta = 0;
        clienteDNI = " ";
        fechaPago = "";
    }

    public Venta(int idVenta, String clienteDNI, String fechaPago, String hora){
        this.idVenta = idVenta;
        this.clienteDNI = clienteDNI;
        this.fechaPago = fechaPago;
        horaPago = hora;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public String getClienteDNI() {
        return clienteDNI;
    }

    public void setClienteDNI(String clienteDNI) {
        this.clienteDNI = clienteDNI;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }
    public void setHoraPago(String hora){
        horaPago = hora;
    }
    public String getHoraPago(){
        return horaPago;
    }
    
    //public abstract void mostrarBoleta(Empresa emp);
}
