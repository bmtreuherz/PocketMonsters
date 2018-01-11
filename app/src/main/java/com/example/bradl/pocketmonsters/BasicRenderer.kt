package com.example.bradl.pocketmonsters

import android.content.Context
import android.util.Log
import android.view.MotionEvent
import org.rajawali3d.lights.DirectionalLight
import org.rajawali3d.materials.Material
import org.rajawali3d.materials.methods.DiffuseMethod
import org.rajawali3d.materials.textures.ATexture
import org.rajawali3d.materials.textures.Texture
import org.rajawali3d.math.vector.Vector3
import org.rajawali3d.primitives.Sphere
import org.rajawali3d.renderer.Renderer

/**
 * Created by bradl on 1/11/2018.
 */
class BasicRenderer : Renderer {

    lateinit private var earthSphere: Sphere
    lateinit private var directionalLight: DirectionalLight


    constructor(context: Context) : super(context){
        setFrameRate(60)
    }

    override fun onOffsetsChanged(xOffset: Float, yOffset: Float, xOffsetStep: Float, yOffsetStep: Float, xPixelOffset: Int, yPixelOffset: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onTouchEvent(event: MotionEvent?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initScene() {
        // Setup light
        directionalLight = DirectionalLight(1.0, 0.2, -1.0)
        directionalLight.setColor(1.0f, 1.0f, 1.0f)
        directionalLight.power = 2.0f
        currentScene.addLight(directionalLight)

        // Setup Globe
        var material = Material()
        material.enableLighting(true)
        material.diffuseMethod = DiffuseMethod.Lambert()
        material.colorInfluence = 0.0f
        var earthTexture = Texture("Earth", R.drawable.earth)
        try{
            material.addTexture(earthTexture)
        } catch (error: ATexture.TextureException) {
            Log.d("DEBUG", "Texture Error.")
        }

        earthSphere = Sphere(1.0f, 24, 24)
        earthSphere.material = material
        currentScene.addChild(earthSphere)
        currentCamera.z = 4.2
    }

    override fun onRender(ellapsedRealtime: Long, deltaTime: Double) {
        super.onRender(ellapsedRealtime, deltaTime)
        earthSphere.rotate(Vector3.Axis.Y, 1.0)
    }


}