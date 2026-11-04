package DAO;

import conexao.Conexao;
import java.sql.Connection;
import beans.Funcionario;
import java.util.List;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author laboratorio
 */
public class FuncionarioDAO {

    private Conexao conexao;
    private Connection conn;

    public FuncionarioDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }

    public boolean inserir(Funcionario funcionario) {
        try {
            String sql = "INSERT INTO funcionarios (nome, idade, genero, cargo, salario) VALUES (?,?,?,?,?);";
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, funcionario.getNome());
            stmt.setInt(2, funcionario.getIdade());
            stmt.setString(3, funcionario.getGenero());
            stmt.setString(4, funcionario.getCargo());
            stmt.setDouble(5, funcionario.getSalario());

            stmt.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir funcionario: " + ex.getMessage());
        }
        return false;
    }

    public List<Funcionario> listar() {
        String sql = "SELECT * FROM funcionarios";
        try {
            PreparedStatement stmt = conn.prepareStatement(
                    sql,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
            );
            ResultSet rs = stmt.executeQuery();
            List<Funcionario> listaFuncionarios = new ArrayList();
            while (rs.next()) {
                Funcionario f = new Funcionario();
                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setIdade(rs.getInt("idade"));
                f.setGenero(rs.getString("genero"));
                f.setCargo(rs.getString("cargo"));
                f.setSalario(rs.getDouble("salario"));
                listaFuncionarios.add(f);
            }
            return listaFuncionarios;
        } catch (SQLException ex) {
            System.out.println("Erro ao listar todos os funcionarios: " + ex.getMessage());
            return null;
        }
    }

}

