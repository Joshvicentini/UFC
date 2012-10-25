package br.com.kangarooso.so.exception;

public class CommandNotFoundException extends Exception{

	private static final long serialVersionUID = 484906722460490628L;

	public CommandNotFoundException(String command) {
		super("O comando " + command + " não existe!");
	}
}
