/**Metodologias de la programacion
 * Practica 2 - Fichero con la implementacion dinamica del TAD IListRecursos
 *              que almacenara los recursos con sus respectivas consultas
 * Gabriel Garcia **/
import java.util.LinkedList;

public class ListRecursosDinamico implements IListRecursos {
    private final LinkedList<RecursoDinamico> listRecursoDinamico;
    /** Metodo constructor **/
    public ListRecursosDinamico() {
        this.listRecursoDinamico = new LinkedList<>();
    }
    /** Añade una consulta a un recurso **/
    public void addConsultaAt(Consulta a) {
        String recurs = a.getRecurso();
        boolean trobat = false;
        for (RecursoDinamico recursoDinamico : listRecursoDinamico) {
            if (recursoDinamico.getNombre().equalsIgnoreCase(recurs)) {
                recursoDinamico.addConsulta(a);
                trobat = true;
                break;
            }
        }
        if(!trobat) {
            RecursoDinamico rd = new RecursoDinamico(recurs);
            rd.addConsulta(a);
            listRecursoDinamico.add(rd);
        }

    }
    /** Elimina una consulta a un recurso **/
    public void removeConsultaAt(Consulta a) {
        String recurs = a.getRecurso();
        for (RecursoDinamico recursoDinamico : listRecursoDinamico) {
            if (recursoDinamico.getNombre().equalsIgnoreCase(recurs)) {
                recursoDinamico.removeConsulta(a);
                break;
            }
        }
    }
    /** Elimina una consulta especifica dado el nombre del recurso y la fecha de la misma **/
    public void removeConsultaDataAt(String recurs, int data) {
        for (RecursoDinamico recursoDinamico : listRecursoDinamico) {
            if (recursoDinamico.getNombre().equalsIgnoreCase(recurs)) {
                recursoDinamico.removeConsultaData(data);
                break;
            }
        }
    }
    /** Devuelve una cadena con la lista de usuarios que han consultado un recurso **/
    public String getUsuarisAt(String recurs){
        String usuaris = "";
        for (RecursoDinamico recursoDinamico : listRecursoDinamico) {
            if (recursoDinamico.getNombre().equalsIgnoreCase(recurs)) {
                usuaris = recursoDinamico.getUsuaris();
                break;
            }
        }
        return usuaris;
    }
    /** Devuelve una cadena con la lista de usuarios que han consultado un recurso en la fecha dada **/
    public String getUsuarisDataAt(String recurs, int data) {
        String usuaris = "";
        for (RecursoDinamico recursoDinamico : listRecursoDinamico) {
            if (recursoDinamico.getNombre().equalsIgnoreCase(recurs)) {
                usuaris = recursoDinamico.getUsuarisData(data);
            }
        }
        return usuaris;
    }
    /** Devuelve el recurso que mas consultas tiene **/
    public RecursoDinamico getNConsultasAt() {
        RecursoDinamico r = null;
        int nConsultas = 0;
        int nConsultas2;
        for(RecursoDinamico c : listRecursoDinamico){
            nConsultas2 = c.getNConsultas();
            if(nConsultas2>nConsultas) {
                nConsultas = nConsultas2;
                r = c;
            }
        }
        return r;
    }
    /**Devuelve una cadena con los recursos consultados por el usuario **/
    public String recursosConsultats(String user) {
        StringBuilder usersConsultat = new StringBuilder();
        for(RecursoDinamico r : listRecursoDinamico){
            if(r.consultat(user)){
                usersConsultat.append(r.getNombre()).append(";");
            }
        }
        return usersConsultat.toString();
    }

}
