package Semana4;

public class Superman extends Voladores implements Aterrizable{
    
    String nombre = "Clark Kent";
    String nemesis = "Lex Luthor";

    public String getNemesis() {
        return nemesis;
    }

    public void setNemesis(String nemesis) {
        this.nemesis = nemesis;
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
        System.out.println("Superman: "+getNombre()+" - SIN permiso para aterrizar.Cuidate de: "+getNemesis());
        System.out.println("Gracias por mantenernos a salvo!!!");
    }
    @Override
    public void codigoAterrizaje() {
        System.out.println("NO TIENE PERMISO PARA ATERRIZAR");
        
    }
}
