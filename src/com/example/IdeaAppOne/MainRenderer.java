package com.example.IdeaAppOne;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import rajawali.BaseObject3D;
import rajawali.lights.DirectionalLight;
import rajawali.lights.PointLight;
import rajawali.materials.DiffuseMaterial;
import rajawali.materials.PhongMaterial;
import rajawali.materials.SimpleMaterial;
import rajawali.materials.TextureManager;
import rajawali.primitives.Cube;
import rajawali.primitives.Sphere;
import rajawali.renderer.RajawaliRenderer;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by ramuta on 13/11/2014.
 */
public class MainRenderer extends RajawaliRenderer {
    private static final String TAG = "MainRenderer";

    private DirectionalLight mLight;
    private BaseObject3D mSphere;
    private BaseObject3D mCube;

    public MainRenderer(Context context) {
        super(context);
        setFrameRate(60);
    }

    public void initScene() {
        mLight = new DirectionalLight(1.0f, 0.2f, -1.0f);
        mLight.setColor(1.0f, 1.0f, 1.0f);
        mLight.setPower(2);

        Bitmap earthImage = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.bunch);

        DiffuseMaterial material = new DiffuseMaterial();
        //SimpleMaterial material = new SimpleMaterial();

        /*
        SimpleMaterial cubeMaterial = new SimpleMaterial();
        cubeMaterial.setUseColor(true);
        mCube.setMaterial(cubeMaterial);
        mCube.setColor(0xff009900);
        */

        //mSphere = new Sphere(1, 24, 24);
        //mSphere.setMaterial(material);
        //mSphere.addLight(mLight);
        //mSphere.addTexture(mTextureManager.addTexture(earthImage));
        //addChild(mSphere);

        /*
        mCube = new Cube(20);
        mCube.setMaterial(material);
        mCube.addLight(mLight);
        mCube.addTexture(mTextureManager.addTexture(earthImage));
        addChild(mCube);

        //mCamera.setZ(8.2f);
        mCamera.setLookAt(0, 0, 0);
        */

        mCube = new Cube(2);

        /*
        SimpleMaterial simple = new SimpleMaterial();
        simple.setUseColor(true);
        mCube.setMaterial(simple);
        */

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
