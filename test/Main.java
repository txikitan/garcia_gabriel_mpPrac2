import java.io.File;
import java.io.IOException;
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
            ListConsultaEstatica listaEstatica = null;
            try {
                listaEstatica = leerFicheroEstatico(filename,dim);
            } catch (IOException e) {
                e.printStackTrace();
            }
            testEstatico(listaEstatica);
            ListRecursosEstatico listaREstatica = consultaToRecursoEstatic(listaEstatica);
            testREstatico(listaREstatica);
        }
        else {
            ListConsultaDinamica listaDinamica = null;
            try {
                listaDinamica = leerFicheroDinamico(filename);
            } catch (IOException e) {
                e.printStackTrace();
            }
            testDinamico(listaDinamica);
            ListRecursosDinamico listaRDinamica = consultaToRecursoDinamic(listaDinamica);
            testRDinamico(listaRDinamica);
        }
        scanner.close();
    }

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


    public static void testEstatico(ListConsultaEstatica listaEstatica) {

    }

    public static void testDinamico(ListConsultaDinamica listaDinamica) {

    }

    public static ListRecursosEstatico consultaToRecursoEstatic(ListConsultaEstatica listaEstatica) {

    }

    public static ListRecursosDinamico consultaToRecursoDinamic(ListConsultaDinamica listaDinamica) {

    }

    public static void testRDinamico(ListRecursosDinamico listaREstatica) {

    }

    public static void testREstatico(ListRecursosEstatico listaRDinamica) {

    }

}
