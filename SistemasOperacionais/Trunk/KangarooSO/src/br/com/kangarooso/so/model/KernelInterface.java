package br.com.kangarooso.so.model;

import java.io.Serializable;

import br.com.kangarooso.vm.model.VirtualMachine;

public class KernelInterface implements Serializable{

	private static final long serialVersionUID = -6901237705152414534L;

	private VirtualMachine virtualMachine;
	
	public KernelInterface(VirtualMachine vm) {
		this.virtualMachine = vm;
	}
}
