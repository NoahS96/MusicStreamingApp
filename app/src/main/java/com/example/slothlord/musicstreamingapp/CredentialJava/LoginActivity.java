package com.example.slothlord.musicstreamingapp.CredentialJava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.slothlord.musicstreamingapp.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText email_input = (EditText) findViewById(R.id.email_input);
        final EditText password_input = (EditText) findViewById(R.id.password_input);


        Button login = (Button) findViewById(R.id.login_button);
        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                String email = email_input.getText().toString();
                String password = password_input.getText().toString();

                if (!email.isEmpty() && !password.isEmpty()) {
                    LoginController controller = new LoginController();
                    System.out.println("Email: " + email + "\tPassword: " + password);
                    controller.checkCredentials(email, password);
                } else {
                    Toast.makeText(view.getContext(), "Fill all input areas", Toast.LENGTH_SHORT);
                }

                //Intent myIntent = new Intent(view.getContext(), NewsFeedActivity.class);
                //startActivityForResult(myIntent, 0);
            }

        });    }
}
