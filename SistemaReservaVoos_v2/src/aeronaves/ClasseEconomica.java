package aeronaves;

public class ClasseEconomica  {
	private String[][] poltronas = new String[15][6];

	public ClasseEconomica() {
		for(int i=0; i<poltronas.length;i++) {
			for(int j=0; j<poltronas[0].length; j++) {
				if(i<10) poltronas[i][j] = "[E0" + i + j + "]";
				else poltronas[i][j] = "[E" + i + j + "]";

			}
		}	
	}
	

	public void imprimePoltronas() {
		for(int i=0; i<poltronas.length; i++) {
			for(int j=0; j<poltronas[0].length-3;j++) {
				System.out.print(poltronas[i][j]);
			}
			System.out.print(" |    | ");
			for(int j=3; j<poltronas[0].length; j++) {
				System.out.print(poltronas[i][j]);
			}
			System.out.println(" ");
		}		
	}
	
	public String imprimePoltronasString() {
		String s = "";
		for(int i=0; i<poltronas.length; i++) {
			for(int j=0; j<poltronas[0].length-3;j++) {
				s = (s + poltronas[i][j]);
			}
			s = (s + " |    | ");
			for(int j=3; j<poltronas[0].length; j++) {
				s = (s + poltronas[i][j]);
			}
			s = (s + " \n");
		}
		return s;
	}

		
	private void imprimePoltronas(int j1, int j2) {
		for(int i=0; i<poltronas.length; i++) {
			if(poltronas[i][j1]!= "      ") System.out.print(poltronas[i][j1] + " ");
			if(poltronas[i][j2]!= "      ") System.out.print(poltronas[i][j2] + " ");
			System.out.print("\n");
		}
		
	}
	
	protected void reservaPoltrona(String numPoltrona) {
		int i=Integer.parseInt(numPoltrona.substring(1, 3));
		int j=Integer.parseInt(String.valueOf(numPoltrona.charAt(3)));
		poltronas[i][j]= "            ";	
	}

	protected void mostrarOpcoes(int numPessoas, String posicao) {
		posicao=posicao.toLowerCase();
		switch(posicao) {
		case "corredor":
			if(numPessoas==2) {
				imprimePoltronas(1,2);
				imprimePoltronas(3,4);
			}
			imprimePoltronas(2,3);
		case "meio":
			if(numPessoas==2) {
				imprimePoltronas();
			}
			imprimePoltronas(1,4);
		case "janela":
			if(numPessoas==2) {
				imprimePoltronas(0,1);
				imprimePoltronas(4,5);
			}
			imprimePoltronas(0,5);
		} if(numPessoas>=3) {
			imprimePoltronas();
		}
	}
	
}