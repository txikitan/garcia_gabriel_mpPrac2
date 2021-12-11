/**Metodologias de la programacion
 * Practica 2 - Fichero que define la interfaz que tendra el tipo abstracto de datos IRecurso,
 *              que almacenara todas las consultas a dicho recurso
 * Gabriel Garcia **/
public interface IRecurso {
    /** Añade una consulta al recurso **/
    void addConsulta(Consulta a);
    /** Elimina una consulta del recurso **/
    void removeConsulta(Consulta a);
    /** Dada una fecha, elimina las consultas cuya fecha coincide **/
    void removeConsultaData(int data);
    /** Devuelve una cadena con los usuarios que han consultado un recurso **/
    String getUsuaris();
    /** Dada una fecha, devuelve una cadena con los usuarios que han consultado el recurso en esa fecha **/
    String getUsuarisData(int data);
    /** Devuelve el numero de consultas que tiene el recurso **/
    int getNConsultas();
}
