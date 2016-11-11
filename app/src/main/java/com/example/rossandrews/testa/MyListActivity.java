package com.example.rossandrews.testa;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rossandrews.testa.MenuAfterLogin.*;

import static com.example.rossandrews.testa.MenuAfterLogin.clients;

/**
 * Created by Ross Andrews on 11/11/2016.
 */

public class MyListActivity extends AppCompatActivity {
    private EditText ReceivedUsername;
    private EditText ReceivedPassword;
    private EditText ReceivedEmail;

    private Button saveChanges;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_list_activity);

        saveChanges = (Button) findViewById(R.id.buttonSave);

        String username = getIntent().getStringExtra("username");
        String password = getIntent().getStringExtra("password");
        String email = getIntent().getStringExtra("email");

        final int position = getIntent().getIntExtra("position", -1);

        ReceivedUsername = (EditText) findViewById(receivedTextUsername2);
        ReceivedUsername.setText(username);

        ReceivedPassword = (EditText) findViewById(receivedTextPassword2);
        ReceivedPassword.setText(password);

        ReceivedEmail = (EditText) findViewById(receivedTextEmail2);
        ReceivedEmail.setText(email);

        saveChanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String NewUsername = ReceivedUsername.getText().toString();
                String NewPassword = ReceivedPassword.getText().toString();
                String NewEmail = ReceivedEmail.getText().toString();

                Client client = new Client(NewUsername, NewPassword, NewEmail);

                clients.set(position, client);
                Toast.makeText(getBaseContext(), "Saved", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}
