package br.com.alvesmateus;

import java.util.Observable;
import java.util.Observer;

public class Expedicao implements Observer {
    @Override
    public void update(Observable observable, Object objeto) {

        Componente componente = (Componente) objeto;

        prepararExpedicao(componente);
    }

    public String prepararExpedicao(Componente componente) {
        return "Expedição recebeu: " + componente;
    }
}