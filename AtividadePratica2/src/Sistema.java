public class Sistema {
    
    public static void executar() {
        int opccao;

        do {

            menu();
            opccao = Console.lerInt();
            verificarOpcao(opccao);

        } while (opccao != 0);
    }
    
    private static void menu() {

        System.out.println("\nMENU DO SISTEMA DE FUNCIONARIOS");
        System.out.println("1) Cadastrar Funcionario.");
        System.out.println("2) Buscar Funcionario");
        System.out.println("3) Editar Funcionario");
        System.out.println("4) Excluir Funcionario");
        System.out.println("5) Listar Funcionarios");
        System.out.println("6) Resetar Banco de Dados de Funcionarios");
        System.out.println("0) Sair");
        System.out.print("Informe uma Opcao: ");
    }

    private static void verificarOpcao(int opccao) {
        int matricula;

        switch (opccao) {

            case 1:

                System.out.println("\nO QUE VAI CADASTRO:");
                System.out.println("1) Cadastrar Diretor");
                System.out.println("2) Cadastrar Coordenador");
                System.out.println("3) Cadastrar Professor");
                System.out.println("0) Voltar");
                System.out.print("Informe uma Opcao: ");
                int case1 = Console.lerInt();
                if (case1 == 0){break;}
                cadastroOpccaoCase1(case1);
                break;

            case 2:

                System.out.println("\nBUSCAR FUNCIONARIO");
                System.out.print("Informe a maticula do funcionario: ");
                matricula = Console.lerInt();

                for (Funcionario tempFunc : CadastroDeFuncionarios.getListaFuncionarios()) {
                    if (tempFunc.getMatricula() == matricula){
                        System.out.println("\nFuncionario encontrado:");
                        System.out.println(tempFunc);
                        return;
                    }
                }
                System.out.println("\nFuncionario da matricula " + matricula + " nao localizado");
                break;

            case 3:

                System.out.println("\nEDITAR FUNCIONARIO");
                System.out.print("Informe a matricula do funcionario: ");
                matricula = Console.lerInt();
        
                Funcionario funcionario = null;
                for (Funcionario tempFuncionario : CadastroDeFuncionarios.getListaFuncionarios()) {
                    if (tempFuncionario.getMatricula() == matricula) {
                        funcionario = tempFuncionario;
                        break;
                    }
                }
        
                if (funcionario == null) {
                    System.out.println("\nFuncionario da matricula " + matricula + " nao encontrado.");
                    return;
                }
        
                System.out.println("\nFuncionario encontrado:");
                System.out.println(funcionario);
        
                System.out.println("\nDigite as novas informacoes do funcionario:");
                System.out.print("Nome: ");
                String nome = Console.lerString();
                funcionario.setNome(nome);
        
                if (funcionario instanceof Professor) {
                    System.out.print("Disciplina: ");
                    String disciplina = Console.lerString();
                    ((Professor) funcionario).setDisciplina(disciplina);
                } else if (funcionario instanceof Coordenador) {
                    System.out.print("Curso: ");
                    String curso = Console.lerString();
                    ((Coordenador) funcionario).setCurso(curso);
                } else if (funcionario instanceof Diretor) {
                    System.out.print("Instituto: ");
                    String instituto = Console.lerString();
                    ((Diretor) funcionario).setInstituto(instituto);
                }
        
                System.out.println("\nFuncionario editado com sucesso!");            
                break;

            case 4:

                System.out.println("\nEXCLUIR FUNCIONARIO");
                System.out.print("Informe a maticula do funcionario: ");
                matricula = Console.lerInt();

                if (CadastroDeFuncionarios.excluir(matricula)){
                    System.out.println("\nFuncionario foi excluido com sucesso!");
                } else {
                    System.out.println("\nFuncionario " + matricula + " nao localizado no cadastro");
                }
                break;

            case 5:

                System.out.println("\nLISTAR FUNCIONARIOS:");
                System.out.println("1) Listar todos os funcionarios");
                System.out.println("2) Listar Diretores");
                System.out.println("3) Listar Coordenadores");
                System.out.println("4) Listar Professores");
                System.out.println("0) Voltar");
                System.out.print("Informe uma Opcao: ");
                int case5 = Console.lerInt();
                if (case5 == 0){break;}
                listarOpccaoCase5(case5);
                break;

            case 6:

                CadastroDeFuncionarios.resetarLista();
                break;

            case 0:

                System.out.println("\nO Sistema foi finalizado...");
                break;

            default:

                System.out.println("\nOpcao invalida. Digite novamente.");
                break;
        }

        System.out.println();
    }

    private static void cadastroOpccaoCase1(int case1) {
        String nome;
        int matricula;

        switch (case1) {

            case 1:

                System.out.println("\nCADASTRANDO DIRETOR:");
                System.out.print("Nome: ");
                nome = Console.lerString();
                System.out.print("Matricula: ");
                matricula = Console.lerInt();
                System.out.print("Diretor do Instituto: ");
                String instituto = Console.lerString();

                Diretor diretor = new Diretor(nome, matricula, instituto);
                CadastroDeFuncionarios.cadastrar(diretor);

                System.out.println("\nDiretor cadastrado com sucesso!");
                break;

            case 2:

                System.out.println("\nCADASTRANDO COORDENADOR:");
                System.out.print("Nome: ");
                nome = Console.lerString();
                System.out.print("Matricula: ");
                matricula = Console.lerInt();
                System.out.print("Coordenador do Curso: ");
                String curso = Console.lerString();

                Coordenador coordenador = new Coordenador(nome, matricula, curso);
                CadastroDeFuncionarios.cadastrar(coordenador);

                System.out.println("\nCoordenador cadastrado com sucesso!");
                break;

            case 3:

                System.out.println("\nCADASTRANDO PROFESSOR:");
                System.out.print("Nome: ");
                nome = Console.lerString();
                System.out.print("Matrícula: ");
                matricula = Console.lerInt();
                System.out.print("Disciplina ministrada: ");
                String disciplina = Console.lerString();

                Professor professor = new Professor(nome, matricula, disciplina);
                CadastroDeFuncionarios.cadastrar(professor);

                System.out.println("\nProfessor cadastrado com sucesso!");
                break;

            default:

                System.out.println("\nOpcao invalida. Digite novamente.");
                break;
        }
    }

    private static void listarOpccaoCase5(int case5){

        switch (case5) {
            case 1:

                if (CadastroDeFuncionarios.getListaFuncionarios().size() == 0) {
                    System.out.println("\nNao ha funcionarios cadastrados...");
                    break;
                }
            
                System.out.println("\nTODOS FUNCIONARIOS CADASTRADOS:");
                for (Funcionario tempFuncionario : CadastroDeFuncionarios.getListaFuncionarios()) {
                    System.out.println(tempFuncionario);
                }
                break;

            case 2:

                if (CadastroDeFuncionarios.getDiretores().size() == 0) {
                    System.out.println("\nNao ha Diretores cadastrados...");
                    break;
                }

                System.out.println("\nDIRETORES CADASTRADOS:");
                for (Funcionario tempDir : CadastroDeFuncionarios.getDiretores()) {
                    System.out.println(tempDir);
                }
                break;

            case 3:

                if (CadastroDeFuncionarios.getCoordenadores().size() == 0) {
                    System.out.println("\nNao ha Coordenadores cadastrados...");
                    break;
                }

                System.out.println("\nCOORDENADORES CADASTRADOS:");
                for (Funcionario tempCoord : CadastroDeFuncionarios.getCoordenadores()) {
                    System.out.println(tempCoord);
                }              
                break;

            case 4:

                if (CadastroDeFuncionarios.getProfessores().size() == 0) {
                    System.out.println("\nNao ha Professores cadastrados...");
                    break;
                }

                System.out.println("\nPROFESSORES CADASTRADOS:");
                for (Funcionario tempProf : CadastroDeFuncionarios.getProfessores()) {
                    System.out.println(tempProf);
                }break;
        
            default:
            
                System.out.println("\nOpcao invalida. Digite novamente.");
                break;
        }
    }
}
