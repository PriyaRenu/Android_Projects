package com.example.priya.remaider_alarm;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RemainList extends ArrayAdapter<Remain>{
    private List<Remain> remain;
    private Activity activity;
   // String text,mrng,aftn,eve,ni8;
    //static int position=1;
    int id;
    private static LayoutInflater inflater=null;
    EditText edtMedicine;
    ImageView imageRemove;
    String text,mrngString,aftString,eveString,ni8String;
    CheckBox checkMorning,checkNoon,checkEven,checkNight;
    TextView t1,t2,t3,t4,t5;
    public RemainList(Activity activity,List<Remain> remain){
        super(activity,R.layout.list_main,remain);
    this.activity=activity;
    this.remain=remain;

        inflater = ( LayoutInflater )activity.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    public int getCount() {

        if(remain.size()<=0)
            return 1;
        return remain.size();
    }

    //public int getItem(int position) {return position;}

    public long getItemId(int position) {
        return position;
    }
    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listViewItem=convertView;
        if(convertView==null) {
            LayoutInflater inflater = activity.getLayoutInflater();
            //this.position=position;
            // final View listViewItem = inflater.inflate(R.layout.list_main, null, true);
              listViewItem=inflater.inflate(R.layout.list_main ,null);

            //   View lisetselect = inflater.inflate(R.layout.selec_txt, null, true);
            checkMorning = (CheckBox) listViewItem.findViewById(R.id.c1);
            checkNoon = (CheckBox) listViewItem.findViewById(R.id.c2);
            checkEven = (CheckBox) listViewItem.findViewById(R.id.c3);
            checkNight = (CheckBox) listViewItem.findViewById(R.id.c4);
           imageRemove = (ImageView) listViewItem.findViewById(R.id.imgRemove);
            edtMedicine = (EditText) listViewItem.findViewById(R.id.s1);
        }
        else
            convertView.getTag();
        if(remain.size()==0)
        {

        }
        else {
          /*  text = new ArrayList<String>()
            mrng = new ArrayList<String>();
            aftn = new ArrayList<String>();
            eve = new ArrayList<String>();
            ni8 = new ArrayList<String>();*/
       /*   mrngString=new String[50];
          text =new String[50];
          aftString=new String[50];
          eveString=new String[50];
          ni8String=new String[50];*/
            /// text = edtMedicine.getText().toString();
            /// text.add(p);

            mrngString = "False";
            aftString = "False";
            eveString = "False";
            ni8String = "False";

            final View finalListViewItem = listViewItem;
            edtMedicine.addTextChangedListener(new
                                                       TextWatcher() {
                                                           @Override
                                                           public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                                           }

                                                           @Override
                                                           public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                                                               EditText edtMedicine1 = (EditText) finalListViewItem.findViewById(R.id.s1);
                                                               text = edtMedicine1.getText().toString();
                                                               System.out.println("priya crispy" + text);
                                                           }

                                                           @Override
                                                           public void afterTextChanged(Editable editable) {

                                                           }
                                                       });

                                                   /*edtMedicine.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (!b) {
                    text = edtMedicine.getText().toString();
                }
            }
        });*/
            //mrng="False";
            checkMorning.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    //text=edtMedicine.getText().toString().trim();
                    // System.out.println("Inside Name"+text);
                    if (isChecked) {
                        mrngString = "True";
                        // mrng.add(mrngString);
                        System.out.println("Morning" + mrngString);
                    } else {
                        mrngString = "False";
                        // mrng.add(mrngString);
                        System.out.println("Morning" + mrngString);
                    }
                }
            });

            checkNoon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        aftString = "True";
                        // aftn.add(aftString);
                        System.out.println("Afternoon" + aftString);

                    } else {
                        aftString = "False";
                        // aftn.add(aftString);
                        System.out.println("Afternoon" + aftString);
                    }
                }
            });
            checkEven.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        eveString = "True";
                        // eve.add(eveString);
                        System.out.println("Evening" + eveString);
                    } else {

                        eveString = "False";
                        // eve.add(eveString);
                        System.out.println("Evening" + eveString);
                    }
                }
            });
            checkNight.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        ni8String = "TRUE";
                        //   ni8.add(ni8String);
                        System.out.println("Night" + ni8String);

                    } else {
                        ni8String = "False";
                        //   ni8.add(ni8String);
                        System.out.println("Night" + ni8String);

                    }
                }

            });
            imageRemove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    remain.remove(position);
                    Toast.makeText(activity.getApplicationContext(),""+position, Toast.LENGTH_LONG).show();
                    notifyDataSetChanged();
                }
            });

       /* edtMedicine.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                text=edtMedicine.getText().toString().trim();
                System.out.println("Inside Name"+text);

            }
        });*/
            Remain r = remain.get(position);
            edtMedicine.setText(r.getMedicineName());
            checkMorning.setText(remain.get(position).getMorngTime());
            checkNoon.setText(remain.get(position).getAftnTime());
            checkEven.setText(remain.get(position).getEveTime());
            checkNight.setText(remain.get(position).getNi8Time());

        }
        return listViewItem;
    }
}
