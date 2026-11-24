public class LigarLampadaComando implements Comando {

    private Lampada lampada;
    private boolean estadoAnterior;

    public LigarLampadaComando(Lampada lampada) {
        this.lampada = lampada;
    }

    public void executar() {
        estadoAnterior = lampada.isLigada();
        lampada.ligar();
    }

    public void cancelar() {
        if (estadoAnterior) {
            lampada.ligar();
        } else {
            lampada.desligar();
        }
    }
}