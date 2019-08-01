package sistema;

public interface SistemaUsuario extends Sistema {

	@Override
	void reservaPoltrona(int numero, String numPoltrona);

	@Override
	void mostrarOpcoes(int numero, String classe, int numPessoas, String posicao);
	
	void comprar(int numeroVoo, String formaDePagamento);
	
}
