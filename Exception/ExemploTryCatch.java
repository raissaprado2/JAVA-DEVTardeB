package Exception;

import javax.swing.JOptionPane;
public class ExemploTryCatch {
    public static void main(String[] args) {
        // tratando as exceptions
        boolean calcular = true;
        int n1=0, n2=0;
        while (calcular) {
            try {
                // recebendo os dados
                boolean n1ok = true;
                while (n1ok) {
                    try {
                        n1 = Integer.parseInt(JOptionPane.showInputDialog("Digite um Nº inteiro"));
                        n1ok = false;
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Erro - valor digitado n~ é inteiro");
                    }

                }
                boolean n2ok = true;
                while (n2ok) {
                    try {
                        n2 = Integer.parseInt(JOptionPane.showInputDialog("Digite outro Nº inteiro"));
                        n2ok = false;
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Erro - valor digitado n~ é inteiro");
                    }
                }
                // mostrando o resultado
                JOptionPane.showMessageDialog(null, "O Resultado é "
                        + (n1 + n2));
                calcular = false;
            } catch (Exception erro1) {
                JOptionPane.showMessageDialog(null, "Erro - valor digitadno não é inteiro6");
            }
        }
    }
}
