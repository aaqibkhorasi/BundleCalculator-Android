package com.example.thecalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
public class Feedback extends Activity implements OnClickListener{
	
	Button send;
	EditText name, subject, message;
	String emailAdd = "danish.khakwani@gmail.com";
	String pName, pSubject, pMessage;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.feedback);
		initialize();
		send.setOnClickListener(this);
	}
	private void initialize() {
		// TODO Auto-generated method stub
		send = (Button) findViewById(R.id.btSend);
		name = (EditText) findViewById(R.id.etName);
		subject = (EditText) findViewById(R.id.etSubject);
		message = (EditText) findViewById(R.id.etMessage);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		EditTextIntoStrings();
		String emailAddress[] = {emailAdd};
		Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
		emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, emailAddress); //has to be a string Array
		emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, pSubject);
		emailIntent.setType("plain/text");
		emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, pMessage + "\n\n" + pName);
		startActivity(emailIntent);
		
		
	}
	public void EditTextIntoStrings() {
		// TODO Auto-generated method stub
		pName = name.getText().toString();
		pSubject = subject.getText().toString();
		pMessage = message.getText().toString();
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
//			startActivity(new Intent(this, tipCalculator.class));
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
//		case R.id.feedback:
//			break;
		}
		return super.onOptionsItemSelected(item);
	}
}
