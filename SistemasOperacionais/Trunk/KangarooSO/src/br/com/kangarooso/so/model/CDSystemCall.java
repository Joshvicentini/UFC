package br.com.kangarooso.so.model;

public class CDSystemCall extends Systemcall{

	private static final long serialVersionUID = 4214028622536185730L;
	public static final String keyCommand = "cd";
	
	@Override
	public void run(String... params) {
		System.out.println("teste");
	}
	
}
