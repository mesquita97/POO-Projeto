package sistema;

import aeronaves.Aeronave;

public interface Sistema {
	AgendaVoos agenda = new AgendaVoos();
	Aeronave[] aeronaves = new Aeronave[4];
	
	public abstract void reservaPoltrona(int numero, String numPoltrona);
	
	public abstract void mostrarOpcoes(int numero, String classe, int numPessoas, String posicao);
	
	void buscaVoos(String destino);

}
