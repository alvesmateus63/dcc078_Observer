package br.com.alvesmateus;

import java.util.Observable;
import java.util.Observer;

public class Estoque implements Observer {
    @Override
    public void update(Observable observable, Object objeto) {
        Componente componente = (Componente) objeto;
    }

    public String registrarEntrada(Componente componente) {
        return "Estoque: componente " + componente.getCodigo() + " adicionado ao estoque.";
    }
}
