package com.example.IdeaAppOne.plane;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.example.IdeaAppOne.R;
import rajawali.BaseObject3D;
import rajawali.lights.DirectionalLight;
import rajawali.materials.DiffuseMaterial;
import rajawali.materials.SimpleMaterial;
import rajawali.primitives.Plane;
import rajawali.renderer.RajawaliRenderer;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by ramuta on 13/11/2014.
 */
public class PlaneRenderer extends RajawaliRenderer {
    private static final String TAG = "CubeRenderer";

    private DirectionalLight mLight;
    private BaseObject3D mPlane;

    public PlaneRenderer(Context context) {
        super(context);
        setFrameRate(60);
    }

    public void initScene() {
        mLight = new DirectionalLight(1.0f, 0.2f, -1.0f);
        mLight.setColor(1.0f, 1.0f, 1.0f);
        mLight.setPower(2);

        Bitmap earthImage = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.bunch);

        SimpleMaterial material = new SimpleMaterial();
        //material.addTexture(mTextureManager.addTexture(earthImage));
        //material.setColor(0xffff0000);
        material.setUseColor(true);

        mPlane = new Plane(3, 3, 1, 1);
        mPlane.addLight(mLight);
        mPlane.setZ(-1.2f);
        mPlane.setRotY(-40);
        mPlane.setRotX(65);
        mPlane.setRotZ(15);
        //mPlane.setY(-1.2f);
        mPlane.setMaterial(material);

        addChild(mPlane);

        getCamera().setZ(7);
    }

    @Override
    public void onDrawFrame(GL10 glUnused) {
        super.onDrawFrame(glUnused);
        //mPlane.setRotation(mPlane.getRotX() + 1, mPlane.getRotY() + 1, 0);
    }
}
