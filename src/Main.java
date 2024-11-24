import model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Camion camion = new Camion("5634654","Ramon");
        Garaje garaje = new Garaje();
        List<Vehiculo> coches = generarCoches();

       testFuncionamiento(coches,garaje,camion);
       testFuncionamientoMarcasEspecificas();

       testRecogidaCochesEspecificos();

    }

    /*****/
    public static void testFuncionamiento( List<Vehiculo> coches,Garaje garaje,Camion camion){
        System.out.println("\n");
        mostrarVehiculos(coches);

        recogerCoches(coches,camion);
        mostrarEstadoElementos(coches,garaje,camion);

        garaje.recogidaVehiculos(camion);


        mostrarEstadoElementos(coches,garaje,camion);

        recogerCoches(coches,camion);
        garaje.recogidaVehiculos(camion);

        mostrarEstadoElementos(coches,garaje,camion);


        recogerCoches(coches,camion);
        garaje.recogidaVehiculos(camion);

        mostrarEstadoElementos(coches,garaje,camion);

    }
    /** Internamente genrea los objetos necesarios para realizar las pruebas.
     * Intentara añadir de la carga de un camion solo coches de la marca especifica al garaje.
     * Carga multiples tipos de vehiculos y debe vaciar la carga para poder continuar.**/
    public static void testFuncionamientoMarcasEspecificas(){
        List<Vehiculo> coches = generarCoches();
        Garaje garajeToyota = new GarageEspecializado("Toyota");
        Camion camion = new Camion("5334654","Jose Manuel");

        mostrarVehiculos(coches);
        recogerCoches(coches,camion);
        garajeToyota.recogidaVehiculos(camion);

        mostrarEstadoElementos(coches,garajeToyota,camion);
        recogerCoches(coches,camion);
        garajeToyota.recogidaVehiculos(camion);

        mostrarEstadoElementos(coches,garajeToyota,camion);

        vaciarCarga(coches,camion);

        mostrarEstadoElementos(coches,garajeToyota,camion);

        recogerCoches(coches,camion);
        garajeToyota.recogidaVehiculos(camion);
        mostrarEstadoElementos(coches,garajeToyota,camion);

        vaciarCarga(coches,camion);
        mostrarEstadoElementos(coches,garajeToyota,camion);

    }
    public static void testRecogidaCochesEspecificos(){
        List<Vehiculo> coches = generarCoches();
        Garaje garajeToyota = new GarageEspecializado("BMW");
        Camion camion = new Camion("5334654","Jose Manuel");
        mostrarVehiculos(coches);
        recogerCoches(coches,camion,"BMW");
        garajeToyota.recogidaVehiculos(camion);

        mostrarEstadoElementos(coches,garajeToyota,camion);
        recogerCoches(coches,camion,"BMW");
        garajeToyota.recogidaVehiculos(camion);
        mostrarEstadoElementos(coches,garajeToyota,camion);
    }
    public  static  void vaciarCarga(List<Vehiculo> coches, Camion camion){
        for(Coche coche : camion.getCarga()){
            if(coche == null)continue;
            coches.addLast(coche);
            camion.removeCar(coche.getMatricula());
        }
    }

    /**
     * @param coches Conjunto de coches pendientes de recogida.
     * @param camion Camion encargado de la recogida de los vehiculos, puede ir cargado o descargado.
     * @param garaje Garaje donde se van a almacenar los vehiculos, con un numero de plazas disponibles
     *               y coches ya guardados.**/
    public static void mostrarEstadoElementos(List<Vehiculo> coches,Garaje garaje,Camion camion){
        mostrarVehiculos(coches);
        System.out.println("\n\n"+camion);
        System.out.println("\n\n"+garaje);
    }

    /**
     * @param coches  Conjunto de coches que estan por recoger
     * @param camion  Camion encargado de recoger los coches.
     **/
    public static void recogerCoches(List<Vehiculo> coches,Camion camion){

        for(int i = 0; i < camion.getCarga().length && i < coches.size();i++){
            camion.addCar((Coche) coches.get(i));
        }
        coches.removeAll(Arrays.asList(camion.getCarga()));
    }
    public static void recogerCoches(List<Vehiculo> coches,Camion camion, String brand){
        for(Vehiculo coche : coches){
            if(coche instanceof Coche){
                if(((Coche) coche).getMarca().equals(brand)){
                    camion.addCarByBrand((Coche) coche,brand);
                }
            }
        }

        coches.removeAll(Arrays.asList(camion.getCarga()));
    }

    /**
     * Mostrara los vehiculos de la lista de vehiculos disponibles previos a recogida o almacenage
     **/
    public static void mostrarVehiculos(List<Vehiculo> vehiculos){
        System.out.println("\n-------------------------VEHICULOS DISPONIBLES----------------------------");
        for (Vehiculo c : vehiculos){
            System.out.println(c);
        }
        System.out.println("--------------------------------------------------------------------------");
    }

    /**
     * @return List[Vehiculo]
     **/
    public static List<Vehiculo> generarCoches(){
        List<Vehiculo> coches = new ArrayList<>();

        coches.add(new Coche("2810 BGY","Pepe","Toyota","Corola"));
        coches.add(new Coche("4458 KVS","Lope","Toyota","Avensis"));
        coches.add(new Coche("8515 UNN","Oscar","Mecedes","Cherry"));
        coches.add(new Coche("8746 MDM","Simon","BMW","Java"));
        coches.add(new Coche("1010 BND","Jorge","BMW","Javac"));
        coches.add(new Coche("2343 KPK","Miguel","BMW","Javac"));
        coches.add(new Coche("7107 ABB","Bernarda","BMW","Javac"));
        coches.add(new Coche("7898 ZCT","Eugenia","Toyota","Yaris"));
        coches.add(new Coche("4030 NSV","Barbara","Nissab","GTR"));
        coches.add(new Coche("9801 CCC","Beatriz","Tesla","Lavadora"));
        coches.add(new Coche("7891 RPK","JoseLu","Tesla","Cybertruk"));
        coches.add(new Coche("7207 ABB","Joan","BMW","Javac"));
        return coches;
    }
}