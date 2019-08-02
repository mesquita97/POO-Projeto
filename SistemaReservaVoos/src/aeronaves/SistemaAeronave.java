package aeronaves;

public interface SistemaAeronave {

	void imprimePoltronas();

	void reservaPoltrona(String numPoltrona);

	void mostrarOpcoes(String classe , int numPessoas, String posicao);

}
