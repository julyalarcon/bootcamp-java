package Semana4;

public class Ovni extends Voladores implements Aterrizable{
    String nombre = "OVNI";
    String lugarAvistamiento;

    public String getLugarAvistamiento() {
        return lugarAvistamiento;
    }

    public void setLugarAvistamiento(String lugarAvistamiento) {
        this.lugarAvistamiento = lugarAvistamiento;
    }
    
    @Override
    public void setNombre(String nombre){
        this.nombre= "OVNI";
    }
    
    @Override
    public String getNombre(){
        return this.nombre;
    }

    @Override
    public void aterrizar() {
        System.out.println("Nombre: "+getNombre()+" - Avistado: "+getLugarAvistamiento()+" - SIN permiso para aterrizar");
    }

    @Override
    public void codigoAterrizaje() {
        System.out.println("NO TIENE PERMISO PARA ATERRIZAR");
        System.out.println("Reportar a la NASA el avistamiento");
    }
    
    

    

   
    
    
}
