

public class Consulta {

    private String user;
    private String recurso;
    private int fecha;
    private int hora;

    public Consulta(String user, String recurso, int fecha, int hora) {
        this.user = user;
        this.recurso = recurso;
        this.fecha = fecha;
        this.hora = hora;
        // Control errores
    }

    /** Verifica si una fecha o una hora es superior a la otra **/
    public boolean esMajor(int datahora2, boolean dataORhora) {
        int datahora1;
        if(dataORhora) {
            datahora1 = this.fecha;
        }
        else datahora1 = this.hora;

        int[] abc1;
        int[] abc2;
        abc1 = this.convertDataHora(datahora1);
        abc2 = this.convertDataHora(datahora2);


        if(abc1[0]>abc2[0]) return true;
        if(abc1[1]>abc2[1]) return true;
        return abc1[2] > abc2[2];
    }

    private int[] convertDataHora(int fechahora){
        int[] abc = new int[3];
        abc[0] = fechahora % 100;
        fechahora = fechahora/100;
        abc[1] = fechahora % 100;
        fechahora = fechahora/100;
        abc[2] = fechahora % 100;
        return abc;
    }

    /**Getters y setters basicos**/
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getRecurso() {
        return recurso;
    }

    public void setRecurso(String recurso) {
        this.recurso = recurso;
    }

    public int getFecha() {
        return fecha;
    }

    public void setFecha(int fecha) {
        this.fecha = fecha;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }
    public Consulta copy() {
        return new Consulta(this.user, this.recurso, this.fecha, this.hora);
    }

}
