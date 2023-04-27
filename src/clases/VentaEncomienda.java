/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;
import java.util.ArrayList;

/**
 *
 * @author jvall
 */
public class VentaEncomienda extends Venta{
    //Atributos
    private String codigoPaquete;
    private ArrayList<Encomienda> listaEncomienda;
    private String ruta;
    private String destinatarioDNI;
    //private String destinarioNombre;
    //private String destinarioDireccion;
    private double pesoTotal;
    private double costoTotal;
    private int cantidad;

    //Metodos
    public VentaEncomienda() {   
    }

    public VentaEncomienda(int idVenta, String clienteDNI, String fechaPago,String hora, Encomienda listaEncomienda[], String destinatarioDNI,
    String destinarioNombre, String destinarioDireccion, double pesoTotal, double costoTotal) {
        super(idVenta,clienteDNI,fechaPago,hora);
        //this.listaEncomienda = listaEncomienda;
        this.destinatarioDNI = destinatarioDNI;
        //this.destinarioNombre = destinarioNombre;
        //this.destinarioDireccion = destinarioDireccion;
        this.pesoTotal=pesoTotal;
        this.costoTotal=costoTotal;
    }

    public void setCostoTotal(double costoTotal){
        this.costoTotal=costoTotal;
    }

    public double getCostoTotal(){
        return costoTotal;
    }

    public void setPesoTotal(double pesoTotal){
        this.pesoTotal=pesoTotal;
    }

    public double getPesoTotal(){
        return pesoTotal;
    }
    /*
    public void setDestinatarioDireccion(String destinarioDireccion){
        this.destinarioDireccion=destinarioDireccion;
    }
    
    public String getDestinatarioDireccion(){
        return destinarioDireccion;
    }

    public void setDestinarioNombre(String destinarioNombre){
        this.destinarioNombre=destinarioNombre;
    }
    
    public String getDestinatarioNombre(){
        return destinarioNombre;
    }
    */
    public ArrayList<Encomienda> getListaEncomienda() {
        return listaEncomienda;
    }

    public void setListaEncomienda(ArrayList<Encomienda> listaEncomienda) {
        this.listaEncomienda = listaEncomienda;
    }

    public String getDestinatarioDNI() {
        return destinatarioDNI;
    }

    public void setDestinatarioDNI(String destinatarioDNI) {
        this.destinatarioDNI = destinatarioDNI;
    }
    public void setRuta(String r){
        ruta = r;
    }
    public String getRuta(){
        return ruta;
    }
    public void setCantidad(int c){
        cantidad = c;
    }
    public int getCantidad(){
        return cantidad;
    }
    public void setCodigoPaquete(String cd){
        codigoPaquete = cd;
    }
    public String getCodigoPaquete(){
        return codigoPaquete;
    }
    public void enlistarEncomienda(Encomienda listaEncomienda[]){
        //MUDANZA
    }
    
    public void calcularCostoTotal(double precio){
        double costoT=0, cunid;
        for(int i=0; i<listaEncomienda.size(); i++){
            if(listaEncomienda.get(i).isFragilidad()==true){
                cunid=listaEncomienda.get(i).getPeso()*precio*1.05;
                costoT+=cunid;
            }else{
                cunid=listaEncomienda.get(i).getPeso()*precio;
                costoT+=cunid;
            }
        }  
        costoTotal=costoT;
    }
    
/*
    public void mostrarListaEncomienda(){
        System.out.println("NUM\t NOMBRE_OBJETO \t PESO(Kg.)\t FRAGILIDAD");
        System.out.println("==========================================================");
        for(int i=0; i<listaEncomienda.length; i++){
            System.out.print("["+(i+1)+"]\t "+listaEncomienda[i].getNombreObjeto()+"\t "+listaEncomienda[i].getPeso()+
            "\t "+listaEncomienda[i].isFragilidad());
        }
        System.out.println("==========================================================");
    }
    public void calcularPesoTotal(){
        double suma=0;
        for(int i=0; i<listaEncomienda.size(); i++){
            suma+=listaEncomienda.get(i).getPeso();
        }
        pesoTotal=suma;
    }
    

   //5 soles por costo en kg
    public void calcularCostoTotal(){
        double costoT=0, cunid;
        for(int i=0; i<listaEncomienda.length; i++){
            if(listaEncomienda[i].isFragilidad()==true){
                cunid=listaEncomienda[i].getPeso()*5*1.05; //Si el objeto es fragil se añade al costo un 5%
                costoT+=cunid;
            }else{
                cunid=listaEncomienda[i].getPeso()*5;
                costoT+=cunid;
            }
        }  
        this.costoTotal=costoT;
    }

    public void mostrarBoleta(Empresa emp){
        Date fechaPago=new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); dateFormat.format(fechaPago);
        System.out.println("==============FISI INTERPROVINCIAL S.A.===================");
        System.out.println("--------------------------------------------------------");
        System.out.println("############----------BOLETA ELECTRONICA--------###########");
        System.out.println("---------------------------------------------------");
        System.out.println("RUC: "+emp.getRuc());
        //System.out.println("RECEPCIONISTA: "+Trabajador.getNombre());
        System.out.println("RECEPCIONISTA: "+clienteDNI);
        System.out.println("FECHA Y HORA ACTUAL: "+fechaPago);
        //System.out.println("NUM. DE SERIE: ");
        System.out.println("==========================================================");
        System.out.println("DNI DEL REMITENTE: "+clienteDNI); 
        System.out.println("NOMBRE DEL REMITENTE: "+clienteDNI);
        System.out.println("TELEFONO DEL REMITENTE: "+clienteDNI);
        System.out.println("NOMBRE DEL CONSIGNADO: "+getDestinatarioNombre());
        System.out.println("DNI DEL CONSIGNADO: "+getDestinatarioDNI());
        System.out.println("DIRECCION DEL CONSIGNADO: "+getDestinatarioDireccion()); //DESTINO - PENDIENTE RELACION ITINERARIO
        System.out.println("==========================================================");
        System.out.print("\tCONDICION DE PAGO: EFECTIVO");
        System.out.println("==========================================================");
        mostrarListaEncomienda();
        calcularPesoTotal();
        System.out.println("PESO TOTAL: "+getPesoTotal());
        //COSTO TOTAL
        calcularCostoTotal();
        System.out.println("COSTO TOTAL: "+getCostoTotal());
        System.out.println("==========================================================");
    }
*/
}
