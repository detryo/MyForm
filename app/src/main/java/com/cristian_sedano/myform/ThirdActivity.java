package com.cristian_sedano.myform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {

    ImageButton imageButtonConfirm;
    Button buttonSharing;

    private String name;
    private int age;
    private int typeOfMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null){
            age = bundle.getInt("age");
            name = bundle.getString("name");
            typeOfMessage = bundle.getInt("option");
        }

        imageButtonConfirm = (ImageButton) findViewById(R.id.imageButtonConfirm);
        buttonSharing = (Button) findViewById(R.id.buttonSharing);

        imageButtonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ThirdActivity.this, createMessage(name, age, typeOfMessage), Toast.LENGTH_SHORT).show();
                buttonSharing.setVisibility(View.VISIBLE);
                imageButtonConfirm.setVisibility(View.INVISIBLE);
            }
        });

        buttonSharing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, createMessage(name, age, typeOfMessage));
                startActivity(intent);
            }
        });


    }

    private String createMessage(String name, int age, int typeOfMessage){

        if (typeOfMessage == SecondActivity.GREETER_OPTION){
            return "Hello"  +name+  "How are your spending those"  +age+  "years?";

        }else {
            return"C'ya soon"  +name;
        }

    }
}
