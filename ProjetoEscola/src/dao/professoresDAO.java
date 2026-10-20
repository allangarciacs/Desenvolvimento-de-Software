package dao;

// import beans.Alunos;
import conexao.Conexao;
import beans.Professores;
import java.sql.Connection;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class professoresDAO {

    private Conexao conexao;
    private Connection conn;

    public professoresDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }

    public boolean inserir(Professores professor) {
        try {
            String sql = "INSERT INTO professores (nome, idade, disciplina) VALUES (?,?,?);";
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, professor.getNome());
            stmt.setInt(2, professor.getIdade());
            stmt.setString(3, professor.getDisciplina());

            stmt.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir professor: " + ex.getMessage());
        }
        return false;
    }

    public Professores getProfessor(int id) {
        String sql = "SELECT * FROM professores WHERE id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(
                    sql,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Professores p = new Professores();

            rs.first();
            p.setId(id);
            p.setNome(rs.getString("nome"));
            p.setIdade(rs.getInt("idade"));
            p.setDisciplina(rs.getString("disciplina"));
            return p;
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar professor: " + ex.getMessage());
            return null;
        }
    }

    public void editar(Professores professor) {
        try {
            String sql = "UPDATE professores set nome=?, idade=?, disciplina=? WHERE id=?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, professor.getNome());
            stmt.setInt(2, professor.getIdade());
            stmt.setString(3, professor.getDisciplina());
            stmt.setInt(4, professor.getId());
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar professor: " + ex.getMessage());
        }
    }

    public void excluir(int id) {
        try {
            String sql = "delete from matriculas where id_aluno=?;";
            String sql2 = "delete from professores where id=?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();

            PreparedStatement stmt2 = conn.prepareStatement(sql2);
            stmt2.setInt(1, id);
            stmt2.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir professor: " + ex.getMessage());
        }
    }

    public List<Professores> getProfessores() {
        String sql = "SELECT * FROM professores";
        try {
            PreparedStatement stmt = conn.prepareStatement(
                    sql,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
            );
            ResultSet rs = stmt.executeQuery();
            List<Professores> listaProfessores = new ArrayList();
            while (rs.next()) {
                Professores p = new Professores();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setIdade(rs.getInt("idade"));
                p.setDisciplina(rs.getString("disciplina"));
                listaProfessores.add(p);
            }
            return listaProfessores;
        } catch (SQLException ex) {
            System.out.println("Erro consultar todos os professores: " + ex.getMessage());
            return null;
        }
    }

    public List<Professores> getProfessoresNome(String nome, String disciplina) {
        String sql = "SELECT * FROM professores WHERE nome LIKE ? AND disciplina LIKE ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(
                    sql,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
            );
            stmt.setString(1, "%" + nome + "%");
            stmt.setString(2, "%" + disciplina + "%");
            ResultSet rs = stmt.executeQuery();
            List<Professores> listaProfessores = new ArrayList();
            while (rs.next()) {
                Professores p = new Professores();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setIdade(rs.getInt("idade"));
                p.setDisciplina(rs.getString("disciplina"));
                listaProfessores.add(p);
            }
            return listaProfessores;
        } catch (SQLException ex) {
            System.out.println("Erro consultar todos os professores: " + ex.getMessage());
            return null;
        }
    }
}
