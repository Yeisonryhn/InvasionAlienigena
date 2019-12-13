package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Utilidades {
    Scanner input;
    String linea;
    InvasionAlienigena invasion;

    public InvasionAlienigena cargarDatos(){
        try {
            input = new Scanner(new File("src/com/company/input.txt"));
            invasion= new InvasionAlienigena(Integer.parseInt( input.nextLine()));
            while(input.hasNextLine()){

                for (int k=0; k<invasion.CANT_NAVES; k++ ){

                    linea = input.nextLine();
                    invasion.dimensionarNave(linea);
                    for(int i=0; i<invasion.naves[k].x; i++){
                        linea = input.nextLine();
                        invasion.naves[k].setFila(linea, i);
                    }
                    invasion.nuevaNave();
                }
            }
            input.close();
        }catch (Exception ex){
            System.out.println(ex);
        }
        return invasion;
    }

    public PrintWriter abrirArchivoEscritura(){
        FileWriter file = null;
        PrintWriter pwriter = null;
        try {
            file = new FileWriter("src/com/company/output.txt");
            pwriter = new PrintWriter(file);

        }catch (Exception e){
            System.out.println("Error al Crear el Archivo");
        }

        return pwriter;
    }
    public void cerrarArchivoEscritura(PrintWriter pwriter){
        pwriter.close();
    }
    public void escribirCoordenadasNave(PrintWriter pwriter, Nave nave){
        nave.imprimir(pwriter);
    }
}
