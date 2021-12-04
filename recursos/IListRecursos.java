public interface IListRecursos {
    void addConsultaAt(Consulta a);
    void removeConsultaAt(Consulta a);
    void removeConsultaDataAt(String recurs, int data);
    String getUsuarisAt(String recurs);
    String getUsuarisDataAt(String recurs, int data);
    int getNConsultasAt(String recurso);
}
