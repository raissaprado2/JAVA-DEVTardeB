package com.example;

public class Curso {
    private String nomeCurso;
    private List<Aluno> aluno;
    private Professor professor;

    public Curso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
        alunos = new ArrayList<>();
    }

    // adicionar professor no curso
    public void addProf(Professor professor){
        this.professor = professor;
    }

    //Adicionar Alunos
    public void addAluno(Aluno aluno){
        alunos.add(aluno);
    }

    //lanlar notas
    public void lancarNotas(String nomeAluno, double notaAluno){
        
    }
}
