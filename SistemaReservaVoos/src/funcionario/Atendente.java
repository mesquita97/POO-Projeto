/**
 * 
 */
package funcionario;

import aeronaves.Aeronave;
import sistema.Sistema;
import sistema.Usuario;
import sistema.Voo;


public class Atendente extends Usuario {

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
	
	public void mostraLista() {
		Sistema.agenda.mostraLista();
	}
}
