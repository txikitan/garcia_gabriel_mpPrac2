/**Metodologias de la programacion
 * Practica 2 - Fichero que define el TAD lista enlazada generica para la implementacion dinamica de la aplicacion
 * Gabriel Garcia **/
public interface IListaEnlazada<T> {
     /**Nos devuelve el elemento iEssimo de la lista**/
     T get(int index);
     /**Devuelve el tamaño de la lista**/
     int size();
     /**Elimina un nodo de la lista **/
     void remove(T data);
     /**Añade un nodo a la lista**/
     void add(T data);
}
