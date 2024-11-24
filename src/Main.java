import model.Camion;
import model.Coche;
import model.Garaje;
import model.Vehiculo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Camion camion = new Camion("5634654","JuanitoJuan");
        Garaje garaje = new Garaje();
        List<Vehiculo> coches = generarCoches();

       testFuncionamiento(coches,garaje,camion);

    }
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
    public static void mostrarEstadoElementos(List<Vehiculo> coches,Garaje garaje,Camion camion){
        mostrarVehiculos(coches);
        System.out.println("\n\n"+camion);
        System.out.println("\n\n"+garaje);
    }

    public static boolean recogerCoches(List<Vehiculo> coches,Camion camion){
        for(int i = 0; i < camion.getCarga().length && i < coches.size();i++){
            camion.addCar((Coche) coches.get(i));
        }
        coches.removeAll(Arrays.asList(camion.getCarga()));

        return true;
    }

    public static void mostrarVehiculos(List<Vehiculo> vehiculos){
        System.out.println("\n-------------------------VEHICULOS DISPONIBLES----------------------------");
        for (Vehiculo c : vehiculos){
            System.out.println(c);
        }
        System.out.println("--------------------------------------------------------------------------");
    }

    public static List<Vehiculo> generarCoches(){
        List<Vehiculo> coches = new ArrayList<>();

        coches.add(new Coche("2810 BGY","Pepe","Toyota","Corla"));
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
        return coches;
    }
}