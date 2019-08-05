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

	public String compraPassagem(int numeroVoo, String numPoltrona, String formaDePagamento) {
		String s;
		try {
			Voo voo = Sistema.agenda.getVoo(numeroVoo);
			voo.compraPassagem(this, numPoltrona);	
			this.totalAPagar+=voo.getPreco(numPoltrona);
		} catch(Exception e) {
			System.out.print(e.getMessage());
		}
		return s = ("Valor total: R$ " + this.totalAPagar + "\n");
	}
	
}