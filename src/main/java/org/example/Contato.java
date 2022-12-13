package org.example;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

public class Contato implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;

    private String nome;

    private String numero;

    private LocalDate dataDeNascimento;

    public Contato() {
    }

    public Contato(String id, String nome, String numero, LocalDate dataDeNascimento) {
        this.id = id;
        this.nome = nome;
        this.numero = numero;
        this.dataDeNascimento = dataDeNascimento;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public int getIdade() {
        return Period.between(dataDeNascimento, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return "Contato " + id +
                " nome: " + nome +
                ", numero: " + numero +
                ", idade: " + getIdade();
    }
}
