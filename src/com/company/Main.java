package com.company;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        InvasionAlienigena invasion = null;
        String linea;
        StringTokenizer tokens;
        Utilidades utilidades = new Utilidades();
        PrintWriter p;

        invasion = utilidades.cargarDatos();
        p = utilidades.abrirArchivoEscritura();
        for (int i = 0; i < invasion.CANT_NAVES; i++) {
            invasion.naves[i].detectarCentrosControl();
            Collections.sort(invasion.naves[i].centros);
            utilidades.escribirCoordenadasNave(p,invasion.naves[i]);
        }
        utilidades.cerrarArchivoEscritura(p);
    }

}
