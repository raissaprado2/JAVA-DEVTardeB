import javax.swing.JOptionPane;

public class ExemploThrow {
    /**
     * InnerExemploThrow
     */
    public class InnerExemploThrow {
    public static void main(String[] args) {
        //
        JOptionPane.showMessageDialog(null, "Welcome to SENAI");
        String login = JOptionPane.showInputDialog("Informe o seu login");
        String senha = JOptionPane.showInputDialog("Informe sua senha de 6 digitos");
        if (senha.length() !=6){
            throw new Exception("Senha deve ter 6 digitos");
        }
    } try {
        
    } catch (Exception e) {
        // TODO: handle exception
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
        
    }
}
