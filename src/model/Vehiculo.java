package model;

public abstract class Vehiculo{

    protected String matricula;
    protected String propietario;

    public Vehiculo(){}

    public Vehiculo(String matricula,String propietario){
        this.matricula = matricula;
        this.propietario = propietario;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

}
