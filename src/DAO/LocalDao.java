
package DAO;

import entidades.Local;
import interfaces.ICRUDlocal;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.List;
import javax.swing.JOptionPane;
import utils.ConectaDB;

public class LocalDao implements ICRUDlocal {

    @Override
    public Local inserir(Local lc) {
        try {
            String sql = "insert into tb_locais(nome_local, endereco, nome_responsavel, celular_responsavel, email_responsavel)values(?,?,?,?,?)";

            PreparedStatement stm = ConectaDB.getConexao().prepareStatement(sql);

            stm.setString(1, lc.getNomeLocal());
            stm.setString(2, lc.getEndereco());
            stm.setString(3, lc.getNomeResponsavel());
            stm.setString(4, lc.getCelularResponsavel());
            stm.setString(5, lc.getEmailResponsavel());

            stm.execute();
            return lc;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        }
    }

    @Override
    public Local alterar(Local lc) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deletar(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Local consultar(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Local> consultar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
