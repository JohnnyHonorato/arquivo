package org.example;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Optional;

public class GerenteStreamContato {

    private GerenteBancoDeDadosContato gerenteBancoDeDados;

    public GerenteStreamContato(GerenteBancoDeDadosContato gerenteBancoDeDados) {
        this.gerenteBancoDeDados = gerenteBancoDeDados;
    }

    public void mostreSomaDeTodasAsIdades() {
        System.out.println("Soma: " + gerenteBancoDeDados.retonarContatos().stream()
                .reduce(0,
                        (somaParcial, contatoAtual) -> somaParcial + contatoAtual.getIdade(),
                        Integer::sum
                ));
    }

    public void mostrePorDataDeNascimento(LocalDate dataDeNascimento) {
        System.out.println("----------- Busca por data de nascimento ----------");
        gerenteBancoDeDados.retonarContatos().stream()
                .filter(contato -> contato.getDataDeNascimento().isEqual(dataDeNascimento))
                .forEach(System.out::println);
        System.out.println("---------------------");
    }

    public void mostrePorIdOuNome(String value) {
        Optional<Contato> optionalContato = gerenteBancoDeDados.retonarContatos().stream()
                .filter(contato -> contato.getNome().equals(value) || contato.getId().equals(value)).findFirst();
        if(optionalContato.isPresent()) {
            System.out.println("filtro id ou nome: " + optionalContato.get());
        } else {
            System.out.println("Nao existe contato com esse id ou nome");
        }
    }

    public void mostreOrdenadoPorNome() {
        System.out.println("----------- Ordenado por nome ----------");
        gerenteBancoDeDados.retonarContatos().stream()
                .sorted(Comparator.comparing(Contato::getNome))
                .forEach(System.out::println);
        System.out.println("---------------------");
    }

    public void mostreUmaPessoaMaisVelha() {
        System.out.println("Mais velha:" +  gerenteBancoDeDados.retonarContatos().stream()
                .min(Comparator.comparing(Contato::getDataDeNascimento))
                .orElse(null));
    }

    public void mostreUmaPessoaMaisNova() {
        System.out.println("Mais nova:" + gerenteBancoDeDados.retonarContatos().stream()
                .max(Comparator.comparing(Contato::getDataDeNascimento))
                .orElse(null));
    }


}