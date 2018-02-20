package com.main.sai.regapp;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * Created by KV035320 on 7/13/2017.
 */

public class Background extends AsyncTask<String,Void,String> {
    AlertDialog alertDialog;
    Context ctx;
    Background(Context ctx)
    {
        this.ctx =ctx;
    }
    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(ctx).create();
        alertDialog.setTitle("Login Information....");
    }
    @Override
    protected String doInBackground(String... params) {
        String reg_url = "http://192.168.0.114:8079/saiapp_1/register.php";
        //String login_url = "http://192.168.43.104:8080/saiapp/login.php";
        String method = params[0];
        String data="",FirstName,LastName,Address,City, Dist, State, HomePhone, MobilePhone, EmailAddress, Education,Occupation,Skill,Lang_cd,Sex,sevafrequency,Partiyatra,Stu_Balvikas,Guru_Balvikas,Age,inareas;
        String text = "";
        BufferedReader reader=null;
        if (method.equals("register")) {
            FirstName = params[1];
            LastName = params[2];
            Address = params[3];
            City = params[4];
            Dist = params[5];
            State = params[6];
            HomePhone = params[7];
            MobilePhone = params[8];
            EmailAddress = params[9];
            Sex = "1";
            Partiyatra="0";
            Stu_Balvikas="1";
            Guru_Balvikas="0";
            Education = params[10];
            Occupation="SOFTWARE";// ENGINEER";
            Skill="Music";
            Lang_cd="HINDI";//,TAMIL,ENGLISH";
            Age="23";
            sevafrequency="WEEKLY";
            inareas="MUSIC";//,BHAJAN,VEDAM,SERVICE";

            try {
                URL url = new URL(reg_url);
                URLConnection conn = url.openConnection();
                conn.setDoOutput(true);
                OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
                data = URLEncoder.encode("FirstName","UTF-8") + "=" + URLEncoder.encode(FirstName, "UTF-8") + "&" +
                        URLEncoder.encode("LastName","UTF-8") + "=" + URLEncoder.encode(LastName, "UTF-8") + "&" +
                        URLEncoder.encode("Address","UTF-8") + "=" + URLEncoder.encode(Address,      "UTF-8") + "&" +
                        URLEncoder.encode("City","UTF-8") + "=" + URLEncoder.encode(City,      "UTF-8") + "&" +
                        URLEncoder.encode("Dist","UTF-8") + "=" + URLEncoder.encode(Dist,      "UTF-8") + "&" +
                        URLEncoder.encode("State","UTF-8") + "=" + URLEncoder.encode(State,      "UTF-8") + "&" +
                        URLEncoder.encode("HomePhone","UTF-8") + "=" + URLEncoder.encode(HomePhone,      "UTF-8") + "&" +
                        URLEncoder.encode("MobilePhone","UTF-8") + "=" + URLEncoder.encode(MobilePhone,      "UTF-8") + "&" +
                        URLEncoder.encode("EmailAddress","UTF-8") + "=" + URLEncoder.encode(EmailAddress,      "UTF-8") + "&" +
                        URLEncoder.encode("Sex","UTF-8") + "=" + URLEncoder.encode(Sex,      "UTF-8") + "&" +
                        URLEncoder.encode("Partiyatra","UTF-8") + "=" + URLEncoder.encode(Partiyatra,      "UTF-8") + "&" +
                        URLEncoder.encode("Stu_Balvikas","UTF-8") + "=" + URLEncoder.encode(Stu_Balvikas,      "UTF-8") + "&" +
                        URLEncoder.encode("Guru_Balvikas","UTF-8") + "=" + URLEncoder.encode(Guru_Balvikas,      "UTF-8") + "&" +
                        URLEncoder.encode("Education","UTF-8") + "=" + URLEncoder.encode(Education,      "UTF-8") + "&" +
                        URLEncoder.encode("Occupation","UTF-8") + "=" + URLEncoder.encode(Occupation,      "UTF-8") + "&" +
                        URLEncoder.encode("Skill","UTF-8") + "=" + URLEncoder.encode(Skill,      "UTF-8") + "&" +
                        URLEncoder.encode("Lang_cd","UTF-8") + "=" + URLEncoder.encode(Lang_cd,      "UTF-8") + "&" +
                        URLEncoder.encode("Age","UTF-8") + "=" + URLEncoder.encode(Age,      "UTF-8") + "&" +
                        URLEncoder.encode("sevafrequency","UTF-8") + "=" + URLEncoder.encode(sevafrequency,      "UTF-8") + "&" +
                        URLEncoder.encode("inareas","UTF-8") + "=" + URLEncoder.encode(inareas, "UTF-8");
                Log.d("SAIRAM_MESSAGE",data);
                wr.write( data );
                wr.flush();

                // Get the server response

                reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line = null;

                // Read Server Response
                while((line = reader.readLine()) != null)
                {
                    // Append server response in string
                    sb.append(line + "\n");
                }


                text = sb.toString();
            }
            catch(Exception ex)
            {

            }
            finally
            {
                try
                {

                    reader.close();
                }

                catch(Exception ex) {}
            }

            // Show response on activity


            //Log.d("SAIRAM_MESSAGE",text);
            return "Registration Success...";

        }

        return null;
    }
    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
    @Override
    protected void onPostExecute(String result) {
        if(result.equals("Registration Success..."))
        {
            Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
        }
        else
        {
            alertDialog.setMessage(result);
            alertDialog.show();
        }
    }
}