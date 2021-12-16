/**Metodologias de la programacion
 * Practica 2 - Fichero que aprovecha el polimorfismo para crear una subclase de la lista enlazada con un set de operaciones de ordenacion
 *              basados en el algorismo mergesort
 * Gabriel Garcia **/
public class SortedListaEnlazada extends ListaEnlazada<Consulta> {
    /**Metodo recursivo para llevar a cabo el mergesort**/
    Node sortedMerge(Node a, Node b, boolean dataORhora)
    {
        Node result = null;
        /* Base cases */
        if (a == null)
            return b;
        if (b == null)
            return a;

        /* Cogemos a o b */
        Consulta cA = a.getData();
        Consulta cB = b.getData();
        int datahora;
        if(dataORhora) {
            datahora = cB.getFecha();
        }
        else{
            datahora = cB.getHora();
        }
        /*Recursividad*/
        int retMaj = cA.esMajor(datahora,dataORhora);
        if (retMaj == -1 || retMaj == 0) {
            result = a;
            result.setNext(sortedMerge(a.getNext(), b,dataORhora));
        }
        else {
            result = b;
            result.setNext(sortedMerge(a, b.getNext(),dataORhora));
        }
        return result;
    }

    /**Metodo principal**/
    Node mergeSort(Node h,boolean dataORhora)
    {
        // Caso base: head es nulo
        if (h == null || h.getNext() == null) {
            return h;
        }

        // Obtenemos el centro de la lista
        Node middle = getMiddle(h);
        Node nextofmiddle = middle.getNext();

        // el nodo siguiente a la mitad sera nulo
        middle.setNext(null);

        // Aplicamos mergesort en el lado izquierdo de la lista
        Node left = mergeSort(h,dataORhora);

        // Aplicamos mergesort en el lado derecho de la lista
        Node right = mergeSort(nextofmiddle,dataORhora);

        // Aplicamos mergesort la lista izquierda y la derecha
        Node sortedlist = sortedMerge(left, right,dataORhora);
        return sortedlist;
    }

    /**Nos devuelve el centro de la lista**/
    public static Node getMiddle(Node head)
    {
        if (head == null)
            return head;

        Node slow = head, fast = head;

        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }
}
