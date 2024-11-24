package model;

public class Camion extends Vehiculo{
    public static final int MAX_COCHES = 4;
    Coche[] carga;

    public Camion(String matricula,String propietario){
        super(matricula,propietario);
        this.carga = new Coche[MAX_COCHES];
    }

    public boolean addCar(Coche coche){
        int i = 0;
        do {

            if(carga[i] == null){
                carga[i] = coche;
                return true;
            }
            i++;
        }while (carga != null && i < carga.length);
            return false;
    }
    public boolean estaCargado(String id_coche){
        for(Coche c : carga){
            if(id_coche.equals(c.matricula))return true;
        }
        return false;
    }
    public boolean removeCar(String id_coche){
        int encontrado = 0;
        Coche[] aux = new Coche[MAX_COCHES];

        if(estaCargado(id_coche)){
            for (int i = 0; i < MAX_COCHES; i++){
                if(carga[i] == null)break;
                if(carga[i].matricula.equals(id_coche)){
                    encontrado = i;
                    continue;
                }
                aux[encontrado] = carga[i];
                encontrado++;
            }
            carga = aux;
            return true;
        }
        return false;
    }

    public Coche[] getCarga(){
        return this.carga;
    }
    private String mostrarCarga(){
        String coches = "\n";
        int i = 0;
        while (i != MAX_COCHES&&carga[i] != null){
            coches += carga[i].toString()+"\n";
            i++;
        }
        if (coches.isBlank()) coches = "No hay carga";
        return coches;
    }


    @Override
    public String toString() {
        return "---------------------------ESTADO ACTUAL DE EL CAMION-----------------------------------\n"+
                "Camion --> " + "Matricula: "+  matricula + "\t Conductor: "+ propietario +"\nCarga:"+ mostrarCarga()+
                "\n---------------------------------------------------------------------------------------\n";
    }
}
