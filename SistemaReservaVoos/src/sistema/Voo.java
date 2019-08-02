package sistema;

import aeronaves.Aeronave;
import cliente.Passageiro;

public class Voo {
	Aeronave aeronave;
	private String data, horarioIda, horarioChegada, cidadeEmbarque, cidadeDestino, status;
	private int numero;
	private int numPassageiros=0;
	Passageiro[] passageiros = new Passageiro[110];
	private double precoEconomica, precoExecutiva;
	private double precoTotal=0.0;
	public Voo(Aeronave aeronave, int numero,String horarioIda,String horarioChegada, String cidadeEmbarque,
			String cidadeDestino, double precoEconomica, double precoExecutiva) {
		aeronave = new Aeronave();
		this.aeronave=aeronave;
		this.numero=numero;
		this.horarioIda=horarioIda;
		this.horarioChegada=horarioChegada;
		this.cidadeEmbarque=cidadeEmbarque;
		this.cidadeDestino=cidadeDestino;
		this.precoEconomica=precoEconomica;
		this.precoExecutiva=precoExecutiva;
		this.status="Parte as: " + getHorarioIda();
	}
	public Aeronave getAeronave() {
		return aeronave;
	}
	
	public String getCidadeDestino() {
		return cidadeDestino;
	}

	public String getCidadeEmbarque() {
		return cidadeEmbarque;
	}

	public String getData() {
		return data;
	}

	public String getHorarioChegada() {
		return horarioChegada;
	}

	public String getHorarioIda() {
		return horarioIda;
	}

	public int getNumero() {
		return numero;
	}

	public int getNumPassageiros() {
		return numPassageiros;
	}

	public Passageiro[] getPassageiros() {
		return passageiros;
	}
	
	public double getPreco(String numPoltrona) {
		char classe = numPoltrona.charAt(0);
		if(classe=='E') return precoEconomica;
		if(classe=='A') return precoExecutiva;
		else return 0;
	}

	public double getPrecoEconomica() {
		return precoEconomica;
	}

	public double getPrecoExecutiva() {
		return precoExecutiva;
	}

	protected double getPrecoTotal() {
		return precoTotal;
	}

	public String getStatus() {
		return status;
	}

	public void mostrarOpcoes(String classe, int numPessoas, String posicao) {
		this.aeronave.mostrarOpcoes(classe, numPessoas, posicao);
		if(classe=="Econômica") System.out.print("Preço classe econômica: R$ " + getPrecoEconomica() + "\n");
		if(classe=="Executiva") System.out.print("Preço classe executiva: R$ " + getPrecoExecutiva() + "\n");

	}

	public void compraPassagem(Passageiro passageiro, String numPoltrona) {
		this.aeronave.reservaPoltrona(numPoltrona);
		this.passageiros[numPassageiros]=passageiro;
		this.numPassageiros++;
		this.precoTotal+=getPreco(numPoltrona);
	}

	
	public void setAeronave(Aeronave aeronave) {
		this.aeronave = aeronave;
	}
	
	
	public void mostraAssentosDisponiveis(int numeroVoo) {
		this.aeronave.imprimePoltronas();
	}
	
	@Override
	public String toString() {
		return "Voo = " + getNumero() + " Embarque = " + getCidadeEmbarque() + " " + getHorarioIda() + " Destino = " + getCidadeDestino() +
			  " " + getHorarioChegada() + "\n";
	}
}
