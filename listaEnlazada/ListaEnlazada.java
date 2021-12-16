/**Metodologias de la programacion
 * Practica 2 - Fichero que implementa la estructura de datos lista enlazada generica para la implementacion dinamica de la aplicacion
 * Gabriel Garcia **/
import java.util.Iterator;
import java.util.NoSuchElementException;

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

    //Primer elemento
    private Node head;
    //Ultimo elemento
    private Node tail;
    //Tamaño
    private int nodeCounter;

    public boolean add(T data) {
        boolean addFlag = false;

        //Creating new node with given data
        Node node = new Node(data);
        //Linked list is empty, adding first element
        if (this.head == null) {
            head = node;
            //Head and tail pointing to the same node
            tail = head;
            nodeCounter++;
            addFlag = true;
        } else {
            //Linked list is not empty, adding new element to the list
            tail.setNext(node);
            tail = node;
            nodeCounter++;
            addFlag = true;
        }
        return addFlag;
    }

    public boolean remove(T data) {

        boolean removeFlag = false;
        //Checking whether list is empty or not
        if (head == null) {
            throw new IndexOutOfBoundsException("List is empty");
        }

        //Deleting head element
        if (head.getData().equals(data)) {
            Node temp = head;
            head = temp.getNext();
            temp = null;
            this.nodeCounter--;
            removeFlag = true;
        } else {
            Node temp = head.getNext();
            Node prev = head;
            // Iterating over the list
            while (temp != null) {
                // Checking the data for node deletion
                if (temp.getData().equals(data)) {
                    prev.setNext(temp.getNext());
                    temp = null;
                    this.nodeCounter--;
                    removeFlag = true;
                    break;
                }
                prev = temp;
                temp = temp.getNext();
            }
        }
        return removeFlag;
    }

    public void printNodes() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.getData() + " ");
            temp = temp.getNext();
        }
        System.out.println();
    }

    public int size() {
        return this.nodeCounter;
    }

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

    public Iterator<T> iterator() {
        return new Iterator<T>() {

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

