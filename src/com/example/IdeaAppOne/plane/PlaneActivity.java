package com.example.IdeaAppOne.plane;

import android.os.Bundle;
import rajawali.RajawaliActivity;

public class PlaneActivity extends RajawaliActivity {
    private static final String TAG = "PlaneActivity";

    private PlaneRenderer mainRenderer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainRenderer = new PlaneRenderer(this);
        mainRenderer.setSurfaceView(mSurfaceView);
        super.setRenderer(mainRenderer);
    }
}
