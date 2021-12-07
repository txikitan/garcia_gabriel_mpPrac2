import java.io.File;
import java.io.FileNotFoundException;
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
        scanner.close();
        if(modo==1) {
            ListConsultaEstatica listaEstatica = leerFicheroEstatico(filename);
            testEstatico(listaEstatica);
            ListRecursosEstatico listaREstatica = consultaToRecursoEstatic(listaEstatica);
            testREstatico(listaREstatica);
        }
        else {
            ListConsultaDinamica listaDinamica = leerFicheroDinamico(filename);
            testDinamico(listaDinamica);
            ListRecursosDinamico listaRDinamica = consultaToRecursoDinamic(listaDinamica);
            testRDinamico(listaRDinamica);
        }
    }

    public static ListConsultaEstatica leerFicheroEstatico(String filename) {

    }

    public static ListConsultaDinamica leerFicheroDinamico(String filename) {

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
