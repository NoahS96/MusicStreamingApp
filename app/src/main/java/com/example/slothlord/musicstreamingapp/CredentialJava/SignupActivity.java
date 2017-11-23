package com.example.slothlord.musicstreamingapp.CredentialJava;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.slothlord.musicstreamingapp.R;

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        final Context context = this;
        final EditText email_input = (EditText) findViewById(R.id.new_email_input);
        final EditText password_input = (EditText) findViewById(R.id.new_password_input);
        final EditText password_conf_input = (EditText) findViewById(R.id.new_conf_password);
        Button submit = (Button) findViewById(R.id.submit_button);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = email_input.getText().toString();
                String password = password_input.getText().toString();
                String password_conf = password_conf_input.getText().toString();

                if (!password.equals(password_conf)) {
                    Toast.makeText(getApplicationContext(), "Passwords do not match", Toast.LENGTH_SHORT).show();
                } else if (!(email.isEmpty()) && !(password.isEmpty()) && !(password_conf.isEmpty())) {
                    SignupController controller = new SignupController(context);
                    controller.addUser(email, password, password_conf);

                } else {
                    Toast.makeText(getApplicationContext(), "Fill all input areas", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}
