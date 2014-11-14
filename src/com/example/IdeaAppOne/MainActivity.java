package com.example.IdeaAppOne;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.IdeaAppOne.cube.CubeActivity;
import com.example.IdeaAppOne.plane.PlaneActivity;

public class MainActivity extends Activity {
    private static final String TAG = "MainActivity";

    // buttons
    private Button cubeButton;
    private Button planeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.main);

        cubeButton = (Button) findViewById(R.id.mainCubeButton);
        cubeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cubeIntent = new Intent(MainActivity.this, CubeActivity.class);
                startActivity(cubeIntent);
            }
        });

        planeButton = (Button) findViewById(R.id.mainPlaneButton);
        planeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent planeIntent = new Intent(MainActivity.this, PlaneActivity.class);
                startActivity(planeIntent);
            }
        });
    }
}
