package aeronaves;

import sistema.SistemaCompanhia;

public class Aeronave {
	private Classes primeiraClasse;
	private Classes segundaClasse;
	
	public Aeronave() {
		this.primeiraClasse = new ClasseExecutiva();
		this.segundaClasse = new ClasseEconomica();
	}
	
	public void imprimePoltronas() {
		this.primeiraClasse.imprimePoltronas();
		this.segundaClasse.imprimePoltronas();
	}

	public void reservaPoltrona(String numPoltrona) {
		if(numPoltrona.charAt(0)=='A') this.primeiraClasse.reservaPoltrona(numPoltrona);
		if(numPoltrona.charAt(0)=='E') this.segundaClasse.reservaPoltrona(numPoltrona);
	}


	public void mostrarOpcoes(String classe, int numPessoas, String posicao) {
		if(classe=="Executiva") this.primeiraClasse.mostrarOpcoes(numPessoas, posicao);
		if(classe=="Economica") this.segundaClasse.mostrarOpcoes(numPessoas, posicao);
	}
	
}
