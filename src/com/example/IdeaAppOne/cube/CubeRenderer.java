package com.example.IdeaAppOne.cube;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.example.IdeaAppOne.R;
import rajawali.BaseObject3D;
import rajawali.lights.DirectionalLight;
import rajawali.materials.DiffuseMaterial;
import rajawali.primitives.Cube;
import rajawali.renderer.RajawaliRenderer;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by ramuta on 13/11/2014.
 */
public class CubeRenderer extends RajawaliRenderer {
    private static final String TAG = "CubeRenderer";

    private DirectionalLight mLight;
    private BaseObject3D mCube;

    public CubeRenderer(Context context) {
        super(context);
        setFrameRate(60);
    }

    public void initScene() {
        mLight = new DirectionalLight(1.0f, 0.2f, -1.0f);
        mLight.setColor(1.0f, 1.0f, 1.0f);
        mLight.setPower(2);

        Bitmap earthImage = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.bunch);

        DiffuseMaterial material = new DiffuseMaterial();

        mCube = new Cube(2);

        mCube.setMaterial(material);
        mCube.addLight(mLight);
        mCube.addTexture(mTextureManager.addTexture(earthImage));

        //mCube.setColor(0xff009900);

        addChild(mCube);

        getCamera().setZ(7);
    }

    @Override
    public void onDrawFrame(GL10 glUnused) {
        super.onDrawFrame(glUnused);
        //mSphere.setRotY(mSphere.getRotY() + 1);
        //mCube.setRotY(mCube.getRotY() + 1);
        mCube.setRotation(mCube.getRotX() + 1, mCube.getRotY() + 1, 0);
    }
}
