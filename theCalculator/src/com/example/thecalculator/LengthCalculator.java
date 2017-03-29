package com.example.thecalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class LengthCalculator extends Activity implements OnClickListener,
		OnItemSelectedListener {

	Button convert;
	EditText firstET;
	TextView firstTV, secondTV, answerTV;
	Spinner dropMenu1, dropMenu2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.height_calc);
		initialize();
		dropMenu1.setSelection(6);
		dropMenu2.setSelection(7);
		dropMenu1.setOnItemSelectedListener(this);
		dropMenu2.setOnItemSelectedListener(this);
		convert.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				calculate();
			}
		});
	}

	private void initialize() {
		// TODO Auto-generated method stub
		convert = (Button) findViewById(R.id.btConvert);
		firstET = (EditText) findViewById(R.id.etFirst);
		answerTV = (TextView) findViewById(R.id.tvAnswer);
		firstTV = (TextView) findViewById(R.id.tvFirst);
		secondTV = (TextView) findViewById(R.id.tvSecond);
		dropMenu1 = (Spinner) findViewById(R.id.spinner1);
		dropMenu2 = (Spinner) findViewById(R.id.spinner2);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

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
		// case R.id.basicCalc:
		// startActivity(new Intent(this, BasicCalculator.class));
		// finish();
		// break;
		// case R.id.advCalc:
		// // startActivity(new Intent(this, advCalculator.class));
		// finish();
		// break;
		// case R.id.gpaCalc:
		// startActivity(new Intent(this, GpaCalculator.class));
		// finish();
		// break;
		// case R.id.tipCalc:
		// startActivity(new Intent(this, tipCalculator.class));
		// finish();
		// break;
		// case R.id.tempCalc:
		// startActivity(new Intent(this, tempCalculator.class));
		// finish();
		// break;
		// case R.id.debtCalc:
		// finish();
		// break;
		// case R.id.lengthCalc:
		// break;
		case R.id.feedback:
			startActivity(new Intent(this, Feedback.class));
			finish();
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		firstTV.setText(dropMenu1.getSelectedItem().toString());
		secondTV.setText(dropMenu2.getSelectedItem().toString());
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub

	}

	public void calculate() {
		String drop1 = dropMenu1.getSelectedItem().toString();
		String drop2 = dropMenu2.getSelectedItem().toString();
		if (firstET.getText().toString().length() == 0
				|| (firstET.getText().toString().matches("."))) {
		} else {
			if (drop1.contentEquals("Foot")) {
				if (drop2.contentEquals("Foot")) {
					answerTV.setText(firstET.getText().toString());
				} else if (drop2.contentEquals("Kilometer")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) / 3280.8);
					answerTV.setText(Float.toString(ans));
				}

				else if (drop2.contentEquals("Meter")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) / 3.2808);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Centimeter")) {
					float ans = (float) ((Float.parseFloat(firstET.getText()
							.toString()) * 12) * 2.54);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Millimeter")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) / 0.0032808);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Mile")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 0.00018939);
					answerTV.setText(Float.toString(ans));

				} else if (drop2.contentEquals("Yard")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 0.33333);
					answerTV.setText(Float.toString(ans));
				}

				else if (drop2.contentEquals("Inch")) {
					float ans = Float.parseFloat(firstET.getText().toString()) * 12;
					answerTV.setText(Float.toString(ans));
				} else { // Nautical Miles
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) / 6076.1);
					answerTV.setText(Float.toString(ans));
				}
			}

			else if (drop1.contentEquals("Kilometer")) {
				if (drop2.contentEquals("Kilometer")) {
					answerTV.setText(firstET.getText().toString());
				}

				else if (drop2.contentEquals("Meter")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 1000);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Centimeter")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 100000);
					answerTV.setText(Float.toString(ans));

				} else if (drop2.contentEquals("Millimeter")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 1000000);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Mile")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 0.621371);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Yard")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 1093.61);
					answerTV.setText(Float.toString(ans));

				} else if (drop2.contentEquals("Foot")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 3280.84);
					answerTV.setText(Float.toString(ans));

				} else if (drop2.contentEquals("Inch")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 39370.1);
					answerTV.setText(Float.toString(ans));

				} else { // Nautical Miles
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 0.539957);
					answerTV.setText(Float.toString(ans));
				}
			} else if (drop1.contentEquals("Meter")) {
				if (drop2.contentEquals("Meter")) {
					answerTV.setText(firstET.getText().toString());
				} else if (drop2.contentEquals("Kilometer")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 0.001);
					answerTV.setText(Float.toString(ans));

				} else if (drop2.contentEquals("Centimeter")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 100);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Millimeter")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 1000);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Mile")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 0.000621371);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Yard")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 1.09361);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Foot")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 3.28084);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Inch")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 39.3701);
					answerTV.setText(Float.toString(ans));
				} else { // Nautical Miles
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 0.000539957);
					answerTV.setText(Float.toString(ans));
				}

			} else if (drop1.contentEquals("Centimeter")) {
				if (drop2.contentEquals("Centimeter")) {
					answerTV.setText(firstET.getText().toString());
				} else if (drop2.contentEquals("Kilometer")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 0.00001);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Meter")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 0.01);
					answerTV.setText(Float.toString(ans));
				}

				else if (drop2.contentEquals("Millimeter")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 10);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Mile")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 6.2137e-6);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Yard")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 0.0109361);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Foot")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 0.0328084);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Inch")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 0.393701);
					answerTV.setText(Float.toString(ans));
				} else { // Nautical Miles
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 5.3996e-6);
					answerTV.setText(Float.toString(ans));
				}

			} else if (drop1.contentEquals("Millimeter")) {
				if (drop2.contentEquals("Millimeter")) {
					answerTV.setText(firstET.getText().toString());
				} else if (drop2.contentEquals("Kilometer")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 1e-6);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Meter")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 0.001);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Centimeter")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 0.1);
					answerTV.setText(Float.toString(ans));
				}

				else if (drop2.contentEquals("Mile")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 6.2137e-7);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Yard")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 0.00109361);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Foot")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 0.00328084);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Inch")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 0.0393701);
					answerTV.setText(Float.toString(ans));
				} else { // Nautical Miles
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 5.3996e-7);
					answerTV.setText(Float.toString(ans));
				}

			} else if (drop1.contentEquals("Mile")) {
				if (drop2.contentEquals("Mile")) {
					answerTV.setText(firstET.getText().toString());
				} else if (drop2.contentEquals("Kilometer")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 1.60934);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Meter")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 1609.34);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Centimeter")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 160934);
					answerTV.setText(Float.toString(ans));
				}

				else if (drop2.contentEquals("Millimeter")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 1.609e+6);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Yard")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 1760);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Foot")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 5280);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Inch")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 63360);
					answerTV.setText(Float.toString(ans));
				} else { // Nautical Miles
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 0.868976);
					answerTV.setText(Float.toString(ans));
				}

			}

			else if (drop1.contentEquals("Yard")) {
				if (drop2.contentEquals("Yard")) {
					answerTV.setText(firstET.getText().toString());
				} else if (drop2.contentEquals("Kilometer")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 0.0009144);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Meter")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 0.9144);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Centimeter")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 91.44);
					answerTV.setText(Float.toString(ans));
				}

				else if (drop2.contentEquals("Millimeter")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 914.4);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Mile")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 0.000568182);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Foot")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 3);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Inch")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 36);
					answerTV.setText(Float.toString(ans));
				} else { // Nautical Miles
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 0.000493737);
					answerTV.setText(Float.toString(ans));
				}

			} else if (drop1.contentEquals("Foot")) {
				if (drop2.contentEquals("Foot")) {
					answerTV.setText(firstET.getText().toString());
				} else if (drop2.contentEquals("Kilometer")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 0.0003048);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Meter")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 0.3048);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Centimeter")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 30.48);
					answerTV.setText(Float.toString(ans));
				}

				else if (drop2.contentEquals("Millimeter")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 304.8);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Mile")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 0.000189394);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Yard")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 0.333333);
					answerTV.setText(Float.toString(ans));
				}

				else if (drop2.contentEquals("Inch")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 12);
					answerTV.setText(Float.toString(ans));
				} else { // Nautical Miles
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 0.000164579);
					answerTV.setText(Float.toString(ans));
				}

			} else if (drop1.contentEquals("Inch")) {
				if (drop2.contentEquals("Inch")) {
					answerTV.setText(firstET.getText().toString());
				} else if (drop2.contentEquals("Kilometer")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 2.54e-5);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Meter")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 0.0254);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Centimeter")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 2.54);
					answerTV.setText(Float.toString(ans));
				}

				else if (drop2.contentEquals("Millimeter")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 25.4);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Mile")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 1.5783e-5);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Yard")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 0.0277778);
					answerTV.setText(Float.toString(ans));
				}

				else if (drop2.contentEquals("Foot")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 0.0833333);
					answerTV.setText(Float.toString(ans));
				}

				else { // Nautical Miles
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 1.3715e-5);
					answerTV.setText(Float.toString(ans));
				}

			}

			else if (drop1.contentEquals("Nautical Mile")) {
				if (drop2.contentEquals("Nautical Mile")) {
					answerTV.setText(firstET.getText().toString());
				} else if (drop2.contentEquals("Kilometer")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 1.852);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Meter")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 1852);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Centimeter")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 185200);
					answerTV.setText(Float.toString(ans));
				}

				else if (drop2.contentEquals("Millimeter")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 1.852e+6);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Mile")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 1.15078);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Yard")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 2025.37);
					answerTV.setText(Float.toString(ans));
				}

				else if (drop2.contentEquals("Foot")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 6076.12);
					answerTV.setText(Float.toString(ans));
				}

				else { // Inch
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 72913.4);
					answerTV.setText(Float.toString(ans));
				}

			}

		}
	}
}
