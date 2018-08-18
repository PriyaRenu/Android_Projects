package com.example.priya.remaider_alarm;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Listview_bar extends AppCompatActivity {
EditText userName;
Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_bar);
        userName=(EditText)findViewById(R.id.userName);
        final Context context = this;
        b1=(Button)findViewById(R.id.button2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MainActivity.class);
                intent.putExtra ( "TextBox", userName.getText().toString() );
                startActivity(intent);
            }
        });

    }
}
