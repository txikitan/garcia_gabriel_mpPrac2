public class ListConsultaEstatica<high> implements IListConsulta {
    private int nConsultas;
    private final Consulta[] listaConsultaEstatica;
    private final int dim;

    public ListConsultaEstatica(int dim) {
        this.dim = dim;
        this.listaConsultaEstatica = new Consulta[dim];
        this.nConsultas = 0;
    }

    public void addConsulta(Consulta consulta) throws NullPointerException {
        if (nConsultas < dim) {
            this.listaConsultaEstatica[nConsultas] = consulta.copy();
            nConsultas += 1;
        } else throw new NullPointerException();
    }


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

    public String getUsers(String recurs) {
        StringBuilder users = new StringBuilder(new String());
        for (int i = 0; i < nConsultas; i++) {
            if (listaConsultaEstatica[i].getRecurso().equalsIgnoreCase(recurs)) {
                users.append(listaConsultaEstatica[i].getUser()).append(";");
            }
        }
        return users.toString();
    }

    public String getUsersData(String recurs, int data1, int data2) {
        StringBuilder users = new StringBuilder(new String());
        for (int i = 0; i < nConsultas; i++) {
            // Si el recurso coincide y la fecha de la consulta esta entre el rango deseado...
            if (listaConsultaEstatica[i].getRecurso().equalsIgnoreCase(recurs) && listaConsultaEstatica[i].esMajor(data1, true) && !(listaConsultaEstatica[i].esMajor(data2, true))) {
                users.append(listaConsultaEstatica[i].getUser()).append(";");
            }
        }
        return users.toString();
    }

    public String getAccess(String nom, boolean orden) {
        StringBuilder access= new StringBuilder(new String());
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

    /**
     * QuickSort para ordenar el vector por fecha/hora
     **/

    private static int partition(Consulta arr[], int low, int high, boolean dataORhora) {
        Consulta pivot = arr[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            if (!(arr[j].esMajor(pivot.getFecha(), dataORhora))) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }


    private static void quicksort(Consulta arr[], int low, int high, boolean dataORhora) {
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
}
