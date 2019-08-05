package sistema;

import javax.swing.JOptionPane;

import aeronaves.Aeronave;

public class AgendaVoos {
	Voo[] voos = new Voo[100];
	int numeroVoos=0;

	public int getNumeroVoos() {
		return numeroVoos;
	}

	public void setNumeroVoos(int numeroVoos) {
		this.numeroVoos = numeroVoos;
	}

	public Voo[] getVoos() {
		return voos;
	}

	public Voo getVoo(int numero) throws Exception {
		for(Voo voo: voos) {
			if(voo.getNumero()==numero) return voo;	
		} throw new Exception("Vôo inválido.\n");
	}


	public void cancelaVoo(int numero) {
		for(int j=0; j<numeroVoos; j++) {
			if(voos[j].getNumero()==numero) voos[j]=null; 
		}
		numeroVoos--;
	}

	public void cadastraVoo(Aeronave aeronave, int numero, String horarioIda, String horarioChegada,
			String cidadeEmbarque, String cidadeDestino, double precoEconomica, double precoExecutiva) {
			voos[numeroVoos]= new Voo(aeronave, numero, horarioIda, horarioChegada, cidadeEmbarque, cidadeDestino, precoEconomica,
				precoExecutiva);
			numeroVoos++;
	}

	public void buscaVoos(String destino) throws Exception {
		boolean a=false;
		for(int j=0; j<numeroVoos; j++) {
			if(voos[j].getCidadeDestino()==destino) {
				a=true;
				JOptionPane.showMessageDialog(null, voos[j]);
			}
		} if(!a) throw new Exception("Não há vôos para " + destino);
	}
	
	
	public void mostraLista(){
		for(int j=0; j<numeroVoos; j++) {
			System.out.print(voos[j]);
		}
	}

}