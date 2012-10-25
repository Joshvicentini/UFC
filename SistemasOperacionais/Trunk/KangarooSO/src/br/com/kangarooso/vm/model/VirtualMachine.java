package br.com.kangarooso.vm.model;

import java.io.Serializable;

public class VirtualMachine implements Serializable{

	private static final long serialVersionUID = -470393765399562196L;

	private Disk disk;
	private Memory memory;
	private Processor processor;
	
	public VirtualMachine(Disk disk, Memory memory, Processor processor) {
		this.disk = disk;
		this.memory = memory;
		this.processor = processor;
	}
	
	/** GETS & SETS **/
	
	public Disk getDisk() {
		return disk;
	}
	public Memory getMemory() {
		return memory;
	}
	public Processor getProcessor() {
		return processor;
	}
}
