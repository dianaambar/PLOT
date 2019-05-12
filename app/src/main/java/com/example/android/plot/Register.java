package com.example.android.plot;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.android.plot.Model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {

    private static final String TAG = "Register";
    private EditText mFirstName, mLastName, mEmailAddress, mPassword, mConfrimPassword, mUsername;
    private Button mbtnRegister;
    private ImageButton mbtnBackButton;
    private FirebaseAuth mAuth;
    private FirebaseDatabase mdatabase;
    private DatabaseReference mref;
    String email, password, confirm_password, last_name, first_name, username;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Log.d(TAG, "onCreate: start");

        mFirstName = findViewById(R.id.etRegisFirstName);
        mLastName = findViewById(R.id.etRegisLastName);
        mEmailAddress = findViewById(R.id.etRegisEmailAddress);
        mPassword = findViewById(R.id.etRegisPassword);
        mConfrimPassword = findViewById(R.id.etRegisConfirmPass);
        mUsername = findViewById(R.id.etRegisUsername);
        mbtnRegister = findViewById(R.id.btnRegisRegister);
        mbtnBackButton = findViewById(R.id.btnRegisBackButton);

        mAuth = FirebaseAuth.getInstance();
        mdatabase = FirebaseDatabase.getInstance();
        mref = mdatabase.getReference("user");

        sendUserData();
    }
    private void sendUserData(){
        mbtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = mEmailAddress.getText().toString();
                password = mPassword.getText().toString();
                confirm_password = mConfrimPassword.getText().toString();
                last_name = mLastName.getText().toString();
                first_name = mFirstName.getText().toString();
                username = mUsername.getText().toString();

                Log.d(TAG, "getUserData: getdata" + email + password + confirm_password + last_name + first_name + username);

                regisNewUser(email, password, confirm_password, last_name, first_name, username);
            }
        });
    }

    private void regisNewUser(final String email, final String password, final String first_name, final String last_name, final String confrim_password, final String username) {
        Log.d(TAG, "regisNewUser: regist user" + email + password);
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            //Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            //FirebaseUser user = mAuth.getCurrentUser();
                            User newUser = new User();
                            newUser.setFirst_name(first_name);
                            newUser.setLast_name(last_name);
                            newUser.setEmail_address(email);
                            newUser.setPassword(password);
                            newUser.setConfirm_password(confrim_password);
                            newUser.setUsername(username);

                            mref.push().setValue(newUser);

                            Toast.makeText(Register.this, "Register Successful.",
                                    Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent();
                            intent.setClass(Register.this, Login.class);
                            startActivity(intent);

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(Register.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                        // ...
                    }
                });
        }
}
