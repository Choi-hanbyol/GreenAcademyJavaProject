package io_p;

import java.io.Serializable;

public class ObjectData implements Serializable{
	private static final long serialVersionUID = 8522;
	
	String tag, src, dst;
	Object data;
	public ObjectData(String tag, String src, String dst, Object data) {
		super();
		this.tag = tag;
		this.src = src;
		this.dst = dst;
		this.data = data;
	}
	@Override
	public String toString() {
		return "ObjData [tag=" + tag + ", src=" + src + ", dst=" + dst + ", data=" + data + "]";
	}
	
	
}