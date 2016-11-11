package com.example.rossandrews.testa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View v){
        Log.d("Main", ""+v.getId());
        if(v.getId() == R.id.LOGIN_Button){
            Log.d("MAIN", "Hello");
            EditText user = (EditText) findViewById(R.id.TF_UserName);
            EditText pass = (EditText) findViewById(R.id.TF_Password);

            Intent intent = new Intent(MainActivity.this, MenuAfterLogin.class);
            intent.putExtra("Username", user.getText().toString());
            intent.putExtra("Password", pass.getText().toString());
            startActivityForResult(intent, 0);

        }
    }

    @Override
    public void onClick(View v) {

    }
}
