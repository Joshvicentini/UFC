package br.com.kangarooso.vm.model;

import java.io.Serializable;

public class Disk implements Serializable {

	private static final long serialVersionUID = 1339764066545053653L;

	private long size;
	private byte[] content;

	public Disk(long size) {
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
