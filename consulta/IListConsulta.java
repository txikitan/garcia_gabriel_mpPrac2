/**Metodologias de la programacion
 * Practica 2 - Fichero que define la interfaz que tendra el tipo abstracto de datos ListConsulta,
 *              que almacenara las consultas y permitira operar con ellas
 * Gabriel Garcia **/

public interface IListConsulta {
    /** Añade una consulta **/
    void addConsulta(Consulta consulta);
    /** Verifica si un recurso ha sido consultado por cierto usuario **/
    boolean consultat(String nom, String recurs);
    /** Devuelve la lista de usuarios que han consultado un recurso **/
    String getUsers(String recurs);
    /** Devuelve la lista de usuarios que han consultado un recurso entr dos fechas**/
    String getUsersData(String recurs, int data1, int data2);
    /** Devuelve la lista de recursos accedidos por un usuario, ordenados por fecha(true) o por hora(false)**/
    String getAccess(String nom, boolean orden);
}
