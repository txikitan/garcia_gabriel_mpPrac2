/**Metodologias de la programacion
 * Practica 2 - Fichero que implementa de forma estatica la interfaz del TAD IRecurso
 *              que almacenara todas las consultas a dicho recurso
 * Gabriel Garcia **/
public class RecursoEstatico implements IRecurso {

    private final String nombre;
    private final Consulta[] consultas;
    private int nConsultas;
    private final int dim;

    /** Metodo constructor **/
    public RecursoEstatico(String nombre, int dim) {
        this.dim=dim;
        this.nConsultas=0;
        this.consultas=new Consulta[dim];
        this.nombre=nombre;
    }
    /** Añade una consulta al recurso **/
    public void addConsulta(Consulta a) throws NullPointerException {
        if(nConsultas<dim){
            consultas[nConsultas]=a;
            nConsultas++;
        }
        else throw new NullPointerException();
    }
    /** Elimina una consulta del recurso **/
    public void removeConsulta(Consulta a) {
        for(int i=0;i<nConsultas;i++){
            if(consultas[i].equals(a)) {
                eliminar(consultas,i, nConsultas);
                this.nConsultas--;
                break;
            }
        }
    }
    /** Dada una fecha, elimina las consultas cuya fecha coincide **/
    public void removeConsultaData(int data) {
        for(int i=0;i<nConsultas;i++){
            if(consultas[i].getFecha()==data){
                eliminar(consultas,i,nConsultas);
                nConsultas--;
            }
        }
    }
    /** Devuelve una cadena con los usuarios que han consultado un recurso **/
    public String getUsuaris() {
        StringBuilder usuaris = new StringBuilder();
        for(int i=0;i<nConsultas;i++) {
            usuaris.append(consultas[i].getUser()).append(";");
        }
        return usuaris.toString();
    }
    /** Dada una fecha, devuelve una cadena con los usuarios que han consultado el recurso en esa fecha **/
    public String getUsuarisData(int data){
        StringBuilder usuaris = new StringBuilder();
        for(int i=0;i<nConsultas;i++) {
            if(consultas[i].getFecha()==data) {
                usuaris.append(consultas[i].getUser()).append(";");
            }
        }
        return usuaris.toString();
    }
    /** Devuelve el numero de consultas que tiene el recurso **/
    public int getNConsultas() {
        return nConsultas;
    }
    /** Metodo auxiliar que ajusta la lista estatica al eliminar una consulta a cierto recurso **/
    private static void eliminar(Consulta[] arr, int index, int dim) {
        if (dim - 1 - index >= 0) System.arraycopy(arr, index + 1, arr, index, dim - 1 - index);
        arr[dim-1]=null;
    }
    /**Getters y setters basicos**/
    public String getNombre() {
        return nombre;
    }
    /**Nos dira si un usuario ha realizado una consulta al recurso**/
    public boolean consultat(String usuario){
        for(int i=0;i<nConsultas;i++){
            if(consultas[i].getUser().equalsIgnoreCase(usuario)){
                return true;
            }
        }
        return false;
    }


}
