package br.com.alvesmateus;

import java.util.Observable;
import java.util.Observer;

public class ControleQualidade implements Observer {
    @Override
    public void update(Observable observable, Object objeto) {

        Componente componente = (Componente) objeto;

        realizarInspecao(componente);
    }

    public String realizarInspecao(Componente componente) {
        return "Controle de qualidade recebeu: " + componente;
    }
}
