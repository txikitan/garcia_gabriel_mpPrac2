/**Metodologias de la programacion
 * Practica 2 - Fichero que implementa con almacenamiento estatico el TAD IListConsulta
 * Gabriel Garcia **/
public class ListConsultaEstatica implements IListConsulta {


    private int nConsultas;
    private final Consulta[] listaConsultaEstatica;
    private final int dim;

    /** Metodo constructor **/
    public ListConsultaEstatica(int dim) {
        this.dim = dim;
        this.listaConsultaEstatica = new Consulta[dim];
        this.nConsultas = 0;
    }

    /** Añade una consulta **/
    public void addConsulta(Consulta consulta) throws NullPointerException {
        if (nConsultas < dim) {
            this.listaConsultaEstatica[nConsultas] = consulta.copy();
            nConsultas += 1;
        } else throw new NullPointerException();
    }

    /** Verifica si un recurso ha sido consultado por cierto usuario **/
    public boolean consultat(String nom, String recurs) {
        boolean consultado = false;
        for (int i = 0; i < nConsultas; i++) {
            if (listaConsultaEstatica[i].getRecurso().equalsIgnoreCase(recurs) && listaConsultaEstatica[i].getUser().equalsIgnoreCase(nom)) {
                consultado = true;
                break;
            }
        }
        return consultado;
    }

    /** Devuelve la lista de usuarios que han consultado un recurso **/
    public String getUsers(String recurs) {
        StringBuilder users = new StringBuilder();
        for (int i = 0; i < nConsultas; i++) {
            if (listaConsultaEstatica[i].getRecurso().equalsIgnoreCase(recurs)) {
                users.append(listaConsultaEstatica[i].getUser()).append(";");
            }
        }
        return users.toString();
    }

    /** Devuelve la lista de usuarios que han consultado un recurso entr dos fechas**/
    public String getUsersData(String recurs, int data1, int data2) {
        StringBuilder users = new StringBuilder();
        for (int i = 0; i < nConsultas; i++) {
            // Si el recurso coincide y la fecha de la consulta esta entre el rango deseado...
            int major2 = listaConsultaEstatica[i].esMajor(data2, true);
            int major1 = listaConsultaEstatica[i].esMajor(data1, true);
            if (listaConsultaEstatica[i].getRecurso().equalsIgnoreCase(recurs) && (major1==1 || major1 == 0) && (major2==-1 || major2 == 0)) {
                users.append(listaConsultaEstatica[i].getUser()).append(";");
            }
        }
        return users.toString();
    }

    /** Devuelve la lista de recursos accedidos por un usuario, ordenados por fecha(true) o por hora(false)**/
    public String getAccess(String nom, boolean orden) {
        StringBuilder access= new StringBuilder();
        Consulta[] arr = new Consulta[nConsultas];
        int j=0;
        for(int i=0; i<nConsultas;i++) {
            if(listaConsultaEstatica[i].getUser().equalsIgnoreCase(nom)){
                arr[j]=listaConsultaEstatica[i];
                j++;
            }
        }
        quicksort(arr,0, j-1,orden);
        for(int i=0;i<j;i++){
            access.append(arr[i].getRecurso()).append(";");
        }
        return access.toString();
    }

    /** QuickSort para ordenar el vector por fecha/hora **/
    private static int partition(Consulta[] arr, int low, int high, boolean dataORhora) {
        Consulta pivot = arr[high];
        int i = (low - 1); // index of smaller element
        int major;
        for (int j = low; j < high; j++) {
            if(dataORhora) {
                major = arr[j].esMajor(pivot.getFecha(), dataORhora);
            }
            else {
                major = arr[j].esMajor(pivot.getHora(), dataORhora);
            }
            if (major==-1) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void quicksort(Consulta[] arr, int low, int high, boolean dataORhora) {
        if (low < high) {
            int pi = partition(arr, low, high, dataORhora);
            quicksort(arr, low, pi - 1, dataORhora);
            quicksort(arr, pi + 1, high, dataORhora);
        }
    }

    private static void swap(Consulta[] arr, int i, int j) {
        Consulta temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /** Getters y setters basicos **/
    public int getnConsultas() {
        return nConsultas;
    }

    public Consulta[] getListaConsultaEstatica() {
        return listaConsultaEstatica;
    }

}
