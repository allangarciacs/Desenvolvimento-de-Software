package DAO;

import beans.Pessoa;
import beans.Veiculo;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VeiculoDAO {

    private Conexao conexao;
    private Connection conn;

    public VeiculoDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }

    public void inserir(Veiculo veiculo) {
        try {
            String sql = "INSERT INTO veiculos (modelo, placa, id_pessoa) VALUES (?,?,?);";
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, veiculo.getModelo());
            stmt.setString(2, veiculo.getPlaca());
            stmt.setInt(3, veiculo.getPessoaid().getId());

            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir vaiculo: " + ex.getMessage());
        }
    }

    public void editar(Veiculo veiculo) {
        try {
            String sql = "UPDATE veiculos set modelo=?, placa=?, id_pessoa=? WHERE id=?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, veiculo.getModelo());
            stmt.setString(2, veiculo.getPlaca());
            stmt.setInt(3, veiculo.getPessoaid().getId());
            stmt.setInt(4, veiculo.getId());
            stmt.execute();

        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar veiculo: " + ex.getMessage());
        }
    }

    public void excluir(int id) {
        try {
            String sql = "delete from veiculos WHERE id=?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir veiculo: " + ex.getMessage());
        }
    }
        public List<Veiculo> getVeiculosTabela(String modelo, String placa) {
        String sql = "SELECT * FROM veiculos WHERE modelo LIKE ? AND placa LIKE ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(
                    sql,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
            );
            stmt.setString(1, "%" + modelo + "%");
            stmt.setString(2, "%" + placa + "%");
            ResultSet rs = stmt.executeQuery();
            List<Veiculo> listaVeiculos = new ArrayList();
            while (rs.next()) {
                Veiculo v = new Veiculo();
                Pessoa p = new Pessoa();
                
                v.setId(rs.getInt("id"));
                v.setModelo(rs.getString("modelo"));
                v.setPlaca(rs.getString("placa"));
                
                p.setId(rs.getInt("id_pessoa"));
                v.setPessoaid(p);
                listaVeiculos.add(v);
            }
            return listaVeiculos;
        } catch (SQLException ex) {
            System.out.println("Erro consultar todos os veiculos: " + ex.getMessage());
            return null;
        }
    }
    

}
