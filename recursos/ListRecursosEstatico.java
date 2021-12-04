public class ListRecursosEstatico implements IListRecursos {
    private int nRecursos;
    private final RecursoEstatico[] listRecursoEstatico;
    private final int dimConsultas;

    public ListRecursosEstatico(int dim, int dimConsultas) {
        this.listRecursoEstatico = new RecursoEstatico[dim];
        this.nRecursos = 0;
        this.dimConsultas = dimConsultas;
    }

    public void addConsultaAt(Consulta a) {
        String recurs = a.getRecurso();
        boolean trobat = false;
        for(int i=0;i<nRecursos;i++) {
            if(listRecursoEstatico[i].getNombre().equalsIgnoreCase(recurs)) {
                listRecursoEstatico[i].addConsulta(a);
                trobat=true;
                break;
            }
        }
        if(!trobat) {
            listRecursoEstatico[nRecursos] = new RecursoEstatico(recurs, dimConsultas);
            listRecursoEstatico[nRecursos].addConsulta(a);
        }
        nRecursos++;
    }

    public void removeConsultaAt(Consulta a) {
        String recurs = a.getRecurso();
        for(int i=0;i<nRecursos;i++) {
            if(listRecursoEstatico[i].getNombre().equalsIgnoreCase(recurs)) {
                listRecursoEstatico[i].removeConsulta(a);
                break;
            }
        }
    }

    public void removeConsultaDataAt(String recurs, int data) {
        for(int i=0;i<nRecursos;i++) {
            if(listRecursoEstatico[i].getNombre().equalsIgnoreCase(recurs)) {
                listRecursoEstatico[i].removeConsultaData(data);
                break;
            }
        }

    }

    public String getUsuarisAt(String recurs){
        String usuaris = "";
        for(int i=0;i<nRecursos;i++) {
            if(listRecursoEstatico[i].getNombre().equalsIgnoreCase(recurs)){
                usuaris = listRecursoEstatico[i].getUsuaris();
                break;
            }
        }
        return usuaris;
    }

    public String getUsuarisDataAt(String recurs, int data) {
        String usuaris = "";
        for(int i=0;i<nRecursos;i++) {
            if(listRecursoEstatico[i].getNombre().equalsIgnoreCase(recurs)){
                usuaris = listRecursoEstatico[i].getUsuarisData(data);
            }
        }
        return usuaris;
    }

    public int getNConsultasAt(String recurs) {
         int nConsultas = -1;
         for(int i=0;i<nRecursos;i++) {
             if(listRecursoEstatico[i].getNombre().equalsIgnoreCase(recurs)) {
                 nConsultas = listRecursoEstatico[i].getNConsultas();
             }
         }
         return nConsultas;
    }

}
