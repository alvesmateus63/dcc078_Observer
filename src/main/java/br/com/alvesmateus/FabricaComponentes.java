package br.com.alvesmateus;

import java.util.Observable;

public class FabricaComponentes extends Observable {
    public String produzir(Componente componente) {

        setChanged();
        notifyObservers(componente);

        return "Componente produzido: " + componente;
    }
}
