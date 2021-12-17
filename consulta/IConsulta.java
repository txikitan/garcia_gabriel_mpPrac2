/**Metodologias de la programacion
 * Practica 2 - Fichero que define el TAD basico Consulta
 * Gabriel Garcia **/
public interface IConsulta {
     /** Metodo que verifica si una consulta es exactamente igual a otra **/
     boolean equals(Consulta a);
     /** Metodo que verifica si una fecha o una hora es superior a la otra
      * Si dataORhora==true->ordenar por fecha
      * Si dataORhora==false->ordenar por hora**/
     int esMajor(int datahora2, boolean dataORhora);
}
