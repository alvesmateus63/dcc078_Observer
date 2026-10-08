package br.com.alvesmateus;

public class Componente {
    private final String nome;
    private final String codigo;

    public Componente(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return nome + " (" + codigo + ")";
    }
}
