package com.example.lenovo.ceaser_cipher;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import 	android.text.TextUtils;

import java.lang.reflect.Array;
import java.security.KeyStore;

public class Main2Activity extends AppCompatActivity {
Button b1,b2;
String plain="";
TextView t1;
char ch;
EditText e1,e2;
    char[] ceaser1;
    int no;
    int ascii;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        e1=(EditText)findViewById(R.id.ee1);
        e2=(EditText)findViewById(R.id.eee);
        t1=(TextView)findViewById(R.id.tt3);
        ceaser1=new char[50];
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //ceaser1=null;
        final Context context = this;
        b1=(Button)findViewById(R.id.bb1);
        b2=(Button)findViewById(R.id.bb2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 String plainText= String.valueOf(e1.getText());
                final char[] ceaser=plainText.toCharArray();
                System.out.println(plainText);
                System.out.println(ceaser.length);
                String s=e2.getText().toString();
                no=Integer.parseInt(s);
                System.out.println(no);
                if(TextUtils.isEmpty(plainText))
                {
                    e1.setError("This item can't be empty ");
                    //e1.setSoundEffectsEnabled();
                }
                else if(TextUtils.isEmpty(s))
                {
                    e2.setError("This item can't be empty");
                }
                else {
                        for (int i = 0; i < ceaser.length; ++i) {
                            ch = plainText.charAt(i);

                            if (ch >= 'a' && ch <= 'z') {
                                ch = (char) (ch + no);

                                if (ch > 'z') {
                                    ch = (char) (ch - 'z' + 'a' - 1);
                                }

                                plain += ch;
                                System.out.println("1." + plain);
                            } else if (ch >= 'A' && ch <= 'Z') {
                                ch = (char) (ch + no);

                                if (ch > 'Z') {
                                    ch = (char) (ch - 'Z' + 'A' - 1);
                                }

                                plain += ch;
                                System.out.println("2." + plain);
                            } else {
                                plain += ch;
                                System.out.println("3." + plain);
                            }
                        }
                    }
                 //   Toast.makeText(getApplicationContext(), "Enter the Data's in the blank ", Toast.LENGTH_LONG).show();

              /*  if((plainText!=" ")||no != 0 ) {
                    for (int i = 0; i < ceaser.length; i++) {
                        // System.out.println(plainText.charAt(i));
                          /*if(plainText.charAt(i)!=0)
                              ceaser1[i] ='\0';
                        ascii = (int) plainText.charAt(i);
                        ascii = ascii - 97;
                        ascii = ((ascii + no) % 26);
                        ascii = ascii + 97;
                        ceaser1[i] = (char) ascii;
                        //   System.out.println(ceaser1[i]);
                    }
                }

                    else
                        Toast.makeText(getApplicationContext(), "Enter the Data's in the blank ", Toast.LENGTH_LONG).show();
                    //Toast.makeText(getApplicationContext(),"Enter the word to Decrypt",Toast.LENGTH_SHORT).show();
                for(int i1=0;i1<ceaser1.length;i1++)
                {
                    if(ceaser1[i1]=='W')
                        ceaser1[i1]=' ';
                  //  System.out.print("hello ");
                  //  System.out.println(ceaser1[i1]);
                }
                String value=new String(ceaser1);*/
                t1.setText(plain);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                plain=" ";
                e1.getText().clear();
                e2.getText().clear();
                t1.setText(plain);
            }
        });
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
