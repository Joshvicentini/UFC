package br.com.kangarooso.so.model;

import java.io.Serializable;
import java.util.Scanner;

import br.com.kangarooso.so.exception.CommandNotFoundException;

public class Shell implements Serializable{

	private static final long serialVersionUID = -6600101935286091345L;

	private KSInterpreter ksInterpreter;
	private SystemcallInterface systemcallInterface;
	
	public Shell(SystemcallInterface systemcallInterface,KSInterpreter ksInterpreter) {
		this.ksInterpreter = ksInterpreter;
		this.systemcallInterface = systemcallInterface;
	}
	
	/** METHODS **/
	
	public void init(){
		Scanner scanner = new Scanner(System.in);
		String input = null;
		while(!"exit".equals(input)){
			System.out.print("$ ");
			input = scanner.nextLine();
			if(input.length() >= 2 && "ks".equals(input.substring(0, 1))){
				
			}
			else{
				try{
					systemcallInterface.exec(input);
				}
				catch(CommandNotFoundException e){
					System.out.println(e.getMessage());
				}
			}
			System.out.println("");
		}
		System.out.println("shutdown!");
		scanner.close();
	}
	
	/** GETS & SETS **/
	
	public KSInterpreter getKsInterpreter() {
		return ksInterpreter;
	}
	public void setKsInterpreter(KSInterpreter ksInterpreter) {
		this.ksInterpreter = ksInterpreter;
	}
	public SystemcallInterface getSystemcallInterface() {
		return systemcallInterface;
	}
	public void setSystemcallInterface(SystemcallInterface systemcallInterface) {
		this.systemcallInterface = systemcallInterface;
	}
	
}
