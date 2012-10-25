package br.com.kangarooso.so.model;

import java.io.Serializable;

public abstract class Systemcall implements Serializable{

	private static final long serialVersionUID = 4673825312675933992L;
	
	public abstract void run(String... params);
}
