package com.example.android.coderunner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private TextView mLog;
    private Button clearBtn;
    private String string = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clearBtn = (Button) findViewById(R.id.clear_button);
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                string = " a ";
                mLog.setText(string);
            }
        });
        mLog = (TextView) findViewById(R.id.log);
        mLog.setMovementMethod(new ScrollingMovementMethod());

    }

    private void logMessage(String message) {
//      Output message to logcat console
        Log.i(TAG, message);
//      Output message to TextView
        string += message + "\n";
        mLog.setText(string);
//      Adjust scroll position to make last line visible
        Layout layout = mLog.getLayout();
        if (layout != null) {
            int scrollAmount = layout.getLineTop(mLog.getLineCount()) - mLog.getHeight();
            mLog.scrollTo(0, scrollAmount > 0 ? scrollAmount : 0);
        }
    }
}
