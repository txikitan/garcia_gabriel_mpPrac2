public interface IListConsulta {
    void addConsulta(Consulta consulta) throws Exception;
    boolean consultat(String nom, String recurs);
    String getUsers(String recurs);
    String getUsersData(String recurs, int data1, int data2);
    String getAccess(String nom, boolean orden);
}
