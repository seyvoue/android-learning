package com.letica.demo.android.activitytest;

import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends BaseActivity {
    private static final String TAG = "SecondActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        Log.d(TAG, "Task id is " + getTaskId());
        /* 获得从FirstActivity中传递过来的数据，并打印出来 */
//        Intent intent = getIntent();
//        String data = intent.getStringExtra("extra_data");
//        Log.d(TAG, data);
        /* 给按钮注册点击事件 */
        Button button2 = (Button) findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                /* 返回数据给上一个活动 */
//                Intent intent = new Intent();
//                intent.putExtra("data_return", "Hello FirstActivity");
//                setResult(RESULT_OK, intent);
//                finish();
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });
    }

    public static void actionStart(Context context,String data1, String data2){
        Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtra("param1", data1);
        intent.putExtra("param2", data2);
        context.startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("data_return","Hello FirstActivity");
        setResult(RESULT_OK,intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }
}
