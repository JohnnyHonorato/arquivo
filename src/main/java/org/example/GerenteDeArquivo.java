package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class GerenteDeArquivo {

    private String caminhoDoBackup = "src/main/resources/backup/";
    private String caminhoDoArquivo = "src/main/resources/banco/";

    public void criarArquivoDeBanco(String nomeDoArquivo) throws IOException {
        File novoArquivo = new File(caminhoDoArquivo + nomeDoArquivo);
        if(novoArquivo.createNewFile()) {
            System.out.println("Arquivo criado com sucesso");
        } else {
            System.out.println("Arquivo nao criado");
        }
    }

    public void apagarArquivoDeBanco(String nomeDoArquivo) {
        Path path = Path.of(caminhoDoArquivo + nomeDoArquivo);
        File arquivo = path.toFile();
        if(arquivo.delete()) {
            System.out.println("Arquivo deletado com sucesso");
        } else {
            System.out.println("Arquivo nao deletado");
        }
    }

    public void fazerBackupArquivoDeBanco(String nomeDoArquivo) throws IOException {
        Files.copy(Path.of(caminhoDoArquivo + nomeDoArquivo), Path.of(caminhoDoBackup + nomeDoArquivo));
    }

    public File getArquivoDeBanco(String nomeDoArquivo) {
        return Path.of(caminhoDoArquivo + nomeDoArquivo).toFile();
    }
}
