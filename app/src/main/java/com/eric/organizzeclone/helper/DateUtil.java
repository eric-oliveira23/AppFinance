package com.eric.organizzeclone.helper;

import java.text.SimpleDateFormat;

public class DateUtil {

    public static String retornarData(){

       long date = System.currentTimeMillis();
       SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

       String dateFormat = simpleDateFormat.format(date);

       return dateFormat;
    }

    public static String mesAnoData(String data){

        String retornoData[] = data.split("/");
        String dia = retornoData[0];
        String mes = retornoData[1];
        String ano = retornoData[2];

        String dataFinal = mes+ano;
        return dataFinal;
    }

}
