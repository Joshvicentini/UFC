package br.com.kangarooso.so.model;

public class HelpSystemcall extends Systemcall{

	private static final long serialVersionUID = 4214028622536185730L;
	public static final String keyCommand = "help";
	
	@Override
	public void run(String... params) {
		System.out.println("Para mais informacoes sobre um comando, digite \"help -COMANDO\"");
		System.out.println("ls	        Lista os objetos do diretorio atual");
		System.out.println("cd	        Navega nos diretorios do sistema");
		System.out.println("mkDir       Cria um novo diretorio");
	}
	
}
