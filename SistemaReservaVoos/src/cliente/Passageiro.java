package cliente;

import sistema.Sistema;
import sistema.Usuario;
import sistema.Voo;

public class Passageiro extends Usuario {
	String nome, cpf;
	int idade;
	double totalAPagar=0;
	
	public Passageiro(String nome, String cpf, int idade) {
		this.nome=nome;
		this.cpf=cpf;
		this.idade=idade;
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
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}

	public void compraPassagem(int numeroVoo, String numPoltrona, String formaDePagamento) {
		try {
			Voo voo = Sistema.agenda.getVoo(numeroVoo);
			voo.compraPassagem(this, numPoltrona);	
			this.totalAPagar+=voo.getPreco(numPoltrona);
			System.out.print("Valor total: R$ " + this.totalAPagar + "\n");
		} catch(Exception e) {
			System.out.print(e.getMessage());
		}

	}
	
}
