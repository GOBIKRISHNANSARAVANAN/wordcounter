package com.example.wordcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button btn1,btn2,btn3,btn4;
EditText txt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=(Button)findViewById(R.id.button1);
        btn2=(Button)findViewById(R.id.button2);
        btn3=(Button)findViewById(R.id.button3);
        txt1=(EditText)findViewById(R.id.text1);
        btn4=(Button)findViewById(R.id.buttonscan);
        Intent i=getIntent();
        String inputformsecondactivity=i.getStringExtra("value");
        txt1.setText(inputformsecondactivity);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input=txt1.getText().toString();
                String words[]=input.split("\\s");
                Toast.makeText(MainActivity.this,"words  "+String.valueOf(words.length),Toast.LENGTH_LONG).show();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input=txt1.getText().toString();
                Toast.makeText(MainActivity.this,"Character   "+String.valueOf(input.length()),Toast.LENGTH_LONG).show();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count=0;
                String input=txt1.getText().toString();
                char ch[]=input.toCharArray();
                for(int i=0;i<input.length();i++){
                    if(Character.isWhitespace(ch[i])){
                        count=count+1;
                    }
                }
                int withoutwhitespace=input.length()-count;
                Toast.makeText(MainActivity.this,"Character   "+String.valueOf(withoutwhitespace),Toast.LENGTH_LONG).show();
            }
        });


    }
}