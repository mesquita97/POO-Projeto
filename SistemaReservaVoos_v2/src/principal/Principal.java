package principal;
import cliente.Passageiro;
import funcionario.Atendente;
import sistema.Sistema;
import javax.swing.JOptionPane;
import sistema.Voo;
import InterfaceGrafica.Painel;


public class Principal {

	public static void main(String[] args) throws Exception{
		try {
			Painel painel = new Painel();
		}catch(Exception e) {
			System.out.print(e.getMessage());
		}

	}
	
}