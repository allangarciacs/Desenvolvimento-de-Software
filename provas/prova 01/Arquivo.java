package prova01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Arquivo {
    
    public static void salvar(
            String titulo, 
            String autor, 
            String ano, 
            String tipo, 
            String categorias, 
            String status) {
        
        try {
            FileWriter arquivo = new FileWriter("biblioteca.txt", true);
            PrintWriter escrever = new PrintWriter(arquivo);
            
            escrever.println(
                    titulo + "; " +
                    autor + "; " +
                    ano + "; " +
                    tipo + "; " +
                    categorias + "; " +
                    status
            );
            
            escrever.close();
            arquivo.close();
            
        } catch (IOException erro){
            System.out.println("Erro ao salvar o arquivo!");
        }
    }
    
    public static void salvarTabela(JTable tabela) {
        try {
            FileWriter arquivo = new FileWriter("biblioteca.txt");
            PrintWriter escrever = new PrintWriter(arquivo);
            
            for (int i = 0; i < tabela.getRowCount(); i++) {
                escrever.println(
                tabela.getValueAt(i, 0) + ";" + 
                tabela.getValueAt(i, 1) + ";" +
                tabela.getValueAt(i, 2) + ";" +
                tabela.getValueAt(i, 3) + ";" +
                tabela.getValueAt(i, 4) + ";" +
                tabela.getValueAt(i, 5)
                );
            }
            escrever.close();
            arquivo.close();
            
        } catch (IOException erro) {
            System.out.println("Erro ao salvar o arquivo!");
        }
    }
    
    public static void carregarTabela(JTable tabela) {
        try {
            BufferedReader ler = new BufferedReader(
                    new FileReader("biblioteca.txt"));
            
            DefaultTableModel modelo = (
                    DefaultTableModel) tabela.getModel();
            
            String linha;
            
            while ((linha = ler.readLine()) != null) {
                String[] dados = linha.split(";");
                
                modelo.addRow(dados);
            }
            ler.close();
        
        } catch (IOException erro) {
                System.out.println("Erro ao carregar o arquivo!");
        }
    }
}
