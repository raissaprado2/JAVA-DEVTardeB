import javax.swing.JOptionPane;

public class ExemploTryCatchFinally {
    public static void main (String[]args){
        String frase = null;
        String fraseUpper = null;
        frase = JOptionPane.showMessageDialog("Digite uma frase");
        try{
            fraseUpper = frase.toUpperCase();
        }catch(NullPointerException erro){
            JOptionPane.showMessageDialog(null, "Erro - string vazia");
            frase = "A frase estava vazia";
        }finally{
            fraseUpper = frase.toUpperCase();
            JOptionPane.showMessageDialog(null, fraseUpper);
        }
        
    }
}
