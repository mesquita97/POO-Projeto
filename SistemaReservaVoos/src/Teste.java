import cliente.Passageiro;
import funcionario.Atendente;
import sistema.Sistema;

public class Teste {

	public static void main(String[] args) {
		Atendente a = new Atendente();
		
		a.cadastraVoo(Sistema.aeronaves[0], 133, "16:00", "22:00", "São Paulo", "Manaus", 1800.88, 5700.00);
		a.cadastraVoo(Sistema.aeronaves[1], 134, "12:35", "15:10", "Porto Alegre", "São Paulo", 1800.88, 5700.00);
		a.cadastraVoo(Sistema.aeronaves[2], 135, "11:04", "14:00", "Rio de Janeiro", "Porto Alegre", 1800.88, 5700.00);
		a.cadastraVoo(Sistema.aeronaves[3], 136, "08:20", "09:40", "São Paulo", "Rio de Janeiro", 1800.88, 5700.00);
		
		Passageiro p1= new Passageiro("Gabriel", "111.333.889-21", 21);
		
		p1.reservaPoltrona(133, "E101");
		
		a.mostraAssentosDisponiveis(133);
		
		

	}

}
