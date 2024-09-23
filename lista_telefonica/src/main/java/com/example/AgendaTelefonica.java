package com.example;

public class AgendaTelefonica {
    //atributos
    private Contato[] contatos;
    private int contador;

    //construtor
    public AgendaTelefonica(int maxContato) {
        contatos = new Contato[maxContato];
        contador = 0;
    }
    //métodos
    //add
    public void addContato(Contato contato) throws AgendaCheiaException {
        if (contador>=contatos.length) {
            throw new AgendaCheiaException("Agenda Cheia");
        }try {
            contatos[contador] = contato;
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    //listar
    public void listarContatos(){
        if (contador==0)        {
            System.out.println("Agenda Vazia");
        }else{
            for (int i=0; i<contador; i++){
                System.out.println(contatos[i].toString());
            }
        }
    }
    //buscar
    public Contato buscarContato(String nome)throws ContatoNaoEncontradoException {
        for (int i=0; i<contador; i++){
            if (contatos[i].getNome().equalsIgnoreCase(nome)) {
                return contatos[i];
            }
        }
        throw new ContatoNaoEncontradoException("Contato não encontrado");
    }
    //remover
    public void removerConta(String nome)  {
        boolean encontrado = false;
        for (int i = 0; i < contador; i ++) {
            if (contatos[i].getNome().equalsIgnoreCase(nome)) {
                encontrado=true;
                contatos[i]=contatos[contador-1];
                contatos[contador-1]= null;
                contador--;
                System.out.println("Contato Removido com sucesso");
            }
        }
        if (!encontrado) {
            throw new ContatoNaoEncontradoException(
            "Contato não encontrado");
        }
    }


}
