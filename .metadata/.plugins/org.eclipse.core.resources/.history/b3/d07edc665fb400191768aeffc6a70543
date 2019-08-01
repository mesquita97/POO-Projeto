package sistema;

import cliente.Passageiro;

public class Voo {
	private String data, horarioIda, horarioChegada, cidadeEmbarque, cidadeDestino, status;
	private int numero;
	private int numPassageiros=0;
	Passageiro[] passageiros = new Passageiro[10];
	private double precoEconomica, precoExecutiva;
	private double precoTotal=0.0;
	
	public String getData() {
		return data;
	}

	public String getHorarioChegada() {
		return horarioChegada;
	}

	public String getCidadeEmbarque() {
		return cidadeEmbarque;
	}

	public String getCidadeDestino() {
		return cidadeDestino;
	}

	public String getStatus() {
		return status;
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

	public double getPrecoEconomica() {
		return precoEconomica;
	}

	public double getPrecoExecutiva() {
		return precoExecutiva;
	}

	protected double getPrecoTotal() {
		return precoTotal;
	}

	public Voo(int numero,String horarioIda,String horarioChegada, String cidadeEmbarque,
			String cidadeDestino, double precoEconomica, double precoExecutiva) {
		this.numero=numero;
		this.horarioIda=horarioIda;
		this.horarioChegada=horarioChegada;
		this.cidadeEmbarque=cidadeEmbarque;
		this.cidadeDestino=cidadeDestino;
		this.precoEconomica=precoEconomica;
		this.precoExecutiva=precoExecutiva;
		this.status="Parte as :" + getHorarioIda();
	}

	public String getHorarioIda() {
		return horarioIda;
	}
}
