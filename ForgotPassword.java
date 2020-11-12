package com.example.ondoctor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity {

    private EditText editTextemail;
    private Button buttonresetPassword;
    private ProgressBar progressBar;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        editTextemail = (EditText) findViewById(R.id.email);
        buttonresetPassword = (Button) findViewById(R.id.resetPassword);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);

        auth = FirebaseAuth.getInstance();

        buttonresetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetPassword();
            }
        });
    }
    private void resetPassword(){
        String email = editTextemail.getText().toString().trim();

        if (email.isEmpty()){
            editTextemail.setError("Email is Required");
            editTextemail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextemail.setError("Enter Valid Email");
            editTextemail.requestFocus();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);
        auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(ForgotPassword.this, "Check Email to reset the Password", Toast.LENGTH_LONG).show();
                    progressBar.setVisibility(View.GONE);
                }else {
                    Toast.makeText(ForgotPassword.this, "Try again", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}