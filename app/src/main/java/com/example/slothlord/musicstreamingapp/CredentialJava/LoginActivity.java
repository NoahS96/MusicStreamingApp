package com.example.slothlord.musicstreamingapp.CredentialJava;

import android.content.Context;
import android.content.Intent;
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

        final Context context = this;
        final EditText email_input = (EditText) findViewById(R.id.email_input);
        final EditText password_input = (EditText) findViewById(R.id.password_input);


        Button login = (Button) findViewById(R.id.login_button);
        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                String email = email_input.getText().toString();
                String password = password_input.getText().toString();

                if (!email.isEmpty() && !password.isEmpty()) {
                    LoginController controller = new LoginController(context);
                    System.out.println("Email: " + email + "\tPassword: " + password);
                    controller.checkCredentials(email, password);

                } else {
                    Toast.makeText(getApplicationContext(), "Fill all input areas", Toast.LENGTH_SHORT).show();
                }

                //Intent myIntent = new Intent(view.getContext(), NewsFeedActivity.class);
                //startActivityForResult(myIntent, 0);
            }

        });

        Button signup_button = (Button) findViewById(R.id.signup_button);
        signup_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iSignup = new Intent(context, SignupActivity.class);
                startActivity(iSignup);
            }
        });
    }
}
