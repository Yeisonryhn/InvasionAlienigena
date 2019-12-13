package com.company;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

public class CentroControl implements Comparable{
    String W;
    float Px,Py, ancho, alto, area;
    boolean rectangular;

    public CentroControl(){
        rectangular = false;
    }

    public void cargarDatos(String descr, float min_x, float min_y, float max_x, float max_y, float escala, int repeticiones){
        this.W = descr;
        Px=((min_x + (max_x+1))/2)*escala;
        Py=((min_y + (max_y+1))/2)*escala;
        ancho = (max_y + 1) - min_y;
        alto =  (max_x + 1) - min_x;
        if( repeticiones == (ancho*alto) ) rectangular=true;

        ancho*=escala;
        alto*=escala;
        area = ancho*alto;
    }

    public String secuencia(){
        DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.US);
        DecimalFormat df = new DecimalFormat("0.000", otherSymbols);
        df.setRoundingMode(RoundingMode.HALF_DOWN);
        return W+":"+df.format(Px)+","+df.format(Py);
    }


    @Override
    public int compareTo(Object o) {
        CentroControl c = (CentroControl)o;
        if(c.area >  area){
            return -1;
        }else if(c.area < area) {
            return 0;
        }else{
            return 1;
        }
    }
}
