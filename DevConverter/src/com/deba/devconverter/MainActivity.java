package com.deba.devconverter;

import android.R.string;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	Spinner spinner;
	EditText Option1;
	EditText Option2;
	Button Converter;
	TextView Result;
	double cm,m,cel,farh,rup,dol;
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner=(Spinner) findViewById(R.id.spinner);
        Option1=(EditText) findViewById(R.id.Option1);
        Option2=(EditText) findViewById(R.id.Option2);
        Converter=(Button) findViewById(R.id.Converter);
        Result=(TextView) findViewById(R.id.Result);
        String[] arr={"SELECT","LENGTH","TEMPRETURE","CURRENCY"};
        ArrayAdapter<String> adpt=new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_dropdown_item_1line, arr);
        spinner.setAdapter(adpt);
        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int pos, long arg3) {
				// TODO Auto-generated method stub
				switch (pos) {
				case 0:
					Option1.setHint(null);
					Option2.setHint(null);
					Toast.makeText(MainActivity.this, "enter a valid selection", Toast.LENGTH_SHORT).show();
					Converter.setOnClickListener(new OnClickListener() {
						
						@Override
						public void onClick(View arg0) {
							// TODO Auto-generated method stub
							String s1=Option1.getText().toString();
							String s2=Option2.getText().toString();
							if (s1.length()==0 && s2.length()==0) {
								Toast.makeText(MainActivity.this, "plz enter a valid selection", Toast.LENGTH_SHORT).show();
							}
						}
					});
					
					
					
					break;
				case 1:
					Option1.setHint("centimeter");
					Option2.setHint("meter");
					Result.setText("Result");
					Converter.setOnClickListener(new OnClickListener() {
						
						@Override
						public void onClick(View arg0) {
							// TODO Auto-generated method stub
							String s1=Option1.getText().toString();
							String s2=Option2.getText().toString();
							if (s1.length()>0 &&s2.length()>0) {
								Toast.makeText(MainActivity.this, "plz enter only one value", Toast.LENGTH_SHORT).show();
							}
							else if (s1.length()==0 && s2.length()==0) {
								Toast.makeText(MainActivity.this, "plz enter some value", Toast.LENGTH_SHORT).show();
							}
							else if (s1.length()>0) {
								cm=Double.parseDouble(Option1.getText().toString());
								m=cm*0.01;
								Result.setText(cm+"Centimeter is "+m+" meters");
								Option1.setText("");
							}
							else if (s2.length()>0) {
								m=Double.parseDouble(Option2.getText().toString());
								cm=m*100;
								Result.setText(m+" meter is "+cm+" Centimeters");
								Option2.setText("");
								
							}
							//Result.setText("");
						}
					});
					
					break;
				case 2:
					Option1.setHint("celcious");
					Option2.setHint("farenhite");
					Result.setText("Result");
					Converter.setOnClickListener(new OnClickListener() {
						
						@Override
						public void onClick(View arg0) {
							// TODO Auto-generated method stub
							String s1=Option1.getText().toString();
							String s2=Option2.getText().toString();
							if (s1.length()>0 && s2.length()>0) {
								Toast.makeText(MainActivity.this, "enter only one value", Toast.LENGTH_SHORT).show();
							}
							else if (s1.length()==0 && s2.length()==0) {
								Toast.makeText(MainActivity.this, "plz enter some value", Toast.LENGTH_SHORT).show();
							}
							else if (s1.length()>0) {
								cel=Double.parseDouble(Option1.getText().toString());
								farh=(1.8*cel)+32;
								Result.setText(cel+"celcious is"+farh+"farenhite");
								Option1.setText("");
								
							}
							else if (s2.length()>0) {
								farh=Double.parseDouble(Option2.getText().toString());
								cel=0.55*(farh-32);
								Result.setText(farh+"farenhite is"+cel+"celcious");
								Option2.setText("");
							}
						}
					});
					break;
				case 3:
					Option1.setHint("rupees");
					Option2.setHint("dolar");
					Result.setText("Result");
					Converter.setOnClickListener(new OnClickListener() {
						
						@Override
						public void onClick(View arg0) {
							// TODO Auto-generated method stub
							String s1=Option1.getText().toString();
							String s2=Option2.getText().toString();
							if (s1.length()>0 && s2.length()>0) {
								Toast.makeText(MainActivity.this, "enter only one value", Toast.LENGTH_SHORT).show();
							}
							else if (s1.length()==0 && s2.length()==0) {
								Toast.makeText(MainActivity.this, "plz enter some value", Toast.LENGTH_SHORT).show();
							}
							else if (s1.length()>0) {
								rup=Double.parseDouble(Option1.getText().toString());
								dol=rup*0.015;
								Result.setText(rup+"Rupees is"+dol+"Dollars");
								Option1.setText("");
							}
							else if (s2.length()>0) {
								dol=Double.parseDouble(Option2.getText().toString());
								rup=dol*66.18;
								Result.setText(dol+"Dollars is"+rup+"rupees");
								Option2.setText("");
							}
							
						}
					});
					break;
				

				default:
					break;
				}
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
        
        
        Converter.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			
				
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
