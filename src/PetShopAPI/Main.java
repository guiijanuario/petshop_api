package PetShopAPI;

import java.util.*;


public class Main {

    //armazena cadastros de clientes
    public static List<Cliente> DB_CLIENTES = new ArrayList<>();

    public static void main(String[] args) {

        Cliente cliente0 = new Cliente(1516, "Guilherme", "101.001.305-88", "Masculino", 28, "44998662330");
        Cliente cliente1 = new Cliente(1517, "João", "100.435.564-45", "Masculino", 56, "44998983402");
        Cliente cliente2 = new Cliente(1518, "Maria", "067.453.765-87", "Feminino", 23, "44984359765");

        Scanner scanner = new Scanner(System.in);
        System.out.println("[------------------------------------------------------]");
        System.out.println("[ Olá seja bem vindo ao sistema de gestão de PET SHOP! ]");
        System.out.println("[------------------------------------------------------]");

        System.out.println("Escolha uma das opções abaixo:");

        boolean sair = false;

        do {

            System.out.println("[------------------]");
            System.out.println("[ 1 - Clientes     ]");
            System.out.println("[ 2 - Serviços     ]");
            System.out.println("[ 3 - PETs         ]");
            System.out.println("[ 4 - Funcionários ]");
            System.out.println("[ X - Sair         ]");
            System.out.println("[------------------]");

            String opcao = scanner.nextLine().toLowerCase();

            boolean sairClientes = false;

            do {
                switch (opcao) {
                    case "1": {
                        System.out.println("[---------------------------------]");
                        System.out.println("[ 1 - Cadastrar novo cliente      ]");
                        System.out.println("[ 2 - Consultar cliente pelo nome ]");
                        System.out.println("[ 3 - Alterar dados do cliente    ]");
                        System.out.println("[ 4 - Excluir cliente             ]");
                        System.out.println("[ X - Voltar ao menu anterior     ]");
                        System.out.println("[---------------------------------]");
                        String entradaCliente = scanner.nextLine().toLowerCase();


                        switch (entradaCliente) {
                            case "1":

                                System.out.println("[--------------------------------]");
                                System.out.println("[ Área de Cadastrar novo cliente ]");
                                System.out.println("[--------------------------------]");

                                double random = Math.random();
                                int randomInt = (int) random;
                                int codigoCliente = randomInt;

                                System.out.print("Digite o nome do cliente: ");
                                String nomeCliente = scanner.nextLine();
                                if (nomeCliente.equalsIgnoreCase(" ")) {
                                    System.out.println("É necessário digitar um nome!");
                                }

                                System.out.print("Digite o seu cpf: Ex.(000.000.000-00) ");
                                String cpfCliente = scanner.nextLine();

                                System.out.print("Qual o sexo do cliente: ");
                                String sexoCliente = scanner.nextLine();

                                System.out.print("Qual a idade do cliente: ");
                                int idadeCliente = scanner.nextInt();
                                if (idadeCliente >= 120) {
                                    System.out.println("Não é possível que você tenho mais de 120 anos, por favor insira a sua idade eral");
                                }

                                System.out.print("Qual telefone do cliente: ");
                                String telefoneCliente = scanner.nextLine();

                                Cliente cliente3 = new Cliente(codigoCliente, nomeCliente, cpfCliente, sexoCliente,
                                        idadeCliente, telefoneCliente);

                                cliente3.cadastrarCliente();

                                System.out.printf(DB_CLIENTES.toString());

                                break;
                            case "2":
                                System.out.println("Área de Consultar cliente pelo nome");
                                break;
                            case "3":
                                System.out.println("Área de Alterar dados do cliente");
                                break;
                            case "4":
                                System.out.println("Área de Excluir cliente");
                                break;
                            case "x":
                                sairClientes = true;
                                break;
                            default:
                                System.out.println("Opção inválida!");
                                break;

                        }
                    }
                    break;
                    case "2":
                        System.out.println("Área de Serviços");
                        break;
                    case "3":
                        System.out.println("Área de PETs");
                        break;
                    case "4":
                        System.out.println("Área de Funcionários");
                        break;
                    case "x":
                        sair = true;
                        sairClientes = true;
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
            } while (!sairClientes);
        } while (!sair);
    }
}

