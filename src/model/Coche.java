package model;

public class Coche extends Vehiculo{
    private String modelo;
    private String marca;

    public Coche() {
        super();
    }
    public Coche(String matricula, String propietario,String marca,String modelo){
        super(matricula,propietario);
        this.marca = marca;
        this.modelo = modelo;
    }
    public String getMarca(){
        return this.marca;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "marca='" + marca + '\'' +
                "modelo='" + modelo + '\'' +
                ", matricula='" + matricula + '\'' +
                ", propietario='" + propietario + '\'' +
                '}';
    }
}
