package com.example.mathgame;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends Activity implements OnClickListener{

	TextView problem, result;
	EditText value;
	Button btn_submit, btn_close;	
	
	int x, y;
	int count_o, count_x;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);
        
        problem = (TextView)findViewById(R.id.textView1);
        result = (TextView)findViewById(R.id.textView2);
        value = (EditText)findViewById(R.id.editText1);
        btn_submit = (Button)findViewById(R.id.button1);
        btn_close =  (Button)findViewById(R.id.button2);
        
        btn_submit.setOnClickListener(this);
        btn_close.setOnClickListener(this);
        
        count_o = 0;
        count_x = 0;  
        
        x = (int)Math.round(Math.random() * 99);
		y = (int)Math.round(Math.random() * 99);
		
		problem.setText(x + " + " + y + " = ");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main_activity2, menu);
        return true;
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch(v.getId()){
		case R.id.button1:
			if(Integer.parseInt(value.getText().toString()) == x+y)
				result.setText("정답 : " + ++count_o + ", 오답 : " + count_x);
			else
				result.setText("정답 : " + count_o + ", 오답 : " + ++count_x);
			
			x = (int)Math.round(Math.random() * 99);
			y = (int)Math.round(Math.random() * 99);
			
			problem.setText(x + " + " + y + " = ");
			
			value.setText("");
			
			break;
			
		case R.id.button2:			
			finish();		
		}
		
	}
}
