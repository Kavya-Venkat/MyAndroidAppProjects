package com.main.sai.finaltry;

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
 * Created by KV035320 on 7/18/2017.
 */

/**
 * Created by KV035320 on 7/13/2017.
 */

public class Register extends AsyncTask<String,Void,String> {
    AlertDialog alertDialog;
    Context ctx;
    Register(Context ctx)
    {
        this.ctx =ctx;
    }
    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(ctx).create();
        alertDialog.setTitle("Register Information....");
    }
    @Override
    protected String doInBackground(String... params) {
        String reg_url = "http://192.168.43.199:8079/saiapp/register.php";
        //String login_url = "http://192.168.43.104:8080/saiapp/login.php";
        String method = params[0];
        String data="",FirstName,LastName,Address,City, Dist, State,Samiti,MobilePhone, EmailAddress, Education,Marital_status,Occupation,Other_Skill,
                Sex,CnvtSex,comments,Partiyatra,Prev_sadhana,Stu_Balvikas,Guru_Balvikas,Age,interest;
        String text = "",HomePhone;
        BufferedReader reader=null;
        if (method.equals("register")) {
            FirstName       = params[1];
            LastName        = params[2];
            Address         = params[3];
            City            = params[4];
            Dist            = params[5];
            State           = params[6];
            Samiti          = params[7];
            MobilePhone     = params[8];
            EmailAddress    = params[9];
            Education       = params[10];
            Marital_status  = params[11];
            Occupation      = params[12];
            Other_Skill     = params[13];
            CnvtSex             = params[14];
            if(CnvtSex.equalsIgnoreCase("Male"))
                Sex="1";
            else
                Sex="0";
            comments        = params[15];
            Partiyatra      = params[16];
            Prev_sadhana    = params[17];
            Stu_Balvikas    = params[18];
            Guru_Balvikas   = params[19];
            Age             = params[20];
            interest        = params[21];



            try {
                URL url = new URL(reg_url);
                URLConnection conn = url.openConnection();
                conn.setDoOutput(true);
                OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
                data =  URLEncoder.encode("FirstName","UTF-8") + "=" + URLEncoder.encode(FirstName, "UTF-8") + "&" +
                        URLEncoder.encode("LastName","UTF-8") + "=" + URLEncoder.encode(LastName, "UTF-8") + "&" +
                        URLEncoder.encode("Address","UTF-8") + "=" + URLEncoder.encode(Address, "UTF-8") + "&" +
                        URLEncoder.encode("City","UTF-8") + "=" + URLEncoder.encode(City, "UTF-8") + "&" +
                        URLEncoder.encode("Dist","UTF-8") + "=" + URLEncoder.encode(Dist, "UTF-8") + "&" +
                        URLEncoder.encode("State","UTF-8") + "=" + URLEncoder.encode(State, "UTF-8") + "&" +
                        URLEncoder.encode("Samiti","UTF-8") + "=" + URLEncoder.encode(Samiti, "UTF-8") + "&" +
                        URLEncoder.encode("MobilePhone","UTF-8") + "=" + URLEncoder.encode(MobilePhone, "UTF-8") + "&" +
                        URLEncoder.encode("EmailAddress","UTF-8") + "=" + URLEncoder.encode(EmailAddress, "UTF-8") + "&" +
                        URLEncoder.encode("Education","UTF-8") + "=" + URLEncoder.encode(Education, "UTF-8") + "&" +
                        URLEncoder.encode("Marital_status","UTF-8") + "=" + URLEncoder.encode(Marital_status, "UTF-8") + "&" +
                        URLEncoder.encode("Occupation","UTF-8") + "=" + URLEncoder.encode(Occupation, "UTF-8") + "&" +
                        URLEncoder.encode("Other_Skill","UTF-8") + "=" + URLEncoder.encode(Other_Skill, "UTF-8") + "&" +
                        URLEncoder.encode("Sex","UTF-8") + "=" + URLEncoder.encode(Sex, "UTF-8") + "&" +
                        URLEncoder.encode("comments","UTF-8") + "=" + URLEncoder.encode(comments, "UTF-8") + "&" +
                        URLEncoder.encode("Partiyatra","UTF-8") + "=" + URLEncoder.encode(Partiyatra, "UTF-8") + "&" +
                        URLEncoder.encode("Prev_sadhana","UTF-8") + "=" + URLEncoder.encode(Prev_sadhana, "UTF-8") + "&" +
                        URLEncoder.encode("Stu_Balvikas","UTF-8") + "=" + URLEncoder.encode(Stu_Balvikas, "UTF-8") + "&" +
                        URLEncoder.encode("Guru_Balvikas","UTF-8") + "=" + URLEncoder.encode(Guru_Balvikas, "UTF-8") + "&" +
                        URLEncoder.encode("Age","UTF-8") + "=" + URLEncoder.encode(Age, "UTF-8") + "&" +
                        URLEncoder.encode("interest","UTF-8") + "=" + URLEncoder.encode(interest,"UTF-8");
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
            Log.d("SAIRAM_OUTPUT",text);

            // Show response on activity



            return text;

        }

        return null;
    }
    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
    @Override
    protected void onPostExecute(String result) {
        if(result.contains("Data insertion success"))
        {
            Toast.makeText(ctx, "Registration Success", Toast.LENGTH_LONG).show();
            //need to test below https://stackoverflow.com/questions/7929953/moving-to-a-new-activity-based-upon-response-from-web-service
            //Intent showContent = new Intent(ctx.getApplicationContext(),activity_message.class);
            //ctx.startActivity(showContent);
        }
        else
        {
            Toast.makeText(ctx, "Could not register,Try again", Toast.LENGTH_LONG).show();
            alertDialog.setMessage(result);
            alertDialog.show();
        }
    }
}
//startActivity(new Intent(this,Main4Activity.class));