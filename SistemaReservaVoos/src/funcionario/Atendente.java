/**
 * 
 */
package funcionario;

import aeronaves.Aeronave;
import sistema.Sistema;
import sistema.SistemaCompanhia;


public class Atendente implements SistemaCompanhia {
	@Override
	public void reservaPoltrona(int numeroVoo, String numPoltrona) {
		Sistema.agenda.reservaPoltrona(numeroVoo, numPoltrona);
	}

	@Override
	public void mostrarOpcoes(int numeroVoo, String classe, int numPessoas, String posicao) {
		Sistema.agenda.mostrarOpcoes(numeroVoo, classe, numPessoas, posicao);
	}

	@Override
	public void cancelaVoo(int numeroVoo) {
		Sistema.agenda.cancelaVoo(numeroVoo);
	}

	@Override
	public void cadastraVoo(Aeronave aeronave, int numeroVoo, String horarioIda, String horarioChegada,
			String cidadeEmbarque, String cidadeDestino, double precoEconomica, double precoExecutiva) {
		Sistema.agenda.cadastraVoo(aeronave, numeroVoo, horarioIda, horarioChegada, cidadeEmbarque, cidadeDestino, precoEconomica, precoExecutiva);
	}

	@Override
	public void buscaVoos(String destino) {
		Sistema.agenda.buscaVoos(destino);
	}
	
	public void mostraAssentosDisponiveis(int numeroVoo) {
		Sistema.agenda.mostraAssentosDisponiveis(numeroVoo);
	}
	
	@Override
	public void mostraLista() {
		Sistema.agenda.mostraLista();
	}
}
