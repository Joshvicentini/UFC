package br.com.kangarooso.vm.model;

import java.io.Serializable;

public class Memory implements Serializable{

	private static final long serialVersionUID = -7702478357477443921L;
	
	private long size;
	private byte[] content;

	public Memory(long size) {
		this.size = size;
	}
	
	/** GETS & SETS **/
	
	public long getSize() {
		return size;
	}
	public byte[] getContent() {
		return content;
	}
	public void setContent(byte[] content) {
		this.content = content;
	}
}
