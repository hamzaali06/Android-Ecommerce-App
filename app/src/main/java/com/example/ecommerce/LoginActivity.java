package com.example.ecommerce;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseError;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {

    private EditText InputPhoneNumber, InputPassword;
    private Button LoginButton;
    private ProgressDialog lodingBar;
    private TextView AdminLink, NotAdminLink;
    private String parentDbName= "Users";
    private CheckBox chkBoxRememberMe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        LoginButton= (Button) findViewById(R.id.login_btn);
        InputPassword = (EditText) findViewById(R.id.login_password_input);
        InputPhoneNumber = (EditText) findViewById(R.id.login_phone_number_input);
        AdminLink = (TextView) findViewById(R.id.admin_panel_link);
        NotAdminLink = (TextView) findViewById(R.id.not_admin_panel_link);
       // lodingBar = new ProgressDialog(context this);
        chkBoxRememberMe = (CheckBox) findViewById(R.id.remember_me_chkb);
        //Paper.init(context this);

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginUser();
            }
        });
        AdminLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginButton.setText("Login Admin");
                AdminLink.setVisibility(View.INVISIBLE);
                NotAdminLink.setVisibility(View.VISIBLE);
                parentDbName = "Admins";
            }
        });
        NotAdminLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginButton.setText("Login");
                AdminLink.setVisibility(View.VISIBLE);
                NotAdminLink.setVisibility(View.INVISIBLE);
                parentDbName = "Users";
            }
        });
    }

    private void LoginUser(){
        String phone = InputPhoneNumber.getText().toString();
        String password = InputPassword.getText().toString();
        if (TextUtils.isEmpty(phone)){
       //   Toast.makeText(this, "Please write your phone number... ",Toast.);
        }
        else if (TextUtils.isEmpty(password)){
         //          Toast.makeText(this, "Please write your password... ",Toast.);
        }
        /*else{
            loadingBar.setTitle("Login Account");
            loadingBar.setMessage("Please wait, while we are checking the credential ");
            loadingBar.setCanceledOnTouchOutSide(false);
            loadingBar.show();

            AllowAccessToAccount(phone, password);
        }*/
    }
    private void AllowAccessToAccoount(final String phone, final String password){
        if (chkBoxRememberMe.isChecked()){
       //     Paper.book().write(Prevalent.UserPhoneKey, phone);
       //        Paper.book().write(Prevalent.UserPasswordKey, password);
        }
        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance().getReference();
        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
             /*   if (dataSnapshot.child(parentDbName).child(phone).exists()){
                    Users usersData = dataSnapshot.child(parentDbName).child(phone).exists();
                    if (usersData.getPhone().equals(phone)){
                        if (usersData.getPassword().equals(password)){
                            if(parentDbName.equals("Admins")){
                       //    Toast.makeText(LoginActivity.this,"Welcom Admin, you are logged In Successfully...",Toast.Length_Short).show();
                       //    loadingBar.dismiss();
                       //    Intent intent = new Intent(LoginActivity.this,AdminAddNewProductActivity.class);
                       //    startActivity(intent);
                            }
                         else if(parentDbName.equals("Users")){
                       //    Toast.makeText(LoginActivity.this,"Logged In Successfully...",Toast.Length_Short).show();
                       //    loadingBar.dismiss();
                       //    Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                       //    startActivity(intent);
                         }
                        }
                        else{
                            loadingBar.dismiss();
                            Toast.makeText(LoginActivity.this,"Password")
                        }
                    }
                 }
                 else{
                    Toast.makeText(LoginActivity.this,"Accouunt with this");
                 }
                }*/

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}

