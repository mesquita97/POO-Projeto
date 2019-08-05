package InterfaceGrafica;


import javax.swing.JOptionPane;

import cliente.Passageiro;
import funcionario.Atendente;
import sistema.Sistema;

public class Painel {
	private int opcao=-1;
	private Passageiro passageiro;
	Atendente atendente = new Atendente();
	
	public Painel() throws Exception {		

		atendente.cadastraVoo(Sistema.aeronaves[0], 133, "16:00", "22:00", "São Paulo", "Manaus", 2100.88, 6200.00);
		atendente.cadastraVoo(Sistema.aeronaves[1], 134, "12:35", "15:10", "Porto Alegre", "São Paulo", 1100.99, 4800.10);
		atendente.cadastraVoo(Sistema.aeronaves[2], 135, "11:04", "14:00", "Rio de Janeiro", "Porto Alegre", 1300.00, 5300.84);
		atendente.cadastraVoo(Sistema.aeronaves[3], 136, "08:20", "09:40", "São Paulo", "Rio de Janeiro", 573.99, 2114.45);
		atendente.cadastraVoo(Sistema.aeronaves[0], 137, "02:40", "11:30", "Manaus", "São Paulo", 2325.19, 6188.13);
		atendente.cadastraVoo(Sistema.aeronaves[3], 138, "11:00", "20:25", "Manaus", "Rio de Janeiro", 1950.12, 6123.41);
		atendente.cadastraVoo(Sistema.aeronaves[2], 139, "08:20", "22:00", "Manaus", "Porto Alegre", 2583.23, 6830.39);
		atendente.cadastraVoo(Sistema.aeronaves[1], 140, "11:40", "15:35", "São Paulo", "Porto Alegre", 1030.82, 4389.90);
		atendente.cadastraVoo(Sistema.aeronaves[3], 141, "08:20", "09:40", "Porto Alegre", "Rio de Janeiro", 1243.25, 4010.34);
		atendente.cadastraVoo(Sistema.aeronaves[2], 142, "13:00", "14:14", "Rio de Janeiro", "São Paulo", 493.99, 1755.23);
		try {
			telaIncial();
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
		
		
	private void telaIncial() throws Exception {
		while(opcao != 0) {
			opcao = Integer.parseInt(JOptionPane.showInputDialog("[1] Atendente\n"
									  						   + "[2] Cliente\n"
									  						   + "[0] Sair"));
			//Tela Atendente
			if (opcao == 1) {
				telaAtendente();
			}
			
			//Tela Cliente
			else if (opcao == 2) {
				telaCliente();
			} else if(opcao!=0) throw new Exception("Opcao invalida");
		}	
	}


	private void telaAtendente() {
		opcao = Integer.parseInt(JOptionPane.showInputDialog("[1] Cadastrar Vôo\n"
				   + "[2] Cancelar Vôo\n"
				   + "[3] Relatório de Vôo\n"
				   + "[4] Cadastrar usuário\n"
				   + "[0] Sair"));
		switch(opcao) {
			case 1:
				cadastraVoo();
				break;
			case 2:
				cancelaVoo();
				break;
			case 3:
				relatorioVoo();
				break;
			case 4:
				cadastraUsuario();
				break;
		}
		
	}
	
	private void telaCliente() {
		cadastraUsuario();
		
		opcao = Integer.parseInt(JOptionPane.showInputDialog("[1] Reservar Poltrona\n"
														   + "[2] Procurar Vôo\n"
				   										   + "[0] Sair"));		
		switch(opcao) {
			case 1:
				try {
					reservaPoltrona();
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				break;
			case 2:
				try {
					procuraVoo();
				} catch(Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				break;
				
		}
		
	}
		
	private void procuraVoo() throws Exception {
		int cidadeOpcao=Integer.parseInt(JOptionPane.showInputDialog("Digite o destino que busca - [1]São Paulo [2]Rio de Janeiro"
				+ " [3]Porto Alegre [4]Manaus"));
		
		switch(cidadeOpcao) {
			case 1:
				System.out.print("Buscando voos para SP:\n");
				atendente.buscaVoos("São Paulo");
				reservaPoltrona();
				break;
			case 2:
				System.out.print("Buscando voos para RJ:\n");
				atendente.buscaVoos("Rio de Janeiro");
				reservaPoltrona();
				break;
			case 3:
				System.out.print("Buscando voos para POA:\n");
				atendente.buscaVoos("Porto Alegre");
				reservaPoltrona();
				break;
			case 4:
				System.out.print("Buscando voos para Manaus:\n");
				atendente.buscaVoos("Manaus");
				reservaPoltrona();
				break;
		}
	}		

	private void reservaPoltrona() throws Exception {
		String classe="", posicao="";
		String pagamento="";
		int numeroVoo = Integer.parseInt(JOptionPane.showInputDialog("Qual o numero do Vôo desejado ?"));
		verificaVoo(numeroVoo);
		classe = pegaClasse(classe);
		int numPessoas=Integer.parseInt(JOptionPane.showInputDialog("Quantas pessoas o acompanharão?"));
		posicao=pegaPosicao(posicao);
		
		try {
			passageiro.reservaPoltrona(numeroVoo, classe, numPessoas, posicao);
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		try {
			mostraAssentos(numeroVoo);
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		pagamento=definePagamento(pagamento);
		
		pegaAssentos(numPessoas, numeroVoo, posicao, pagamento);		
		
		telaIncial();
		//Fim Resrvar Poltrona		
	}


	private void pegaAssentos(int numPessoas,int numeroVoo, String posicao, String pagamento) {
		int c = 0 ;
		while (c < numPessoas) {
			posicao = JOptionPane.showInputDialog("Qual é o assento desejado ?");
			JOptionPane.showMessageDialog(null,  "         -----------------Aeronave-------------------\n"
					   + passageiro.compraPassagem(numeroVoo, posicao, pagamento));	
			c++;
		}
		JOptionPane.showMessageDialog(null, "Poltrona Reservada !");
		JOptionPane.showMessageDialog(null, pagamento  + "\n\n" + atendente.mostraAssentosDisponiveisString(numeroVoo));		
	}


	private String definePagamento(String pagamento) {
		pagamento=null;
		opcao = Integer.parseInt(JOptionPane
				   .showInputDialog("Credito ou Debito ?\n\n"
				   				  + "[1] Crédito\n"
								  + "[2] Débito\n"
								  + "[0] Cancelar\n"));
	
		if(opcao == 1) {
			pagamento = "Credito";
		}
		else if (opcao == 2) {
			pagamento = "Debito";
		}		return pagamento;
	}


	private String pegaPosicao(String posicao) {
		opcao=Integer.parseInt(JOptionPane.showInputDialog("[1]Janela [2]Meio [3]Corredor"));
		switch(opcao) {
			case 1:
				posicao ="janela";
				return posicao;
			case 2:
				posicao="meio";
				return posicao;
			case 3:
				posicao="corredor";
				return posicao;
		} return null;
	}


	private String pegaClasse(String classe) {
		opcao = Integer.parseInt(JOptionPane.showInputDialog("Qual classe ? [1]Economica [2]Executiva"));
		switch(opcao) {
			case 1:
				classe="economica";
				return classe;
			case 2:
				classe="executiva";
				return classe;
		} if(opcao!=1 && opcao!=2 && opcao!=0) {
			JOptionPane.showMessageDialog(null, "Opcao Invalida");
			pegaClasse(classe);
		} return null;
	}


	private void verificaVoo(int numeroVoo) {
		try {
			atendente.verificaVoo(numeroVoo);
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Vôo inválido");
			telaCliente();
		}		
	}


	private void mostraAssentos(int numeroVoo) {
		JOptionPane.showMessageDialog(null, "         -----------------Aeronave-------------------\n"
				+	atendente.mostraAssentosDisponiveisString(numeroVoo));		
	}


	private void cadastraUsuario() {
		String nome = JOptionPane.showInputDialog("Digite o nome do passageiro.");
		String cpf = JOptionPane.showInputDialog("Insira o CPF do passageiro.");
		int idade = Integer.parseInt(JOptionPane.showInputDialog("Qual a idade do passageiro ?"));
		passageiro=atendente.cadastraUsuario(nome, cpf, idade);
	}


	private void relatorioVoo() {
		int v = Integer.parseInt(JOptionPane.showInputDialog("Qual o numero do vôo solicitado ?"));
		JOptionPane.showMessageDialog(null, atendente.RelatorioVoo(v) + "\n\n" + atendente.mostraAssentosDisponiveisString(v));		
	}


	private void cancelaVoo() {
		int v = Integer.parseInt(JOptionPane.showInputDialog("Qual o numero do vôo a ser cancelado ?"));
		atendente.cancelaVoo(v);
		JOptionPane.showMessageDialog(null, "Vôo " + v + " cancelado");
	}


	private void cadastraVoo() {
		atendente.cadastraVoo(Sistema.aeronaves[1], Integer.parseInt(JOptionPane.showInputDialog("Numero do Vôo")), JOptionPane.showInputDialog("Horário de ida"), 
		JOptionPane.showInputDialog("Horário de Chegada"), JOptionPane.showInputDialog("Cidade de Embarque"), JOptionPane.showInputDialog("Cidade de Destino"), 
		Double.parseDouble(JOptionPane.showInputDialog("Preço Classe Econômica")), Double.parseDouble(JOptionPane.showInputDialog("Preço Classe Executiva")));
		JOptionPane.showMessageDialog(null, "Vôos Cadastardos !");		
	}		
}
	


