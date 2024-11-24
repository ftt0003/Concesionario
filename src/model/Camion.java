package model;

public class Camion extends Vehiculo{
    /**@Atributos **/
    public static final int MAX_COCHES = 4;
    Coche[] carga;

    /**@Constructor **/
    public Camion(String matricula,String propietario){
        super(matricula,propietario);
        this.carga = new Coche[MAX_COCHES];
    }

    /**Anyade un Coche a la carga de el Camion
     * @param coche typeOf(Coche)
     * @return boolean **/
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
    public boolean addCarByBrand(Coche coche,String brand){
        int i = 0;
        if (!brand.equals(coche.getMarca())) return false;
        do {

            if(carga[i] == null){
                carga[i] = coche;
                return true;
            }
            i++;
        }while (i < carga.length);
        return false;
    }

    /** Evalua si un coche se encuentra entre la carga de el camion
     * @param id_coche> corresponde con la matricula de el vehiculo
     * @return boolean -> True: encontado. False: no encontrado.  **/
    public boolean estaCargado(String id_coche){
        for(Coche c : carga){
            if (c == null) continue;
            if(id_coche.equals(c.matricula))return true;
        }
        return false;
    }

    /****/
    public boolean removeCar(String id_coche){
        int encontrado = 0;
        Coche[] aux = new Coche[MAX_COCHES];

        if(estaCargado(id_coche)){
            for (int i = 0; i < MAX_COCHES; i++){
                if(carga[i] == null)continue;

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

    /****/
    public Coche[] getCarga(){
        return this.carga;
    }

    /****/
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

    /****/
    @Override
    public String toString() {
        return "---------------------------ESTADO ACTUAL DE EL CAMION-----------------------------------\n"+
                "Camion --> " + "Matricula: "+  matricula + "\t Conductor: "+ propietario +"\nCarga:"+ mostrarCarga()+
                "\n---------------------------------------------------------------------------------------\n";
    }
}
