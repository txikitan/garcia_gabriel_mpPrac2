public interface IListConsulta {
    void addConsulta(Consulta consulta);
    boolean consultat(String nom, String recurs);
    String[] getUsers(String nom, int data1, int data2);
    String getAccess(String nom, boolean orden);
}
