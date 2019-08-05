package funcionario;


import aeronaves.Aeronave;
import cliente.Passageiro;
import sistema.Sistema;
import sistema.Usuario;
import sistema.Voo;


public class Atendente extends Usuario {
	Passageiro[] usuarios = new Passageiro[10000];
	int numUsuarios=0;

	public void cancelaVoo(int numeroVoo) {
		Sistema.agenda.cancelaVoo(numeroVoo);
	}

	public void cadastraVoo(Aeronave aeronave, int numeroVoo, String horarioIda, String horarioChegada,
		String cidadeEmbarque, String cidadeDestino, double precoEconomica, double precoExecutiva) {
		Sistema.agenda.cadastraVoo(aeronave, numeroVoo, horarioIda, horarioChegada, cidadeEmbarque, cidadeDestino, precoEconomica, precoExecutiva);
	}
	
	public void mostraAssentosDisponiveis(int numeroVoo) {
		try {
			Voo voo = Sistema.agenda.getVoo(numeroVoo);
			voo.mostraAssentosDisponiveis(numeroVoo);
		} catch(Exception e) {
			System.out.print(e.getMessage());
		}
	}
	
	public String mostraAssentosDisponiveisString(int numeroVoo) {
		String s = "";
		try {
			Voo voo = Sistema.agenda.getVoo(numeroVoo);
			s = voo.mostraAssentosDisponiveisString(numeroVoo);
		} catch(Exception e) {
			System.out.print(e.getMessage());
		}
		return s;
	}
	
	public String RelatorioVoo(int numeroVoo) {
		String s = "";
		try {
			Voo voo = Sistema.agenda.getVoo(numeroVoo);
			s = voo.RelatorioVoo(numeroVoo);
		} catch(Exception e) {
			System.out.print(e.getMessage());
		}
		return s;
	}
	
	public void mostraLista() {
		Sistema.agenda.mostraLista();
	}

	public Passageiro cadastraUsuario(String nome, String cpf, int idade) {
		usuarios[numUsuarios]=new Passageiro(nome, cpf, idade);
		return usuarios[numUsuarios];
	}

	public void verificaVoo(int numero) throws Exception{
		Sistema.agenda.getVoo(numero);
		if(Sistema.agenda.getVoo(numero)==null) throw new Exception("Vôo inválido");
	}
}