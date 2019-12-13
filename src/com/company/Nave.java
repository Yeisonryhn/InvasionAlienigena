package com.company;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.regex.*;
import java.util.StringTokenizer;
import java.util.Vector;

public class Nave {
    int x,y;
    float escala;
    String matriz[][];
    String regex;
    ArrayList<CentroControl> centros = new ArrayList<CentroControl>();
    ArrayList<CentroControl> centros2 = new ArrayList<CentroControl>();

    public Nave(int x, int y, float escala) {
        this.x = x;
        this.y = y;
        this.escala = escala;
        matriz = new String [x][y];
        regex = "[a-zA-Z]";
    }

    public void setEscala(float escala) {
        this.escala = escala;
    }

    public void setFila(String linea, int i){
        StringTokenizer tokens = new StringTokenizer(linea);
        for(int j=0; j<y; j++){

            matriz[i][j]=tokens.nextToken();
        }
    }

    public void detectarCentrosControl(){
        CentroControl centro;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if(Pattern.matches(regex, matriz[i][j])){
                    centro=calcularCentroControl(matriz[i][j], i, j);
                    if(centro.rectangular){
                        centros.add(centro);
                    }else{
                        centros2.add(centro);
                    }
                    destruirControl(matriz[i][j]);

                }else{
                }
            }
        }
    }

    public CentroControl calcularCentroControl(String descr, int x, int y){
        CentroControl centro = new CentroControl();
        int max_x = x;
        int min_x = x;
        int max_y = y;
        int min_y = y;
        int repeticiones=0;
        for (int i = 0; i < this.x; i++) {
            for (int j = 0; j < this.y; j++) {
                if(descr.equals(matriz[i][j])){
                    repeticiones+=1;
                    if(i > max_x) max_x = i;
                    if(i < min_x) min_x = i;
                    if(j > max_y) max_y = j;
                    if(j < min_y) min_y =j;
                }
            }
        }
        centro.cargarDatos(matriz[x][y], min_x, min_y, max_x, max_y, escala, repeticiones);
        return centro;
    }

    public void destruirControl(String descr){
        for (int i = 0; i < x ; i++) {
            for (int j = 0; j < y; j++) {
                if(descr.equals(matriz[i][j])) matriz[i][j]=" ";
            }
        }

    }

    public void imprimir(PrintWriter p){
        int i;
        String secuencias = new String();
        for (i = 0; i < centros.size(); i++) {
            if(i < centros.size()-1){
                p.print(centros.get(i).secuencia());
                p.print(";");
                System.out.print(centros.get(i).secuencia());
                System.out.print(";");
            }else{
                System.out.print(centros.get(i).secuencia());
                p.print(centros.get(i).secuencia());
            }
        }
        p.print(" ");
        System.out.print(" ");
        for (i = 0; i < centros2.size() ; i++) {
            if(i < centros2.size()-1){
                p.print(centros2.get(i).secuencia());
                p.print(" ");
                System.out.print(centros2.get(i).secuencia());
                System.out.print(" ");
            }else {
                p.print(centros2.get(i).secuencia());
                System.out.print(centros2.get(i).secuencia());
            }

        }
        System.out.println();
        p.println();
    }

}
