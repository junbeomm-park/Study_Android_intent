package com.example.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class ExamFirstActivity_Callback extends AppCompatActivity {
    EditText name;
    EditText tel;
    Button btn;
    Button btn2;
    TextView result;
    ActivityResultLauncher<Intent> btn_Launcher;
    public static final int INPUT_DATA_RESULT_TEST = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstexam);
        name = findViewById(R.id.EditText01);
        tel = findViewById(R.id.EditText02);
        btn  = (Button)findViewById(R.id.Button01);//입력완료
        btn2  = (Button)findViewById(R.id.Button02);//객체공유
        result = findViewById(R.id.first_return);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //명시적인텐트 - 실행할 액티비티의 클래스명을 직접 입력해서 처리
                Intent intent = new Intent(ExamFirstActivity_Callback.this, ExamSecondActivity.class);
                intent.putExtra("name",name.getText().toString());
                intent.putExtra("tel",tel.getText().toString());

                btn_Launcher.launch(intent);
            }
        });

        btn_Launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result2) {
                        if(result2.getResultCode()== Activity.RESULT_OK) {
                            Intent intent = result2.getData();
                            boolean state = intent.getBooleanExtra("chkVal", false);
                            if(state){
                                result.setText("우수회원");
                            }else{
                                result.setText("일반회원");
                            }
                        }
                    }
                });
    }


}
