/**Metodologias de la programacion
* Practica 2 - Fichero que implementa el tipo basico Consulta
* Gabriel Garcia **/

public class Consulta implements IConsulta {

    private final String user;
    private final String recurso;
    private final int fecha;
    private final int hora;

    /** Metodo constructor +*/
    public Consulta(String user, String recurso, int fecha, int hora) {
        this.user = user;
        this.recurso = recurso;
        this.fecha = fecha;
        this.hora = hora;
        // Control errores
    }

    /** Metodo que verifica si una consulta es exactamente igual a otra **/
    public boolean equals(Consulta a) {
        return this.user.equalsIgnoreCase(a.getUser()) && this.recurso.equalsIgnoreCase(a.getRecurso()) && this.fecha == a.getFecha() && this.hora == a.getHora();
    }

    /** Metodo que verifica si una fecha o una hora es superior a la otra
     * Si dataORhora==true->ordenar por fecha
     * Si dataORhora==false->ordenar por hora**/
    public int esMajor(int datahora2, boolean dataORhora) {
        int datahora1;
        if(dataORhora) {
            datahora1 = this.fecha;
        }
        else datahora1 = this.hora;

        int[] abc1;
        int[] abc2;
        abc1 = this.convertDataHora(datahora1);
        abc2 = this.convertDataHora(datahora2);
        if(!dataORhora) {
            if(abc1[0] == abc2[0] && abc1[1] == abc2[1] && abc1[2] == abc2[2]) return 0;
            if(abc1[2] > abc2[2]) return 1;
            if(abc1[2] < abc2[2]) return -1;
            if(abc1[1] > abc2[1]) return 1;
            if(abc1[1] < abc2[1]) return -1;
            if(abc1[0] > abc2[0]) return 1;
            return -1;

        }
        else {
            if(abc1[0]==abc2[0] && abc1[1]==abc2[1] && abc1[2]==abc2[2]) return 0;
            if(abc1[0] > abc2[0]) return 1;
            if(abc1[0] < abc2[0]) return -1;
            if(abc1[1] > abc2[1]) return 1;
            if(abc1[1] < abc2[1]) return -1;
            if(abc1[2] > abc2[2]) return 1;
            return -1;
        }
    }

    /** Metodo auxiliar que splittea la fecha / hora para comparar si es mayor a otra**/
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

    public String getRecurso() {
        return recurso;
    }

    public int getFecha() {
        return fecha;
    }

    public int getHora() {
        return hora;
    }

    public Consulta copy() {
        return new Consulta(this.user, this.recurso, this.fecha, this.hora);
    }

}
