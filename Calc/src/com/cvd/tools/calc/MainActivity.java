package com.cvd.tools.calc;

import com.cvd.tools.calc.Calculator.Sign;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	private EditText display;
	private EditText history;

	private Button equals;
	private Button minus;
	private Button div;
	private Button plus;
	private Button mult;

	private Calculator calc;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		calc = Calculator.getInstance();

		display = (EditText) findViewById(R.id.display);
		history = (EditText) findViewById(R.id.history);

		minus = (Button) findViewById(R.id.minus);
		div = (Button) findViewById(R.id.div);
		mult = (Button) findViewById(R.id.mult);
		equals = (Button) findViewById(R.id.equals);
		plus = (Button) findViewById(R.id.plus);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		display.setCursorVisible(false);
		return true;
	}

	public void inOne(View view) {
		display.setText(display.getText() + "1");
	}

	public void inTwo(View view) {
		display.setText(display.getText() + "2");
	}

	public void inThree(View view) {
		display.setText(display.getText() + "3");
	}

	public void inFour(View view) {
		display.setText(display.getText() + "4");
	}

	public void inFive(View view) {
		display.setText(display.getText() + "5");
	}

	public void inSix(View view) {
		display.setText(display.getText() + "6");
	}

	public void inSeven(View view) {
		display.setText(display.getText() + "7");
	}

	public void inEight(View view) {
		display.setText(display.getText() + "8");
	}

	public void inNine(View view) {
		display.setText(display.getText() + "9");

	}

	public void inZero(View view) {
		String value = display.getText().toString();
		if (value.length() > 0 && value.charAt(0) == '0') {
			return;
		}
		display.setText(display.getText() + "0");

	}

	public void inComma(View view) {
		String value = display.getText().toString();
		if (value.contains((CharSequence) ".")) {
			return;
		}
		display.setText(display.getText() + ".");

	}

	public boolean checkLastSign() {

		switch (calc.getCurrentSign()) {
		case PLUS:
		case MINUS:
		case DIVIDE:
		case MULTIPLY:
			return true;
		default:
			return false;
		}

		// String value = outputText.getText().toString();
		// if (value.length() > 0) {
		// if (value.charAt(value.length() - 1) == '+') {
		//
		// } else if (value.charAt(value.length() - 1) == '-') {
		//
		// } else if (value.charAt(value.length() - 1) == '/') {
		//
		// } else if (value.charAt(value.length() - 1) == '*') {
		//
		// }
		// }
	}

	public String formatHistory(boolean equals) {
		String sign = calc.getSignString();
		String history = "";
		if (!equals) {
			history = calc.getFirstInput() + "";
		} else {
			history = calc.getFirstInput() + " " + sign + " "
					+ calc.getSecondInput();
		}
		return history;
	}

	private void checkForResult() {
		if (calc.equals()) {
			display.setText(calc.getResult() + "");
			history.setText(formatHistory(true) + " = " + calc.getResult());
		} else {
			history.setText(formatHistory(false) + " " + calc.getSignString());
			display.setText("");
		}
	}

	public void inEquals(View view) {
		try {
			float value = Float.parseFloat(display.getText().toString());
			calc.setInputValue(value);
			checkForResult();
			calc.setCurrentSign(Sign.NONE);
		} catch (NumberFormatException e) {
		}
	}

	public void inPlus(View view) {
		try {
			float value = Float.parseFloat(display.getText().toString());
			calc.setInputValue(value);
			calc.setCurrentSign(Sign.PLUS);
			checkForResult();
		} catch (NumberFormatException e) {
		}
	}

	public void inMinus(View view) {
		try {
			float value = Float.parseFloat(display.getText().toString());
			calc.setInputValue(value);
			calc.setCurrentSign(Sign.MINUS);
			checkForResult();
		} catch (NumberFormatException e) {
		}
	}

	public void inDivide(View view) {
		try {
			float value = Float.parseFloat(display.getText().toString());
			calc.setInputValue(value);
			calc.setCurrentSign(Sign.DIVIDE);
			checkForResult();
		} catch (NumberFormatException e) {

		}
	}

	public void inMultiply(View view) {
		try {
			float value = Float.parseFloat(display.getText().toString());
			calc.setInputValue(value);
			calc.setCurrentSign(Sign.MULTIPLY);
			checkForResult();
		} catch (NumberFormatException e) {

		}
	}

	public void inErase(View view) {
		calc.erase();
		display.setText("");
	}
}
