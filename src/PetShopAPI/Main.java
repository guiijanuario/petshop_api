package PetShopAPI;

import java.util.*;


public class Main {

    //armazena cadastros de clientes
    public static List<Cliente> DB_CLIENTES = new ArrayList<>();

    public static void main(String[] args) {

        Cliente cliente0 = new Cliente(1516, "Guilherme", "101.001.305-88", "Masculino", 28, "44998662330");
        Cliente cliente1 = new Cliente(1517, "João", "100.435.564-45", "Masculino", 56, "44998983402");
        Cliente cliente2 = new Cliente(1518, "Maria", "067.453.765-87", "Feminino", 23, "44984359765");

        DB_CLIENTES.add(cliente0);
        DB_CLIENTES.add(cliente1);
        DB_CLIENTES.add(cliente2);

        Scanner scanner = new Scanner(System.in);
        System.out.print("\n\n[------------------------------------------------------]\n[ Olá seja bem vindo ao sistema de gestão de PET SHOP! ]\n[------------------------------------------------------]\n\n");

        System.out.println("Escolha uma das opções abaixo:\n");

        boolean sair = false;

        do {
            System.out.print("[------------------]\n[ 1 - Clientes     ]\n[ 2 - Serviços     ]\n[ 3 - PETs         ]\n[ 4 - Funcionários ]\n[ X - Sair         ]\n[------------------]\n");

            String opcao = scanner.nextLine().toLowerCase();

            boolean sairClientes = false;

            do {
                switch (opcao) {
                    case "1": {
                        System.out.print("\n[------ Área de Clientes ---------]\n[ 1 - Cadastrar novo cliente      ]\n[ 2 - Consultar cliente pelo nome ]\n[ 3 - Alterar dados do cliente    ]\n[ 4 - Excluir cliente             ]\n[ X - Voltar ao menu anterior     ]\n[---------------------------------]\n");
                        String entradaCliente = scanner.nextLine().toLowerCase();

                        switch (entradaCliente) {
                            case "1":
                                System.out.print("[--------------------------------]\n[ Área de Cadastrar novo cliente ]\n[--------------------------------]\n");

                                double random = Math.random();
                                int randomInt = (int) random;
                                int codigoCliente = randomInt;

                                System.out.print("\nDigite o nome do cliente: ");
                                String nomeCliente = scanner.nextLine();
                                if (nomeCliente.equalsIgnoreCase(" ")) {
                                    System.out.println("É necessário digitar um nome!");
                                }

                                System.out.print("Digite o seu cpf: Ex.(000.000.000-00) ");
                                String cpfCliente = scanner.nextLine();
                                for(Cliente cliente : DB_CLIENTES){
                                    if (cliente.getCpf().equals(cpfCliente)){
                                        System.out.print("\nEsse CPF já está cadastrado em nosso sistema. ");
                                        System.out.print("\nDigite novamente o seu cpf: Ex.(000.000.000-00) ");
                                        cpfCliente = scanner.nextLine();
                                    }
                                }
                                System.out.print("Qual o sexo do cliente: ");
                                String sexoCliente = scanner.nextLine();

                                System.out.print("Qual a idade do cliente: ");
                                int idadeCliente = scanner.nextInt();
                                if (idadeCliente >= 120) {
                                    System.out.println("Não é possível que você tenho mais de 120 anos, por favor insira a sua idade real");
                                    System.out.print("Insira a idade do cliente novamente: ");
                                    idadeCliente = scanner.nextInt();
                                }

                                System.out.print("Qual telefone do cliente: ");
                                String telefoneCliente = scanner.next();

                                Cliente cliente3 = new Cliente(codigoCliente, nomeCliente, cpfCliente, sexoCliente,
                                        idadeCliente, telefoneCliente);

                                cliente3.cadastrarCliente();

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

