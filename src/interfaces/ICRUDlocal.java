package interfaces;

import entidades.Local;
import java.util.List;

public interface ICRUDlocal {
    Local inserir(Local lc);
    Local alterar(Local lc);
    void deletar(int id);
    Local consultar(int id);
    List<Local> consultar();
}
