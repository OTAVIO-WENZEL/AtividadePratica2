import java.util.ArrayList;
import java.util.List;

public class CadastroDeFuncionarios {
    
    private static List<Funcionario> listaFuncionarios = new ArrayList<>();

    public static void cadastrar (Funcionario var) {
        listaFuncionarios.add(var);
    }

    public static List<Funcionario> getListaFuncionarios() {
        return listaFuncionarios;
    }

    public static boolean excluir(int matricula) {

        for (Funcionario tempFuncionario : listaFuncionarios){
            if (tempFuncionario.getMatricula() == matricula) {
                listaFuncionarios.remove(tempFuncionario);
                return true;
            }
        }

        return false;

    }

    public static void resetarLista(){
        listaFuncionarios.clear();

        System.out.println("\nBanco de Dados Resetado com Sucesso!");
    }

    //Optei por manter a funccao de listar as profissoes aqui
    //para não deixar a Classe Sistema muito extensa visualmente.
    
    public static List<Funcionario> getDiretores() {
        List<Funcionario> tempListDir = new ArrayList<>();

        for(Funcionario tempDir: listaFuncionarios) {
            if (tempDir instanceof Diretor) {
                tempListDir.add(tempDir);
            }
        }
        return tempListDir;       
    }

    public static List<Funcionario> getCoordenadores() {
        List<Funcionario> tempListCoord = new ArrayList<>();

        for(Funcionario tempCoord: listaFuncionarios) {
            if (tempCoord instanceof Coordenador) {
                tempListCoord.add(tempCoord);
            }
        }

        return tempListCoord;
    }

    public static List<Funcionario> getProfessores() {
        List<Funcionario> tempListProf = new ArrayList<>();

        for(Funcionario tempProf: listaFuncionarios) {
            if (tempProf instanceof Professor) {
                tempListProf.add(tempProf);
            }
        }

        return tempListProf;
    }
}
