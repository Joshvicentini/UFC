package br.com.kangarooso.so.model;

import java.io.Serializable;

public class Kernel implements Serializable{

	private static final long serialVersionUID = -6493197776688663103L;

	private KernelInterface kernelInterface;
	
	public Kernel(KernelInterface kernelInterface) {
		this.kernelInterface = kernelInterface;
	}
	
}
