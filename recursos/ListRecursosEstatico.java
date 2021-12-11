/**Metodologias de la programacion
 * Practica 2 - Fichero con la implementacion estatica del TAD IListRecursos
 *              que almacenara los recursos con sus respectivas consultas
 * Gabriel Garcia **/
public class ListRecursosEstatico implements IListRecursos {
    private int nRecursos;
    private final RecursoEstatico[] listRecursoEstatico;
    private final int dimConsultas;
    /** Metodo constructor **/
    public ListRecursosEstatico(int dim, int dimConsultas) {
        this.listRecursoEstatico = new RecursoEstatico[dim];
        this.nRecursos = 0;
        this.dimConsultas = dimConsultas;
    }
    /** Añade una consulta a un recurso **/
    public void addConsultaAt(Consulta a) {
        String recurs = a.getRecurso();
        boolean trobat = false;
        for(int i=0;i<nRecursos;i++) {
            if(listRecursoEstatico[i].getNombre().equalsIgnoreCase(recurs)) {
                listRecursoEstatico[i].addConsulta(a);
                trobat=true;
                break;
            }
        }
        if(!trobat) {
            listRecursoEstatico[nRecursos] = new RecursoEstatico(recurs, dimConsultas);
            listRecursoEstatico[nRecursos].addConsulta(a);
        }
        nRecursos++;
    }
    /** Elimina una consulta a un recurso **/
    public void removeConsultaAt(Consulta a) {
        String recurs = a.getRecurso();
        for(int i=0;i<nRecursos;i++) {
            if(listRecursoEstatico[i].getNombre().equalsIgnoreCase(recurs)) {
                listRecursoEstatico[i].removeConsulta(a);
                break;
            }
        }
    }
    /** Elimina una consulta especifica dado el nombre del recurso y la fecha de la misma **/
    public void removeConsultaDataAt(String recurs, int data) {
        for(int i=0;i<nRecursos;i++) {
            if(listRecursoEstatico[i].getNombre().equalsIgnoreCase(recurs)) {
                listRecursoEstatico[i].removeConsultaData(data);
                break;
            }
        }

    }
    /** Devuelve una cadena con la lista de usuarios que han consultado un recurso **/
    public String getUsuarisAt(String recurs){
        String usuaris = "";
        for(int i=0;i<nRecursos;i++) {
            if(listRecursoEstatico[i].getNombre().equalsIgnoreCase(recurs)){
                usuaris = listRecursoEstatico[i].getUsuaris();
                break;
            }
        }
        return usuaris;
    }
    /** Devuelve una cadena con la lista de usuarios que han consultado un recurso en la fecha dada **/
    public String getUsuarisDataAt(String recurs, int data) {
        String usuaris = "";
        for(int i=0;i<nRecursos;i++) {
            if(listRecursoEstatico[i].getNombre().equalsIgnoreCase(recurs)){
                usuaris = listRecursoEstatico[i].getUsuarisData(data);
            }
        }
        return usuaris;
    }
    /** Devuelve el numero  de consultas que tiene un recurso **/
    public int getNConsultasAt(String recurs) {
         int nConsultas = -1;
         for(int i=0;i<nRecursos;i++) {
             if(listRecursoEstatico[i].getNombre().equalsIgnoreCase(recurs)) {
                 nConsultas = listRecursoEstatico[i].getNConsultas();
             }
         }
         return nConsultas;
    }

}
