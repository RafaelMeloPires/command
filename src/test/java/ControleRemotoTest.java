import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControleRemotoTest {

    @Test
    void deveLigarLampada() {
        Lampada lampada = new Lampada();
        ControleRemoto controle = new ControleRemoto();

        controle.executarComando(
                new LigarLampadaComando(lampada));

        assertTrue(lampada.isLigada());
    }

    @Test
    void deveDesligarLampada() {
        Lampada lampada = new Lampada();
        lampada.ligar();

        ControleRemoto controle = new ControleRemoto();

        controle.executarComando(
                new DesligarLampadaComando(lampada));

        assertFalse(lampada.isLigada());
    }

    @Test
    void deveCancelarComandoLigar() {
        Lampada lampada = new Lampada();
        ControleRemoto controle = new ControleRemoto();

        controle.executarComando(
                new LigarLampadaComando(lampada));

        controle.cancelarUltimoComando();

        assertFalse(lampada.isLigada());
    }

    @Test
    void deveCancelarComandoDesligar() {
        Lampada lampada = new Lampada();
        lampada.ligar();

        ControleRemoto controle = new ControleRemoto();

        controle.executarComando(
                new DesligarLampadaComando(lampada));

        controle.cancelarUltimoComando();

        assertTrue(lampada.isLigada());
    }

    @Test
    void deveManterLampadaLigadaAoCancelar() {
        Lampada lampada = new Lampada();
        lampada.ligar();

        ControleRemoto controle = new ControleRemoto();

        controle.executarComando(
                new LigarLampadaComando(lampada));

        controle.cancelarUltimoComando();

        assertTrue(lampada.isLigada());
    }

    @Test
    void deveManterLampadaDesligadaAoCancelar() {
        Lampada lampada = new Lampada();
        ControleRemoto controle = new ControleRemoto();

        controle.executarComando(
                new DesligarLampadaComando(lampada));

        controle.cancelarUltimoComando();

        assertFalse(lampada.isLigada());
    }

    @Test
    void deveRetornarExcecaoSemComandos() {
        try {
            ControleRemoto controle = new ControleRemoto();
            controle.cancelarUltimoComando();

            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Nenhum comando executado",
                    e.getMessage());
        }
    }
}