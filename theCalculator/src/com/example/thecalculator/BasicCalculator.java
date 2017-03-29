package com.example.thecalculator;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.*;

public class BasicCalculator extends ActionBarActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_main);

	}

	static boolean clear_screen = true;

	static float operand1 = 0f;
	static float operand2 = 0f;
	static float answer = 0f;
	boolean operator_state = false;
	boolean insert_state = false;
	boolean last_click = false;
	String Operator = "";


	public void insert_text(String text) {
		// TODO Auto-generated method stub
		TextView display = (TextView) findViewById(R.id.textView1);
		if (clear_screen) {
			display.setText("");
			clear_screen = false;

		}

		this.insert_state = true;
		this.last_click = true;
		display.append(text);
	}

	public void onClick(View v) {
		TextView screen = (TextView) findViewById(R.id.textView1);
    	switch(v.getId()){
    		case R.id.num0 : insert_text("0"); break;
    		case R.id.num1 : insert_text("1"); break;
    		case R.id.num2 : insert_text("2"); break;
    		case R.id.num3 : insert_text("3"); break;
    		case R.id.num4 : insert_text("4"); break;
    		case R.id.num5 : insert_text("5"); break;
    		case R.id.num6 : insert_text("6"); break;
    		case R.id.num7 : insert_text("7"); break;
    		case R.id.num8 : insert_text("8"); break;
    		case R.id.num9 : insert_text("9"); break;
    		case R.id.point : 
    			if (!screen.getText().toString().contains(".") || this.operator_state){
    				insert_text("."); 
    			}
    			break;
    		case R.id.plusSign: 	set_operator("+"); break;
    		case R.id.minusSign:	set_operator("-"); break;
    		case R.id.mulSign:		set_operator("*"); break;
    		case R.id.divSign:		set_operator("/"); break;
    		case R.id.sqRoot:		set_operator("Sqroot"); break;
    		case R.id.power:	set_operator("^"); break;
    		case R.id.percentage:	set_operator("%"); break;
    		case R.id.flip:	set_operator("1/x"); break;
    		case R.id.equalsTo:	
    			if(screen.getText().toString().length() > 0 && this.Operator != ""){
    				calculate(); 
    				clear_screen = true;
    				operand1 = 0f; 
    				operand2 = 0f;
    				this.Operator = "";
    				this.operator_state = false ;
    			}
    			break;
    		case R.id.delButton:
    			if(screen.getText().toString().length() > 1){
	    			 String screen_new = screen.getText().toString().substring(0, screen.getText().toString().length()-1);
	    			 screen.setText(screen_new);
	    			 clear_screen = false;
   			 	}else{
   			 		 screen.setText("0");
   			 		clear_screen = true;
   			 	}
	   			 break;
    		case R.id.clearButton:
    			operand1 = 0f;
    			operand2 = 0f;
    			answer = 0f;
    			this.Operator = "";
    			this.operator_state = false ;
    			this.insert_state = false;
    			this.last_click = false;
    			clear_screen = true;
    			screen.setText("0");
    			break;
    	}
	}


	public void set_operator(String operator) {
		// TODO Auto-generated method stub
		TextView display = (TextView) findViewById(R.id.textView1);
		if (display.getText().toString().equals(".")) {
			display.setText("0");
		}
		if (this.insert_state && this.operator_state && this.last_click) {
			calculate();
		}
		if (display.getText().length() > 0)
			operand1 = Float.parseFloat(display.getText().toString());

		this.operator_state = true; // Means we have now pressed + operator
		clear_screen = true;
		this.last_click = false;

		// operation=op;

		if (operator.equals("+"))
			this.Operator = "+";
		else if (operator.equals("-"))
			this.Operator = "-";
		else if (operator.equals("*"))
			this.Operator = "*";
		else if (operator.equals("/"))
			this.Operator = "/";
		else if (operator.equals("Sqroot")) {
			answer = (float) Math.sqrt(Float.parseFloat(display.getText()
					.toString()));
			display.setText(answer + "");
			clear_screen = true;
			operand1 = 0f;
			operand2 = 0f;
			Operator = "";
			last_click = true;
			operator_state = false;
		} else if (operator.equals("1/x")) {
			answer = 1 / Float.parseFloat(display.getText().toString());
			display.setText(answer + "");
			clear_screen = true;
			operand1 = 0f;
			operand2 = 0f;
			Operator = "";
			last_click = true;
			operator_state = false;
		} else if (operator.equals("^"))
			this.Operator = "^";
		else if (operator.equals("%"))
			this.Operator = "%";
	}

	public void calculate() {
		// TODO Auto-generated method stub
		TextView display = (TextView) findViewById(R.id.textView1);
		if (display.getText().toString().equals(".")) {
			display.setText("0");
		}
		if (display.getText().toString().length() > 0) {
			operand2 = Float.parseFloat(display.getText().toString());
		}
		if (this.Operator.equals("+")) {
			answer = operand1 + operand2;
		} else if (this.Operator.equals("-")) {
			answer = operand1 - operand2;
		} else if (this.Operator.equals("*")) {
			answer = operand1 * operand2;
		} else if (this.Operator.equals("/")) {
			answer = operand1 / operand2;
		} else if (this.Operator.equals("^")) {
			answer = (float) Math.pow(operand1, operand2);
		} else if (this.Operator.equals("%")) {
			answer = operand1 % operand2;
		} else {
			answer = Float.parseFloat(display.getText().toString());
		}

		display.setText(answer + "");
		// if (display.getText().toString().equals(".")){
		// display.setText("0");
		// }
		// if (display.getText().toString().length() > 0){
		// operand2 = Float.parseFloat(display.getText().toString());
		// }
		// //operand2 = Float.parseFloat(display.getText().toString());
		// if(operation.equals("+")){
		// answer = operand1 + operand2;
		// }
		// else if(operation.equals("-")){
		// answer = operand1 - operand2;
		// }
		// else if(operation.equals("*")){
		// answer = operand1 * operand2;
		// }
		// else if(operation.equals("/")){
		// answer = operand1 / operand2;
		// }
		// else if (operation.equals("^")){
		// answer = (float) Math.pow(operand1, operand2) ;
		//
		// }
		// else if (operation.equals("%")){
		// answer = operand1 % operand2;
		// }
		// else{
		// answer = Float.parseFloat(display.getText().toString());
		// }
		// display.setText(answer + "");
		// //display.setText(Float.toString(answer));
	}

	// public void ButtonClickHandler(View v){
	// TextView screen = (TextView) findViewById(R.id.textView1);
	// switch(v.getId()){
	// case R.id.num0 : insert_text("0"); break;
	// case R.id.num1 : insert_text("1"); break;
	// case R.id.num2 : insert_text("2"); break;
	// case R.id.num3 : insert_text("3"); break;
	// case R.id.num4 : insert_text("4"); break;
	// case R.id.num5 : insert_text("5"); break;
	// case R.id.num6 : insert_text("6"); break;
	// case R.id.num7 : insert_text("7"); break;
	// case R.id.num8 : insert_text("8"); break;
	// case R.id.num9 : insert_text("9"); break;
	// case R.id.point :
	// if (!screen.getText().toString().contains(".") || this.operator_state){
	// insert_text(".");
	// }
	// break;
	// case R.id.plusSign : set_operator("+"); break;
	// case R.id.minusSign : set_operator("-"); break;
	// case R.id.mulSign: set_operator("*"); break;
	// case R.id.divSign: set_operator("/"); break;
	// case R.id.sqRoot: set_operator("Sqroot"); break;
	// case R.id.power: set_operator("^"); break;
	// case R.id.percentage: set_operator("%"); break;
	// case R.id.flip: set_operator("1/x"); break;
	// case R.id.equalsTo:
	// if(screen.getText().toString().length() > 0 && this.Operator != ""){
	// calculate();
	// clear_screen = true;
	// operand1 = 0f;
	// operand2 = 0f;
	// this.Operator = "";
	// this.operator_state = false ;
	// }
	// break;
	// case R.id.delButton:
	// if(screen.getText().toString().length() > 1){
	// String screen_new = screen.getText().toString().substring(0,
	// screen.getText().toString().length()-1);
	// screen.setText(screen_new);
	// clear_screen = false;
	// }else{
	// screen.setText("0");
	// clear_screen = true;
	// }
	// break;
	// case R.id.clearButton:
	// operand1 = 0f;
	// operand2 = 0f;
	// answer = 0f;
	// this.Operator = "";
	// this.operator_state = false ;
	// this.insert_state = false;
	// this.last_click = false;
	// clear_screen = true;
	// screen.setText("0");
	// break;
	// }
	// }

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

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}
}
