package com.example.estacionamento.util;

public class ValidaPlaca {

    public static boolean validaPlaca(String placa) {
        return placa.matches("^[A-Z]{3}[0-9]{4}$|^[A-Z]{3}[0-9][0-9A-Z][0-9]{2}$");
    }

}
