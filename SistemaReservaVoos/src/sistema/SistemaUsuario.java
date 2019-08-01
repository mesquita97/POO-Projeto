package sistema;

public interface SistemaUsuario extends Sistema {

	@Override
	void reservaPoltrona(String numPoltrona);

	@Override
	void mostrarOpcoes(String classe, int numPessoas, String posicao);

	String buscaVoos(String destino);
	
	void comprar(int numeroVoo, String formaDePagamento);
	
}
