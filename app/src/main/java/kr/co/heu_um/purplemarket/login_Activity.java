package kr.co.heu_um.purplemarket;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login_Activity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthListener;
    private EditText et_Email;
    private EditText et_Pw;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);

        firebaseAuth = FirebaseAuth.getInstance();

        et_Email = findViewById(R.id.etMail);
        et_Pw = findViewById(R.id.et_pw);


    }

    public void loginBtn(View view) {

        }







    public void joinBtn(View view) {

        Intent intent= new Intent(this,joinActivity.class);
        startActivity(intent);

    }


}