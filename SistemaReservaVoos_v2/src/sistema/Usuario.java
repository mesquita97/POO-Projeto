package sistema;


public abstract class Usuario implements Sistema {

	
	@Override
	public void buscaVoos(String destino) {
		try { 
			Sistema.agenda.buscaVoos(destino);
		} catch(Exception e) {
			System.out.print(e.getMessage());
		}
	}
	
	public void reservaPoltrona(int numeroVoo, String classe, int numPessoas, String posicao) {
		try{
			Voo voo = Sistema.agenda.getVoo(numeroVoo);
			voo.mostrarOpcoes(classe, numPessoas, posicao);
		} catch(Exception e) {
			System.out.print(e.getMessage());
		}
	}
}