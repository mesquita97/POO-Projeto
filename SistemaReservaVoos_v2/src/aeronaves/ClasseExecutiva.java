package aeronaves;

public class ClasseExecutiva  {
	private String[][] poltronas = new String[5][4];

	
	public ClasseExecutiva() {
		for(int i=0; i<poltronas.length;i++) {
			for(int j=0; j<poltronas[0].length; j++) {
				poltronas[i][j]="[A" + i + j + "]";
			}
		}
	}

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
	
	public String imprimePoltronasString() {
		String s = "";
		for(int i=0; i<poltronas.length; i++) {
			s = (s + "             ");
			for(int j=0; j<poltronas[0].length-2;j++) {
				s = (s + poltronas[i][j]);
			}
			s = (s + " 	   |    |	  ");
			for(int j=2; j<poltronas[0].length; j++) {
				s = (s + poltronas[i][j]);
			}
			s = (s + " \n");
		}
		return s;
	}

	public void imprimePoltronas(int j1, int j2) {
		for(int i=0; i<poltronas.length; i++) {
			if(poltronas[i][j1]!= "      ") System.out.print(poltronas[i][j1] + " ");
			if(poltronas[i][j2]!= "      ") System.out.print(poltronas[i][j2] + " ");
			System.out.print("\n");
		}
		
	}

	public void reservaPoltrona(String numPoltrona) {
		int i=Integer.parseInt(String.valueOf(numPoltrona.charAt(1)));
		int j=Integer.parseInt(String.valueOf(numPoltrona.charAt(2)));
		poltronas[i][j]= "            ";	
	}


	public void mostrarOpcoes(int numPessoas, String posicao) {
		posicao=posicao.toLowerCase();
		switch(posicao) {
		case "corredor":
			if(numPessoas==2) {
				imprimePoltronas(0,1);
				imprimePoltronas(2,3);
			} else imprimePoltronas();
		case "meio":
			if(numPessoas==2) {
				imprimePoltronas(0,1);
				imprimePoltronas(2,3);
			}else imprimePoltronas();
		case "janela":
			if(numPessoas==2) {
				imprimePoltronas(0,1);
				imprimePoltronas(2,3);
			} else imprimePoltronas();
		} if(numPessoas>=3) {
			imprimePoltronas();
		}
	}

	
	

}