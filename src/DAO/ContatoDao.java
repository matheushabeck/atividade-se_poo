/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import entidades.Contato;
import interfaces.ICRUDcontato;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import utils.ConectaDB;

public class ContatoDao implements ICRUDcontato{

    @Override
    public Contato inserir(Contato ct) {        
        try {
            String sql =  "insert into tb_contatos(nome, email, celular)values(?,?,?)";
            PreparedStatement stm = ConectaDB.getConexao().prepareStatement(sql);
            stm.setString(1, ct.getNome());
            stm.setString(2, ct.getEmail());
            stm.setString(3, ct.getCelular());
            stm.execute();
            return ct;
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        }        
    }

    @Override
    public Contato alterar(Contato ct) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deletar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Contato consultar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Contato> consultar() {
       List<Contato> contatos = new ArrayList<>();
        try{ 
            String sql = "select * from tb_contatos";
            PreparedStatement stm = ConectaDB.getConexao().prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Contato ct = new Contato();
                ct.setId(rs.getInt("id"));
                ct.setNome(rs.getString("nome"));
                ct.setEmail(rs.getString("email"));
                ct.setCelular(rs.getString("celular"));
                
                contatos.add(ct);
            }
       } catch (SQLException ex){
           throw new RuntimeException(ex.getMessage());
       }
        return contatos;
    }
    //inserir
    //alterar
    //deletar
    //consultar
    //consultarById
}
