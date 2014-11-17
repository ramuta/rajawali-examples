package com.example.IdeaAppOne.geodata;

import android.app.Activity;
import android.os.Bundle;
import rajawali.RajawaliActivity;

/**
 * Created by ramuta on 17/11/2014.
 */
public class GeoDataActivity extends RajawaliActivity {
    GeoDataRenderer mainRenderer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainRenderer = new GeoDataRenderer(this);
        mainRenderer.setSurfaceView(mSurfaceView);
        super.setRenderer(mainRenderer);
    }
}