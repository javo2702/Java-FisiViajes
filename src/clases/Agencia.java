/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jvall
 */
public class Agencia {
    private String nombre;
    private String direccion;
    private String recepcionistaDNI;
    private String telefono;
    private VentaPasaje ventaPasajes[];
    private VentaEncomienda ventaEncomiendas[];
    Connection con;
    
    public Agencia(Empresa emp){
        con = emp.getConexion();
    }
    public Agencia(){
        nombre = "-----";//Identificador para buscarAgencia -> (Empresa)
        direccion = "-----";
        recepcionistaDNI = "-----";
        telefono = "-----";
        ventaPasajes = new VentaPasaje[0];
        ventaEncomiendas = new VentaEncomienda[0];
    }
    public Agencia(String nombre, String direccion, String recepcionistaDNI, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.recepcionistaDNI = recepcionistaDNI;
        this.telefono = telefono;
        ventaPasajes = new VentaPasaje[0];
        ventaEncomiendas = new VentaEncomienda[0];
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRecepcionistaDni() {
        return recepcionistaDNI;
    }

    public void setRecepcionistaDni(String recepcionistaDNI) {
        this.recepcionistaDNI = recepcionistaDNI;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public VentaPasaje[] getVentaPasajes() {
        return ventaPasajes;
    }

    public void setVentaPasajes(VentaPasaje[] ventaPasajes) {
        this.ventaPasajes = ventaPasajes;
    }

    public VentaEncomienda[] getVentaEncomiendas() {
        return ventaEncomiendas;
    }

    public void setVentaEncomiendas(VentaEncomienda[] ventaEncomiendas) {
        this.ventaEncomiendas = ventaEncomiendas;
    }

    public void llenarVentas(VentaPasaje vp){
        try{
            String query = "INSERT INTO ventapasajes (clienteDni,fechaPago,horaPago,numeroAsiento,piso,ruta,horaSalida,montoPagado) values(?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, vp.getClienteDNI());
            ps.setString(2, vp.getFechaPago());
            ps.setString(3, vp.getHoraPago());
            ps.setInt(4, vp.getNumAsiento());
            ps.setInt(5, vp.getPiso());
            ps.setString(6, vp.getRuta());
            ps.setString(7, vp.getHorarioSalida());
            ps.setDouble(8, vp.getMontoTotalPagado());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Venta Registrada");
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al registrar vetna "+e.getMessage());
        }
    }
    public void llenarEncomienda(VentaEncomienda ve, String placa){
        try{
            String query = "INSERT INTO encomienda (codigoPaquete,clienteDni,fechaPago,horaPago,ruta,destinatarioDni,cantidad,montoPagado) values(?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, ve.getCodigoPaquete());
            ps.setString(2, ve.getClienteDNI());
            ps.setString(3, ve.getFechaPago());
            ps.setString(4, ve.getHoraPago());
            ps.setString(5, ve.getRuta());
            ps.setString(6, ve.getDestinatarioDNI());
            ps.setInt(7, ve.getCantidad());
            ps.setDouble(8, ve.getCostoTotal());
            ps.execute();
            llenarDetalleEncomienda(ve);
            actualizarCapacidadFurgon(ve.getPesoTotal(),placa);
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al registrar encomienda "+e.getMessage());
        }
    }
    
    public void llenarDetalleEncomienda(VentaEncomienda ve){
        for(int i=0; i<ve.getListaEncomienda().size();i++){
            try{
                String query = "INSERT INTO detalleencomienda (codigoPaquete,descripcion,peso,fragil) values(?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, ve.getCodigoPaquete());
                ps.setString(2, ve.getListaEncomienda().get(i).getNombreObjeto());
                ps.setDouble(3, ve.getListaEncomienda().get(i).getPeso());
                ps.setBoolean(4, ve.getListaEncomienda().get(i).isFragilidad());
                ps.execute();
            } catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error al registrar detalles de la encomienda "+e.getMessage());
            }
        }
    }
    
    public double obtenerCapacidadFurgon(String placa){
        double valor = 0;
        try{
            String query = "SELECT capacidad FROM furgon WHERE placa like '%"+placa+"%'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                valor = rs.getDouble("capacidad");
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error al obtener la capacidad del furgon "+placa+"; "+e.getMessage());
        }
        return valor; 
    }
    
    public void actualizarCapacidadFurgon(double peso, String placa){
        double pesoActu = obtenerCapacidadFurgon(placa) - peso;
        try{
            String query = "UPDATE furgon SET capacidad=? WHERE placa like '%"+placa+"%'";
            PreparedStatement p = con.prepareStatement(query);
            p.setDouble(1, pesoActu);
            p.execute();
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error al actualizar el peso del furgon "+placa+"; "+e.getMessage());
        }
    }
    
    /*public ArrayList<Encomienda> getDetalles(){
        ArrayList<Encomienda> encomiendas = new ArrayList<>();
        try{
            String query = "SELECT * FROM detalleencomienda";
            Statement s = con.createStatement();
            ResultSet r = s.executeQuery(query);
            while(r.next()){
                Encomienda en = new Encomienda();
                en.setNombreObjeto(r.getString("descripcion"));
                en.setPeso(r.getInt("peso"));
                en.setFragilidad(r.getBoolean("fragil"));
                encomiendas.add(en);
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al mostrar las encomienda "+e.getMessage());
        }
        return encomiendas;
    }
    */
    public ArrayList<String> buscarEncominedaDni(String dni){
        ArrayList<String> datos = new ArrayList<>();
        try{
            String query = "SELECT codigoPaquete,cantidad FROM encomienda WHERE destinatarioDni like '%"+dni+"%'";
            Statement s = con.createStatement();
            ResultSet r = s.executeQuery(query);
            while(r.next()){
                datos.add(r.getString("codigoPaquete"));
                datos.add(String.valueOf(r.getInt("cantidad")));
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al buscar Dni "+e.getMessage());
        }
        return datos;
    }
    
    public DefaultTableModel mostrarDetalles(String codigo){
        String [] titulos = {"Codigo Paqueto","Descripcion","Peso","Fragil"};
        DefaultTableModel modelo = new DefaultTableModel(null,titulos);
        String [] campos = new String[4];
        try{
            String query = "SELECT * FROM detalleencomienda WHERE codigoPaquete like '%"+codigo+"%'";
            Statement s = con.createStatement();
            ResultSet r = s.executeQuery(query);
            while(r.next()){
                campos[0] = r.getString("codigoPaquete");
                campos[1] = r.getString("descripcion");
                campos[2] = r.getString("peso");
                campos[3] = r.getString("fragil");
                modelo.addRow(campos);
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al buscar Dni "+e.getMessage());
        }
        return modelo;
    }
    public void registrarEntregaEncomienda(String codigo){
        try{
            String query = "DELETE FROM detalleencomienda WHERE codigoPaquete like '%"+codigo+"%'";
            Statement pst = con.createStatement();
            int n = pst.executeUpdate(query);
            if(n>=0) {
                JOptionPane.showMessageDialog(null, "Registro eliminado");
            } 
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al registrar entrega "+e.getMessage());
        }
    }
    
    /*
    public void agregarVentaPasajes(VentaPasaje vp ){
        int posi = ventaPasajes.length;
        redimensionarVentaPasaje();
        ventaPasajes[posi] = vp;
    }
    public void redimensionarVentaPasaje(){
        int n = ventaPasajes.length + 1;
        VentaPasaje vpaux[] = new VentaPasaje[n];
        for(int i=0;i<ventaPasajes.length;i++){
            vpaux[i]=ventaPasajes[i];
        }
        ventaPasajes = vpaux;
    }
/*
    public void procesoDeVenta(Empresa emp){
        int opc;
        char rpta;
        Scanner entrada = new Scanner(System.in);
        do{
            do{
                System.out.println("\tProcesos de Ventas");
                System.out.println("1. Venta Pasajes");
                System.out.println("2. Realizar Encomiendas");
                System.out.println("=> Seleccione un opcion: ");
                opc = entrada.nextInt();
            }while(opc<1||opc>2);
            switch(opc){
                case 1:
                    realizarVentaPasaje(emp);
                    break;
                case 2:
                    realizarVentaEncomienda(emp);
                    break;
            }
            entrada.nextLine();
            System.out.println("¿Desea realizar otra venta o encomienda?[y/n]");
            rpta = entrada.nextLine().charAt(0);
        }while(rpta=='Y'||rpta=='y');
    }
    
    public void realizarVentaPasaje(Empresa emp){
        //Para llenar Venta Pasaje
        String destino, horario, clienteDNI;
        Date fechaPago=new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); dateFormat.format(fechaPago);
        int numAs, piso, idVent, cantAsientos=0, listAsientos[] = new int[0];
        double montoTotal;
        //extras
        int indiceItinerario, indicePlaca;
        char rpta;
        double monto=0;
        Bus busAllenar;
        Scanner entrada = new Scanner(System.in);
        System.out.println("###########################################");
        System.out.println("#\tVenta de Pasajes");
        System.out.println("#  Fecha y hora actual: "+fechaPago);//va a cambiar
        //fechaPago = entrada.nextLine(); //va a cambiar
        clienteDNI = ingresarDatosCliente(emp);
        System.out.println("#  Ingrese el destino: ");
        destino = entrada.nextLine();
        if(emp.buscarDestino(destino)){
            horario = seleccionarHorario(emp, destino);
            indiceItinerario = emp.obtenerIndiceItiABorrar(destino,horario);
            indicePlaca = emp.obtenerIndiceVehiculo(emp.obtenerItinerario(indiceItinerario).getPlacaBus());
            busAllenar = emp.obtenerBus(indicePlaca);
            do{
                System.out.println("Seleccione el piso [1/2]: ");
                piso = entrada.nextInt();
                System.out.println("");
                busAllenar.mostarAsientosDisponibles(piso);
                System.out.println("");
                System.out.println("Seleccione el numero de asiento");
                numAs = entrada.nextInt();
                busAllenar.ActualizarNAsiento(numAs);
                System.out.println("=============================");
                busAllenar.mostarAsientosDisponibles(piso);
                System.out.println("=============================");
                

                cantAsientos = cantAsientos + 1;
                switch (piso) {
                    case 1:
                        monto = monto + emp.obtenerItinerario(indiceItinerario).getCostoPrimerPiso();
                        break;
                    case 2:
                        monto = monto + emp.obtenerItinerario(indiceItinerario).getCostoSegundoPiso();
                        break;
                }
                listAsientos = llenarAsientos(listAsientos,numAs);
                entrada.nextLine();
                System.out.println("¿Desea comprar otro asiento?");
                rpta = entrada.nextLine().charAt(0);
            }while(rpta=='Y'||rpta=='y');
            montoTotal = monto;
            idVent = generarIdVentaPajase();
            VentaPasaje vp = new VentaPasaje(idVent,clienteDNI,fechaPago,montoTotal,cantAsientos,listAsientos,destino,horario);
            agregarVentaPasajes(vp);
            vp.mostrarBoleta(emp);
            System.out.println("\n¡Venta Exitosa!");
        }
        else{
            System.out.println("Destino no disponible");
            System.out.println("\nVenta no realizada");
        }
    }
   
    public String ingresarDatosCliente(Empresa emp){
        String dniCliente;
        int indiceBuscar;
        Scanner entrada = new Scanner(System.in);
        System.out.println("#  Ingrese el DNI del cliente: ");
        dniCliente = entrada.nextLine();
        indiceBuscar = emp.buscarIndexCliente(dniCliente);
        if(indiceBuscar == -1){
            emp.agregarCliente();
        }
        return dniCliente;
    }
    public String seleccionarHorario(Empresa emp, String destino){
        String horarioElegido;
        Scanner entrada = new Scanner(System.in);
        emp.mostrarHorariosItinerario(destino);
        System.out.println("Seleccione un horario: ");
        horarioElegido = entrada.nextLine();
        return horarioElegido;
    }
    public int generarIdVentaPajase(){
        int idVentaAnt, ind = ventaPasajes.length;
        if(ind!=0)
            idVentaAnt = ventaPasajes[ind-1].getIdVenta()+1;
        else
            idVentaAnt = 100;
        return idVentaAnt;
    }
    public int generarIdVentaEncomienda(){
        int idVentaAnt, ind = ventaPasajes.length;
        if(ind!=0)
            idVentaAnt = ventaPasajes[ind-1].getIdVenta()+1;
        else
            idVentaAnt = 100;
        return idVentaAnt;
    }
    public int [] llenarAsientos(int asientos[], int nAsiento){
        int pos = asientos.length;
        int listAux[] = new int[pos+1];
        for(int i=0;i<asientos.length;i++){
            listAux[i] = asientos[i];
        }
        listAux[pos]=nAsiento;
        asientos = listAux;
        return asientos;
    }
    
    /*
    
    public void realizarVentaEncomienda(Empresa emp){
        Scanner entrada=new Scanner(System.in);
        int n,idVenta,indiceItinerario;
        String nomC, dirC, dniC;
        //Atributos
        Date fechaPago=new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); dateFormat.format(fechaPago);
        Encomienda listaEncomienda[];
        String destinatarioDNI;
        String destinarioNombre;
        String destinarioDireccion;
        double pesoTotal=0,peso;
        double costoTotal;
        String destino,horario;
        String clienteDNI;
        System.out.print("\t===== Realizar venta encomienda =====");
        System.out.println("Registro de datos del consignado");
        System.out.println("#  Fecha y hora actual: "+fechaPago);
        System.out.println("# Ingrese el DNI del cliente que envia: ");
        clienteDNI = entrada.nextLine();
        if(emp.buscarIndexCliente(clienteDNI)==-1){
            emp.agregarCliente();
        }
        System.out.print("\tDireccion: ");
        dirC=entrada.nextLine();

        if(emp.buscarDestino(dirC)){
            emp.mostrarHorariosItinerario(dirC);
            System.out.println("Seleccione un horario: ");
            horario = entrada.nextLine();
            indiceItinerario = emp.obtenerIndiceItiABorrar(dirC,horario);
            //setDestinatarioDireccion(dirC);
            System.out.print("\tNombre: ");
            nomC=entrada.nextLine();
            //setDestinarioNombre(nomC);
            System.out.print("\tDNI: ");
            dniC=entrada.nextLine();
            //setDestinatarioDNI();
            do{
            System.out.print("Ingrese la cantidad de objetos: ");
                n=entrada.nextInt(); 
            }while(n<1);
            listaEncomienda = new Encomienda[n];
            int rpta; //revisar
            for(int i=0; i<n; i++){
                String nom;
                System.out.print("Nombre del objeto "+(i+1)+": ");
                nom = entrada.nextLine();
                listaEncomienda[i].setNombreObjeto(nom);
                do{
                    System.out.print("Fragilidad del objeto "+(i+1)+" (1-SI || 0-NO): ");
                    rpta=entrada.nextInt();
                }while(rpta<0 || rpta>1);
                boolean f;
                if(rpta==1) f=true;
                else f=false;
                
                listaEncomienda[i].setFragilidad(f);
                System.out.print("Peso(Kg) del objeto "+(i+1)+": ");
                peso=entrada.nextDouble();
                if(f) peso=1.05*peso;
                pesoTotal+=peso;
                listaEncomienda[i].setPeso(peso);
            }
            //costoTotal=pesoTotal*emp.obtenerItinerario(indiceItinerario).getPrecioPorKilo();
            costoTotal=pesoTotal*5;
            idVenta=generarIdVentaEncomienda();
            VentaEncomienda ve = new VentaEncomienda(idVenta,clienteDNI,fechaPago,listaEncomienda,dniC,
            nomC,dirC,pesoTotal,costoTotal);
        }
        else{
            System.out.println("Destino no disponible");
            System.out.println("\nVenta no realizada");
        }   
    }
    
    */
}
