package com.example.thecalculator;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class GpaCalculator extends Activity {
	Float key = (float) 0.00;
	float credit = 0;
	float totalTermCredits = 0;
	float totalCredits = 0;
	Float gradePoint = (float) 0.00;
	float gradePointBefore = 0;

	// ** above variable were in calculate function, just testing.
	Button calculate;
	EditText etCGPA;
	EditText etTot;
	Spinner[] gradesArray = new Spinner[7]; // 7 items of grades
	Spinner[] creditsArray = new Spinner[7]; // 7 items of credits
	Map<String, Float> gradeValues = new HashMap<String, Float>(); // Creating
																	// hash map
																	// which
																	// will hold
																	// grades
																	// and its
																	// key
	Spinner gradesMenu1, creditsMenu1, gradesMenu2, creditsMenu2, gradesMenu3,
			creditsMenu3, gradesMenu4, creditsMenu4, gradesMenu5, creditsMenu5,
			gradesMenu6, creditsMenu6, gradesMenu7, creditsMenu7;
	float GPA, CGPA;

	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gpa_calc);
		initialize();
		calculate.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				calculate();
			}
		});
	}

	public void calculate() {
		// TODO Auto-generated method stub
		gradePointsSetter();

		for (int i = 0; i < 7; i++) {
			key = (gradeValues.get(gradesArray[i].getSelectedItem())); // .get
																		// will
																		// get
																		// the
																		// key

			credit = (Float.parseFloat((String) creditsArray[i]
					.getSelectedItem()));
			
			gradePoint = gradePoint + (key * credit); // accumulating
														// grade points
			if (!(gradesArray[i].getSelectedItem().equals("") && credit>0)){
				totalTermCredits = totalTermCredits + credit;
			}
			 //*** PROBLEM GRADE AYA NAHI AUR CREDITS COUNT
		}

		GPA = gradePoint / totalTermCredits; // here we will get the GPA
												// For the term

		// TO CALCULATE CGPA, WE need total credits before + current
		// semester credits
		if (etCGPA.getText().toString().length()==0 || etTot.getText().toString().length()==0){
			
		}else {
			gradePointBefore = (Float.parseFloat(etCGPA.getText().toString()))
					* (Float.parseFloat(etTot.getText().toString()));
			totalCredits = (Float.parseFloat(etTot.getText().toString()))
					+ totalTermCredits;
			CGPA = (gradePointBefore + gradePoint) / totalCredits;
			String gpaMessage = "GPA: " + GPA + "\nCGPA: " + CGPA;
			//Dialog
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setMessage(gpaMessage);
			builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
			    public void onClick(DialogInterface dialog, int which) {
			        // do something interesting.
			    }
			});
			// other code to customize the dialog
			Dialog d = builder.create();
			d.show();
			
		}
		
		GPA = 0;
		CGPA = 0;
		gradePoint = (float) 0 ;
		gradePointBefore = 0;
		totalCredits = 0;
		totalTermCredits = 0 ;
	}

	public void gradePointsSetter() {
		// TODO Auto-generated method stub

		gradeValues.put("", (float) 0.00); // Empty
		gradeValues.put("A+", (float) 4.33);
		gradeValues.put("A", (float) 4.00);
		gradeValues.put("A-", (float) 3.67);
		gradeValues.put("B+", (float) 3.33);
		gradeValues.put("B", (float) 3.00);
		gradeValues.put("B-", (float) 2.67);
		gradeValues.put("C+", (float) 2.33);
		gradeValues.put("C", (float) 2.00);
		gradeValues.put("C-", (float) 1.67);
		gradeValues.put("D", (float) 1.00);
		gradeValues.put("F", (float) 0.00);
	}

	public void initialize() {
		// TODO Auto-generated method stub
		calculate = (Button) findViewById(R.id.btCalc);
		etCGPA = (EditText) findViewById(R.id.etCGPA);
		etTot = (EditText) findViewById(R.id.etTotalUnits);

		gradesMenu1 = (Spinner) findViewById(R.id.spGrade1);
		gradesArray[0] = gradesMenu1;

		creditsMenu1 = (Spinner) findViewById(R.id.spCredit1);
		creditsArray[0] = creditsMenu1;

		gradesMenu2 = (Spinner) findViewById(R.id.spGrade2);
		gradesArray[1] = gradesMenu2;

		creditsMenu2 = (Spinner) findViewById(R.id.spCredit2);
		creditsArray[1] = creditsMenu1;

		gradesMenu3 = (Spinner) findViewById(R.id.spGrade3);
		gradesArray[2] = gradesMenu3;

		creditsMenu3 = (Spinner) findViewById(R.id.spCredit3);
		creditsArray[2] = creditsMenu3;

		gradesMenu4 = (Spinner) findViewById(R.id.spGrade4);
		gradesArray[3] = gradesMenu4;

		creditsMenu4 = (Spinner) findViewById(R.id.spCredit4);
		creditsArray[3] = creditsMenu4;

		gradesMenu5 = (Spinner) findViewById(R.id.spGrade5);
		gradesArray[4] = gradesMenu5;

		creditsMenu5 = (Spinner) findViewById(R.id.spCredit5);
		creditsArray[4] = creditsMenu5;

		gradesMenu6 = (Spinner) findViewById(R.id.spGrade6);
		gradesArray[5] = gradesMenu6;

		creditsMenu6 = (Spinner) findViewById(R.id.spCredit6);
		creditsArray[5] = creditsMenu6;

		gradesMenu7 = (Spinner) findViewById(R.id.spGrade7);
		gradesArray[6] = gradesMenu7;

		creditsMenu7 = (Spinner) findViewById(R.id.spCredit7);
		creditsArray[6] = creditsMenu7;
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
	

}
