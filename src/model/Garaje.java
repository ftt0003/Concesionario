package model;

import java.util.ArrayList;
import java.util.List;

public class Garaje {

    public  static final int PLAZAS_DISPONIBLES = 10;
    public  int ESPACIO_OCUPADO = 0;

    protected List<Coche> cochesAlmacen;



    public Garaje(){
        this.cochesAlmacen = new ArrayList<>();

    }


    public void recogidaVehiculos(Camion camion){
        recogidaVehiculo(camion);

    }


    public boolean recogidaVehiculo(Camion camion){
        boolean descargado = false;
        List<String> cochesGuardados = new ArrayList<>();

        for(Coche c : camion.getCarga()){
            if(ESPACIO_OCUPADO < PLAZAS_DISPONIBLES){
                cochesAlmacen.add(c);
                cochesGuardados.add(c.getMatricula());

                ESPACIO_OCUPADO++;
                descargado = true;
            }else{
                return descargado;
            }

        }
        if (descargado){
            for(String id_coche : cochesGuardados){
                camion.removeCar(id_coche);
            }
        }


        return descargado;
    }


    private String obtenerVehiculosGaraje(){
        String coches = "";
        for(Coche c : cochesAlmacen){
            coches += c.toString()+"\n";
        }
        return coches;
    }

    @Override
    public String toString() {
        return "---------------------------ESTADO ACTUAL DE EL GARAJE-----------------------------------\n"+
                "Graje --> " + "cochesAlmacen:\n" + obtenerVehiculosGaraje() +
                "\n---------------------------------------------------------------------------------------";
    }
}
