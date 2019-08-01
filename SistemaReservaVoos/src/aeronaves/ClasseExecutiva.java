package aeronaves;

public class ClasseExecutiva implements Classes  {
	private String[][] poltronas = new String[5][4];

	
	public ClasseExecutiva() {
		Poltronas();
	}
	
	
	@Override
	public void Poltronas() {
		for(int i=0; i<poltronas.length;i++) {
			for(int j=0; j<poltronas[0].length; j++) {
				poltronas[i][j]="[A" + i + j + "]";
			}
		}
	}
	

	@Override
	public void imprimePoltronas() {
		for(int i=0; i<poltronas.length; i++) {
			for(int j=0; j<poltronas[0].length-2;j++) {
				System.out.print(poltronas[i][j]);
			}
			System.out.print(" 	   |    |	  ");
			for(int j=2; j<poltronas[0].length; j++) {
				System.out.print(poltronas[i][j]);
			}
			System.out.println(" ");
		}
		
	}


	@Override
	public void reservaPoltrona(String numPoltrona) {
		int i=Integer.parseInt(String.valueOf(numPoltrona.charAt(1)));
		int j=Integer.parseInt(String.valueOf(numPoltrona.charAt(2)));
		poltronas[i][j]= "     ";		}


	@Override
	public void mostrarOpcoes(int numPessoas, String posicao) {
		// TODO Auto-generated method stub
		
	}
	

}
