package meuapp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TesteArquivos {
    public static void main(String[] args) {
        String path = "teste.txt";
        try {
            List<String> mensagens = new ArrayList<>();
            Scanner in = new Scanner(System.in);
            System.out.println("Escreva algo: ");
            String mensagem = in.nextLine();
            mensagens.add(mensagem);
            System.out.println("Deseja adicionar mais mensagens? (s/n)");
            String resposta = in.nextLine();
            while (resposta.equalsIgnoreCase("s")) {
                System.out.println("Escreva algo: ");
                mensagem = in.nextLine();
                mensagens.add(mensagem);
                System.out.println("Deseja adicionar mais mensagens? (s/n)");
                resposta = in.nextLine();
            }
            escritor(path, mensagens);
            leitor(path);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void escritor(String path, List<String> mensagens) throws IOException {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path, true));
        for (String mensagem : mensagens) {
            buffWrite.append(mensagem + "\n");
        }
        buffWrite.close();
    }

    private static void leitor(String path) throws IOException {
        File arquivo = new File(path);
        if (arquivo.exists()) {

            BufferedReader buffRead = new BufferedReader(new FileReader(path));
            String linha = "";
            while (true) {
                if (linha!= null) {
                    System.out.println(linha);

                } else
                    break;
                linha = buffRead.readLine();
            }
            buffRead.close();
        } else {
            throw new FileNotFoundException("Arquivo não encontrado.");
        }
    }
}