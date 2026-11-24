public class DesligarLampadaComando implements Comando {

    private Lampada lampada;
    private boolean estadoAnterior;

    public DesligarLampadaComando(Lampada lampada) {
        this.lampada = lampada;
    }

    public void executar() {
        estadoAnterior = lampada.isLigada();
        lampada.desligar();
    }

    public void cancelar() {
        if (estadoAnterior) {
            lampada.ligar();
        } else {
            lampada.desligar();
        }
    }
}
