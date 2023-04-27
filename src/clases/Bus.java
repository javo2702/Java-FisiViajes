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
public class Bus extends Vehiculo{
    private Asiento[] listaPiso01 = new Asiento[15];
    private Asiento[] listaPiso02 = new Asiento[60];
    public Bus() {
        super();
        for(int i=0; i<listaPiso01.length;i++){
            listaPiso01[i]= new Asiento(i+1,1,false);
        }
        int nConti=listaPiso01.length;
        for(int j=0; j<listaPiso02.length;j++){
            nConti = nConti + 1;
            listaPiso02[j]= new Asiento(nConti,2,false);
        }
    }
    public Bus(String placa, String marca, boolean mantenimiento){
        super(placa,marca,mantenimiento);
        for(int i=0; i<listaPiso01.length;i++){
            listaPiso01[i]= new Asiento(i+1,1,false);
        }
        int nConti=listaPiso01.length;
        for(int j=0; j<listaPiso02.length;j++){
            nConti = nConti + 1;
            listaPiso02[j]= new Asiento(nConti,2,false);
        }
    }
    
    public void setListaPiso01(Asiento[] listaPiso01) {this.listaPiso01=listaPiso01;}
    public Asiento[] getListaPiso01() {return listaPiso01;}

    public void setListaPiso02(Asiento[] listaPiso02) {this.listaPiso02=listaPiso02;}
    public Asiento[] getListaPiso02() {return listaPiso02;}

    public void ActualizarNAsiento(int nBuscar){
        if(nBuscar<=15||nBuscar>=1){
            for(int i=0;i<listaPiso01.length;i++){
                if(listaPiso01[i].getnAsiento()==nBuscar){
                    listaPiso01[i].actualizarStatusVenta(true);
                    break;
                }
            }
        }
        else if(nBuscar>15||nBuscar<=75){
            for(int j=0;j<listaPiso02.length;j++){
                if(listaPiso02[j].getnAsiento()==nBuscar){
                    listaPiso02[j].actualizarStatusVenta(true);
                    break;
                }
            }
        }
    }

    public void mostarAsientosDisponibles(int piso){
        switch(piso){
            case 1:
                for(int i=0;i<listaPiso01.length;i++){
                    if(!listaPiso01[i].getStatusVenta()){
                        System.out.print("["+listaPiso01[i].getnAsiento()+"]  ");
                        if(i%5==0)
                            System.out.println("");
                    }
                    else
                        System.out.print("[  X  ]  ");
                }
                break;
            case 2:
                for(int j=0;j<listaPiso02.length;j++){
                    if(!listaPiso02[j].getStatusVenta()){
                        System.out.print("["+listaPiso02[j].getnAsiento()+"]  ");
                        if(j%15==0)
                            System.out.println("");
                    }
                    else
                        System.out.print("[  X  ]  ");
                }
                break;
        }
        
        
    }
}
