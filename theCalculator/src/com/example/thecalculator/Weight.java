package com.example.thecalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

public class Weight extends Activity implements OnClickListener,
		OnItemSelectedListener {

	Button convert;
	EditText firstET;
	TextView firstTV, secondTV, answerTV;
	Spinner dropMenu1, dropMenu2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.weight);
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
			if (drop1.contentEquals("Metric ton")) {
				if (drop2.contentEquals("Metric ton")) {
					answerTV.setText(firstET.getText().toString());
				} else if (drop2.contentEquals("Kilogram")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 1000);
					answerTV.setText(Float.toString(ans));
				}

				else if (drop2.contentEquals("Gram")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 1000000);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Milligram")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 1000000000);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Long ton")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 0.98421);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Short ton")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 1.10231);
					answerTV.setText(Float.toString(ans));

				} else if (drop2.contentEquals("Pound")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 2204.62);
					answerTV.setText(Float.toString(ans));
				}

				else if (drop2.contentEquals("Ounce")) {
					float ans = Float.parseFloat(firstET.getText().toString()) * 35274;
					answerTV.setText(Float.toString(ans));
				}

			}

			else if (drop1.contentEquals("Kilogram")) {
				if (drop2.contentEquals("Kilogram")) {
					answerTV.setText(firstET.getText().toString());
				}

				else if (drop2.contentEquals("Metric ton")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) / 1000);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Gram")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 1000);
					answerTV.setText(Float.toString(ans));

				} else if (drop2.contentEquals("Milligram")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 1000000);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Long ton")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 0.000984207);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Short ton")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 0.00110231);
					answerTV.setText(Float.toString(ans));

				} else if (drop2.contentEquals("Pound")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 2.20462);
					answerTV.setText(Float.toString(ans));

				} else if (drop2.contentEquals("Ounce")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 35.274);
					answerTV.setText(Float.toString(ans));

				}
			} else if (drop1.contentEquals("Gram")) {
				if (drop2.contentEquals("Gram")) {
					answerTV.setText(firstET.getText().toString());
				} else if (drop2.contentEquals("Metric ton")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) / 1000000);
					answerTV.setText(Float.toString(ans));

				} else if (drop2.contentEquals("Kilogram")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) / 1000);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Milligram")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 1000);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Long ton")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) / 1016046.9088);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Short ton")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 0.0000011);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Pound")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 0.00220462);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Ounce")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 0.035274);
					answerTV.setText(Float.toString(ans));
				}

			} else if (drop1.contentEquals("Milligram")) {
				if (drop2.contentEquals("Milligram")) {
					answerTV.setText(firstET.getText().toString());
				} else if (drop2.contentEquals("Metric ton")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) / 1000000000);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Kilogram")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) / 1000000);
					answerTV.setText(Float.toString(ans));
				}

				else if (drop2.contentEquals("Gram")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 0.001);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Long ton")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 0.000000000984);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Short ton")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 0.000000001102311311);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Pound")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 0.000002204);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Ounce")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 0.000035274);
					answerTV.setText(Float.toString(ans));
				}

			} else if (drop1.contentEquals("Long ton")) {
				if (drop2.contentEquals("Long ton")) {
					answerTV.setText(firstET.getText().toString());
				} else if (drop2.contentEquals("Metric ton")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 1.01605);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Kilogram")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 1016.05);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Gram")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 1016000);
					answerTV.setText(Float.toString(ans));
				}

				else if (drop2.contentEquals("Milligram")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 1016000000);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Short ton")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 1.12);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Pound")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 2240);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Ounce")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 35840);
					answerTV.setText(Float.toString(ans));
				}

			} else if (drop1.contentEquals("Short ton")) {
				if (drop2.contentEquals("Short ton")) {
					answerTV.setText(firstET.getText().toString());
				} else if (drop2.contentEquals("Metric ton")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 0.907185);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Kilogram")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 907.185);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Gram")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 907185);
					answerTV.setText(Float.toString(ans));
				}

				else if (drop2.contentEquals("Milligram")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 907200000);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Long ton")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 0.892857);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Pound")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 2000);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Ounce")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 32000);
					answerTV.setText(Float.toString(ans));
				}

			}

			else if (drop1.contentEquals("Pound")) {
				if (drop2.contentEquals("Pound")) {
					answerTV.setText(firstET.getText().toString());
				} else if (drop2.contentEquals("Metric ton")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 0.000453592);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Kilogram")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 0.453592);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Gram")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 453.592);
					answerTV.setText(Float.toString(ans));
				}

				else if (drop2.contentEquals("Milligram")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 453592);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Long ton")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 0.000446429);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Short ton")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 0.0005);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Ounce")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 16);
					answerTV.setText(Float.toString(ans));
				}

			} else if (drop1.contentEquals("Ounce")) {
				if (drop2.contentEquals("Ounce")) {
					answerTV.setText(firstET.getText().toString());
				} else if (drop2.contentEquals("Metric ton")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 0.00002835);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Kilogram")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 0.0283495);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Gram")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 28.3495);
					answerTV.setText(Float.toString(ans));
				}

				else if (drop2.contentEquals("Milligram")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 28349.5);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Long ton")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 0.000027902);
					answerTV.setText(Float.toString(ans));
				} else if (drop2.contentEquals("Short ton")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 0.00003125);
					answerTV.setText(Float.toString(ans));
				}

				else if (drop2.contentEquals("Pound")) {
					float ans = (float) (Float.parseFloat(firstET.getText()
							.toString()) * 0.0625);
					answerTV.setText(Float.toString(ans));
				}

			}

		}
	}
}
