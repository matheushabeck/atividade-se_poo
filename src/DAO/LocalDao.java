
package DAO;

import entidades.Local;
import interfaces.ICRUDlocal;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import utils.ConectaDB;

public class LocalDao implements ICRUDlocal {

    @Override
    public Local inserir(Local lc) {
        try {
            String sql = "insert into tb_locais(nome_local, endereco, nome_responsavel, celular_responsavel, email_responsavel) values(?,?,?,?,?)";

            PreparedStatement stm = ConectaDB.getConexao().prepareStatement(sql);

            stm.setString(1, lc.getNomeLocal());
            stm.setString(2, lc.getEndereco());
            stm.setString(3, lc.getNomeResponsavel());
            stm.setString(4, lc.getCelularResponsavel());
            stm.setString(5, lc.getEmailResponsavel());

            stm.executeUpdate();
            return lc;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        }
    }

    @Override
    public Local alterar(Local lc) {
        try {
            String sql = "update tb_locais set nome_local = ?, endereco = ?, nome_responsavel = ?, celular_responsavel = ?, email_responsavel = ? where id = ?";

            PreparedStatement stm = ConectaDB.getConexao().prepareStatement(sql);

            stm.setString(1, lc.getNomeLocal());
            stm.setString(2, lc.getEndereco());
            stm.setString(3, lc.getNomeResponsavel());
            stm.setString(4, lc.getCelularResponsavel());
            stm.setString(5, lc.getEmailResponsavel());
            stm.setInt(6, lc.getId());

            stm.executeUpdate();
            return lc;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        }
    }

    @Override
    public void deletar(int id) {
        try {
            String sql = "delete from tb_locais where id = ?";

            PreparedStatement stm = ConectaDB.getConexao().prepareStatement(sql);
            stm.setInt(1, id);
            stm.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    @Override
    public Local consultar(int id) {
        Local lc = null;

        try {
            String sql = "select * from tb_locais where id = ?";
            PreparedStatement stm = ConectaDB.getConexao().prepareStatement(sql);
            stm.setInt(1, id);

            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                lc = new Local();

                lc.setId(rs.getInt("id"));
                lc.setNomeLocal(rs.getString("nome_local"));
                lc.setEndereco(rs.getString("endereco"));
                lc.setNomeResponsavel(rs.getString("nome_responsavel"));
                lc.setCelularResponsavel(rs.getString("celular_responsavel"));
                lc.setEmailResponsavel(rs.getString("email_responsavel"));
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }

        return lc;
    }

    @Override
    public List<Local> consultar() {
        List<Local> locais = new ArrayList<>();

        try {
            String sql = "select * from tb_locais";
            PreparedStatement stm = ConectaDB.getConexao().prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Local lc = new Local();

                lc.setId(rs.getInt("id"));
                lc.setNomeLocal(rs.getString("nome_local"));
                lc.setEndereco(rs.getString("endereco"));
                lc.setNomeResponsavel(rs.getString("nome_responsavel"));
                lc.setCelularResponsavel(rs.getString("celular_responsavel"));
                lc.setEmailResponsavel(rs.getString("email_responsavel"));

                locais.add(lc);
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }

        return locais;
    }
}
