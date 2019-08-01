package sistema;

import aeronaves.Aeronave;

public class AgendaVoos implements SistemaCompanhia{
	Voo[] voos = new Voo[10];
	int numeroVoos=0;

	public Voo[] getVoos() {
		return voos;
	}

	public Voo getVoo(int numero) {
		for(Voo voo: voos) {
			if(voo.getNumero()==numero) return voo;	
		}
		return null;
	}

	@Override
	public void reservaPoltrona(int numero, String numPoltrona) {
		for(int j=0; j<numeroVoos; j++) {
			if(voos[j].getNumero()==numero) voos[j].reservaPoltrona(numPoltrona);
		}
	}

	@Override
	public void mostrarOpcoes(int numero, String classe, int numPessoas, String posicao) {
		for(int j=0; j<numeroVoos; j++) {
			if(voos[j].getNumero()==numero) voos[j].mostrarOpcoes(classe, numPessoas, posicao);
		}
	}

	@Override
	public void cancelaVoo(int numero) {
		for(int j=0; j<numeroVoos; j++) {
			if(voos[j].getNumero()==numero) voos[j]=null; 
		}
		numeroVoos--;
	}

	@Override
	public void cadastraVoo(Aeronave aeronave, int numero, String horarioIda, String horarioChegada,
			String cidadeEmbarque, String cidadeDestino, double precoEconomica, double precoExecutiva) {
			voos[numeroVoos]= new Voo(aeronave, numero, horarioIda, horarioChegada, cidadeEmbarque, cidadeDestino, precoEconomica,
				precoExecutiva);
			numeroVoos++;
	}

	@Override
	public void buscaVoos(String destino) {
		for(int j=0; j<numeroVoos; j++) {
			if(voos[j].getCidadeDestino()==destino) System.out.print(voos[j]);
		}
	}
	
	public void mostraLista(){
		for(int j=0; j<numeroVoos; j++) {
			System.out.print(voos[j]);
		}
	}

	public void mostraAssentosDisponiveis(int numeroVoo) {
		for(int j=0; j<numeroVoos; j++) {
			if(voos[j].getNumero()==numeroVoo) voos[j].mostraAssentosDisponiveis(numeroVoo);
		}
		
	}
}