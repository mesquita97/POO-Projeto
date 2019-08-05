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
		return this.aeronave;
	}
	
	public String getCidadeDestino() {
		return this.cidadeDestino;
	}

	public String getCidadeEmbarque() {
		return this.cidadeEmbarque;
	}

	public String getData() {
		return this.data;
	}

	public String getHorarioChegada() {
		return this.horarioChegada;
	}

	public String getHorarioIda() {
		return this.horarioIda;
	}

	public int getNumero() {
		return this.numero;
	}

	public int getNumPassageiros() {
		return this.numPassageiros;
	}

	public Passageiro[] getPassageiros() {
		return this.passageiros;
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

	public void mostrarOpcoes(String classe, int numPessoas, String posicao) throws Exception {
		classe=classe.toLowerCase();
		if(classe != "economica" && classe != "executiva") throw new Exception("Classe não permitida, escolher executiva ou economica\n" + classe);
		if(classe=="economica") System.out.print("Preço classe econômica: R$ " + getPrecoEconomica() + "\n");
		if(classe=="executiva") System.out.print("Preço classe executiva: R$ " + getPrecoExecutiva() + "\n");
		this.aeronave.mostrarOpcoes(classe, numPessoas, posicao);
	}

	public void compraPassagem(Passageiro passageiro, String numPoltrona) {
		try {
			this.aeronave.reservaPoltrona(numPoltrona);
			this.passageiros[numPassageiros]=passageiro;
			this.numPassageiros++;
			this.precoTotal+=getPreco(numPoltrona);
		} catch(Exception e) {
			System.out.print(e.getMessage());
		}
	}

	public String RelatorioVoo(int numero) {
		String s = "";
		for(int j=0; j<Sistema.agenda.numeroVoos; j++) {
			if(Sistema.agenda.voos[j].getNumero()==numero) s = "Origem: " + Sistema.agenda.getVoos()[j].getCidadeEmbarque() + "    Saída: " + Sistema.agenda.getVoos()[j].getHorarioIda()
											  + "\nDestino: " + Sistema.agenda.getVoos()[j].getCidadeDestino() + "    Chegada: " + Sistema.agenda.getVoos()[j].getHorarioChegada()
											  + "\n--------------------Aeronave--------------------\n\n"; 
		}
		return s;
	}
	
	public void setAeronave(Aeronave aeronave) {
		this.aeronave = aeronave;
	}
	
	
	public void mostraAssentosDisponiveis(int numeroVoo) {
		this.aeronave.imprimePoltronas();
	}
	
	public String mostraAssentosDisponiveisString(int numeroVoo) {
		return this.aeronave.imprimePoltronasString();
	}
	
	@Override
	public String toString() {
		return "Voo = " + getNumero() + " Embarque = " + getCidadeEmbarque() + " " + getHorarioIda() + " Destino = " + getCidadeDestino() +
			  " " + getHorarioChegada() + "\n";
	}
}