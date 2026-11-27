
package interfaces;

import entidades.Compromisso;
import java.util.List;

public interface ICRUDcompromisso {

    Compromisso inserir(Compromisso c);

    Compromisso alterar(Compromisso c);

    void deletar(int id);

    Compromisso consultar(int id);

    List<Compromisso> consultar();
}
