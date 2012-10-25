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
		mapSystemcall.put(LSSystemcall.keyCommand, new LSSystemcall());
		mapSystemcall.put(CDSystemcall.keyCommand, new CDSystemcall());
		mapSystemcall.put(HelpSystemcall.keyCommand, new HelpSystemcall());
		mapSystemcall.put(ExitSystemcall.keyCommand, new ExitSystemcall());
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
