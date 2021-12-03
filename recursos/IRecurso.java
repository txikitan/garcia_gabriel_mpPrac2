public interface IRecurso {
    void addConsulta(Consulta a);
    void removeConsulta(Consulta a);
    void removeConsultaData(int data);
    String getUsuaris();
    String getUsuarisData(int data);
    int getNConsultas();
}
