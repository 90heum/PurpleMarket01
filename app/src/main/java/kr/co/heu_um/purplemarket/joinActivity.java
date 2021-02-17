package kr.co.heu_um.purplemarket;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class joinActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
  //  private EditText etJoinId;
    private EditText etJoinPw;
  //  private EditText etNickName;
    private EditText etMail;

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser= firebaseAuth.getCurrentUser();  //로그인되어있는지 확인
        updateUI(currentUser);
        if(currentUser != null){
            currentUser.reload();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        firebaseAuth = FirebaseAuth.getInstance();

     //   etJoinId=findViewById(R.id.etJoinId);
        etJoinPw=findViewById(R.id.etJoinPw);
      //  etNickName=findViewById(R.id.etNickName);
        etMail=findViewById(R.id.etMail);

    }


// 로그인되어있는지 확인
    private void updateUI(FirebaseUser currentUser) {
    }

    public void joinBtn(View view) {
        if ( !etJoinPw.getText().toString().equals("")&& !etMail.getText().toString().equals("")) {
            // 이메일과 비밀번호가 공백이 아닌 경우
            createUser( etMail.getText().toString(), etJoinPw.getText().toString());
        } else {
            // 이메일과 비밀번호가 공백인 경우
            Toast.makeText(this, "빈입력란이 있습니다.", Toast.LENGTH_LONG).show();
        }
    }

    private void createUser(String etMail, String etJoinPw) {

        firebaseAuth.createUserWithEmailAndPassword(etMail,etJoinPw).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){

                    Toast.makeText(joinActivity.this, "가입을 환영합니다.", Toast.LENGTH_SHORT).show();
                    finish();
                }else{
                    Toast.makeText(joinActivity.this, "다시 입력해주세요.", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }


}