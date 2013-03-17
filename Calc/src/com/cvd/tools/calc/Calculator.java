package com.cvd.tools.calc;

import java.util.ArrayList;

public class Calculator {

	// Singleton Logic

	private static Calculator instance;

	private Calculator() {

	}

	public static Calculator getInstance() {
		if (instance != null) {
			return instance;
		}
		return instance = new Calculator();
	}

	// Calculator Logic

	public enum Sign {
		PLUS, MINUS, DIVIDE, MULTIPLY, EQUALS, NONE
	}

	private boolean first = true;
	private Sign currentSign = Sign.NONE;

	private float firstInputValue;
	private float secondInputValue;
	private float result;

	private void plus() {
		result = firstInputValue + secondInputValue;
	}

	private void minus() {
		result = firstInputValue - secondInputValue;
	}

	private void divide() {
		result = firstInputValue / secondInputValue;
	}

	private void multiply() {
		result = firstInputValue * secondInputValue;
	}
	
	public void applyResultAsInput() {
		if (first) {
			setInputValue(result);
			currentSign = Sign.NONE;
		}
	}

	public boolean equals() {
		if (first) {
			first = !first;
			return false;
		}
		first = !first;
		switch (currentSign) {
		case PLUS:
			plus();
			break;
		case MINUS:
			minus();
			break;
		case DIVIDE:
			divide();
			break;
		case MULTIPLY:
			multiply();
			break;
		default:
			return false;
		}
		return true;
	}

	public void setInputValue(float value) {
		if (first) {
			this.firstInputValue = value;
		} else {
			this.secondInputValue = value;
		}
	}

	public void setCurrentSign(Sign currentSign) {
		this.currentSign = currentSign;
	}

	public Sign getCurrentSign() {
		return currentSign;
	}
	
	public String getSignString() {
		String sign = "";
		switch (currentSign) {
		case PLUS:
			sign = "+";
			break;
		case MINUS:
			sign = "-";
			break;
		case DIVIDE:
			sign = "/";
			break;
		case MULTIPLY:
			sign = "*";
			break;
		default:
			return "";
		}
		return sign;
	}

	public void erase() {
		firstInputValue = 0;
		secondInputValue = 0;
		currentSign = Sign.NONE;
		first = true;
		result = 0;
	}

	public float getFirstInput() {
		return firstInputValue;
	}

	public float getSecondInput() {
		return secondInputValue;
	}

	public float getResult() {
		return result;
	}

}
