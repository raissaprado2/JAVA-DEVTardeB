package view;

import javax.swing.*;
import java.awt.*;

public class ElevadorView extends JFrame {
    private JButton[] botoesChamar;
    private JButton[] botoesAndar;
    private JButton btnSelecionarElevador1;
    private JButton btnSelecionarElevador2;
    private JTextArea display;

    public ElevadorView() {
        // ... (Código para inicializar a interface gráfica)
    }

    public JTextArea getDisplay() {
        return display;
    }

    public JButton[] getBotoesAndar() {
        return botoesAndar;
    }

    public JButton[] getBotoesChamar() {
        return botoesChamar;
    }


    public JButton getBtnSelecionarElevador1() {
        return btnSelecionarElevador1;
    }

    public JButton getBtnSelecionarElevador2() {
        return btnSelecionarElevador2;
    }
}

