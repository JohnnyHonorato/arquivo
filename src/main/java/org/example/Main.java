package org.example;

import java.io.*;
import java.time.LocalDate;

public class Main {

    static GerenteDeArquivo gerenteDeArquivo = new GerenteDeArquivo();

    static GerenteBancoDeDadosContato gerenteBancoDeDadosContato = new GerenteBancoDeDadosContato();

    public static void main(String[] args) throws IOException {
        var gerenteDeArquivo = new GerenteDeArquivo();
        gerenteDeArquivo.criarArquivoDeBanco("contatos");
        gerenteBancoDeDadosContato.cadastrarContato(
                new Contato(
                        "1",
                        "Johnny Menezes",
                        "83 00000-000",
                        LocalDate.of(1997, 02, 13)
                )
        );
        gerenteBancoDeDadosContato.retonarContatos().stream().forEach(System.out::println);
    }



}