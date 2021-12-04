public class RecursoEstatico implements IRecurso {

    private final String nombre;
    private final Consulta[] consultas;
    private int nConsultas;
    private final int dim;

    public RecursoEstatico(String nombre, int dim) {
        this.dim=dim;
        this.nConsultas=0;
        this.consultas=new Consulta[dim];
        this.nombre=nombre;
    }

    public void addConsulta(Consulta a) throws NullPointerException {
        if(nConsultas<dim){
            consultas[nConsultas]=a;
        }
        else throw new NullPointerException();
    }

    public void removeConsulta(Consulta a) {
        for(int i=0;i<nConsultas;i++){
            if(consultas[i].equals(a)) {
                eliminar(consultas,i, nConsultas);
                this.nConsultas--;
                break;
            }
        }
    }

    public void removeConsultaData(int data) {
        for(int i=0;i<nConsultas;i++){
            if(consultas[i].getFecha()==data){
                eliminar(consultas,i,nConsultas);
                nConsultas--;
            }
        }
    }

    public String getUsuaris() {
        StringBuilder usuaris = new StringBuilder();
        for(Consulta c : consultas) {
            usuaris.append(c.getUser()).append(";");
        }
        return usuaris.toString();
    }

    public String getUsuarisData(int data){
        StringBuilder usuaris = new StringBuilder();
        for(Consulta c : consultas) {
            if(c.getFecha()==data) {
                usuaris.append(c.getUser()).append(";");
            }
        }
        return usuaris.toString();
    }


    public int getNConsultas() {
        return nConsultas;
    }

    private static void eliminar(Consulta[] arr, int index, int dim) {
        arr[index]=null;
        if (dim - 1 - index >= 0) {
            System.arraycopy(arr, index + 1, arr, index, dim - 1 - index);
        }
    }


    /**Getters y setters basicos**/

    public String getNombre() {
        return nombre;
    }

    public Consulta[] getConsultas() {
        return consultas;
    }


    public void setNConsultas(int nConsultas) {
        this.nConsultas = nConsultas;
    }

    public int getDim() {
        return dim;
    }
}
