package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class UseOtherApp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_use_other_app);
    }
    public void callActivity(View v){
        //다른 앱의 액티비티를 호출
        //암시적 Intent - 정확하게 실행할 액티비티클래스명을 모르고 등록된 액션명만 아는경우
        //                                                 ---------------
        //                                              보통은 안드로이드에 미리 등록된 이름으로 설정
        Intent intent = new Intent("com.exam.myview");
        startActivity(intent);
    }
}