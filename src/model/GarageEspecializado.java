package model;

import java.util.ArrayList;
import java.util.List;

public class GarageEspecializado extends Garaje{
    private String marcaEspecialidad;

    public GarageEspecializado(){
        super();
    }
    public GarageEspecializado(String marcaEspecialidad){
        super();
        this.marcaEspecialidad = marcaEspecialidad;
    }
    public void recogidaVehiculos(Camion camion){
        recogidaEspecializada(camion);

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
}
