package com.main.sai.frontend;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main3Activity extends Activity {

    ArrayList<String> selectedItems;
    private Spinner spinner1;
    String finalList="";
    String marital,Interests,age,other_int;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        selectedItems=new ArrayList<String>();
        checkedListFunction();
        addListenerOnSpinnerItemSelection();
        addListenerOnEditText();
        /*Intent intent=new Intent(Main3Activity.this,Main4Activity.class);
        Bundle b =new Bundle();
        b.putString("marital",marital);
        b.putString("Interests",Interests);
        b.putString("age",age);
        b.putString("other_int",other_int);
        intent.putExtras(b);*/



    }
    public void onNext(View view)
    {

        startActivity(new Intent(this,Main4Activity.class));
    }

    public void showSelectedItems(String selectedItem){

        Toast.makeText(this, selectedItem, Toast.LENGTH_LONG).show();
    }
    public void addListenerOnSpinnerItemSelection() {
        spinner1 = (Spinner) findViewById(R.id.marital_spinner);
        spinner1 .setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View selectedItemView, int pos, long id) {
                /*Toast.makeText(parent.getContext(),
                        "OnItemSelectedListener : " + parent.getItemAtPosition(pos).toString(),
                        Toast.LENGTH_SHORT).show();*/
                 marital=parent.getItemAtPosition(pos).toString();

                /*if (getString.equals("Married"))
                {
                    Switch mySwitch = (Switch) findViewById(R.id.sadhana_switch);
                    mySwitch.setVisibility(View.VISIBLE);
                    mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if (isChecked) {
                            }
                            Toast.makeText(getApplicationContext(), "Child going to BV", Toast.LENGTH_LONG).show();
                        }
                    });

                }*/
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
                marital="Single";

            }

        });


    }

    public void checkedListFunction()
    {
        //create an instance of ListView
        ListView chl=(ListView) findViewById(R.id.checkable_list);
        //set multiple selection mode
        chl.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        String[] items={"Information Technology","Veda Chanting","Bhajan","Gram Seva",
                "Medical Camp","Balvikas","Extra"};

        //supply data itmes to ListView
        ArrayAdapter<String> aa=new ArrayAdapter<String>(this,R.layout.list_activity,R.id.txt_title,items);
        chl.setAdapter(aa);
        //set OnItemClickListener
        chl.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // selected item
                String selectedItem = ((TextView) view).getText().toString();
                showSelectedItems(selectedItem);

                if(selectedItems.contains(selectedItem))
                    selectedItems.remove(selectedItem); //remove deselected item from the list of selected items
                else
                    selectedItems.add(selectedItem); //add selected item to the list of selected items

            }

        });
        for(int i=0; i<selectedItems.size();i++){
            finalList=finalList+selectedItems.get(i).toString()+" ";
        }
        Interests=finalList;

    }

    public void addListenerOnEditText(){
        EditText myTextBox = (EditText) findViewById(R.id.age_spinner);
        myTextBox.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged (Editable s){
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                //store the string s which contains the charseq
                //toast to check
               // Toast.makeText(getApplicationContext(), s,Toast.LENGTH_LONG).show();
                age=s.toString();

            }
        });
        myTextBox = (EditText) findViewById(R.id.other_interest);
        myTextBox.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged (Editable s){
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                //store the string s which contains the charseq
                //toast to check
               // Toast.makeText(getApplicationContext(), s,Toast.LENGTH_LONG).show();
                other_int=s.toString();

            }
        });
    }
}
//http://www.journaldev.com/14171/android-checkbox-example-listview