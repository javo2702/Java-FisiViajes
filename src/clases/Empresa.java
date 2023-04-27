/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;
import java.awt.HeadlessException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelos.ConexionSQL;

/**
 *
 * @author jvall
 */
public class Empresa {
    //Conexion database
    ConexionSQL cc = new ConexionSQL();
    Connection con = cc.conexion();
    
    //Atributos nuevos
    private Cliente client;
    private ArrayList<ItinerarioBus> listaItinerarioBuses;
    //
    
    //Atributos
    private String ruc;
    private String razonSocial;
    
    
    //Metodo Constructor
    public Empresa(){
        ruc = "Fisi viajes";
        client = new Cliente();
        listaItinerarioBuses = new ArrayList<ItinerarioBus>();

    }

    public Cliente getCliente(){
        return client;
    }
    public String getRuc() {
        return ruc;
    }
    
    public void setRuc(String ruc) {
        this.ruc = ruc;
    }
    
    public String getRazonSocial() {
        return razonSocial;
    }
    
    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }
    
    public Connection getConexion(){
        return con;
    }
    /* metodos */

    
    // DESDE ACÁ VA A QUEDAR
   
    public void llenarTodosAsientos(String placaBus){
        for(int i=0;i<75;i++){
            try{
                String query = "INSERT INTO asientos (numero,piso,estado,placaBus) values(?,?,?,?)";
                PreparedStatement p = con.prepareStatement(query);
                p.setInt(1, (i+1));
                if(i<15)
                    p.setInt(2, 1);
                else
                    p.setInt(2, 2);
                p.setInt(3, 0);
                p.setString(4, placaBus);
                p.execute();
            } catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Error");
            }
        }
    }
    public void ultimoAsiento(int num,String placa){
        try{
            String query = "UPDATE bus SET ultimoAsiento=? WHERE placa like '%"+placa+"%'";
            PreparedStatement p = con.prepareStatement(query);
            p.setInt(1, num);
            p.execute();
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error"+e.getMessage());
        }
    }
    public int numeroUltimoAsiento(String placa){
        int n=-1;
        try{
            String query = "SELECT ultimoAsiento FROM bus WHERE placa like '%"+placa+"%'";
            Statement s = con.createStatement();
            ResultSet r = s.executeQuery(query);
            while(r.next()){
                n = r.getInt("ultimoAsiento");
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error"+e.getMessage());
        }
        return n;
    }
    public void modificarEstadoAsiento(String placa, int nAsiento){
        try{
            String query = "UPDATE asientos SET estado=1 WHERE placaBus like '%"+placa+"%' AND numero ="+nAsiento;
            PreparedStatement p = con.prepareStatement(query);
            p.execute();
            ultimoAsiento(nAsiento,placa);
            JOptionPane.showMessageDialog(null, "Asiento seleccionado");
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error"+e.getMessage());
        }
    }
    public ArrayList<Integer> obtenerDatosAsiento(String placa){
        int nAsi;
        ArrayList<Integer> datos = new ArrayList<Integer>();
        try{
            nAsi = numeroUltimoAsiento(placa);
            String query = "SELECT * FROM asientos WHERE placaBus like '%"+placa+"%' AND estado ="+1+" AND numero="+nAsi;
            Statement s = con.createStatement();
            ResultSet r = s.executeQuery(query);
            while(r.next()){
               datos.add(r.getInt("numero"));
               datos.add(r.getInt("piso"));
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error");
        }
        return datos;
    }
    public ArrayList<Integer> obtenerAsientosBus(String placa){
        ArrayList<Integer> asientos = new ArrayList<Integer>();
        try{
            String query = "SELECT estado FROM asientos WHERE placaBus like '%"+placa+"%'";
            Statement s = con.createStatement();
            ResultSet r = s.executeQuery(query);
            while(r.next()){
                asientos.add(r.getInt("estado"));
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error"+e.getMessage());
        }
        return asientos;
    }

    //-------ID contraseñas---------
    //
    //
    
    public String convertirSHA256(String password) {
	MessageDigest md = null;
	try {
		md = MessageDigest.getInstance("SHA-256");
	} 
	catch (NoSuchAlgorithmException e) {		
		e.printStackTrace();
		return null;
	}  
	byte[] hash = md.digest(password.getBytes());
	StringBuffer sb = new StringBuffer();
	for(byte b : hash) {        
            sb.append(String.format("%02x", b));
	}  
	return sb.toString();
    }
    
    public Boolean validarUsuario (String user, String psw) {
        String psw_sha = convertirSHA256(psw);
        String psw_db = "";
        String category = "";
        Boolean valid_user = false;
        Boolean valid = false;
        try{
            String query = "SELECT * FROM trabajador WHERE Categoria='Admin' OR Categoria='Recepcionista'";
            Statement st = con.createStatement();
            ResultSet r = st.executeQuery(query);
            while(r.next()){
                if(r.getString("idTrabajador").equals(user)) {
                    valid_user = true;
                    category = getCategoryOfUser(user);
                    psw_db = getPswOfUser(user, category);
                    if(psw_db.equals(psw_sha)) {
                        valid = true;
                    }
                }
            }
            if(valid_user) {
                if(!valid) {
                    JOptionPane.showMessageDialog(null,"Contraseña incorrecta");
                }
            } else {
               JOptionPane.showMessageDialog(null,"Usuario y contraseña incorrectos"); 
            }
            
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al momento de validar el usuario"+e.getMessage());
        }
        return valid;
    }
    
    public String getCategoryOfUser(String user) {
        String type_db = "";
        String category = "";
        try{
            String query = "SELECT * FROM trabajador WHERE Categoria='Admin' OR Categoria='Recepcionista'";
            Statement st = con.createStatement();
            ResultSet r = st.executeQuery(query);
            while(r.next()){
                type_db = r.getString("idTrabajador");
                if(type_db.equals(user)) {
                    category = r.getString("Categoria");
                }
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al momento de obtener categoria "+e.getMessage());
        }
        return category;
    }
    
    public String getPswOfUser(String idCorp, String category) {
        String psw = "";
        if(category.equals("Admin")) {
            try{
                String query = "SELECT * FROM admin WHERE idCorporativo="+"'"+idCorp+"'";
                Statement st = con.createStatement();
                ResultSet r = st.executeQuery(query);
                while(r.next()){
                    psw = r.getString("password");
                }
            } catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error al momento de obtener psw admin "+e.getMessage());
            }
        } else if (category.equals("Recepcionista")) {
            try{
                String query = "SELECT * FROM registro_recepcionista WHERE idCorporativo="+"'"+idCorp+"'";
                Statement st = con.createStatement();
                ResultSet r = st.executeQuery(query);
                while(r.next()){
                    psw = r.getString("password");
                }
            } catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error al momento de obtener psw recep "+e.getMessage());
            }
        }
        return psw;
    }
    
    //Fin de ID contraseñas
    
    //Itinerarios
    
    //
    public void agregarItinerario_buses(ItinerarioBus itBus){
        try{
            String query = "INSERT INTO itinerario_bus (ruta,dniConductor,placaBus,horarioSalida,dniTerramoza,costoSegundoPiso,costoPrimerPiso) values(?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, itBus.getRuta());
            ps.setString(2, itBus.getConductorDNI());
            ps.setString(3, itBus.getPlacaBus());
            ps.setString(4, itBus.getHorarioSalida());
            ps.setString(5, itBus.getTerramozaDNI());
            ps.setDouble(6, itBus.getCostoSegundoPiso());
            ps.setDouble(7, itBus.getCostoPrimerPiso());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Registro exitoso");
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Registro fallido "+e.getMessage());
        }
    }
    public void llenarListaItinerarioBus(){
        try{
            String query = "SELECT * FROM itinerario_bus";
            Statement st = con.createStatement();
            ResultSet r = st.executeQuery(query);
            while(r.next()){
                ItinerarioBus itB = new ItinerarioBus();
                itB.setRuta(r.getString("ruta"));
                itB.setConductorDNI(r.getString("dniConductor"));
                itB.setPlacaBus(r.getString("placaBus"));
                itB.setHorarioSalida(r.getString("horarioSalida"));
                itB.setCostoSegundoPiso(r.getDouble("costoSegundoPiso"));
                itB.setCostoPrimerPiso(r.getDouble("costoPrimerPiso"));
                listaItinerarioBuses.add(itB);
            }
            
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al llenar lista Itinerario Bus "+e.getMessage());
        }
    }
    
    public String obtenerCosto(String ruta, String horario, int piso){
        String costo;
        ItinerarioBus iBus = obtenerItinerario(ruta,horario);
        if(piso==1)
            costo = String.valueOf(iBus.getCostoPrimerPiso());
        else
            costo = String.valueOf(iBus.getCostoSegundoPiso());
        return costo;
        //eso safa creo
    }
    public ItinerarioBus obtenerItinerario(String ruta, String horario){
        ItinerarioBus iB = new ItinerarioBus();
        for(int i=0; i< listaItinerarioBuses.size();i++){
            iB = listaItinerarioBuses.get(i);
            if(iB.getRuta().equals(ruta)&&iB.getHorarioSalida().equals(horario)){
                return iB;
            }
        }
        return iB;
    }
    
    public DefaultTableModel mostrarDatosItBus(){
            String [] titulos = {"ID","ruta","dniConductor","placaBus","horarioSalida","dniTerramoza","Costo 2° piso","Costo 1° piso"};
            String [] campos = new String[8];
            DefaultTableModel modelo = new DefaultTableModel(null,titulos);
            String query = "SELECT * FROM itinerario_bus";
            try{
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query);
                while(rs.next()){
                    //llenarListaItinerarioBus(rs);
                    campos[0] = rs.getString("idItinerario");
                    campos[1] = rs.getString("ruta");
                    campos[2] = rs.getString("dniConductor");
                    campos[3] = rs.getString("placaBus");
                    campos[4] = rs.getString("horarioSalida");
                    campos[5] = rs.getString("dniTerramoza");
                    campos[6] = rs.getString("costoSegundoPiso");
                    campos[7] = rs.getString("costoPrimerPiso");
                    modelo.addRow(campos);
                }
            } catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error al mostrar datos en la tabla "+e.getMessage());
            }
            return modelo;
    }
    public void actualizarDatosItBus(String idItBus, ItinerarioBus itBus) {
            try {
                String query = "UPDATE itinerario_bus SET ruta=?,dniConductor=?,placaBus=?,horarioSalida=?,dniTerramoza=?,costoSegundoPiso=?,costoPrimerPiso=? WHERE idItinerario=?";

                PreparedStatement pst = con.prepareStatement(query);
                pst.setString(1, itBus.getRuta());
                pst.setString(2, itBus.getConductorDNI());
                pst.setString(3, itBus.getPlacaBus());
                pst.setString(4, itBus.getHorarioSalida());
                pst.setString(5, itBus.getTerramozaDNI());
                pst.setDouble(6, itBus.getCostoSegundoPiso());
                pst.setDouble(7, itBus.getCostoPrimerPiso()); 
                pst.setString(8, idItBus);

                pst.execute();

                JOptionPane.showMessageDialog(null, "Actualizacion Exitosa");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Actualizacion Fallida"+e.getMessage());
            }
    }
    public void eliminarDatosItBus(String idItBus) {  
            try {
                String query = "DELETE FROM itinerario_bus WHERE idItinerario="+idItBus;
                Statement pst = con.createStatement();
                int n = pst.executeUpdate(query);
                if(n>=0) {
                    JOptionPane.showMessageDialog(null, "Registro eliminado");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al eliminar registro "+e.getMessage());
            }
    }
    //
    public ArrayList<String> rutas (char rutasOption){
        ArrayList<String> rutas = new ArrayList<String>();
         String query= ""; 
        switch(rutasOption){
            case 'b': 
                query = "SELECT ruta FROM itinerario_bus";
                break;
                
            case 'f':
                query = "SELECT ruta FROM itinerario_furgon";
                break;       
        }
        try{
            Statement rut = con.createStatement();
            ResultSet reR = rut.executeQuery(query);
            while(reR.next()){
                rutas.add(reR.getString("ruta"));
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al obtener rutas"+e.getMessage());
        }
        return rutas;
    }
    
    public ArrayList<String> horarios(String ruta){
        ArrayList<String> horarios = new ArrayList<String>();
        try{
            String query = "SELECT * FROM itinerario_bus WHERE ruta like '%"+ruta+"%'";
            Statement hor = con.createStatement();
            ResultSet rHor = hor.executeQuery(query);
            while(rHor.next()){
                horarios.add(rHor.getString("horarioSalida"));
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al obtener horarios"+e.getMessage());
        }
        return horarios;
    }
    //itinerarioFurgon
    public void agregarItinerario_Furgon(ItinerarioFurgon itFurgon){
        try{
            String query = "INSERT INTO itinerario_furgon(ruta,dniConductor,placaFurgon,precioPorkilo) values(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, itFurgon.getRuta());
            ps.setString(2, itFurgon.getConductorDNI());
            ps.setString(3, itFurgon.getPlacaFurgon());
            ps.setDouble(4, itFurgon.getPrecioPorKilo());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Registro exitoso");
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Registro fallido");
        }
    }
    
    public void actualizarItinerarioFurgon(ItinerarioFurgon furgon, JTable tItinerarioF){
        try{
            String query = "UPDATE itinerario_furgon SET ruta=?, dniConductor=?, placaFurgon=?, precioPorKilo=? WHERE idItinerario=?";
            int filaSeleccionada = tItinerarioF.getSelectedRow();
            String dao = (String)tItinerarioF.getValueAt(filaSeleccionada, 0);
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, furgon.getRuta());
            pst.setString(2, furgon.getConductorDNI());
            pst.setString(3, furgon.getPlacaFurgon());
            pst.setDouble(4, furgon.getPrecioPorKilo());
            pst.setString(5,dao);
            pst.execute();
          
            JOptionPane.showMessageDialog(null, "Actualizacion Exitosa");
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Actualizacion Fallida"+e.getMessage());
        }
    }
    
     public void eliminarDatosItinerarioFurgon(JTable tablaIF){
        int filaSeleccionada = tablaIF.getSelectedRow();
        try{
            String query = "DELETE FROM itinerario_furgon WHERE idItinerario="+(String)tablaIF.getValueAt(filaSeleccionada, 0);
            Statement pst = con.createStatement();
            int n = pst.executeUpdate(query);
            if(n>=0) {
                JOptionPane.showMessageDialog(null, "Registro eliminado");
            } 
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al eliminar registro "+e.getMessage());
        }
    }
    
    public double obtenerCostoEncomienda(String ruta, String placa){
        double costo=0;
        try{
            String query = "SELECT precioPorKilo FROM itinerario_furgon WHERE ruta like '%"+ruta+"%' AND placaFurgon like '%"+placa+"%'";
            Statement s = con.createStatement();
            ResultSet r = s.executeQuery(query);
            while(r.next()){
                costo = r.getDouble("precioPorKilo");
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al obtener costo "+e.getMessage());
        }
        return costo;
    }

    public String placaFurgon(String ruta){
        String in = "";
        try{
            String query = "SELECT placaFurgon FROM itinerario_Furgon WHERE ruta like '%"+ruta+"%'";
            Statement sf=con.createStatement();
            ResultSet rs = sf.executeQuery(query);
            while(rs.next()){
                in = rs.getString("placaFurgon");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al mostrar datos en la tabla "+e.getMessage());
        }
                return in;
    }
    
    public DefaultTableModel mostrarDatosItFurgon(){
            String [] titulos = {"idItinerario","ruta","NomConductor","placaFurgon","precioPorKilo"};
            String [] campos = new String[5];
            DefaultTableModel modelo = new DefaultTableModel(null,titulos);
            String query = "SELECT * FROM itinerario_Furgon";
            try{
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query);
                while(rs.next()){
                    //Se llenarListaItinerarioFurgon(rs);
                    campos[0] = rs.getString("idItinerario");
                    campos[1] = rs.getString("ruta");
                    campos[2] = rs.getString("dniConductor");
                    campos[3] = rs.getString("placaFurgon");
                    campos[4] = rs.getString("precioPorKilo");
                    modelo.addRow(campos);
                }
            } catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error al mostrar datos en la tabla "+e.getMessage());
            }
            return modelo;
    }

    // Fin itinerarios
    
    // Trabajadores
        // Conductor
    public void agregarConductor(Conductor cond){
        try{
            int valor;
            String query = "INSERT INTO conductores (nombres,apellidos,dni,edad,sexo,celular,sueldo,idCorporativo,licencia,categoriaL,experiencia) values(?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, cond.getNombres());
            ps.setString(2, cond.getApellidos());
            ps.setString(3, cond.getDni());
            ps.setInt(4, cond.getEdad());
            ps.setString(5, cond.getSexo());
            ps.setString(6, cond.getCelular());
            ps.setDouble(7, cond.getSueldo());
            ps.setString(8, cond.getIdCorporativo());
            if(cond.getLicencia())
                valor = 1;
            else
                valor = 0;
            ps.setInt(9, valor);
            ps.setString(10, cond.getCategoria());
            ps.setString(11, cond.getExperiencia());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Registro exitoso");
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Registro fallido");
        }
    }
    public DefaultTableModel mostrarDatosConductor(){
        String [] titulos = {"idCond","Nombres","Apellidos","Dni","Edad","Sexo","Celular","Sueldo","IdCorp.","Licencia","Categoria","Experiencia"};
        String [] campos = new String[12];
        DefaultTableModel modelo = new DefaultTableModel(null,titulos);
        String query = "SELECT * FROM conductores";
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                campos[0] = rs.getString("idConductores");
                campos[1] = rs.getString("nombres");
                campos[2] = rs.getString("apellidos");
                campos[3] = rs.getString("dni");
                campos[4] = rs.getString("edad");
                campos[5] = rs.getString("sexo");
                campos[6] = rs.getString("celular");
                campos[7] = rs.getString("sueldo");
                campos[8] = rs.getString("idCorporativo");
                if(rs.getInt("licencia")==1)
                    campos[9] = "Si";
                else
                    campos[9] = "No";
                campos[10] = rs.getString("categoriaL");
                campos[11] = rs.getString("experiencia");
                modelo.addRow(campos);
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al mostrar datos en la tabla "+e.getMessage());
        }
        return modelo;
    }
    public void actualizarConductor(Conductor cond, JTable tCho){
        try{
            String query = "UPDATE conductores SET nombres=?, apellidos=?, dni=?, edad=?, sexo=?, celular=?, sueldo=?, idCorporativo=?, licencia=?, categoriaL=?, experiencia=? WHERE idConductores=?";
            int filaSeleccionada = tCho.getSelectedRow();
            String dao = (String)tCho.getValueAt(filaSeleccionada, 0);
            int valor;
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(12, dao);
            pst.setString(1, cond.getNombres());
            pst.setString(2, cond.getApellidos());
            pst.setString(3, cond.getDni());
            pst.setInt(4, cond.getEdad());
            pst.setString(5, cond.getSexo());
            pst.setString(6, cond.getCelular());
            pst.setDouble(7, cond.getSueldo());
            pst.setString(8, cond.getIdCorporativo());
            if(cond.getLicencia())
                valor = 1;
            else
                valor = 0;
            pst.setInt(9, valor);
            pst.setString(10, cond.getCategoria());
            pst.setString(11, cond.getExperiencia());
            pst.execute();
          
            JOptionPane.showMessageDialog(null, "Actualizacion Exitosa");
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Actualizacion Fallida"+e.getMessage());
        }
    }
    public void eliminarDatosConductor(JTable tablaCho){
        int filaSeleccionada = tablaCho.getSelectedRow();
        try{
            String query = "DELETE FROM conductores WHERE idConductores="+(String)tablaCho.getValueAt(filaSeleccionada, 0);
            Statement pst = con.createStatement();
            int n = pst.executeUpdate(query);
            if(n>=0) {
                JOptionPane.showMessageDialog(null, "Registro eliminado");
            } 
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al eliminar registro "+e.getMessage());
        }
    }
        // Fin conductor
    //Inicio Terramoza
    public void agregarTerramoza(Terramoza terramoza){
        try{
            String query = "INSERT INTO terramoza (nombres,apellidos,dni,edad,sexo,celular,sueldo,idCorporativo,idioma,institucion) values(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, terramoza.getNombres());
            ps.setString(2, terramoza.getApellidos());
            ps.setString(3, terramoza.getDni());
            ps.setInt(4, terramoza.getEdad());
            ps.setString(5, terramoza.getSexo());
            ps.setString(6, terramoza.getCelular());
            ps.setDouble(7, terramoza.getSueldo());
            ps.setString(8, terramoza.getIdCorporativo());
            ps.setString(9, terramoza.getIdiomas());
            ps.setString(10, terramoza.getNombreInstitucion());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Registro exitoso");
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Registro fallido "+e.getMessage());
        }
    }
    
    public DefaultTableModel mostrarDatosTerramoza(){
        String [] titulos = {"ID","Nombres","Apellidos","DNI","Edad","Sexo","Celular","Sueldo","idCorporativo","Idiomas","institucion"};
        String [] campos = new String[11];
        DefaultTableModel modelo = new DefaultTableModel(null,titulos);
        String query = "SELECT * FROM terramoza";
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                campos[0] = rs.getString("idterramoza");
                campos[1] = rs.getString("nombres");
                campos[2] = rs.getString("apellidos");
                campos[3] = rs.getString("dni");
                campos[4] = rs.getString("edad");
                campos[5] = rs.getString("sexo");
                campos[6] = rs.getString("celular");
                campos[7] = rs.getString("sueldo");
                campos[8] = rs.getString("idCorporativo");
                campos[9] = rs.getString("idioma");
                campos[10] = rs.getString("institucion");
                modelo.addRow(campos);
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al mostrar datos en la tabla "+e.getMessage());
        }
        return modelo;
    }
    
        public void actualizarTerramoza(Terramoza terramoza, JTable tRecep){
        try{
            String query = "UPDATE terramoza SET nombres = ?, apellidos = ?, dni = ?, edad = ?, sexo = ?, celular = ?, sueldo = ?, idCorporativo = ?, idioma = ?, institucion = ? WHERE id=?";
            int filaSeleccionada = tRecep.getSelectedRow();
            String dao = (String)tRecep.getValueAt(filaSeleccionada, 0);
            
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, terramoza.getNombres());
            pst.setString(2, terramoza.getApellidos());
            pst.setString(3, terramoza.getDni());
            pst.setInt(4, terramoza.getEdad());
            pst.setString(5, terramoza.getSexo());
            pst.setString(6, terramoza.getCelular());
            pst.setDouble(7, terramoza.getSueldo());
            pst.setString(8, terramoza.getIdCorporativo());
            pst.setString(9, terramoza.getIdiomas());
            pst.setString(10, terramoza.getNombreInstitucion());
            pst.setString(11, dao);
            pst.execute();
          
            JOptionPane.showMessageDialog(null, "Actualizacion Exitosa");
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Actualizacion Fallida"+e.getMessage());
        }
    }
    public void eliminarDatosTerramoza(JTable tablaCho){
        int filaSeleccionada = tablaCho.getSelectedRow();
        try{
            String query = "DELETE FROM terramoza WHERE idterramoza="+(String)tablaCho.getValueAt(filaSeleccionada, 0);
            Statement pst = con.createStatement();
            int n = pst.executeUpdate(query);
            if(n>=0) {
                JOptionPane.showMessageDialog(null, "Registro eliminado");
            } 
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al eliminar registro "+e.getMessage());
        }
    }
    //Fin Terramoza
        // Recepcionista
    public void agregarRecepcionista(Recepcionista recepcionista){
        String psw_sha = "";
        try{
            String query = "INSERT INTO registro_recepcionista (Nombres,Apellidos,DNI,Edad,Sexo,Celular,Sueldo,idCorporativo,NivelTecnologico,Idioma,password) values(?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, recepcionista.getNombres());
            ps.setString(2, recepcionista.getApellidos());
            ps.setString(3, recepcionista.getDni());
            ps.setInt(4, recepcionista.getEdad());
            ps.setString(5, recepcionista.getSexo());
            ps.setString(6, recepcionista.getCelular());
            ps.setDouble(7, recepcionista.getSueldo());
            ps.setString(8, recepcionista.getIdCorporativo());
            ps.setString(9, recepcionista.getNivelTecnologico());
            ps.setString(10, recepcionista.getIdiomas());
            psw_sha = convertirSHA256(recepcionista.getDni());
            ps.setString(11, psw_sha);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Registro exitoso");
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Registro fallido"+e.getMessage());
        }
    }
    
    public DefaultTableModel mostrarDatosRecepcionista(){
        String [] titulos = {"ID","Nombres","Apellidos","DNI","Edad","Sexo","Celular","Sueldo","idCorporativo","NivelTecnologico","Idioma"};
        String [] campos = new String[11];
        DefaultTableModel modelo = new DefaultTableModel(null,titulos);
        String query = "SELECT * FROM registro_recepcionista";
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                campos[0] = rs.getString("id");
                campos[1] = rs.getString("Nombres");
                campos[2] = rs.getString("Apellidos");
                campos[3] = rs.getString("DNI");
                campos[4] = rs.getString("Edad");
                campos[5] = rs.getString("Sexo");
                campos[6] = rs.getString("Celular");
                campos[7] = rs.getString("Sueldo");
                campos[8] = rs.getString("idCorporativo");
                campos[9] = rs.getString("NivelTecnologico");
                campos[10] = rs.getString("Idioma");
                modelo.addRow(campos);
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al mostrar datos en la tabla "+e.getMessage());
        }
        return modelo;
    }
    public void actualizarRecepcionista(Recepcionista recepcionista, JTable tRecep){
        try{
            String query = "UPDATE registro_recepcionista SET Nombres = ?, Apellidos = ?, DNI = ?, Edad = ?, Sexo = ?, Celular = ?, Sueldo = ?, idCorporativo = ?, NivelTecnologico = ?, Idioma = ? WHERE id=?";
            int filaSeleccionada = tRecep.getSelectedRow();
            String dao = (String)tRecep.getValueAt(filaSeleccionada, 0);
            
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, recepcionista.getNombres());
            pst.setString(2, recepcionista.getApellidos());
            pst.setString(3, recepcionista.getDni());
            pst.setInt(4, recepcionista.getEdad());
            pst.setString(5, recepcionista.getSexo());
            pst.setString(6, recepcionista.getCelular());
            pst.setDouble(7, recepcionista.getSueldo());
            pst.setString(8, recepcionista.getIdCorporativo());
            pst.setString(9, recepcionista.getNivelTecnologico());
            pst.setString(10, recepcionista.getIdiomas());
            pst.setString(11, dao);
            pst.execute();
          
            JOptionPane.showMessageDialog(null, "Actualizacion Exitosa");
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Actualizacion Fallida"+e.getMessage());
        }
    }
    public void eliminarDatosRecepcionista(JTable tablaCho){
        int filaSeleccionada = tablaCho.getSelectedRow();
        try{
            String query = "DELETE FROM registro_recepcionista WHERE id="+(String)tablaCho.getValueAt(filaSeleccionada, 0);
            Statement pst = con.createStatement();
            int n = pst.executeUpdate(query);
            if(n>=0) {
                JOptionPane.showMessageDialog(null, "Registro eliminado");
            } 
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al eliminar registro "+e.getMessage());
        }
        eliminarTrabajador((String)tablaCho.getValueAt(filaSeleccionada, 1));
    }
    
    public void eliminarTrabajador(String idCorp){
        try{
            String query = "DELETE FROM trabajador WHERE idTrabajador like '%"+idCorp;
            Statement pst = con.createStatement();
            int n = pst.executeUpdate(query);
            if(n>=0) {
                JOptionPane.showMessageDialog(null, "Trabajador eliminado");
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al eliminar trabajador "+e.getMessage());
        }
    }
    
        // Fin recepcionista
    
        // Clientes
    public void agregarCliente(Cliente clien){
        try{
            String query = "INSERT INTO clientes (nombres,apellidos,dni,edad,sexo,celular) values(?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, clien.getNombres());
            ps.setString(2, clien.getApellidos());
            ps.setString(3, clien.getDni());
            ps.setInt(4, clien.getEdad());
            ps.setString(5,clien.getSexo());
            ps.setString(6,clien.getCelular());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Registro exitoso");
        } catch(HeadlessException | SQLException em){
            JOptionPane.showMessageDialog(null, "Registro fallido");
        }
    }
    public boolean buscarClienteDni(String dniCli){
        boolean flag=false;
        try{
            String query = "SELECT * FROM clientes WHERE dni like '%"+dniCli+"%'";
            Statement busq = con.createStatement();
            ResultSet buscar = busq.executeQuery(query);
            while(buscar.next()){
                client.setNombres(buscar.getString("nombres"));
                client.setApellidos(buscar.getString("apellidos"));
                client.setCelular(buscar.getString("celular"));
                client.setEdad(buscar.getInt("edad"));
                client.setSexo(buscar.getString("sexo"));
                client.setDni(buscar.getString("dni"));
                flag = true;
                break;
            }
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "No se encuentra al cliente");
        }
        return flag;
    }
        // Fin clientes
    //Trabajadores
    public void agregarTrabajador(Trabajador t){
        try{
            String query = "INSERT INTO trabajador (idTrabajador,Categoria) values(?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            if(t instanceof Conductor){
                ps.setString(1, t.getIdCorporativo());
                ps.setString(2, "Conductor");
                ps.execute();
                this.agregarConductor((Conductor) t);
            }
            else if(t instanceof Recepcionista){
                ps.setString(1, t.getIdCorporativo());
                ps.setString(2, "Recepcionista");
                ps.execute();
                agregarRecepcionista((Recepcionista) t);
            }
            else{
                ps.setString(1, t.getIdCorporativo());
                ps.setString(2, "Terramoza");
                ps.execute();
                agregarTerramoza((Terramoza) t);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Registro del trabajador fallido"+e.getMessage());
        }
    }
    public DefaultTableModel mostarTrabajador(){
        String titulos[] = {"idTrabajador","nombres","Apellidos","Dni","Sexo","Sueldo","Categoria"};
        String contenido[] = new String[7];
        DefaultTableModel modelo = new DefaultTableModel(null,titulos);
        try{
            String query = "SELECT * FROM conductores INNER JOIN trabajador on conductores.idCorporativo = trabajador.idTrabajador";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                contenido[0] = rs.getString("idTrabajador");
                contenido[1] = rs.getString("nombres");
                contenido[2] = rs.getString("apellidos");
                contenido[3] = rs.getString("dni");
                contenido[4] = rs.getString("sexo");
                contenido[5] = rs.getString("sueldo");
                contenido[6] = rs.getString("Categoria");
                modelo.addRow(contenido);
            }
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Registro fallido "+e.getMessage());
        }
        try{
            String query = "SELECT * FROM terramoza INNER JOIN trabajador on terramoza.idCorporativo = trabajador.idTrabajador";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                contenido[0] = rs.getString("idTrabajador");
                contenido[1] = rs.getString("nombres");
                contenido[2] = rs.getString("apellidos");
                contenido[3] = rs.getString("dni");
                contenido[4] = rs.getString("sexo");
                contenido[5] = rs.getString("sueldo");
                contenido[6] = rs.getString("Categoria");
                modelo.addRow(contenido);
            }
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Registro fallido "+e.getMessage());
        }
        try{
            String query = "SELECT * FROM registro_recepcionista INNER JOIN trabajador on registro_recepcionista.idCorporativo = trabajador.idTrabajador";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                contenido[0] = rs.getString("idTrabajador");
                contenido[1] = rs.getString("nombres");
                contenido[2] = rs.getString("apellidos");
                contenido[3] = rs.getString("dni");
                contenido[4] = rs.getString("sexo");
                contenido[5] = rs.getString("sueldo");
                contenido[6] = rs.getString("Categoria");
                modelo.addRow(contenido);
            }
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Registro fallido "+e.getMessage());
        }
        return modelo;
    }
    public ArrayList<String> conductores(char cat){
        ArrayList<String> nombres = new ArrayList<>();
        String nombApe;
        switch(cat){
            case 'b': 
            try{
                String query = "SELECT nombres,apellidos FROM conductores WHERE categoriaL = 'A-IIIa' OR categoriaL = 'A-IIIb'";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query);
                while(rs.next()){
                    nombApe = rs.getString("nombres")+ " "+ rs.getString("apellidos");
                    nombres.add(nombApe);
                }
            } catch(SQLException e){
                JOptionPane.showMessageDialog(null,"Consulta fallida "+e.getMessage());
            }
                break;
                
            case 'f':
            try{
                String query = "SELECT nombres,apellidos FROM conductores WHERE categoriaL = 'A-I' OR categoriaL = 'A-IIb'";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query);
                while(rs.next()){
                    nombApe = rs.getString("nombres")+ " "+ rs.getString("apellidos");
                    nombres.add(nombApe);
                }
            } catch(SQLException e){
                JOptionPane.showMessageDialog(null,"Consulta fallida "+e.getMessage());
            }    
                break;   
        }
        return nombres;
    }

    public ArrayList<String> placas(char opc){
        ArrayList<String> placas = new ArrayList<>();
        switch(opc){
            case 'b':
                try{
                    String query = "SELECT placa FROM vehiculo WHERE tipo = 'Bus'";
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery(query);
                    while(rs.next()){
                        placas.add(rs.getString("placa"));
                    }
                } catch(SQLException e){
                    JOptionPane.showMessageDialog(null,"Consulta fallida "+e.getMessage());
                }
                break;
            case 'f':
                try{
                    String query = "SELECT placa FROM vehiculo WHERE tipo = 'Furgon'";
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery(query);
                    while(rs.next()){
                        placas.add(rs.getString("placa"));
                    }
                } catch(SQLException e){
                    JOptionPane.showMessageDialog(null,"Consulta fallida "+e.getMessage());
                }
                break;
        }
        return placas;
    }
    // ESto agregue
    /*public ArrayList<String> placasFurgon(){
        ArrayList<String> placas = new ArrayList<>();
        try{
            String query = "SELECT placa FROM furgon WHERE capacidad > 0";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                placas.add(rs.getString("placa"));
            }
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Consulta fallida "+e.getMessage());
        }
        return placas;
    }
    */
    
    // Hasta aca
    public ArrayList<String> terramozas(){
        ArrayList<String> nombres = new ArrayList<>();
        String nombApe;
        try{
            String query = "SELECT nombres,apellidos FROM terramoza";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                nombApe = rs.getString("nombres")+ " "+ rs.getString("apellidos");
                nombres.add(nombApe);
            }
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Consulta fallida "+e.getMessage());
        }
        return nombres;
    }
    // vehiculo
    public void agregarVehiculo(Vehiculo v){
        try{
            String query = "INSERT INTO vehiculo (placa,tipo) values (?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, v.getPlaca());
            if(v instanceof Bus){
                ps.setString(2, "Bus");
                ps.execute();
                agregarBus((Bus) v);
                
            }
            else{
                ps.setString(2, "Furgon");
                ps.execute();
                agregarFurgon((Furgon) v);
                
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,"Registro vehiculo fallido"+e.getMessage());
        }
    }
    public DefaultTableModel mostarVehiculos(){
        String titulos[] = {"Placa","Marca","¿Mantenimiento?","Categoria"};
        String contenido[] = new String[4];
        DefaultTableModel modelo = new DefaultTableModel(null,titulos);
        try{
            String query = "SELECT * FROM bus INNER JOIN vehiculo on bus.placa = vehiculo.placa";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                contenido[0] = rs.getString("placa");
                contenido[1] = rs.getString("marca");
                if(rs.getInt("mantenimiento")==0)
                    contenido[2] = "No";
                else
                    contenido[2] = "Si";
                contenido[3] = rs.getString("tipo");
                modelo.addRow(contenido);
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,"Registro fallido "+e.getMessage());
        }
        try{
            String query = "SELECT * FROM furgon INNER JOIN vehiculo on furgon.placa = vehiculo.placa";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                contenido[0] = rs.getString("placa");
                contenido[1] = rs.getString("marca");
                if(rs.getInt("mantenimiento")==0)
                    contenido[2] = "No";
                else
                    contenido[2] = "Si";
                contenido[3] = rs.getString("tipo");
                modelo.addRow(contenido);
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,"Registro fallido "+e.getMessage());
        }
        
        return modelo;
    }
    ///
    public void llenarTodosAsientos(String placaBus,Asiento[] a,Asiento[] a2){
        System.out.println("Piso 1:"+a.length+"  Piso 2"+a2.length);   
        for(int i=0;i<15;i++){
            try{
                String query = "INSERT INTO asientos (numero,piso,estado,placaBus) values(?,?,?,?)";
                PreparedStatement p = con.prepareStatement(query);
                    System.out.println(a[i].getnAsiento()+" "+a[i].getPisoAsiento());
                    p.setInt(1, a[i].getnAsiento());
                    p.setInt(2, a[i].getPisoAsiento());
                    p.setBoolean(3, a[i].getStatusVenta());
                    p.setString(4, placaBus);
                    p.execute();

            } catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Error"+ e.getMessage());
            }
        }
        for(int j=0;j<60;j++){
            try{
                String query = "INSERT INTO asientos (numero,piso,estado,placaBus) values(?,?,?,?)";
                PreparedStatement p = con.prepareStatement(query);
                    System.out.println(a2[j].getnAsiento()+" "+a2[j].getPisoAsiento());
                    p.setInt(1, a2[j].getnAsiento());
                    p.setInt(2, a2[j].getPisoAsiento());
                    p.setBoolean(3, a2[j].getStatusVenta());
                    p.setString(4, placaBus);
                    p.execute();

            } catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Error"+ e.getMessage());
            }
        }
    }

        // Bus
    public void agregarBus(Bus b){
        try{
            int valor;
            String query = "INSERT INTO bus (placa, marca, mantenimiento) values(?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, b.getPlaca());
            ps.setString(2, b.getMarca());
            if(b.getMantenimiento())
                valor = 1;
            else
                valor = 0;
            ps.setInt(3, valor);
            ps.execute();
            llenarTodosAsientos(b.getPlaca(),b.getListaPiso01(),b.getListaPiso02());
            JOptionPane.showMessageDialog(null, "Registro exitoso");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Registro de Bus fallido "+e.getMessage());
        }
    }
    
    public void actualizarBus(Bus bus, JTable tbus){
        try{
            String query = "UPDATE bus SET placa =?, marca=?, mantenimiento=? WHERE idBus = ?";
            int filaSeleccionada = tbus.getSelectedRow();
            String dao = (String)tbus.getValueAt(filaSeleccionada, 0);
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, bus.getPlaca());
            pst.setString(2, bus.getMarca());
            pst.setBoolean(3, bus.getMantenimiento());
            pst.setInt(4, Integer.parseInt(dao));
            pst.execute();
            JOptionPane.showMessageDialog(null, "Actualizacion Exitosa");
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Actualizacion Fallida "+e.getMessage());    
        }    
    }
 
    public DefaultTableModel mostrarBus(){
        String[] titulos = {"IdBus","Placa","Marca","Mantenimiento"};
        String[] campos = new String[4];
        DefaultTableModel modelo = new DefaultTableModel(null,titulos);
        String query = "SELECT * FROM bus";
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                //llenarListaBus(rs);
                campos[0] = rs.getString("idBus");
                campos[1] = rs.getString("placa");
                campos[2] = rs.getString("marca");
                if(rs.getInt("mantenimiento")==1)
                    campos[3] = "Si";
                else
                    campos[3] = "No";
                modelo.addRow(campos);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al mostrar datos en la tabla"+
                    e.getMessage());
        }
        return modelo;
    }
    public void eliminarBus(JTable tBus){
        int filaSeleccionada = tBus.getSelectedRow();
        String pla = (String)tBus.getValueAt(filaSeleccionada, 1);
        eliminarAsientos(pla);
        try{
            String query = "DELETE FROM bus WHERE placa like '%"+pla+"%'";
            Statement pst = con.createStatement();
            int n = pst.executeUpdate(query);
            if(n>=0) {
                JOptionPane.showMessageDialog(null, "Registro eliminado");
            } 
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al eliminar registro "+e.getMessage());
        }
    }
    public void eliminarAsientos(String placa){
        try{
            String query = "DELETE FROM asientos WHERE placa="+placa+"%'";
            Statement pst = con.createStatement();
            int n = pst.executeUpdate(query);
            if(n>=0) {
                JOptionPane.showMessageDialog(null, "Asiento eliminado");
            } 
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al eliminar asientos "+e.getMessage());
        }
    }
    
    public void eliminarVehiculo(String placa){
        try{
            String query = "DELETE FROM vehiculo WHERE placa like'%"+placa+"%'";
            Statement pst = con.createStatement();
            int n = pst.executeUpdate(query);
            if(n>=0) {
                JOptionPane.showMessageDialog(null, "vehiculo eliminado");
            } 
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al eliminar vehiculo "+e.getMessage());
        }
    }
    
    
    
    //Furgon
    public void agregarFurgon(Furgon f){
        try{
            int valor;
            String query = "INSERT INTO furgon (placa, marca, mantenimiento,capacidad) values(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, f.getPlaca());
            ps.setString(2, f.getMarca());
            if(f.getMantenimiento())
                valor = 1;
            else
                valor = 0;
            ps.setInt(3, valor);
            ps.setInt(4, f.getCapacidadMaxima());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Registro exitoso");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Registro fallido "+e.getMessage());
        }
    }
    public void actualizarFurgon(Furgon furgon, JTable tFurgon){
        try{
            String query = "UPDATE furgon SET placa =?, marca=?, mantenimiento=? capacidad =? WHERE idfurgon = ?";
            int filaSeleccionada = tFurgon.getSelectedRow();
            String dao = (String)tFurgon.getValueAt(filaSeleccionada, 0);
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, furgon.getPlaca());
            pst.setString(2, furgon.getMarca());
            pst.setBoolean(3, furgon.getMantenimiento());
            pst.setInt(4, furgon.getCapacidadMaxima());
            pst.setString(5, dao);
            pst.execute();
          
            JOptionPane.showMessageDialog(null, "Actualizacion Exitosa");
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Actualizacion Fallida"+e.getMessage());    
        }    
    }
    public DefaultTableModel mostrarFurgon(){
        String[] titulos = {"ID","Placa","Marca","Mantenimiento","Capacidad"};
        String[] campos = new String[5];
        DefaultTableModel modelo = new DefaultTableModel(null,titulos);
        String query = "SELECT * FROM furgon";
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                //llenarListaBus(rs);
                campos[0] = rs.getString("idFurgon");
                campos[1] = rs.getString("placa");
                campos[2] = rs.getString("marca");
                if(rs.getInt("mantenimiento")==1)
                    campos[3] = "Sí";
                else
                    campos[3] = "No";
                campos[4] = rs.getString("capacidad");
                modelo.addRow(campos);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al mostrar datos en la tabla"+
                    e.getMessage());
        }
        return modelo;
    }
    public void eliminarFurgon(JTable tFurgon){
         int filaSeleccionada = tFurgon.getSelectedRow();
        try{
            String query = "DELETE FROM furgon WHERE idfurgon="+(String)tFurgon.getValueAt(filaSeleccionada, 0);
            Statement pst = con.createStatement();
            int n = pst.executeUpdate(query);
            if(n>=0) {
                JOptionPane.showMessageDialog(null, "Registro eliminado");
            } 
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al eliminar registro "+e.getMessage());
        }
    }
    
    public String getNombreRecepcionista(String usuario){
        String nombre = "";
        try{
            String query = "SELECT Nombres, Apellidos FROM registro_recepcionista WHERE idCorporativo like '%"+usuario+"%'";
            Statement s = con.createStatement();
            ResultSet r = s.executeQuery(query);
            while(r.next()){
                nombre = r.getString("Nombres")+" "+r.getString("Apellidos");
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al obtener el nombre de la Recepcionista "+e.getMessage());
        }
        return nombre;
    }
    
}