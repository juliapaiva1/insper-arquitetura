package org.example.pessoa;



import java.util.ArrayList;
import java.util.List;

public class Pessoa {

    @NotNull
    @NotEmpty
    private String nome;
    private String cpf;

    public Pessoa(String cpf) {
        this.cpf = cpf;
    }

    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
