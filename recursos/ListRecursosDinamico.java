import java.util.LinkedList;

public class ListRecursosDinamico implements IListRecursos {
    private final LinkedList<RecursoDinamico> listRecursoDinamico;

    public ListRecursosDinamico() {
        this.listRecursoDinamico = new LinkedList<>();
    }

    public void addConsultaAt(Consulta a) {
        String recurs = a.getRecurso();
        boolean trobat = false;
        for (RecursoDinamico recursoDinamico : listRecursoDinamico) {
            if (recursoDinamico.getNombre().equalsIgnoreCase(recurs)) {
                recursoDinamico.addConsulta(a);
                trobat = true;
                break;
            }
        }
        if(!trobat) {
            listRecursoDinamico.add(new RecursoDinamico(recurs));
            listRecursoDinamico.getLast().addConsulta(a);
        }

    }

    public void removeConsultaAt(Consulta a) {
        String recurs = a.getRecurso();
        for (RecursoDinamico recursoDinamico : listRecursoDinamico) {
            if (recursoDinamico.getNombre().equalsIgnoreCase(recurs)) {
                recursoDinamico.removeConsulta(a);
                break;
            }
        }
    }

    public void removeConsultaDataAt(String recurs, int data) {
        for (RecursoDinamico recursoDinamico : listRecursoDinamico) {
            if (recursoDinamico.getNombre().equalsIgnoreCase(recurs)) {
                recursoDinamico.removeConsultaData(data);
                break;
            }
        }
    }

    public String getUsuarisAt(String recurs){
        String usuaris = "";
        for (RecursoDinamico recursoDinamico : listRecursoDinamico) {
            if (recursoDinamico.getNombre().equalsIgnoreCase(recurs)) {
                usuaris = recursoDinamico.getUsuaris();
                break;
            }
        }
        return usuaris;
    }

    public String getUsuarisDataAt(String recurs, int data) {
        String usuaris = "";
        for (RecursoDinamico recursoDinamico : listRecursoDinamico) {
            if (recursoDinamico.getNombre().equalsIgnoreCase(recurs)) {
                usuaris = recursoDinamico.getUsuarisData(data);
            }
        }
        return usuaris;
    }

    public int getNConsultasAt(String recurs) {
        int nConsultas = -1;
        for (RecursoDinamico recursoDinamico : listRecursoDinamico) {
            if (recursoDinamico.getNombre().equalsIgnoreCase(recurs)) {
                nConsultas = recursoDinamico.getNConsultas();
            }
        }
        return nConsultas;
    }

}
