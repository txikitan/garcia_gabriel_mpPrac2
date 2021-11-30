import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListConsultaEstatica implements IListConsulta {
    private int dim;
    private int nConsultas;
    private Consulta[] listaConsultaEstatica;

    public ListConsultaEstatica(int dim) {
        this.dim = dim;
        this.listaConsultaEstatica = new Consulta[dim];
        this.nConsultas = 0;
    }

    public void addConsulta(Consulta consulta) {
        this.listaConsultaEstatica[nConsultas] = consulta.copy();
        nConsultas += 1;
    }


    public boolean consultat(String nom, String recurs) {
        boolean consultado = false;
        for(int i = 0; i<nConsultas;i++){
            if(listaConsultaEstatica[i].getRecurso().equalsIgnoreCase(recurs) && listaConsultaEstatica[i].getUser().equalsIgnoreCase(nom)) {
                consultado = true;
                break;
            }
        }
        return consultado;
    }

    public String getUsers(String recurs) {
        String users = new String();
        for(int i = 0; i<nConsultas;i++){
            if(listaConsultaEstatica[i].getRecurso().equalsIgnoreCase(recurs)){
                users+=(listaConsultaEstatica[i].getUser()+";");
            }
        }
        return users;
    }

    public String getUsersData(String recurs, int data1, int data2) {
        String users = new String();
        for(int i = 0; i<nConsultas;i++) {
            // Si el recurso coincide y la fecha de la consulta esta entre el rango deseado...
            if(listaConsultaEstatica[i].getRecurso().equalsIgnoreCase(recurs) && listaConsultaEstatica[i].esMajor(data1,true) && !(listaConsultaEstatica[i].esMajor(data2,true))) {
                users+=(listaConsultaEstatica[i].getUser()+";");
            }
        }
        return users;
    }

    public String getAccess(String nom, boolean orden) {

        return null;
    }

    private String[] order(String[] list) {

    }

}
