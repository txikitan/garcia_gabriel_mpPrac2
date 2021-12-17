/**Metodologias de la programacion
 * Practica 2 - Fichero que aprovecha el polimorfismo para crear una subclase de la lista enlazada con la operacion de ordenacion bubblesort
 * Gabriel Garcia **/
public class SortedListaEnlazada extends ListaEnlazada<Consulta> implements IListaEnlazada<Consulta> {
    /**Metodo para llevar a cabo el sort (bubblesort)**/
    public void sortList(boolean dataORhora)
    {

        // Current apuntara a head
        Node current = this.getHead(), index = null;
        Consulta temp;

        if (this.getHead() == null) {
            return;
        }
        else {
            while (current != null) {
                // index apuntara al nodo siguiente a current
                index = current.next;

                while (index != null) {
                    // Bubblesort si el nodo es mayor al contiguo (swap)
                    Consulta cA = current.data;
                    Consulta cB = index.data;
                    int datahora;
                    if(dataORhora) {
                        datahora = cB.getFecha();
                    }
                    else{
                        datahora = cB.getHora();
                    }

                    int retMaj = cA.esMajor(datahora,dataORhora);
                    if (retMaj == 1) {
                        temp = current.data;
                        current.data = index.data;
                        index.data = temp;
                    }

                    index = index.next;
                }
                current = current.next;
            }
        }
    }
}
