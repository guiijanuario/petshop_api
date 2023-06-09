package PetShopAPI;

import java.util.*;


public class Main {

    //armazena cadastros de clientes
    public static List<Cliente> DB_CLIENTES = new ArrayList<>();

    public static void main(String[] args) {

        Cliente cliente0 = new Cliente(1516, "Jorge", "101.001.305-88", "Masculino", 28, "44998662330");
        Cliente cliente1 = new Cliente(1517, "João", "100.435.564-45", "Masculino", 56, "44998983402");
        Cliente cliente2 = new Cliente(1518, "Maria", "067.453.765-87", "Feminino", 23, "44984359765");
        Cliente cliente4 = new Cliente(1519, "Leonardo", "100.823.053-32", "Masculino", 24, "4499854366");
        Cliente cliente5 = new Cliente(1520, "Leonice", "100.435.564-45", "Feminino", 34, "44998987556");
        Cliente cliente6 = new Cliente(1521, "Marta", "100.435.564-45", "Masculino", 17, "4499898426");

        DB_CLIENTES.add(cliente0);
        DB_CLIENTES.add(cliente1);
        DB_CLIENTES.add(cliente2);
        DB_CLIENTES.add(cliente4);
        DB_CLIENTES.add(cliente5);
        DB_CLIENTES.add(cliente6);

        Scanner scanner = new Scanner(System.in);
        System.out.print("\n\n[------------------------------------------------------]\n[ Olá seja bem vindo ao sistema de gestão de PET SHOP! ]\n[------------------------------------------------------]\n\n");

        System.out.println("Escolha uma das opções abaixo:\n");

        boolean sair = false;

        do {
            System.out.print("[------------------]\n[ 1 - Clientes     ]\n[ 2 - Serviços     ]\n[ 3 - PETs         ]\n[ 4 - Funcionários ]\n[ X - Sair         ]\n[------------------]\n-> ");

            String opcao = scanner.nextLine().toLowerCase();

            boolean sairClientes = false;

            do {
                switch (opcao) {
                    case "1": {
                        System.out.print("\n\n[------ Área de Clientes ---------]\n[ 1 - Cadastrar novo cliente      ]\n[ 2 - Consultar cliente pelo nome ]\n[ 3 - Alterar dados do cliente    ]\n[ 4 - Excluir cliente             ]\n[ X - Voltar ao menu anterior     ]\n[---------------------------------]\n-> ");
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
                                System.out.print("Qual o seu gênero: ");
                                String generoCliente = scanner.nextLine();

                                System.out.print("Qual a idade do cliente: ");
                                int idadeCliente = scanner.nextInt();
                                if (idadeCliente >= 120) {
                                    System.out.println("Não é possível que você tenho mais de 120 anos, por favor insira a sua idade real");
                                    System.out.print("Insira a idade do cliente novamente: ");
                                    idadeCliente = scanner.nextInt();
                                }

                                System.out.print("Qual telefone do cliente: ");
                                String telefoneCliente = scanner.next();

                                Cliente cliente3 = new Cliente(codigoCliente, nomeCliente, cpfCliente, generoCliente,
                                        idadeCliente, telefoneCliente);

                                cliente3.cadastrarCliente();

                                break;
                            case "2":
                                System.out.print("[-------------------------------------]\n[ Área de Consultar cliente pelo nome ]\n[-------------------------------------]\n");

                                System.out.print("Digite o nome do cliente que você deseja buscar: ");
                                String buscarCliente = scanner.nextLine();
                                if(buscarCliente.length() < 3) {
                                    System.out.print("Digite um nome com pelo menos 3 caractere por favor: ");
                                    buscarCliente = scanner.nextLine();
                                }
                                for(Cliente cliente : DB_CLIENTES){
                                    if (cliente.getNome().contains(buscarCliente)){
                                        System.out.print("\nEncontrei esse cadastro em nosso sistema\n ");
                                        System.out.print(cliente +"\n");
                                    } else {
                                        System.out.println();
                                    }
                                }
                                break;
                            case "3":
                                System.out.print("[----------------------------------]\n[ Área de Alterar dados do cliente ]\n[----------------------------------]\n");
                                System.out.print("\n         Lista dos clientes:\n");
                                for (Cliente cliente : DB_CLIENTES){
                                    System.out.printf(cliente.toString(cliente.getIdCliente()));
                                }
                                System.out.print("\n\nDigite o código do cliente que você deseja editar: \nR: ");
                                int codEditCliente = scanner.nextInt();
                                for(Cliente cliente : DB_CLIENTES) {
                                    if(cliente.getIdCliente() == codEditCliente){
                                        System.out.print("\nNome: " + cliente.getNome() +
                                                "\nCPF: " + cliente.getCpf() +
                                                "\nGênero: " + cliente.getGenero() +
                                                "\nIdade: " + cliente.getIdade() +
                                                "\nTelefone: " + cliente.getTelefone() + "\n");

                                        System.out.print("\nVocê deseja editar esse cliente correto? Sim/Não\n -> ");
                                        String respUser = scanner.next();

                                        if (respUser.equalsIgnoreCase("Sim")){

                                        System.out.print("\nDigite o novo nome: \nR: ");
                                        String newNome = scanner.next();
                                        if (newNome.equalsIgnoreCase(" ")) {
                                            System.out.println("\nÉ necessário digitar um nome!");
                                        }
                                        cliente.setNome(newNome);
                                        System.out.print("\nDigite o novo cpf: Ex.(000.000.000-00) \nR: ");
                                        String newCpfCliente = scanner.next();
                                        if (DB_CLIENTES.contains(newCpfCliente)){
                                            System.out.print("\nEsse CPF já está cadastrado em nosso sistema. ");
                                            System.out.print("\nDigite novamente o seu cpf: Ex.(000.000.000-00) \nR: ");
                                            newCpfCliente = scanner.next();
                                            cliente.setCpf(newCpfCliente);
                                        } else {
                                            cliente.setCpf(newCpfCliente);
                                        }

                                        System.out.print("\nDigite o novo gênero: \nR: ");
                                        String newGenero = scanner.next();
                                        cliente.setGenero(newGenero);

                                        System.out.print("\nDigite a nova idade do cliente: \nR: ");
                                        int newIdadeCliente = scanner.nextInt();
                                        if (newIdadeCliente >= 120) {
                                            System.out.println("\nNão é possível que você tenho mais de 120 anos, por favor insira a sua idade real");
                                            System.out.print("\nInsira a idade do cliente novamente: \nR: ");
                                            newIdadeCliente = scanner.nextInt();
                                            cliente.setIdade(newIdadeCliente);
                                        } else {
                                            cliente.setIdade(newIdadeCliente);
                                        }

                                        System.out.print("\nDigite o novo telefone do cliente: \nR: ");
                                        String newTelefoneCliente = scanner.next();
                                        cliente.setTelefone(newTelefoneCliente);



                                        System.out.print("\nSegue os dados do cliente depois de alterado: \n");
                                        System.out.print("\nCódigo do cliente: " + cliente.getIdCliente() +
                                                "\nNome: " + cliente.getNome() +
                                                "\nCPF: " + cliente.getCpf() +
                                                "\nGênero: " + cliente.getGenero() +
                                                "\nIdade: " + cliente.getIdade() +
                                                "\nTelefone: " + cliente.getTelefone());

                                            System.out.print("\n[------- Cliente alterado com sucesso! --------]");
                                        }else {
                                            System.out.print("Você optou por não editar");
                                        }
                                    }
                                }

                                break;
                            case "4":
                                System.out.print("[------------------------------]\n[ Área de Excluir cliente ]\n[-------------------------------]\n");
                                System.out.print("Digite o nome do cliente que você deseja excluir: \nR: ");
                                String excluirCliente = scanner.next();
                                for(Cliente cliente : DB_CLIENTES){
                                    if (cliente.getNome().equalsIgnoreCase(excluirCliente)){
                                        System.out.print("\nEncontrei esse cadastro em nosso sistema:\n ");
                                        System.out.print(cliente +"\n\n");

                                        System.out.print("Você deseja mesmo excluir o cliente: " + cliente.getNome() + "? Digite 'Sim' para confirmar\nR: ");
                                        String respExcluir = scanner.next();
                                        if (respExcluir.equalsIgnoreCase("sim")){
                                            cliente.excluirCliente();

                                        } else {
                                            System.out.println("Ok, não vamos excluir ele.");
                                        }

                                    }
                                }
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

