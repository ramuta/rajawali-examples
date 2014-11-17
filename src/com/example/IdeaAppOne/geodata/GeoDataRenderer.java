package com.example.IdeaAppOne.geodata;

import android.content.Context;
import com.example.IdeaAppOne.R;
import rajawali.BaseObject3D;
import rajawali.SerializedObject3D;
import rajawali.animation.Animation3D;
import rajawali.animation.RotateAnimation3D;
import rajawali.lights.DirectionalLight;
import rajawali.materials.PhongMaterial;
import rajawali.math.MathUtil;
import rajawali.math.Number3D;
import rajawali.math.Quaternion;
import rajawali.primitives.Particle;
import rajawali.primitives.Sphere;
import rajawali.renderer.RajawaliRenderer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import java.io.ObjectInputStream;
import java.nio.FloatBuffer;
import java.util.zip.GZIPInputStream;

/**
 * Created by ramuta on 17/11/2014.
 */
public class GeoDataRenderer  extends RajawaliRenderer {
    private Animation3D mAnim;
    private BaseObject3D mRootSpike;

    public GeoDataRenderer(Context context) {
        super(context);
        setFrameRate(60);
    }

    protected void initScene() {
        setBackgroundColor(0xffeeeeee);

        DirectionalLight light = new DirectionalLight(0, -.6f, -.4f);
        light.setColor(1, 1, 1);

        mCamera.setZ(8);

        BaseObject3D sphere = new Sphere(1, 16, 8);

        PhongMaterial spikeMaterial = new PhongMaterial();
        spikeMaterial.setUseColor(true);

        try {
            // -- open gzipped serialized file
            GZIPInputStream gzi = new GZIPInputStream(mContext.getResources().openRawResource(R.raw.spike));
            ObjectInputStream fis = new ObjectInputStream(gzi);
            mRootSpike = new BaseObject3D((SerializedObject3D)fis.readObject());
            mRootSpike.setMaterial(spikeMaterial);
            mRootSpike.addLight(light);
            mRootSpike.setColor(0xff33ff33);
            mRootSpike.setScale(.5f);
            // -- objects that share the same geometry and material,
            //    so batch rendering gives a performance boost.
            mRootSpike.setRenderChildrenAsBatch(true);
            addChild(mRootSpike);

            // -- get vertex buffer
            FloatBuffer vertBuffer = sphere.getGeometry().getVertices();
            // -- get the normal buffer
            FloatBuffer normBuffer = sphere.getGeometry().getNormals();
            int numVerts = vertBuffer.limit();

            // -- define the up axis. we will use this to rotate
            //    the spikes
            Number3D upAxis = new Number3D(0, 1, 0);

            // -- now loop through the sphere's vertices and place
            //    a spike on each vertex
            for(int i=0; i<numVerts; i+=3) {
                BaseObject3D spike = mRootSpike.clone();
                //BaseObject3D spike = new Particle();
                // -- set the spike's position to the sphere's current vertex position
                spike.setPosition(vertBuffer.get(i), vertBuffer.get(i+1), vertBuffer.get(i+2));
                // -- get the normal so we can orient the spike to the normal
                if((i%2) == 0) {
                    spike.setColor(0xffff3333);
                } else if((i%3) == 0) {
                    spike.setColor(0xf5f4f3f2);
                } else {
                    spike.setColor(0x00000000);
                }
                Number3D normal = new Number3D(normBuffer.get(i), normBuffer.get(i+1), normBuffer.get(i+2));
                // -- get the rotation axis
                Number3D axis = Number3D.cross(upAxis, normal);
                // -- get the rotation angle
                float angle = MathUtil.radiansToDegrees((float) Math.acos(Number3D.dot(upAxis, normal)));
                // -- create the quaternion
                Quaternion q = new Quaternion();
                q.fromAngleAxis(angle, axis);
                // -- set the orientation so that it is aligned with the current normal
                spike.setOrientation(q);
                mRootSpike.addChild(spike);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        Number3D rotationAxis = new Number3D(.3f, .9f, .15f);
        rotationAxis.normalize();

        mAnim = new RotateAnimation3D(rotationAxis, 360);
        mAnim.setDuration(8000);
        mAnim.setRepeatCount(Animation3D.INFINITE);
        mAnim.setTransformable3D(mRootSpike);
    }

    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        //((GeoDataActivity) mContext).showLoader();
        super.onSurfaceCreated(gl, config);
        //((GeoDataActivity) mContext).hideLoader();
        mAnim.start();
    }
}
