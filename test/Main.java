/**Metodologias de la programacion
 * Practica 2 - Fichero Main en donde se implementa la estructura funcional de la aplicacion y se realizan los testeos
 * Gabriel Garcia **/
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int modo;
        String filename;
        System.out.println("Modo estatico o dinamico?(1/2)");
        modo = scanner.nextInt();
        while(modo!=1 && modo!=2){
            System.out.println("Error! Repite");
            modo = scanner.nextInt();
        }
        System.out.println("Nombre del fichero?");
        filename = scanner.next();
        if(modo==1) {
            System.out.println("Numero de consultas?");
            int dim = scanner.nextInt();
            ListConsultaEstatica listaEstatica = new ListConsultaEstatica(dim);
            try {
                listaEstatica = leerFicheroEstatico(filename,dim);
            } catch (IOException e) {
                e.printStackTrace();
            }
            testEstatico(listaEstatica);
            System.out.println("Pruebas estaticas del sistema de consultas realizadas");
            System.out.println("Numero de recursos?");
            int dimRecursos = scanner.nextInt();
            ListRecursosEstatico listaREstatica = consultaToRecursoEstatic(listaEstatica,dim,dimRecursos);
            testREstatico(listaREstatica);
            System.out.println("Pruebas estaticas del sistema de recursos realizadas");
        }
        else {
            ListConsultaDinamica listaDinamica = new ListConsultaDinamica();
            try {
                listaDinamica = leerFicheroDinamico(filename);
            } catch (IOException e) {
                e.printStackTrace();
            }
            testDinamico(listaDinamica);
            System.out.println("Pruebas dinamicas del sistema de consultas realizadas");
            ListRecursosDinamico listaRDinamica = consultaToRecursoDinamic(listaDinamica);
            testRDinamico(listaRDinamica);
            System.out.println("Pruebas dinamicas del sistema de recursos realizadas");
        }
        scanner.close();
    }
    /** Dada un nombre de fichero y una dimension,convierte la informacion del fichero a una instancia estatica del TAD IListConsulta **/
    public static ListConsultaEstatica leerFicheroEstatico(String filename,int dim) throws IOException {
        Scanner sc;
        sc = new Scanner(new File(filename));
        ListConsultaEstatica listaEstatica = new ListConsultaEstatica(dim);
        // Check if there is another line of input
        while(sc.hasNextLine()) {
            String str = sc.nextLine();
                Consulta c = parseData(str);
                listaEstatica.addConsulta(c);
        }
        return listaEstatica;
    }
    /** Dada un nombre de fichero, convierte la informacion del fichero a una instancia dinamica del TAD IListConsulta **/
    public static ListConsultaDinamica leerFicheroDinamico(String filename) throws IOException{
        Scanner sc;
        sc = new Scanner(new File(filename));
        ListConsultaDinamica listaDinamica = new ListConsultaDinamica();
        // Check if there is another line of input
        while(sc.hasNextLine()) {
            String str = sc.nextLine();
            // parse each line using delimiter
            Consulta c = parseData(str);
            listaDinamica.addConsulta(c);
        }
        return listaDinamica;
    }
    /** Metodo auxiliar que se encargara de convertir cada linea del fichero de entrada en una Consulta para ser añadida a su lista **/
    private static Consulta parseData(String str) {
        int data, hora;
        String recurs, user;
        Scanner lineScanner = new Scanner(str);
        Consulta c = null;
        lineScanner.useDelimiter(";");
        while(lineScanner.hasNext()){
            user = lineScanner.next();
            data = lineScanner.nextInt();
            hora = lineScanner.nextInt();
            recurs = lineScanner.next();
            c = new Consulta(user,recurs,data,hora);
        }
        lineScanner.close();
        return c;
    }
    /** Devuelve cierto si el test de los metodos de la implementacion estatica del TAD IListConsulta ha ido correctamente **/
    public static void testEstatico(ListConsultaEstatica listaEstatica) {
        /*Insertar aqui datos para las pruebas*/
        int data1 = 61221;
        int data2 = 101221;
        String recurs = "Recurs1";
        String nom = "Gabriel";
        boolean orden = true;
        /*Test*/
        if(!(listaEstatica.consultat(nom,recurs))) System.out.println("Error en metodo consultat()");
        else System.out.println("Resultado consultat correcto");
        System.out.println("Resultado getAccess: " + listaEstatica.getAccess(nom,orden));
        System.out.println("Resultado getUsers(recurso): " + (listaEstatica.getUsers(recurs)));
        System.out.println("Resultado getUsersData(recurs,data1,data2)"+ listaEstatica.getUsersData(recurs, data1, data2));
    }
    /** Devuelve cierto si el test de los metodos de la implementacion dinamica del TAD IListConsulta ha ido correctamente **/
    public static void testDinamico(ListConsultaDinamica listaDinamica) {
        /*Insertar aqui datos para las pruebas*/
        /*Insertar aqui datos para las pruebas*/
        int data1 = 61221;
        int data2 = 101221;
        String recurs = "Recurs1";
        String nom = "Gabriel";
        boolean orden = true;
        /*Test*/
        if(!(listaDinamica.consultat(nom,recurs))) System.out.println("Error en metodo consultat()");
        else System.out.println("Resultado consultat correcto");
        System.out.println("Resultado getAccess: " + listaDinamica.getAccess(nom,orden));
        System.out.println("Resultado getUsers(recurso): " + (listaDinamica.getUsers(recurs)));
        System.out.println("Resultado getUsersData(recurs,data1,data2)"+ listaDinamica.getUsersData(recurs, data1, data2));
    }
    /**Convierte el conjunto de consultas del objeto estatico del TAD IListConculta a un objeto estatico del TAD IListRecursos**/
    public static ListRecursosEstatico consultaToRecursoEstatic(ListConsultaEstatica listaEstatica, int dim, int dimRecursos) {
        ListRecursosEstatico listaREstatica = new ListRecursosEstatico(dimRecursos,dim);
        Consulta[] listaConsultas = listaEstatica.getListaConsultaEstatica();
        for(int i=0;i<listaEstatica.getnConsultas();i++){
            listaREstatica.addConsultaAt(listaConsultas[i]);
        }
        return listaREstatica;
    }
    /**Convierte el conjunto de consultas del objeto dinamico del TAD IListConculta a un objeto dinamico del TAD IListRecursos**/
    public static ListRecursosDinamico consultaToRecursoDinamic(ListConsultaDinamica listaDinamica) {
        ListRecursosDinamico listaRDinamica = new ListRecursosDinamico();
        LinkedList<Consulta> listaConsultas = listaDinamica.getListaConsultaDinamica();
        for(int i=0;i<listaDinamica.getnConsultas();i++) {
            listaRDinamica.addConsultaAt(listaConsultas.get(i));
        }
        return listaRDinamica;
    }
    /** Devuelve cierto si el test de los metodos de la implementacion estatica del TAD IListRecursos ha ido correctamente **/
    public static void testRDinamico(ListRecursosDinamico listaRDinamica) {
        /*Insertar aqui datos para las pruebas*/
        String user = "Gabriel";
        String recurs = "Recurs1";
        int data = 71221;
        int hora = 193423;
        Consulta c = new Consulta(user,recurs,data,hora);
        /*Test*/
        listaRDinamica.removeConsultaAt(c);
        System.out.println("Borrada consulta: "+user+";"+recurs+";"+data+";"+hora+";");
        listaRDinamica.removeConsultaDataAt(recurs,data);
        System.out.println("Borradas consultas por fecha: "+recurs+";"+data+";");
        System.out.println("Resultado de getUsuarisAt(recurs): "+listaRDinamica.getUsuarisAt(recurs));
        System.out.println("Resultado de recursosConsultats(user): "+ listaRDinamica.recursosConsultats(user));
        RecursoDinamico r = listaRDinamica.getNConsultasAt();
        System.out.println("Nombre del recurso resultante de getNConsultasAt(): "+r.getNombre());
    }
    /** Devuelve cierto si el test de los metodos de la implementacion dinamica del TAD IListRecursos ha ido correctamente **/
    public static void testREstatico(ListRecursosEstatico listaREstatica) {
        /*Insertar aqui datos para las pruebas*/
        String user = "Gabriel";
        String recurs = "Recurs1";
        int data = 71221;
        int hora = 193423;
        Consulta c = new Consulta(user,recurs,data,hora);
        /*Test*/
        listaREstatica.removeConsultaAt(c);
        System.out.println("Borrada consulta: "+user+";"+recurs+";"+data+";"+hora+";");
        listaREstatica.removeConsultaDataAt(recurs,data);
        System.out.println("Borradas consultas por fecha: "+recurs+";"+data+";");
        System.out.println("Resultado de getUsuarisAt(recurs): "+listaREstatica.getUsuarisAt(recurs));
        System.out.println("Resultado de recursosConsultats(user): "+ listaREstatica.recursosConsultats(user));
        RecursoEstatico r = listaREstatica.getNConsultasAt();
        System.out.println("Nombre del recurso resultante de getNConsultasAt(): "+r.getNombre());
    }

}
