package com.example.cubeu3ddemo;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import com.unity3d.player.UnityPlayer;
import com.unity3d.player.UnityPlayerActivity;

/**
 * wdymac
 * 2021/9/14
 **/
public class MainUnityActivity extends UnityPlayerActivity {

    private TextView startUnity;
    private TextView finishUnity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        handleIntent(getIntent());
        View appendView = LayoutInflater.from(this).inflate(R.layout.append_view, null, false);
        addContentView(appendView, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        startUnity = appendView.findViewById(R.id.start);
        finishUnity = appendView.findViewById(R.id.pause);
        startUnity.setOnClickListener(v -> {
            mUnityPlayer.resume();
            //UnityPlayer.UnitySendMessage("Canvas","OnTimeResult",text);方法的意思是调用名称为Canvas对象上的OnTimeResult方法，传入的参数为text。
            UnityPlayer.UnitySendMessage(Constant.BUTTON, Constant.ANDROID_MSG, "android btn");
            Log.d("WDY", "startUnity");

        });

        finishUnity.setOnClickListener(v -> {
            mUnityPlayer.pause();
        });

        appendView.findViewById(R.id.exit).setOnClickListener(v -> {
            finish();
        });
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {
        if (intent.getBooleanExtra(Constant.DO_QUIT, false)) {
            finish();
        }
    }
}
