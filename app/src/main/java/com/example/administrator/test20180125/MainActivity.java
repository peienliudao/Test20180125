package com.example.administrator.test20180125;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewTreeObserver;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private boolean isFirst = true;
    private TextView textView1;
    private TextView textView2;
    private String mfinalStr = "";
    private String mFlag = "斑";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = findViewById(R.id.textview_main1);
        textView2 = findViewById(R.id.textview_main2);
//        textView1.setTextSize(8);
        String str1 = "佩恩六道登场 天道 人间道 地狱道 饿鬼道 畜生道 修罗道";
        final String str = str1+"------"+str1;
        textView1.setText(str);
        textView1.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                if (isFirst) {
                    isFirst = false;

                    int txtCount = textView1.getLineCount();
                    textView2.setText("" + txtCount);
                    if (txtCount > 1) {

                        mfinalStr = str + mFlag;
                        textView1.setText(mfinalStr);

                    } else {

                        mfinalStr = str + "\n" + mFlag;
                        textView1.setText(mfinalStr);
                    }
                }
                return true;
            }
        });
    }
}
