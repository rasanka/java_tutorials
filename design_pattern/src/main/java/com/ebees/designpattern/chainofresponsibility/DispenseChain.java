package com.ebees.designpattern.chainofresponsibility;

public interface DispenseChain {

	void setNextChain(DispenseChain chain);
	void dispence(Currency currency);
}
