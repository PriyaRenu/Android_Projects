package com.example.lenovo.ceaser_cipher;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    Button b1,b2;
    TextView t1;
    EditText e1, e2;
    char[] ceaser1;
    int no;
    int ascii;
    char ch;
    String plain="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        e1 = (EditText) findViewById(R.id.e1);
        e2 = (EditText) findViewById(R.id.eeee);
        t1 = (TextView) findViewById(R.id.t3);
        ceaser1 = new char[50];
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final Context context = this;
        b1 = (Button) findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
       // b3=(Button)findViewById(R.id.b3);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String plainText = String.valueOf(e1.getText());
                final char[] ceaser = plainText.toCharArray();
                no = Integer.parseInt(e2.getText().toString());
                System.out.println(no);
                if(TextUtils.isEmpty(plainText))
                {
                    e1.setError("This item can't be empty ");
                }
                else if(no==0)
                {
                    e2.setError("This item can't be empty");
                }
                else {
                    for (int i = 0; i < ceaser.length; ++i) {
                        ch = plainText.charAt(i);

                        if (ch >= 'a' && ch <= 'z') {
                            ch = (char) (ch - no);

                            if (ch < 'a') {
                                ch = (char) (ch + 'z' - 'a' + 1);
                            }

                            plain += ch;
                        } else if (ch >= 'A' && ch <= 'Z') {
                            ch = (char) (ch - no);

                            if (ch < 'A') {
                                ch = (char) (ch + 'Z' - 'A' + 1);
                            }

                            plain += ch;
                        } else {
                            plain += ch;
                        }
                    }
                }
                t1.setText(plain);
            }

        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                plain="";
                e1.getText().clear();
                e2.getText().clear();
                t1.setText(plain);
            }
        });
       // b3.setOnClickListener(new View.OnClickListener() {
         //   @Override
           // public void onClick(View view) {
             //   Intent intent = new Intent(context, splash_screen.class);
               // startActivity(intent);
           // }
        //});

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}
