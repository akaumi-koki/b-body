package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.os.Bundle;
import android.content.SharedPreferences.Editor;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private TextView textView,textRead;
    private EditText editText;
    private SharedPreferences dataStore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ボタンを設定
        Button button = findViewById(R.id.button);
        Button nextButton = findViewById(R.id.button_next);
        // TextView の設定
        textView = findViewById(R.id.text_view);
        textRead = findViewById(R.id.text_read);
        // "DataStore"という名前でインスタンスを生成
        dataStore = getSharedPreferences("DataStore", MODE_PRIVATE);
       button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("debug00", "onClick: ");
                // エディットテキストのテキストを取得
                EditText height = (EditText) findViewById(R.id.edit_text_height);
                EditText weight = (EditText)findViewById(R.id.edit_text_weight);
                // エディットテキストのテキストを取得
                String heightData = height.getText().toString();
                // 入力文字列を"input"に書き込む
                Editor editor = dataStore.edit();
                editor.putString("height_data", heightData);
                //editor.commit();
                editor.apply();
                double a = Double.parseDouble(height.getText().toString());
                double b = Double.parseDouble(weight.getText().toString());
                double c = b/(a*a);

                double text = Math.round(c*100.0)/100.0;

                // 取得したテキストを TextView に張り付ける
                textView.setText("あなたのBMIは"+text+"です。");
            }
        });
        nextButton.setOnClickListener(v -> {
                Intent intent = new Intent(getApplication(), SubActivity.class);
                startActivity(intent);
        });
        Button buttonRead = findViewById(R.id.button_read);
        buttonRead.setOnClickListener( v -> {
            // "input"から読み出す、何もないときは"Nothing"を返す
            String str = dataStore.getString("height_data", "Nothing");
            if(!str.equals("Nothing")) {
                textRead.setText(str);
            }

        });

    }

}