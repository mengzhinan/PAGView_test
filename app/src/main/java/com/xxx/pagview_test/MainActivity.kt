package com.xxx.pagview_test

import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import org.libpag.PAGFile
import org.libpag.PAGView

class MainActivity : AppCompatActivity() {

    private var rlContainer: RelativeLayout? = null
    private var btnStart: Button? = null
    private var btnStop: Button? = null

    private var pagView: PAGView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rlContainer = findViewById(R.id.rl_container)
        btnStart = findViewById(R.id.btn_start)
        btnStop = findViewById(R.id.btn_stop)

        btnStart?.setOnClickListener {
            pagView?.play()
        }

        btnStop?.setOnClickListener {
            pagView?.stop()
        }

    }

    override fun onResume() {
        super.onResume()

        pagView = PAGView(this)
        pagView?.layoutParams = RelativeLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT
        )
        rlContainer?.addView(pagView)

        pagView?.composition = PAGFile.Load(assets, "replacement.pag")
        pagView?.setRepeatCount(0)


    }
}
