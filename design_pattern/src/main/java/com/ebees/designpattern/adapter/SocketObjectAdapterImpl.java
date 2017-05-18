package com.ebees.designpattern.adapter;

public class SocketObjectAdapterImpl implements SocketAdapter {

	private Socket socket = new Socket();
	
	@Override
	public Volt get120() {
		return socket.getVolt();
	}

	@Override
	public Volt get12() {
		Volt v = socket.getVolt();
		return converVolt(v, 10);
	}

	@Override
	public Volt get3() {
		Volt v = socket.getVolt();
		return converVolt(v, 40);
	}

	private Volt converVolt(Volt v, int div) {
		return new Volt(v.getVolt()/div);
	}
	
}
