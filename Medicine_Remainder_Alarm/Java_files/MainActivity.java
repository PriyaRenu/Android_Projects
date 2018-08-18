package com.example.priya.remaider_alarm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    ImageView imageRemove;
    ListView simpleList;
    Button b1;
    String text;
    int position=1;
    int count=0;
    RemainList remainList;
    ArrayList<Remain> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        remainList = new RemainList(this, list);
        simpleList = (ListView) findViewById(R.id.v);
        b1 = (Button) findViewById(R.id.b1);
        simpleList.setAdapter(remainList);
        Intent i = getIntent();
        final Remain m=new Remain();
       text = i.getStringExtra ( "TextBox" );
       list.add(m);
      // list.add(new Remain(null,null,null,null,null));
        imageRemove = (ImageView) findViewById(R.id.imgAdd);

            imageRemove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    count=count+1;
                    //if(count==1) {
                        Remain re = new Remain(remainList.text, remainList.mrngString, remainList.aftString, remainList.eveString, remainList.ni8String);
                        saveUpdate(re);
                        list.add(m);
                        remainList.notifyDataSetChanged();
                        // myRef.push().setValue(re);
                   // myRef.updateChildren(childUpdate);
                    // remainList.notifyDataSetChanged()
                }

            });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // myRef.updateChildren(childUpdate);
            }
        });

    }

   private void saveUpdate(Remain re) {

       FirebaseDatabase database = FirebaseDatabase.getInstance();
       DatabaseReference myRef = database.getReference().child(text);
       String key = myRef.push().getKey();
       Map<String, Object> msgValues = re.toMap();
       Map<String, Object> childUpdate = new HashMap<>();
       childUpdate.put(String.valueOf(position), msgValues);
       position++;
       myRef.updateChildren(childUpdate);


    }
}
