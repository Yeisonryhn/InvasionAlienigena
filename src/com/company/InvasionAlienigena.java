package com.company;

import java.util.StringTokenizer;
import java.util.regex.*;

public class InvasionAlienigena {
    Nave naves[];
    int CANT_NAVES;
    int naves_creadas;

    public InvasionAlienigena(int cantidad_naves) {
        CANT_NAVES = cantidad_naves;
        naves = new Nave[CANT_NAVES];
        naves_creadas=0;
        //this.naves = null;
    }

    public void dimensionarNave(String linea){
        StringTokenizer tokens = new StringTokenizer(linea);
        int x = Integer.parseInt(tokens.nextToken());
        int y = Integer.parseInt(tokens.nextToken());
        float escala = Float.parseFloat(tokens.nextToken());
        naves[naves_creadas]= new Nave(x,y,escala);

    }
    public void nuevaNave(){
        naves_creadas+=1;
    }
}
