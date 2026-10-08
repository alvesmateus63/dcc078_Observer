package br.com.alvesmateus;

import org.junit.jupiter.api.Test;

import java.util.Observable;
import java.util.Observer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class FabricaComponentesTest {
    @Test
    void deveNotificarObserverQuandoComponenteForProduzido() {

        FabricaComponentes fabrica = new FabricaComponentes();

        TestObserver observer = new TestObserver();

        fabrica.addObserver(observer);

        Componente componente = new Componente(
                "Resistor 10KΩ",
                "RES-001"
        );

        String resultado = fabrica.produzir(componente);

        assertEquals(
                "Componente produzido: Resistor 10KΩ (RES-001)",
                resultado
        );

        assertEquals(1, observer.getQuantidadeNotificacoes());
        assertSame(componente, observer.getUltimoComponente());
    }

    @Test
    void deveNotificarTodosOsObservers() {

        FabricaComponentes fabrica = new FabricaComponentes();

        TestObserver estoque = new TestObserver();
        TestObserver qualidade = new TestObserver();
        TestObserver expedicao = new TestObserver();

        fabrica.addObserver(estoque);
        fabrica.addObserver(qualidade);
        fabrica.addObserver(expedicao);

        Componente componente = new Componente(
                "Capacitor 100μF",
                "CAP-001"
        );

        fabrica.produzir(componente);

        assertEquals(1, estoque.getQuantidadeNotificacoes());
        assertEquals(1, qualidade.getQuantidadeNotificacoes());
        assertEquals(1, expedicao.getQuantidadeNotificacoes());

        assertSame(componente, estoque.getUltimoComponente());
        assertSame(componente, qualidade.getUltimoComponente());
        assertSame(componente, expedicao.getUltimoComponente());
    }

    @Test
    void naoDeveNotificarObserverRemovido() {

        FabricaComponentes fabrica = new FabricaComponentes();

        TestObserver observer = new TestObserver();

        fabrica.addObserver(observer);
        fabrica.deleteObserver(observer);

        Componente componente = new Componente(
                "Diodo",
                "DIO-001"
        );

        fabrica.produzir(componente);

        assertEquals(0, observer.getQuantidadeNotificacoes());
    }

    @Test
    void deveNotificarObserverParaCadaComponenteProduzido() {

        FabricaComponentes fabrica = new FabricaComponentes();

        TestObserver observer = new TestObserver();

        fabrica.addObserver(observer);

        Componente resistor = new Componente(
                "Resistor",
                "RES-001"
        );

        Componente capacitor = new Componente(
                "Capacitor",
                "CAP-001"
        );

        fabrica.produzir(resistor);
        fabrica.produzir(capacitor);

        assertEquals(2, observer.getQuantidadeNotificacoes());
        assertSame(capacitor, observer.getUltimoComponente());
    }

    private static class TestObserver implements Observer {

        private int quantidadeNotificacoes;
        private Componente ultimoComponente;

        @Override
        public void update(Observable observable, Object objeto) {

            quantidadeNotificacoes++;

            ultimoComponente = (Componente) objeto;
        }

        public int getQuantidadeNotificacoes() {
            return quantidadeNotificacoes;
        }

        public Componente getUltimoComponente() {
            return ultimoComponente;
        }
    }
}
