package PetShopAPI;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private int idCliente;
    private String nome;
    private String cpf;
    private String sexo;
    private int idade;
    private String telefone;


    public Cliente(int idCliente, String nome,String cpf, String sexo, int idade, String telefone) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.cpf = cpf;
        this.sexo = sexo;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
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
        if(this.idade >= 120 || this.nome.equalsIgnoreCase(" ")){
            System.out.printf("Por favor sua idade não pode ser maior que 120 anos ou seu nome não pode ser ");
        }

        listaClientes.add(this);

        System.out.println("Cliente cadastrado com sucesso!");
      /*  // Imprimir os elementos da lista
        for (Cliente cliente : listaClientes) {
            System.out.println(cliente);
        }*/
        return this;
    }

}
