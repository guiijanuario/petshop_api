package PetShopAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cliente {

    private int idCliente;
    private String nome;
    private String cpf;
    private String genero;
    private int idade;
    private String telefone;


    public Cliente(int idCliente, String nome,String cpf, String genero, int idade, String telefone) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.cpf = cpf;
        this.genero = genero;
        this.idade = idade;
        this.telefone = telefone;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Cliente cadastrarCliente(){
        List<Cliente> listaClientes = Main.DB_CLIENTES;

        System.out.println("Cliente cadastrado com sucesso!");
        listaClientes.add(this);

        // Imprimir os elementos da lista
        for (Cliente cliente : listaClientes) {
            System.out.println(cliente);
        }
        return this;
    }

    public Cliente excluirCliente() {
        List<Cliente> listaClientes = Main.DB_CLIENTES;
        List<Cliente> newDB_CLIENTES = new ArrayList<>();

        for (Cliente cliente : listaClientes) {
            if (!cliente.equals(this)) {
                newDB_CLIENTES.add(cliente);
            }
        }
        Main.DB_CLIENTES = newDB_CLIENTES; // Substitui a lista original pela nova lista

        // Imprimir os elementos restantes da lista
        for (Cliente cliente : newDB_CLIENTES) {
            System.out.println(cliente);
        }

        System.out.println("\n[-------------------------------]\n  Cliente excluído com sucesso!\n[-------------------------------]");


        return this;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(cpf, cliente.cpf);
    }



    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }

    @Override
    public String toString() {
        return "\nCódigo do cliente: " + idCliente +
                "\nNome: " + nome +
                "\nCPF: " + cpf +
                "\nGênero: " + genero +
                "\nIdade: " + idade +
                "\nTelefone: " + telefone;
    }


    public String toString(int idCliente) {
        return "\nCódigo do cliente: " + idCliente + " - Nome: " + nome;
    }
}
