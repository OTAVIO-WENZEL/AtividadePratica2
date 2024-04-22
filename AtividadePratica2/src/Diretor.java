public class Diretor extends Funcionario {

    private String instituto;

    public Diretor (String nome, int matricula, String instituto) {
        super(nome, matricula);
        this.instituto = instituto;
    }
    
    public String getInstituto() {
        return instituto;
    }
    public void setInstituto(String instituto) {
        this.instituto = instituto;
    }

    @Override
    public String toString() {
        return super.toString() +
        "\nInstituto: " + instituto;
    }
}
