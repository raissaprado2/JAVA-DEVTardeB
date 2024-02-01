import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Classe principal que representa a janela do sistema de elevadores
public class elevador extends JFrame {
    private JButton[] botoesChamar;
    private JButton[] botoesAndar;
    private JTextArea display;
    private ElevadorPanel[] elevadores;

    private int[] posicaoElevadores;
    private int[] direcaoElevadores;
    private int elevadorSelecionado;

    // Construtor da classe Elevador
    public elevador() {
        super("Sistema de Elevadores");

        // Inicialização de variáveis
        botoesChamar = new JButton[2];
        botoesAndar = new JButton[6];
        display = new JTextArea();
        elevadores = new ElevadorPanel[2];
        posicaoElevadores = new int[] { 0, 0 };
        direcaoElevadores = new int[] { 0, 0 };
        elevadorSelecionado = 0;

        // Configurando a interface gráfica
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));


        // Painel para os botões de chamada e andares
        JPanel botoesPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        for (int i = 0; i < 6; i++) {
            final int andar = i;
            botoesAndar[i] = new JButton(String.valueOf(i));
            botoesAndar[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int andarSolicitado = Integer.parseInt(((JButton) e.getSource()).getText());
                    moverElevador(elevadorSelecionado, andarSolicitado);
                }
            });
            botoesPanel.add(botoesAndar[i]);

            botoesChamar[i % 2] = new JButton("Chamar");
            botoesChamar[i % 2].setBackground(Color.RED);
            botoesChamar[i % 2].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int elevadorMaisProximo = obterElevadorMaisProximo(andar);
                    moverElevador(elevadorMaisProximo, andar);
                }
            });
            botoesPanel.add(botoesChamar[i % 2]);
        }

        // Painel para exibir os elevadores e o display
        JPanel elevadoresPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        for (int i = 0; i < 2; i++) {
            elevadores[i] = new ElevadorPanel(i + 1);
            elevadoresPanel.add(elevadores[i]);
        }

        display.setFont(new Font("Monospaced", Font.PLAIN, 12));
        display.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(display);

        // Adicionando os painéis à janela
        panel.add(botoesPanel, BorderLayout.WEST);
        panel.add(elevadoresPanel, BorderLayout.CENTER);
        panel.add(scrollPane, BorderLayout.SOUTH);

        add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);
        setVisible(true);
    }

    // Método para obter o elevador mais próximo de um determinado andar
    private int obterElevadorMaisProximo(int andar) {
        int elevadorMaisProximo = 0;
        int distanciaMinima = Math.abs(posicaoElevadores[0] - andar);
        for (int i = 1; i < posicaoElevadores.length; i++) {
            int distancia = Math.abs(posicaoElevadores[i] - andar);
            if (distancia < distanciaMinima) {
                distanciaMinima = distancia;
                elevadorMaisProximo = i;
            }
        }
        return elevadorMaisProximo;
    }

    // Método para mover o elevador para um determinado andar
private void moverElevador(final int indiceElevador, final int andar) {
    new Thread(new Runnable() {
        @Override
        public void run() {
            int andarAtual = posicaoElevadores[indiceElevador];
            int andarDestino = andar;
            direcaoElevadores[indiceElevador] = andarAtual < andarDestino ? 1 : -1;

            display.append("Elevador " + (indiceElevador + 1) + " está se movendo...\n");
            while (andarAtual != andarDestino) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                andarAtual += direcaoElevadores[indiceElevador];
                posicaoElevadores[indiceElevador] = andarAtual;

                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        elevadores[indiceElevador].setAndarAtual(andarAtual);
                        display.append("Elevador " + (indiceElevador + 1) +
                                " está no " + (andarAtual >= 0 ? "andar " + andarAtual : "subsolo") + "\n");
                    }
                });
            }

            display.append("Bem-vindo! Por favor, entre no Elevador " + (indiceElevador + 1) + "\n");
            JOptionPane.showMessageDialog(null, "Elevador " + (indiceElevador + 1) +
                    " chegou ao " + (andarAtual >= 0 ? "andar " + andarAtual : "subsolo"));
        }
    }).start();
}

    // Método principal para iniciar o programa
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new elevador();
            }
        });
    }
}

// Classe que representa o painel visual de um elevador
class ElevadorPanel extends JPanel {
    private int andarAtual;
    private int numeroElevador;

    // Construtor da classe ElevadorPanel
    public ElevadorPanel(int numeroElevador) {
        this.numeroElevador = numeroElevador;
        setPreferredSize(new Dimension(150, 300));
        setBackground(Color.LIGHT_GRAY);
    }

    // Método para atualizar o andar atual do elevador
    public void setAndarAtual(int andarAtual) {
        this.andarAtual = andarAtual;
        repaint();
    }

    // Método para desenhar o painel do elevador
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillRect(30, 50, 90, 200);
        g.setColor(Color.BLACK);
        g.drawRect(30, 50, 90, 200);
        g.drawString("Elevador " + numeroElevador, 40, 30);
        g.drawString("Andar: " + andarAtual, 40, 270);
    }
}
