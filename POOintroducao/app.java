package POOintroducao;

public class app {
    public static void main(String[] args) {
        RegistroAluno aluno1 = new RegistroAluno();//crie um obj
        RegistroAluno aluno2 = new RegistroAluno();

        //setando os atributos(SET)
        aluno1.setNome("Ana Carla Pereira");
        System.out.println("Nome:"+aluno1.getNome());

        //mostrando os atributos com o GET
        System.out.println("Nome:"+aluno1.getNome());

    }
    
}