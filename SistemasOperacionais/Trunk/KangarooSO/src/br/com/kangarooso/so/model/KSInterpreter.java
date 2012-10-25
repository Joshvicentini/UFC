package br.com.kangarooso.so.model;

import java.io.Serializable;

public class KSInterpreter implements Serializable{

	private static final long serialVersionUID = 2019901747616721618L;

	private Kernel kernel;
	
	public KSInterpreter(Kernel kernel) {
		this.kernel = kernel;
	}

}
