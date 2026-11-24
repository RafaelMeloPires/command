import java.util.ArrayList;
import java.util.List;

public class ControleRemoto {

    private List<Comando> comandos = new ArrayList<>();

    public void executarComando(Comando comando) {
        comando.executar();
        comandos.add(comando);
    }

    public void cancelarUltimoComando() {
        if (comandos.isEmpty()) {
            throw new IllegalArgumentException("Nenhum comando executado");
        }

        Comando comando = comandos.get(comandos.size() - 1);
        comando.cancelar();
        comandos.remove(comandos.size() - 1);
    }
}