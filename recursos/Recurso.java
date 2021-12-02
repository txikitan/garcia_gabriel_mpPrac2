import java.util.LinkedList;

public class Recurso {


    private String nombre;
    private LinkedList<Consulta> consultas;

    public Recurso(String nombre) {
        this.nombre=nombre;
        this.consultas = new LinkedList<>();
    }

    public void addConsulta(Consulta a) {
        this.nombre = a.getRecurso();
        this.consultas.add(a);
    }

    /**Getters y setters basicos**/
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LinkedList<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(LinkedList<Consulta> consultas) {
        this.consultas = consultas;
    }
}
