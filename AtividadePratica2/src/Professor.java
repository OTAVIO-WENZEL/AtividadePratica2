public class Professor extends Funcionario {

    private String disciplina;

    public Professor (String nome, int matricula, String disciplina) {
        super(nome, matricula);
        this.disciplina = disciplina;
    }

    public String getDisciplina() {
        return disciplina;
    }
    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }
    
    @Override
    public String toString() {
        return super.toString() +
        "\nDisciplina: " + disciplina;
    }
}
