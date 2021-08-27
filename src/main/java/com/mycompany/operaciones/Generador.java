package com.mycompany.operaciones;

public class Generador {

    private static String[] letras = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    private static String[] numeros = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
    
    public static String generador() {

        String identificadorGenerado = "";
        int numeroCaracteres = (int) (Math.random() * (20 - 10)) + 11;

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

        int opcion = (int)(Math.random() * 51);

        return palabra + letras[opcion];
    }

    private static String agregarNumero(String palabra) {

        int opcion = (int)(Math.random() * 10);

        return palabra + numeros[opcion];
    }
}
