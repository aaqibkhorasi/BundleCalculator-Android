package com.example.thecalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainMenu extends Activity implements OnClickListener{
	
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
							 WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.mainmenu);
		
		ImageView header = (ImageView) findViewById(R.id.header);
		Button btBCalc = (Button) findViewById(R.id.calc);
		Button btGPAcalc = (Button ) findViewById(R.id.gpaCalc);
		Button btTipCalc = (Button) findViewById(R.id.tipCalc);
		Button btLCalc = (Button) findViewById(R.id.lengthCalc);
		Button btTCalc = (Button) findViewById(R.id.tempCalc);
		Button btWeight = (Button) findViewById(R.id.weight);
		btBCalc.setOnClickListener(this);
		btGPAcalc.setOnClickListener(this);
		btTipCalc.setOnClickListener(this);
		btLCalc.setOnClickListener(this);
		btTCalc.setOnClickListener(this);
		btWeight.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.calc:
			startActivity(new Intent(this, BasicCalculator.class));
			break;
		case R.id.gpaCalc:
			startActivity(new Intent(this, GpaCalculator.class));
			break;
		case R.id.tipCalc:
			startActivity(new Intent(this, tipCalculator.class));
			break;
		case R.id.lengthCalc:
			startActivity(new Intent(this, LengthCalculator.class));
			break;
		case R.id.tempCalc:
			startActivity(new Intent(this, tempCalculator.class));
			break;
		case R.id.weight:
			startActivity(new Intent(this, Weight.class));
			break;
		}
	}

}
