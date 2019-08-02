package aeronaves;

public class Aeronave implements SistemaAeronave{
	private ClasseExecutiva primeiraClasse;
	private ClasseEconomica segundaClasse;
	
	public Aeronave(){
		this.primeiraClasse = new ClasseExecutiva();
		this.segundaClasse = new ClasseEconomica();
	}
	
	public void imprimePoltronas() {
		System.out.print("-----------------Aeronave-------------------\n");
		this.primeiraClasse.imprimePoltronas();
		this.segundaClasse.imprimePoltronas();
	}

	@Override
	public void reservaPoltrona(String numPoltrona) {
		if(numPoltrona.charAt(0)=='A') this.primeiraClasse.reservaPoltrona(numPoltrona);
		if(numPoltrona.charAt(0)=='E') this.segundaClasse.reservaPoltrona(numPoltrona);
	}

	@Override
	public void mostrarOpcoes(String classe, int numPessoas, String posicao) {
		System.out.print("Poltronas sugeridas:\n");
		if(classe=="Executiva") this.primeiraClasse.mostrarOpcoes(numPessoas, posicao);
		if(classe=="Economica") this.segundaClasse.mostrarOpcoes(numPessoas, posicao);
	}
	
}
