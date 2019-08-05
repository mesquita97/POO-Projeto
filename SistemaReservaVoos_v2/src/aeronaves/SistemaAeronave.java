package aeronaves;

public interface SistemaAeronave {

	void imprimePoltronas();

	void reservaPoltrona(String numPoltrona) throws Exception;

	void mostrarOpcoes(String classe , int numPessoas, String posicao);

}