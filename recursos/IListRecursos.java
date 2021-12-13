/**Metodologias de la programacion
 * Practica 2 - Fichero que define la interfaz que tendra el tipo abstracto de datos IListRecursos,
 *              que almacenara los recursos con sus respectivas consultas
 * Gabriel Garcia **/
public interface IListRecursos {
    /** Añade una consulta a un recurso **/
    void addConsultaAt(Consulta a);
    /** Elimina una consulta a un recurso **/
    void removeConsultaAt(Consulta a);
    /** Elimina una consulta especifica dado el nombre del recurso y la fecha de la misma **/
    void removeConsultaDataAt(String recurs, int data);
    /** Devuelve una cadena con la lista de usuarios que han consultado un recurso **/
    String getUsuarisAt(String recurs);
    /** Devuelve una cadena con la lista de usuarios que han consultado un recurso en la fecha dada **/
    String getUsuarisDataAt(String recurs, int data);
    /**Devuelve el recurso con mas consultas**/
    IRecurso getNConsultasAt();
    /**Devuelve una cadena con los recursos consultados por el usuario **/
    String recursosConsultats(String user);
}
