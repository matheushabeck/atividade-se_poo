
package DAO;

import entidades.Compromisso;
import interfaces.ICRUDcompromisso;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import utils.ConectaDB;

public class CompromissoDao implements ICRUDcompromisso {

    @Override
    public Compromisso inserir(Compromisso c) {
        try {
            String sql = "INSERT INTO tb_compromissos (id_contato, id_local, data, hora, observacao) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement stm = ConectaDB.getConexao().prepareStatement(sql);

            stm.setInt(1, c.getIdContato());
            stm.setInt(2, c.getIdLocal());
            stm.setString(3, c.getData());
            stm.setString(4, c.getHora());
            stm.setString(5, c.getObservacao());

            stm.executeUpdate();

            return c;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        }
    }

    @Override
    public Compromisso alterar(Compromisso c) {
        throw new UnsupportedOperationException("Não implementado.");
    }

    @Override
    public void deletar(int id) {
        throw new UnsupportedOperationException("Não implementado.");
    }

    @Override
    public Compromisso consultar(int id) {
        throw new UnsupportedOperationException("Não implementado.");
    }

    @Override
    public List<Compromisso> consultar() {
        throw new UnsupportedOperationException("Não implementado.");
    }
}
