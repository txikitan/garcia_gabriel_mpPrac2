import java.util.LinkedList;
import java.util.List;

public interface IListConsulta {
    void addConsulta(Consulta consulta);
    boolean consultat(String nom, String recurs);
    String getUsers(String recurs);
    String getUsersData(String recurs, int data1, int data2);
    String getAccess(String nom, boolean orden);
}
