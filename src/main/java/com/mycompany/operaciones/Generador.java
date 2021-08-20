package com.mycompany.operaciones;

public class Generador {

    public static String generador() {

        String identificadorGenerado = "";
        int numeroCaracteres = (int) (Math.random() * (15 - 10)) + 11;

        for (int i = 0; i < numeroCaracteres; i++) {
            if((int)(Math.random ()*2)+1 == 2){
                identificadorGenerado = agregarLetra(identificadorGenerado);
            } else {
                identificadorGenerado = agregarNumero(identificadorGenerado);
            }
        }
        return identificadorGenerado;
    }

    private static String agregarLetra(String palabra){

        int opcion = (int)(Math.random() * 26) +1;

        switch(opcion){
            case 1:
            return palabra + "a";
            case 2:
            return palabra + "b";
            case 3:
            return palabra + "c";
            case 4:
            return palabra + "d";
            case 5:
            return palabra + "e";
            case 6:
            return palabra + "f";
            case 7:
            return palabra + "g";
            case 8:
            return palabra + "h";
            case 9:
            return palabra + "i";
            case 10:
            return palabra + "j";
            case 11:
            return palabra + "k";
            case 12:
            return palabra + "l";
            case 13:
            return palabra + "m";
            case 14:
            return palabra + "n";
            case 15:
            return palabra + "o";
            case 16:
            return palabra + "p";
            case 17:
            return palabra + "q";
            case 18:
            return palabra + "r";
            case 19:
            return palabra + "s";
            case 20:
            return palabra + "t";
            case 21:
            return palabra + "u";
            case 22:
            return palabra + "v";
            case 23:
            return palabra + "w";
            case 24:
            return palabra + "x";
            case 25:
            return palabra + "y";
            case 26:
            return palabra + "z";
        }
        return "";
    }

    private static String agregarNumero(String palabra) {

        int opcion = (int)(Math.random() * 9);

        switch(opcion){
            case 0:
            return palabra + "0";
            case 1:
            return palabra + "1";
            case 2:
            return palabra + "2";
            case 3:
            return palabra + "3";
            case 4:
            return palabra + "4";
            case 5:
            return palabra + "5";
            case 6:
            return palabra + "6";
            case 7:
            return palabra + "7";
            case 8:
            return palabra + "8";
            case 9:
            return palabra + "9";
        }
        return "";
    }
}
