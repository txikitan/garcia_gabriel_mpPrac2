import java.util.LinkedList;

public class ListConsultaDinamica implements IListConsulta {
    private LinkedList<Consulta> listaConsultaDinamica;

    public ListConsultaDinamica() {
        this.listaConsultaDinamica = new LinkedList<>();
    }
    public void addConsulta(Consulta consulta) {
        listaConsultaDinamica.add(consulta);
    }

    public boolean consultat(String nom, String recurs) {
        boolean consultado=false;
        for(int i=0;i<listaConsultaDinamica.size();i++){
            if(listaConsultaDinamica.get(i).getRecurso().equalsIgnoreCase(recurs) && listaConsultaDinamica.get(i).getUser().equalsIgnoreCase(nom)){
                consultado=true;
                break;
            }
        }
        return consultado;
    }

    public String getUsers(String recurs) {
        return new String();
    }

    public String getUsersData(String recurs, int data1, int data2) {
        return null;
    }

    public String getAccess(String nom, boolean orden) {
        return null;
    }
}
