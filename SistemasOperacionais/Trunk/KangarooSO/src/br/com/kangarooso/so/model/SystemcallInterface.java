package br.com.kangarooso.so.model;

import java.io.Serializable;
import java.util.HashMap;

import br.com.kangarooso.so.exception.CommandNotFoundException;

public class SystemcallInterface implements Serializable{

	private static final long serialVersionUID = -4339072303120200322L;

	private Kernel kernel;
	private HashMap<String,Systemcall> mapSystemcall;
	
	public SystemcallInterface(Kernel kernel) {
		this.kernel = kernel;
		this.mapSystemcall = new HashMap<String,Systemcall>();
		mapSystemcall.put(LSSystemCall.keyCommand, new LSSystemCall());
		mapSystemcall.put(CDSystemCall.keyCommand, new CDSystemCall());
		mapSystemcall.put(HelpSystemCall.keyCommand, new HelpSystemCall());
		mapSystemcall.put(ExitSystemCall.keyCommand, new ExitSystemCall());
	}
	
	public void exec(String input) throws CommandNotFoundException{
		if(input != null && !input.trim().equals("")){
			int index = input.indexOf(" ");
			String commandKey = index == -1 ? input : input.substring(0, index);
			if(!mapSystemcall.containsKey(commandKey)){
				throw new CommandNotFoundException(commandKey);
			}
			else{
				((Systemcall)mapSystemcall.get(commandKey)).run();
			}
		}
	}
}
