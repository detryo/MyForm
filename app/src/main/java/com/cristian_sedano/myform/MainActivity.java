package com.cristian_sedano.myform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextName;
    Button buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setIcon(R.mipmap.ic_from);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        editTextName = (EditText) findViewById(R.id.EditTextUserName);
        buttonNext = (Button) findViewById(R.id.buttonToSecondActivity);

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editTextName.getText().toString();

                if (name != null && !name.isEmpty()){
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("name", name);
                    startActivity(intent);
                }else {
                    Toast.makeText(MainActivity.this, "The name is mandatory, plese type it", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
