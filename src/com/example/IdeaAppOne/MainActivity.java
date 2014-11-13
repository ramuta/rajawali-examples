package com.example.IdeaAppOne;

import android.app.Activity;
import android.os.Bundle;
import rajawali.RajawaliActivity;

public class MainActivity extends RajawaliActivity {
    private static final String TAG = "MainActivity";

    private MainRenderer mainRenderer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainRenderer = new MainRenderer(this);
        mainRenderer.setSurfaceView(mSurfaceView);
        super.setRenderer(mainRenderer);
    }
}
