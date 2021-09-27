package com.example.cubeu3ddemo;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    private TextView startUnity;
    private TextView finishUnity;
    private View showView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handleIntent(getIntent());
        setContentView(R.layout.activity_main);
        startUnity = findViewById(R.id.show_unity);
        finishUnity = findViewById(R.id.finish_unity);
        startUnity.setOnClickListener(v -> {
            loadUnity();
        });

        finishUnity.setOnClickListener(v -> {
            unLoadUnity();
        });

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        handleIntent(intent);

    }

    private void handleIntent(Intent intent) {
        if (intent == null || intent.getExtras() == null) {
            return;
        }
//        if (intent.getExtras().containsKey(Constant.SET_COLOR)) {
//            switch (intent.getExtras().getString(Constant.SET_COLOR)) {
//                case Constant.COLOR_YELLOW:
//                    showView.setBackgroundColor(Color.YELLOW);
//                    break;
//                case Constant.COLOR_RED:
//                    showView.setBackgroundColor(Color.RED);
//                    break;
//                case Constant.COLOR_BLUE:
//                    showView.setBackgroundColor(Color.BLUE);
//                    break;
//                default:
//                    break;
//            }
//        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private void loadUnity() {
        Intent intent = new Intent(this, MainUnityActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivityForResult(intent, 1);
    }

    private void unLoadUnity() {
        Intent intent = new Intent(this, MainUnityActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        intent.putExtra(Constant.DO_QUIT, true);
        startActivityForResult(intent, 2);
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }
}