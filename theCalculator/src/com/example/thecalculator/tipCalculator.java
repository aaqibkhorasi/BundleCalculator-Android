package com.example.thecalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class tipCalculator extends Activity implements OnClickListener{
	
	Button calculate;
	EditText bill, people, tipPercent;
	TextView tip, indBill, totalBill, indTip;
	float fTotalBill, fTip, fIndBill;
	int iPeople;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tipcalculator_main);
		
		bill = (EditText) findViewById(R.id.etBill);
		bill.setSelection(bill.getText().length());
		people = (EditText) findViewById(R.id.etPeople);
		tipPercent = (EditText) findViewById(R.id.etTipPercent);
		
		tip = (TextView) findViewById(R.id.tvTip);
		indBill = (TextView) findViewById(R.id.tvIndBill);
		totalBill = (TextView) findViewById(R.id.tvTotBill);
		indTip = (TextView) findViewById(R.id.tvIndTip);
		
		calculate = (Button) findViewById(R.id.btCalculate);
		calculate.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		fTip = (Float.parseFloat(bill.getText().toString()))*(Float.parseFloat(tipPercent.getText().toString())/100);
		tip.setText("$"+Float.toString(fTip));
		if(people.getText().toString().equals("1")){
			indTip.setText("$"+Float.toString(fTip));
		}
		else{
			float fIndTip = fTip/(Integer.parseInt(people.getText().toString()));
			indTip.setText("$"+Float.toString(fIndTip));
		}
		fTotalBill = Float.parseFloat(bill.getText().toString()) + fTip; 
		totalBill.setText("$"+Float.toString(fTotalBill));
		iPeople = Integer.parseInt(people.getText().toString());
		fIndBill = fTotalBill/iPeople;
		indBill.setText("$"+Float.toString(fIndBill));
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
		switch(id){
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
//            break;
//		case R.id.tempCalc:
//			startActivity(new Intent(this, tempCalculator.class));
//			finish();
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
	
}
