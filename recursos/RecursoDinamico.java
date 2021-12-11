/**Metodologias de la programacion
 * Practica 2 - Fichero que implementa de forma dinamica la interfaz del TAD IRecurso
 *              que almacenara todas las consultas a dicho recurso
 * Gabriel Garcia **/
import java.util.Iterator;
import java.util.LinkedList;

public class RecursoDinamico implements IRecurso {

    private final String nombre;
    private final LinkedList<Consulta> consultas;
    /** Metodo constructor **/
    public RecursoDinamico(String nombre) {
        this.nombre=nombre;
        this.consultas = new LinkedList<>();
    }
    /** Añade una consulta al recurso **/
    public void addConsulta(Consulta a) {
        this.consultas.add(a);
    }
    /** Elimina una consulta del recurso **/
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
    /** Dada una fecha, elimina las consultas cuya fecha coincide **/
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
    /** Devuelve una cadena con los usuarios que han consultado un recurso **/
    public String getUsuaris(){
        StringBuilder usuaris = new StringBuilder();
        for(Consulta c : consultas){
            usuaris.append(c.getUser()).append(";");
        }
        return usuaris.toString();
    }
    /** Dada una fecha, devuelve una cadena con los usuarios que han consultado el recurso en esa fecha **/
    public String getUsuarisData(int data) {
        StringBuilder usuaris = new StringBuilder();
        for(Consulta c : consultas){
            if(c.getFecha()==data) {
                usuaris.append(c.getUser()).append(";");
            }
        }
        return usuaris.toString();
    }
    /** Devuelve el numero de consultas que tiene el recurso **/
    public int getNConsultas() {
       return consultas.size();
    }
    /**Getters y setters basicos**/
    public String getNombre() {
        return nombre;
    }


}
