package com.example.magicidapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et ;
    TextView tv ;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = findViewById(R.id.et);
        tv = findViewById(R.id.tv);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et.getText().toString().trim().equalsIgnoreCase("")){
                    et.setError("ID Number cannot be empty");
                    Toast.makeText(MainActivity.this, "the field cannot be empty", Toast.LENGTH_SHORT).show();

                }else{
                    String ID = et.getText().toString();
                    String dao = ID.substring(0 ,6 );
                    int gender =Integer.parseInt(Character.toString(ID.charAt(6)));
                    String sGender ;
                    if  (gender < 5){
                        sGender ="Female";

                    }else{
                        sGender ="Male";

                    }
                    int nationality = Integer.parseInt(Character.toString((ID.charAt(10))));
                    String sNationality ;
                    if(nationality == 0)
                        sNationality = "SA Citizen";
                    else
                        sNationality = "Permanent Resident";
                    tv.setText("Date of Birth : "+dao + "\n" + "Gender : " +sGender+ "\n" +"Nationality : "+sNationality );
                    tv.setVisibility(View.VISIBLE);
                    }
            }
        });
    }
}