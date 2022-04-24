package Semana4;

public class Avion extends Voladores implements Aterrizable{
    String nombre = "Avion";
    String matricula;
    String vuelo;
    String aerolinea;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getVuelo() {
        return vuelo;
    }

    public void setVuelo(String vuelo) {
        this.vuelo = vuelo;
    }

    public String getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }
    
    @Override
    public void setNombre(String nombre){
        this.nombre= nombre;
    }
    
    @Override
    public String getNombre(){
        return this.nombre;
    }
    
    @Override
    public void aterrizar() {
        getMatricula();
        System.out.println("La aeronave: "+getNombre()+" - Vuelo: "+getVuelo()+" - Matricula: "+getMatricula()+" - Aerolinea: "+getAerolinea()+" - Tiene permitido aterrizar ");
    }

    @Override
    public void codigoAterrizaje() {
        System.out.println("Codigo de aterrizaje: LA75M85S90E64O");
    }
    
    
    
    
}
