package com.ebees.designpattern.adapter;

public class SocketClassAdapterImpl extends Socket implements SocketAdapter {

	@Override
	public Volt get120() {
		return getVolt();
	}

	@Override
	public Volt get12() {
		Volt v = getVolt();
		return converVolt(v, 10);
	}

	@Override
	public Volt get3() {
		Volt v = getVolt();
		return converVolt(v, 40);
	}

	private Volt converVolt(Volt v, int div) {
		return new Volt(v.getVolt()/div);
	}
	
}
