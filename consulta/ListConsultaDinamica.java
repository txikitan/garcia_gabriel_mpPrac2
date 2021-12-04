import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class ListConsultaDinamica implements IListConsulta {
    private final LinkedList<Consulta> listaConsultaDinamica;

    public ListConsultaDinamica() {
        this.listaConsultaDinamica = new LinkedList<>();
    }

    public void addConsulta(Consulta consulta) {
        listaConsultaDinamica.add(consulta);
    }

    public boolean consultat(String nom, String recurs) {
        boolean consultado=false;
        for (Consulta consulta : listaConsultaDinamica) {
            if (consulta.getRecurso().equalsIgnoreCase(recurs) && consulta.getUser().equalsIgnoreCase(nom)) {
                consultado = true;
                break;
            }
        }
        return consultado;
    }

    public String getUsers(String recurs) {
        StringBuilder users = new StringBuilder();
        for (Consulta consulta : listaConsultaDinamica) {
            if (consulta.getRecurso().equalsIgnoreCase(recurs)) {
                users.append(consulta.getUser()).append(";");
            }
        }
        return users.toString();
    }

    public String getUsersData(String recurs, int data1, int data2) {
        StringBuilder users = new StringBuilder();
        for (Consulta consulta : listaConsultaDinamica) {
            // Si el recurso coincide y la fecha de la consulta esta entre el rango deseado...
            int major2 = consulta.esMajor(data2, true);
            int major1 = consulta.esMajor(data1, true);
            if (consulta.getRecurso().equalsIgnoreCase(recurs) && (major1 == 1 || major1 == 0) && (major2 == 1 || major2 == 0)) {
                users.append(consulta.getUser()).append(";");
            }
        }
        return users.toString();
    }

    public String getAccess(String nom, boolean orden) {
        StringBuilder access = new StringBuilder();
        LinkedList<Consulta> arr = new LinkedList<>();
        for (Consulta consulta : listaConsultaDinamica) {
            if (consulta.getUser().equalsIgnoreCase(nom)) {
                arr.add(consulta);
            }
        }
        arr.sort(new ConsultComparator()); // Uso mi comparator para ordenar
        for (Consulta consulta : arr) {
            access.append(consulta.getRecurso()).append(";");
        }
        return access.toString();
    }

    /**Uso el polimorfismo de la clase Comparator para implementar mi propio metodo compare**/
    static class ConsultComparator implements Comparator<Consulta> {

        @Override
        public int compare(Consulta a,  Consulta b) {
            return a.esMajor(b.getFecha(),true);
        }

    }
}
