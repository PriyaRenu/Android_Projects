package com.priyars.priya.tables;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.priyars.priya.tables.R;

import java.util.Locale;

public class Main4Activity extends AppCompatActivity {
    public final static String MESSAGE_KEY ="Multiplication";

    TextToSpeech toSpeech;
    TextView t;
    Button bspeak,bstop;
    String text;
    int result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Intent intent = getIntent();
        t=(TextView)findViewById(R.id.textView2);
        bspeak=(Button) findViewById(R.id.imgPlay);
        //bpause=(ImageView)findViewById(R.id.imgPause);
        bstop=(Button) findViewById(R.id.imgStop);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

     //   String message = intent.getStringExtra(MESSAGE_KEY);
        int s=intent.getIntExtra (MESSAGE_KEY,1);
        //int s=Integer.parseInt(message);
        setTitle((s+1)+" Times Table");
        TextView textView = new TextView(this);
       // t.setElegantTextHeight(true);
       // t.setElegantTextHeight(true);
        t.setLines(25);
        //t.setMaxEms(100);
        t.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE);
        t.setMaxLines(25);
        t.setSingleLine(false);
       // for(int i=1;i<=1;i++)
        //{
         //   for(int j=1;j<=25;j++)
          //  {

          //  }
        //}
        //t.setGravity(1);
       t.setText("\t\t\t\t\t\t\t\t\t\t"+(s+1)+" * "+1 +"   = "+1*(s+1)+"\n"
                +"\t\t\t\t\t\t\t\t\t\t"+(s+1)+" * "+2 +"   = "+2*(s+1)+"\n"
                +"\t\t\t\t\t\t\t\t\t\t"+(s+1)+" * "+3 +"   = "+3*(s+1)+"\n"
                +"\t\t\t\t\t\t\t\t\t\t"+(s+1)+" * "+4 +"   = "+4*(s+1)+"\n"
                +"\t\t\t\t\t\t\t\t\t\t"+(s+1)+" * "+5 +"   = "+5*(s+1)+"\n"
                +"\t\t\t\t\t\t\t\t\t\t"+(s+1)+" * "+6 +"   = "+6*(s+1)+"\n"
                +"\t\t\t\t\t\t\t\t\t\t"+(s+1)+" * "+7 +"   = "+7*(s+1)+"\n"
                +"\t\t\t\t\t\t\t\t\t\t"+(s+1)+" * "+8 +"   = "+8*(s+1)+"\n"
                +"\t\t\t\t\t\t\t\t\t\t"+(s+1)+" * "+9 +"   = "+9*(s+1)+"\n"
                +"\t\t\t\t\t\t\t\t\t\t"+(s+1)+" * "+10 +" = "+10*(s+1)+"\n"
                +"\t\t\t\t\t\t\t\t\t\t"+(s+1)+" * "+11 +" = "+11*(s+1)+"\n"
                +"\t\t\t\t\t\t\t\t\t\t"+(s+1)+" * "+12 +" = "+12*(s+1)+"\n"
                +"\t\t\t\t\t\t\t\t\t\t"+(s+1)+" * "+13 +" = "+13*(s+1)+"\n"
                +"\t\t\t\t\t\t\t\t\t\t"+(s+1)+" * "+14 +" = "+14*(s+1)+"\n"
                +"\t\t\t\t\t\t\t\t\t\t"+(s+1)+" * "+15 +" = "+15*(s+1)+"\n"
                +"\t\t\t\t\t\t\t\t\t\t"+(s+1)+" * "+16 +" = "+16*(s+1)+"\n"
                +"\t\t\t\t\t\t\t\t\t\t"+(s+1)+" * "+17 +" = "+17*(s+1)+"\n"
                +"\t\t\t\t\t\t\t\t\t\t"+(s+1)+" * "+18 +" = "+18*(s+1)+"\n"
                +"\t\t\t\t\t\t\t\t\t\t"+(s+1)+" * "+19 +" = "+19*(s+1)+"\n"
                +"\t\t\t\t\t\t\t\t\t\t"+(s+1)+" * "+20 +" = "+20*(s+1)+"\n"
                +"\t\t\t\t\t\t\t\t\t\t"+(s+1)+" * "+21 +" = "+21*(s+1)+"\n"
                +"\t\t\t\t\t\t\t\t\t\t"+(s+1)+" * "+22 +" = "+22*(s+1)+"\n"
                +"\t\t\t\t\t\t\t\t\t\t"+(s+1)+" * "+23 +" = "+23*(s+1)+"\n"
                +"\t\t\t\t\t\t\t\t\t\t"+(s+1)+" * "+24 +" = "+24*(s+1)+"\n"
                +"\t\t\t\t\t\t\t\t\t\t"+(s+1)+" * "+25 +" = "+25*(s+1)+"\n");
        /*t.setText( for(int i=1;i<=1;i++) {
            int sum=i*(s+1);
            t.setText(1*(s+1)+"\n "+2*(s+1)+"\n"+3*(s+1));
            String add=" ";
            add=(add+(s+1)+" * "+i +" = "+sum+"\n");

            t.setText(add);
            System.out.println(add);
            sum=0;
        });/*
        /*@Override
        protected void onDestroy() {
            super.onDestroy();
            if (toSpeech!=null)
            {
                toSpeech.stop();
                toSpeech.shutdown();
            }
        }*/
        toSpeech=new TextToSpeech(Main4Activity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status==TextToSpeech.SUCCESS)
                {
                    result=toSpeech.setLanguage(Locale.UK);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Feature not supported in your device",Toast.LENGTH_SHORT).show();
                }
            }
        });
        bspeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bspeak.playSoundEffect(android.view.SoundEffectConstants.CLICK);
                if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED)
                {
                    Toast.makeText(getApplicationContext(),"Feature not supported in your device",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"wait for a second to play",Toast.LENGTH_SHORT).show();
                    text = t.getText().toString();
                    toSpeech.setPitch(0.5f);
                    toSpeech.setSpeechRate(1f);
                    toSpeech.speak(text,TextToSpeech.QUEUE_FLUSH,null);
                }}
        });
       /* bpause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
        public void onDestroy( )
        {
                    // Don't forget to shutdown tts!
                    if (toSpeech!= null) {
                        toSpeech.stop();
                        toSpeech.shutdown();
                    }
                    super.onDestroy();
                }
          //  }
        //});*/

        bstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bstop.playSoundEffect(android.view.SoundEffectConstants.CLICK);

                if (toSpeech!=null)
                {

                    Toast.makeText(getApplicationContext(),"Stopped",Toast.LENGTH_SHORT).show();
                    toSpeech.stop();
                }
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
