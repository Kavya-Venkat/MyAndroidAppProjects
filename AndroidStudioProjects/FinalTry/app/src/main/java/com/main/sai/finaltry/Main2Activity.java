package com.main.sai.finaltry;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;

import java.util.ArrayList;

import static com.main.sai.finaltry.R.id.email;

public class Main2Activity extends Activity {
    String data="",FirstName="",LastName="",Address="",City="", Dist="", State="",Samiti="",MobilePhone="",
            EmailAddress="", Education="",Marital_status="",Occupation="",Other_Skill="",
            Sex="Male",comments="",Partiyatra="0",Prev_sadhana="0",Stu_Balvikas="0",Guru_Balvikas="0",
            Age="0",interest="";
    private Spinner stateSpin,distSpin,samitiSpin,genderSpin,eduSpin,occSpin;
    private Spinner spinner1;
    private CheckBox chkIT,chkVC,chkBH,chkGM,chkMC,chkBV;
    ArrayList<String> selectedItems=new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Main1Activity calls
        addListenerOnEditText_1();
        //Main2Activity calls
        addListenerOnSpinnerItemSelection_2();
        addListenerOnCheckedList();

        //Main3Activity calls
        addListenerOnSpinnerItemSelection_3();
        addListenerOnEditText_3();
        //Main4Activity calls
        addListenerOnEditText_4();
        addListenerOnSwitch();
    }

    //calls Register class having main functionality
    public void userReg(View view)
    {
        String finalList="";
        for(int i=0; i<selectedItems.size();i++){
            finalList=finalList+selectedItems.get(i).toString()+" , ";
        }
        interest=finalList;
        String data=FirstName+" "+LastName+" "+Address+" "+City+" "+Dist+" "+State+" "+Samiti+" "+MobilePhone+" "+EmailAddress+" "+Education
                +" "+Marital_status+" "+Occupation+" "+Other_Skill+" "+Sex+" "+comments+" "+Partiyatra+" "+Prev_sadhana+" "+Stu_Balvikas+" "+Guru_Balvikas+" "+Age+
                " "+interest;
        Log.d("SAIRAM_PLEASE",data);
        String method = "register";
        Register register = new Register(this);
        register.execute(method,FirstName,LastName,Address,City, Dist, State,Samiti,MobilePhone, EmailAddress, Education,Marital_status,Occupation,Other_Skill,
                Sex,comments,Partiyatra,Prev_sadhana,Stu_Balvikas,Guru_Balvikas,Age,interest);
        finish();
    }

    //Main1Activity for Name,address,etc

    public void addListenerOnEditText_1(){
        EditText myTextBox = (EditText) findViewById(R.id.fname);
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
                //Toast.makeText(getApplicationContext(), s,Toast.LENGTH_LONG).show();
                FirstName=s.toString();

            }
        });

        myTextBox = (EditText) findViewById(R.id.lname);
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
                //Toast.makeText(getApplicationContext(), s,Toast.LENGTH_LONG).show();
                LastName=s.toString();

            }
        });

        myTextBox = (EditText) findViewById(R.id.mobnum);
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
                //Toast.makeText(getApplicationContext(), s,Toast.LENGTH_LONG).show();
                MobilePhone=s.toString();

            }
        });
        myTextBox = (EditText) findViewById(email);
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
                //Toast.makeText(getApplicationContext(), s,Toast.LENGTH_LONG).show();
                EmailAddress=s.toString();

            }
        });

        myTextBox = (EditText) findViewById(R.id.addr);
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
                //Toast.makeText(getApplicationContext(), s,Toast.LENGTH_LONG).show();
                Address=s.toString();
            }
        });

        myTextBox = (EditText) findViewById(R.id.city);
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
                City=s.toString();

            }
        });
    }

    //Main2Activity for Spinners - State,samiti,gender,etc
    public void addListenerOnSpinnerItemSelection_2()
    {
        stateSpin = (Spinner) findViewById(R.id.state_spinner);
        stateSpin .setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View selectedItemView, int pos, long id) {

                State = parent.getItemAtPosition(pos).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                State="TamilNadu";
                // your code here
            }
        });

        distSpin = (Spinner) findViewById(R.id.dist_spinner);
        distSpin.setOnItemSelectedListener(new  AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View selectedItemView, int pos, long id) {
            /*Toast.makeText(parent.getContext(),
                    "OnItemSelectedListener : " + parent.getItemAtPosition(pos).toString(),
                    Toast.LENGTH_SHORT).show();*/
                Dist = parent.getItemAtPosition(pos).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
                Dist="Erode";
            }
        });

        samitiSpin = (Spinner) findViewById(R.id.samithi_spinner);
        samitiSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View selectedItemView, int pos, long id) {
                /*Toast.makeText(parent.getContext(),
                        "OnItemSelectedListener : " + parent.getItemAtPosition(pos).toString(),
                        Toast.LENGTH_SHORT).show();*/
                Samiti = parent.getItemAtPosition(pos).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                Samiti = "NA";
                // your code here
            }
        });

        genderSpin = (Spinner) findViewById(R.id.gender_spinner);
        genderSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View selectedItemView, int pos, long id) {
                /*Toast.makeText(parent.getContext(),
                        "OnItemSelectedListener : " + parent.getItemAtPosition(pos).toString(),
                        Toast.LENGTH_SHORT).show();*/
                Sex = parent.getItemAtPosition(pos).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                Sex="Male";
                // your code here
            }
        });

        eduSpin = (Spinner) findViewById(R.id.education_spinner);
        eduSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View selectedItemView, int pos, long id) {
                /*Toast.makeText(parent.getContext(),
                        "OnItemSelectedListener : " + parent.getItemAtPosition(pos).toString(),
                        Toast.LENGTH_SHORT).show();*/
                Education = parent.getItemAtPosition(pos).toString();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                Education="Graduate";
                // your code here
            }
        });

        occSpin = (Spinner) findViewById(R.id.occupation_spinner);
        occSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View selectedItemView, int pos, long id) {
               /* Toast.makeText(parent.getContext(),
                        "OnItemSelectedListener : " + parent.getItemAtPosition(pos).toString(),
                        Toast.LENGTH_SHORT).show();*/
                Occupation = parent.getItemAtPosition(pos).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                Occupation="Engineer";
                // your code here
            }
        });

    }

    public void addListenerOnCheckedList()
    {
        chkIT = (CheckBox) findViewById(R.id.chkIT);

        chkIT.setOnClickListener(new OnClickListener() {
            String selectedItem=chkIT.getText().toString();
            @Override
            public void onClick(View v) {
                //is chkIos checked?
                if (((CheckBox) v).isChecked()) {
                    //interest=interest+","+"InformationTechnology ";
                    selectedItems.add(selectedItem);
                }
                else if (selectedItems.contains(selectedItem))
                {
                    selectedItems.remove(selectedItem);
                }


            }
        });

        chkBV = (CheckBox) findViewById(R.id.chkBV);

        chkBV.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                //is chkIos checked?
                String selectedItem=chkBV.getText().toString();
                if (((CheckBox) v).isChecked()) {
                    //interest=interest+","+"BalVikas ";
                    selectedItems.add(selectedItem);
                }
                else if (selectedItems.contains(selectedItem))
                {
                    selectedItems.remove(selectedItem);
                }


            }
        });

        chkGM = (CheckBox) findViewById(R.id.chkGM);

        chkGM.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                //is chkIos checked?
                String selectedItem=chkGM.getText().toString();
                if (((CheckBox) v).isChecked()) {
                    //interest=interest+","+"GramSeva ";
                    selectedItems.add(selectedItem);
                }
                else if (selectedItems.contains(selectedItem))
                {
                    selectedItems.remove(selectedItem);
                }

            }
        });

        chkBH = (CheckBox) findViewById(R.id.chkBH);

        chkBH.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                //is chkIos checked?
                String selectedItem=chkBH.getText().toString();
                if (((CheckBox) v).isChecked()) {
                    //interest=interest+","+"Bhajan ";
                    selectedItems.add(selectedItem);
                }
                else if (selectedItems.contains(selectedItem))
                {
                    selectedItems.remove(selectedItem);
                }

            }
        });

        chkMC = (CheckBox) findViewById(R.id.chkMC);

        chkMC.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                //is chkIos checked?
                String selectedItem=chkMC.getText().toString();
                if (((CheckBox) v).isChecked()) {
                   // interest=interest+","+"Medical Camp ";
                    selectedItems.add(selectedItem);
                }
                else if (selectedItems.contains(selectedItem))
                {
                    selectedItems.remove(selectedItem);
                }

            }
        });

        chkVC = (CheckBox) findViewById(R.id.chkVC);

        chkVC.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                //is chkIos checked?
                String selectedItem=chkVC.getText().toString();
                if (((CheckBox) v).isChecked()) {
                  //  interest=interest+"VedaChanting";
                    selectedItems.add(selectedItem);
                }
                else if (selectedItems.contains(selectedItem))
                {
                    selectedItems.remove(selectedItem);
                }

            }
        });
    }


    //Main3Activity for marital,age,checked list
    public void addListenerOnSpinnerItemSelection_3() {
        spinner1 = (Spinner) findViewById(R.id.marital_spinner);
        spinner1 .setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View selectedItemView, int pos, long id) {
                /*Toast.makeText(parent.getContext(),
                        "OnItemSelectedListener : " + parent.getItemAtPosition(pos).toString(),
                        Toast.LENGTH_SHORT).show();*/
                Marital_status=parent.getItemAtPosition(pos).toString();

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
                Marital_status="Single";

            }

        });


    }

    public void addListenerOnEditText_3(){
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
                Age=s.toString();

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
                Other_Skill=s.toString();

            }
        });
    }
    //Main4Activity for COMMENT
    public void addListenerOnEditText_4()
    {
        EditText myTextBox = (EditText) findViewById(R.id.comment);
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
                //Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
                comments=s.toString();
            }
        });
    }

    //Main4Activity for SWITCHES - Parti yatra,etc
    public void addListenerOnSwitch()
    {
        Switch mySwitch=(Switch)findViewById(R.id.sadhana_switch);
        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Prev_sadhana="1";
                }
                else
                    Prev_sadhana="0";
                // Toast.makeText(getApplicationContext(),"Attended",Toast.LENGTH_LONG).show();
            }
        });

        mySwitch=(Switch)findViewById(R.id.yatra_switch);
        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Partiyatra="1";
                }
                else
                    Partiyatra="0";
                // Toast.makeText(getApplicationContext(),"Parti yatra",Toast.LENGTH_LONG).show();
            }
        });

        mySwitch=(Switch)findViewById(R.id.guru_switch);
        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Guru_Balvikas="1";
                }
                else
                    Guru_Balvikas="0";
                ///Toast.makeText(getApplicationContext(),"Balvikas guru",Toast.LENGTH_LONG).show();
            }
        });

        mySwitch=(Switch)findViewById(R.id.stud_switch);
        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Stu_Balvikas="1";
                }
                else
                    Stu_Balvikas="0";
                // Toast.makeText(getApplicationContext(),"BV Student",Toast.LENGTH_LONG).show();
            }
        });
    }


}
