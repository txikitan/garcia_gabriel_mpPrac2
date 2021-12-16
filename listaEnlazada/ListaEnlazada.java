/**Metodologias de la programacion
 * Practica 2 - Fichero que implementa la estructura de datos lista enlazada generica para la implementacion dinamica de la aplicacion
 * Gabriel Garcia **/
import java.util.Iterator;

class ListaEnlazada<T> implements Iterable<T> {

    /**Definimos el nodo**/
    public class Node {
        private final T data;
        private Node next;

        public Node(T data) {
            super();
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public T getData() {
            return data;
        }
    }

    public Node getHead() {
        return head;
    }


    //Primer elemento
    private Node head;
    //Ultimo elemento
    private Node tail;
    //Tamaño
    private int nodeCounter;

    /**Añade un nodo a la lista**/
    public void add(T data) {

        //Creamos nuevo nodo
        Node node = new Node(data);
        //Si la linkedlist esta vacia..
        if (this.head == null) {
            head = node;
            //Head y tail apuntaran al mismo nodo
            tail = head;
        } else {
            //Linkedlist no vacia, añadimos elemento
            tail.setNext(node);
            tail = node;
        }
        nodeCounter++;
    }

    public void remove(T data) {
        //Checkeamos si esta vacia o no
        if (head == null) {
            throw new IndexOutOfBoundsException("List is empty");
        }

        //Eliminamos el primer elemento si esta en cabeza
        if (head.getData().equals(data)) {
            Node temp = head;
            head = temp.getNext();
            temp = null;
            this.nodeCounter--;
        } else {
            // En caso contrario
            Node temp = head.getNext();
            Node prev = head;
            // Empezamos a iterar sobre la lista
            while (temp != null) {
                // Checkeamos si encontramos el dato a eliminar
                if (temp.getData().equals(data)) {
                    prev.setNext(temp.getNext());
                    temp = null;
                    this.nodeCounter--;
                    break;
                }
                prev = temp;
                temp = temp.getNext();
            }
        }
    }

    /**Devuelve el tamaño de la lista**/
    public int size() {
        return this.nodeCounter;
    }

    /**Nos devuelve el elemento iEssimo de la lista**/
    public T get(int index) {
        T data = null;
        Node temp = head;
        int cntr = 0;

        if (head == null)
            throw new IndexOutOfBoundsException("List is empty");
        if (index >= this.nodeCounter)
            throw new IndexOutOfBoundsException("Index greater than list size");
        //If given index is of head node then return the data
        if (index == cntr)
            data = head.getData();
            //If given index is of tail node then return data
        else if (index == (nodeCounter - 1))
            data = tail.getData();
        else {
            //Checking the given index with the node index
            while (temp != null) {
                if (cntr == index) {
                    data = temp.getData();
                    break;
                }
                temp = temp.getNext();
                cntr++;
            }
        }
        return data;
    }

    /**Hacemos la estructura iterable para poder recorrerla con bucles forEach**/
    public Iterator<T> iterator() {
        return new Iterator<>() {
            Node current = head;
            @Override
            public boolean hasNext() {
                return current != null;
            }
            @Override
            public T next() {
                if (hasNext()) {
                    T data = current.data;
                    current = current.next;
                    return data;
                }
                return null;
            }
        };
    }
}

