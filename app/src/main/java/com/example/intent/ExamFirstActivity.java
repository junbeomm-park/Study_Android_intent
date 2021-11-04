package com.example.intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ExamFirstActivity extends AppCompatActivity {
    EditText name;
    EditText tel;
    Button btn;
    Button btn2;
    TextView result;
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
                Intent intent = new Intent(ExamFirstActivity.this, ExamSecondActivity.class);
                intent.putExtra("name",name.getText().toString());
                intent.putExtra("tel",tel.getText().toString());
                startActivityForResult(intent,INPUT_DATA_RESULT_TEST);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==INPUT_DATA_RESULT_TEST){
            if(resultCode==RESULT_OK){
                boolean state = data.getBooleanExtra("chkVal",false);
                if(state){
                    result.setText("우수회원설정");
                }else{
                    result.setText("일반회원설정");
                }
            }
        }
    }

}
