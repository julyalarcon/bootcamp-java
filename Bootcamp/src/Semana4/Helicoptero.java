package Semana4;

public class Helicoptero extends Voladores implements Aterrizable{
    String nombre = "Helicoptero";
    String marca, modelo;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public void aterrizar() {
        System.out.println("El helicoptero: "+getNombre()+" - Marca: "+getMarca()+" - Modelo: "+getModelo()+" - Tiene permitido aterrizar");
    }
    @Override
    public void codigoAterrizaje() {
        System.out.println("HE23N45S78E56O");
    }
    
    
}
