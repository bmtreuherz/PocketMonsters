package com.example.bradl.pocketmonsters

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.view.ViewGroup
import org.rajawali3d.view.ISurface
import org.rajawali3d.view.SurfaceView

class MainActivity : AppCompatActivity() {

    lateinit private var renderer: BasicRenderer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val surface = SurfaceView(this)
        surface.setFrameRate(60.0)
        surface.renderMode = ISurface.RENDERMODE_WHEN_DIRTY

        addContentView(surface, ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT))

        renderer = BasicRenderer(this)
        surface.setSurfaceRenderer(renderer)
    }
}
