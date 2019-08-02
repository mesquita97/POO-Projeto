package sistema;

public class Usuario implements Sistema {

	
	@Override
	public void buscaVoos(String destino) {
		Sistema.agenda.buscaVoos(destino);
	}
	
	public void reservaPoltrona(int numeroVoo, String classe, int numPessoas, String posicao) {
		Voo voo = Sistema.agenda.getVoo(numeroVoo);
		voo.mostrarOpcoes(classe, numPessoas, posicao);
	}
}
