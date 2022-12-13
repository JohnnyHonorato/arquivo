package org.example;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class GerenteBancoDeDadosContato {

    public ArrayList<Contato> contatos = new ArrayList<>();

    public GerenteDeArquivo gerenteDeArquivo = new GerenteDeArquivo();

    public ArrayList<Contato> retonarContatos() {
        return contatos;
    }

    public void cadastrarContato(Contato contato) {
        var file = gerenteDeArquivo.getArquivoDeBanco("contatos.txt");
        contatos.add(contato);
        try (var out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
            for(Contato item : contatos) {
                out.writeObject(item);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        carregarDados();
    }

    public void carregarDados() {
        contatos.clear();
        var file = gerenteDeArquivo.getArquivoDeBanco("contatos.txt");
        try (var in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
            while (true) {
                var objeto = in.readObject();
                if(objeto instanceof Contato c) {
                    contatos.add(c);
                }
            }
        } catch (Exception e) {
            // tratamento
        }
    }

    public void editarContato(String idContato, Contato contato) {

    }

    public boolean deletarContato() {
        return false;
    }

}
