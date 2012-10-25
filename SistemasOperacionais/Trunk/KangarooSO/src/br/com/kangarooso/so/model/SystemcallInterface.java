package br.com.kangarooso.so.model;

import java.io.Serializable;
import java.util.HashMap;

import br.com.kangarooso.so.exception.CommandNotFoundException;

public class SystemcallInterface implements Serializable{

	private static final long serialVersionUID = -4339072303120200322L;

	private Kernel kernel;
	private HashMap<String,Class<? extends Systemcall>> mapSystemcall;
	
	public SystemcallInterface(Kernel kernel) {
		this.kernel = kernel;
		this.mapSystemcall = new HashMap<String,Class<? extends Systemcall>>();
		mapSystemcall.put(LSSystemcall.keyCommand, LSSystemcall.class);
		mapSystemcall.put(CDSystemcall.keyCommand, CDSystemcall.class);
		mapSystemcall.put(HelpSystemcall.keyCommand, HelpSystemcall.class);
		mapSystemcall.put(ExitSystemcall.keyCommand, ExitSystemcall.class);
	}
	
	public void exec(String input) throws CommandNotFoundException{
		if(input != null && !input.trim().equals("")){
			int index = input.indexOf(" ");
			String commandKey = index == -1 ? input : input.substring(0, index);
			if(!mapSystemcall.containsKey(commandKey)){
				throw new CommandNotFoundException(commandKey);
			}
			else{
				try {
					((Systemcall)((Class<? extends Systemcall>)mapSystemcall.get(commandKey)).newInstance()).run();
				} catch (InstantiationException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
