package model;

import java.util.ArrayList;
import java.util.List;

public class Garaje {

    public  static final int PLAZAS_DISPONIBLES = 10;
    public  int ESPACIO_OCUPADO = 0;

    private List<Coche> cochesAlmacen;
    private String marcaEspecialidad;


    public Garaje(){
        this.cochesAlmacen = new ArrayList<>();
        this.marcaEspecialidad ="";
    }

    public Garaje(String marcaEspecialidad){
        this.marcaEspecialidad = marcaEspecialidad;
        this.cochesAlmacen = new ArrayList<>();
    }

    public void recogidaVehiculos(Camion camion){
        if(marcaEspecialidad.isBlank())recogidaVehiculo(camion);
        else recogidaEspecializada(camion);

    }
    public boolean recogidaEspecializada(Camion camion){
        boolean descargado = false;
        List<String> cochesGuardados = new ArrayList<>();

        for(Coche c : camion.getCarga()){
            if (c == null)continue;
            if(ESPACIO_OCUPADO < PLAZAS_DISPONIBLES && c.getMarca().equals(marcaEspecialidad)){
                cochesAlmacen.add(c);
                cochesGuardados.add(c.getMatricula());

                ESPACIO_OCUPADO++;
                descargado = true;
            }
        }
        if (descargado){
            for(String id_coche : cochesGuardados){
                camion.removeCar(id_coche);
            }
        }


        return descargado;
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
