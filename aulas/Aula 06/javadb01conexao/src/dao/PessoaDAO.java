package DAO;

import conexao.Conexao;
import DAO.PessoaDAO;
import beans.Pessoa;
import java.sql.Connection;
import java.util.List;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList; 
import javax.swing.JOptionPane;

public class PessoaDAO {
    
    private Conexao conexao;
    private Connection conn; 
    
    public PessoaDAO(){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    public void inserir (Pessoa pessoa) {
        try {
            String sql = "INSERT INTO pessoa (nome, sexo, idioma) VALUES (?,?,?);";
            
            PreparedStatement stmt = this.conn.prepareStatement(sql); 
            
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getSexo());
            stmt.setString(3, pessoa.getIdioma());
            
            stmt.execute(); 
            System.out.println("Pessoa inserida");
            
        } catch(SQLException ex){
            System.out.println("Erro ao inserir pessoa: "+ex.getMessage());
        }
    }
    
    public Pessoa consultar(int id) {
        try {
        String sql = "SELECT * FROM pessoa WHERE id = ?";
        PreparedStatement stmt = this.conn.prepareStatement(sql);

        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            Pessoa pessoa = new Pessoa();

            pessoa.setId(rs.getInt("id"));
            pessoa.setNome(rs.getString("nome"));
            pessoa.setSexo(rs.getString("sexo"));
            pessoa.setIdioma(rs.getString("idioma"));

            return pessoa;
        }

    } catch (SQLException ex) {
        System.out.println("Erro ao consultar pessoa: " + ex.getMessage());
    }

    return null;     
    }
   
    public void editar(Pessoa pessoa) {
        try {
            String sql = "UPDATE pessoa " +
                         "SET nome = ?, sexo = ?, idioma = ? " +
                         "WHERE id = ?";

            PreparedStatement stmt = this.conn.prepareStatement(sql);

            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getSexo());
            stmt.setString(3, pessoa.getIdioma());
            stmt.setInt(4, pessoa.getId());

            stmt.execute();

        } catch(SQLException ex) {
            System.out.println("Erro ao editar pessoa: " + ex.getMessage());
        }
    }

    public void excluir (int id) {
        try {
            String sql = "DELETE FROM pessoa WHERE id = ?";

            PreparedStatement stmt = this.conn.prepareStatement(sql);

            stmt.setInt(1, id);

            stmt.execute();

            System.out.println("Pessoa excluída com sucesso!");

        } catch (SQLException ex) {
            System.out.println("Erro ao excluir pessoa: " + ex.getMessage());
        }
    }
   
}