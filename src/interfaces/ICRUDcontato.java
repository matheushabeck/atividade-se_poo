/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.Contato;
import java.util.List;

public interface ICRUDcontato {
    Contato inserir(Contato ct);
    Contato alterar(Contato ct);
    void deletar(int id);
    Contato consultar(int id);
    List<Contato> consultar();
}
