package dao;

import conexao.Conexao;
import beans.Alunos;
import java.sql.Connection;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class alunosDAO {

    private Conexao conexao;
    private Connection conn;

    public alunosDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }

    // mudei para boolean para dar a mensagem de confirmacao ou erro
    public boolean inserir(Alunos aluno) {
        try {
            String sql = "INSERT INTO alunos (nome, idade, disciplina) VALUES (?,?,?);";
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, aluno.getNome());
            stmt.setInt(2, aluno.getIdade());
            stmt.setString(3, aluno.getDisciplina());

            stmt.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir aluno: " + ex.getMessage());
        }
        return false;
    }

    public Alunos getAlunos(int id) {
        String sql = "SELECT * FROM alunos WHERE id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(
                    sql,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Alunos a = new Alunos();

            rs.first();
            a.setId(id);
            a.setNome(rs.getString("nome"));
            a.setIdade(rs.getInt("idade"));
            a.setDisciplina(rs.getString("disciplina"));
            return a;
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar aluno: " + ex.getMessage());
            return null;
        }
    }

    public void editar(Alunos aluno) {
        try {
            String sql = "UPDATE alunos set nome=?, idade=?, disciplina=? WHERE id=?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, aluno.getNome());
            stmt.setInt(2, aluno.getIdade());
            stmt.setString(3, aluno.getDisciplina());
            stmt.setInt(4, aluno.getId());
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar aluno: " + ex.getMessage());
        }
    }

    public void excluir(int id) {
        try {
            String sql = "delete from matriculas where id_aluno=?;";
            String sql2 = "delete from alunos where id=?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();

            PreparedStatement stmt2 = conn.prepareStatement(sql2);
            stmt2.setInt(1, id);
            stmt2.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir aluno: " + ex.getMessage());
        }
    }

    public List<Alunos> getAlunos() {
        String sql = "SELECT * FROM alunos";
        try {
            PreparedStatement stmt = conn.prepareStatement(
                    sql,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
            );
            ResultSet rs = stmt.executeQuery();
            List<Alunos> listaAlunos = new ArrayList();
            while (rs.next()) {
                Alunos a = new Alunos();
                a.setId(rs.getInt("id"));
                a.setNome(rs.getString("nome"));
                a.setIdade(rs.getInt("idade"));
                a.setDisciplina(rs.getString("disciplina"));
                listaAlunos.add(a);
            }
            return listaAlunos;
        } catch (SQLException ex) {
            System.out.println("Erro consultar todos os alunos: " + ex.getMessage());
            return null;
        }
    }

    public List<Alunos> getAlunosNome(String nome, String disciplina) {
        String sql = "SELECT * FROM alunos WHERE nome LIKE ? AND disciplina LIKE ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(
                    sql,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
            );
            stmt.setString(1, "%"+nome+"%");
            stmt.setString(2, "%"+disciplina+"%");
            ResultSet rs = stmt.executeQuery();
            List<Alunos> listaAlunos = new ArrayList();
            while (rs.next()) {
                Alunos a = new Alunos();
                a.setId(rs.getInt("id"));
                a.setNome(rs.getString("nome"));
                a.setIdade(rs.getInt("idade"));
                a.setDisciplina(rs.getString("disciplina"));
                listaAlunos.add(a);
            }
            return listaAlunos;
        } catch (SQLException ex) {
            System.out.println("Erro consultar todos os alunos: " + ex.getMessage());
            return null;
        }
    }
}
