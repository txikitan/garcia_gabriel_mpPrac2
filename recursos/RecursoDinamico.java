import java.util.Iterator;
import java.util.LinkedList;

public class RecursoDinamico implements IRecurso {


    private String nombre;
    private LinkedList<Consulta> consultas;

    public RecursoDinamico(String nombre) {
        this.nombre=nombre;
        this.consultas = new LinkedList<>();
    }

    public void addConsulta(Consulta a) {
        this.nombre = a.getRecurso();
        this.consultas.add(a);
    }

    public void removeConsulta(Consulta a) {
        boolean removed=false;
        Iterator<Consulta> i = consultas.iterator();
        while(i.hasNext() && !removed) {
            Consulta c = i.next();
            if(c.equals(a)) {
                i.remove();
                removed=true;
            }
        }
        /*for(int i=0;i<consultas.size();i++){
            if(consultas.get(i).equals(a)){
                consultas.remove(i);
                break;
            }
        }
        */
    }
    public void removeConsultaData(int data) {
        boolean removed=false;
        Iterator<Consulta> i = consultas.iterator();
        while(i.hasNext() && !removed) {
            Consulta c = i.next();
            if(c.getFecha()==data){
                i.remove();
                removed=true;
            }
        }
       /* for(int i=0;i<consultas.size();i++) {
            if(consultas.get(i).getFecha()==data) {
                consultas.remove(i);
            }
        }
        */
    }

    public String getUsuaris(){
        StringBuilder usuaris = new StringBuilder();
        for(Consulta c : consultas){
            usuaris.append(c.getUser()).append(";");
        }
        return usuaris.toString();
    }

    public String getUsuarisData(int data) {
        StringBuilder usuaris = new StringBuilder();
        for(Consulta c : consultas){
            if(c.getFecha()==data) {
                usuaris.append(c.getUser()).append(";");
            }
        }
        return usuaris.toString();
    }

    public int getNConsultas() {
       return consultas.size();
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
