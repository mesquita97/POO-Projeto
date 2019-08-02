package sistema;

import aeronaves.Aeronave;

public interface Sistema {
	AgendaVoos agenda = new AgendaVoos();
	Aeronave[] aeronaves = new Aeronave[4];
	
	void reservaPoltrona(int numeroVoo, String classe, int numPessoas, String posicao);
		
	void buscaVoos(String destino);

}
