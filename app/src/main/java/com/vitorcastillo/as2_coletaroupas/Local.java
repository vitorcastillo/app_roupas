package com.vitorcastillo.as2_coletaroupas;

public class Local {
    private String nome;
    private String tipo;
    private String endereco;
    private String contato;

    public Local(String nome, String tipo, String endereco, String contato) {
        this.nome = nome;
        this.tipo = tipo;
        this.endereco = endereco;
        this.contato = contato;
    }

    public String getNome() {
        return nome;
    }
    public String getTipo() {
        return tipo;
    }
    public String getEndereco() {
        return endereco;
    }
    public String getContato() {
        return contato;
    }

    public void setNome(String nome) {this.nome = nome;};

}
