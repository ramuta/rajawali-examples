package com.example.IdeaAppOne.cube;

import android.os.Bundle;
import rajawali.RajawaliActivity;

public class CubeActivity extends RajawaliActivity {
    private static final String TAG = "CubeActivity";

    private CubeRenderer mainRenderer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainRenderer = new CubeRenderer(this);
        mainRenderer.setSurfaceView(mSurfaceView);
        super.setRenderer(mainRenderer);
    }
}
