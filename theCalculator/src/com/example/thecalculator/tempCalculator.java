package com.example.thecalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.view.View;

public class tempCalculator extends Activity implements OnClickListener {

	Spinner dropMenu1, dropMenu2;
	EditText temp;
	TextView result;
	float temperature;
	Button convert;
	float calculation;
	String dispResult;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.temperature_calc);
		// radioGroup = (RadioGroup) findViewById(R.id.rgTemp);
		temp = (EditText) findViewById(R.id.etTemp);
		result = (TextView) findViewById(R.id.tvdispResult);
		convert = (Button) findViewById(R.id.btConvert);
		// rbCtoF = (RadioButton) findViewById(R.id.rbCtoF);
		// rbFtoC = (RadioButton) findViewById(R.id.rbFtoC);
		convert.setOnClickListener(this);
		// radioGroup.setOnCheckedChangeListener(this);
		dropMenu1 = (Spinner) findViewById(R.id.spinner1);
		dropMenu2 = (Spinner) findViewById(R.id.spinner2);
		dropMenu1.setSelection(0);
		dropMenu2.setSelection(1);
		convert.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				calculate();
			}
		});
	}

	public void calculate() {
		String drop1 = dropMenu1.getSelectedItem().toString();
		String drop2 = dropMenu2.getSelectedItem().toString();
		if (drop1.contentEquals("Celcius")) {
			if (drop2.contentEquals("Fahrenheit")) {
				temperature = Float.parseFloat(temp.getText().toString());
				calculation = (float) ((temperature * 1.8) + 32);
				dispResult = Float.toString(calculation);
				result.setText(dispResult);
			} else if (drop2.contentEquals("Kelvin")) {
				temperature = Float.parseFloat(temp.getText().toString());
				calculation = (float) (temperature + 273.15);
				dispResult = Float.toString(calculation);
				result.setText(dispResult);
			} else {
				result.setText(temp.getText().toString());
			}
		}
		else if (drop1.contentEquals("Fahrenheit")) {
			if (drop2.contentEquals("Celcius")) {
				temperature = Float.parseFloat(temp.getText().toString());
				calculation = (float) ((temperature - 32) / 1.8);
				dispResult = Float.toString(calculation);
				result.setText(dispResult);
			} else if (drop2.contentEquals("Kelvin")) {
				temperature = Float.parseFloat(temp.getText().toString());
				calculation = (float) (((temperature - 32)/1.8) + 273.15);
				dispResult = Float.toString(calculation);
				result.setText(dispResult);
			} else {
				result.setText(temp.getText().toString());
			}
		}
		else{
			if (drop2.contentEquals("Celcius")) {
				temperature = Float.parseFloat(temp.getText().toString());
				calculation = (float) (temperature - 273.15);
				dispResult = Float.toString(calculation);
				result.setText(dispResult);
			} else if (drop2.contentEquals("Fahrenheit")) {
				temperature = Float.parseFloat(temp.getText().toString());
				calculation = (float) (((temperature - 273.15)*1.8) + 32);
				dispResult = Float.toString(calculation);
				result.setText(dispResult);
			} else {
				result.setText(temp.getText().toString());
			}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		switch (id) {
		case R.id.action_settings:
			break;
//		case R.id.basicCalc:
//			startActivity(new Intent(this, BasicCalculator.class));
//			finish();
//			break;
//		case R.id.advCalc:
//			finish();
//			break;
//		case R.id.gpaCalc:
//			startActivity(new Intent(this, GpaCalculator.class));
//			finish();
//			break;
//		case R.id.tipCalc:
//			startActivity(new Intent(this, tipCalculator.class));
//			finish();
//			break;
//		case R.id.tempCalc:
//			break;
//		case R.id.debtCalc:
//			finish();
//			break;
//		case R.id.lengthCalc:
//			startActivity(new Intent(this, LengthCalculator.class));
//			finish();
//			break;
		case R.id.feedback:
			startActivity(new Intent(this, Feedback.class));
			finish();
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

	//@Override
//	public void onClick(View v) {
//		// TODO Auto-generated method stub
//
//		if (rbCtoF.isChecked()) {
//			temperature = Float.parseFloat(temp.getText().toString());
//			calculation = (float) ((temperature * 1.8) + 32);
//			dispResult = Float.toString(calculation);
//			result.setText(dispResult);
//		} else if (rbFtoC.isChecked()) {
//			temperature = Float.parseFloat(temp.getText().toString());
//			calculation = (float) ((temperature - 32) / 1.8);
//			dispResult = Float.toString(calculation);
//			result.setText(dispResult);
//		}
//	}

}
