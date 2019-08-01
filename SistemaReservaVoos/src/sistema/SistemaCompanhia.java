package sistema;

import aeronaves.Aeronave;

public interface SistemaCompanhia extends Sistema {	
	
	@Override
	public abstract void reservaPoltrona(int numero, String numPoltrona);
	
	@Override
	public abstract void mostrarOpcoes(int numero, String classe, int numPessoas, String posicao);
	
	void cancelaVoo(int numero);
	
	void cadastraVoo(Aeronave aeronave, int numero,String horarioIda,String horarioChegada, String cidadeEmbarque,
			String cidadeDestino, double precoEconomica, double precoExecutiva);
	
	void mostraLista();
}
