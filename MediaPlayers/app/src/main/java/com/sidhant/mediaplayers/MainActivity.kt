package com.sidhant.mediaplayers

import android.media.Image
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import android.widget.SeekBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    lateinit var mediaPlayer: MediaPlayer
    var totalTime:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        mediaPlayer=MediaPlayer.create(this,R.raw.trailer)
        mediaPlayer.setVolume(  1f,1f)
        totalTime=mediaPlayer.duration

        val btnPlay=findViewById<ImageView>(R.id.play)
        val btnPause=findViewById<ImageView>(R.id.pause)
        val btnStop=findViewById<ImageView>(R.id.stop)
        val seekBarMusic=findViewById<SeekBar>(R.id.seekBar)


        btnPlay.setOnClickListener {
            mediaPlayer.start()
        }
        btnPause.setOnClickListener {
            mediaPlayer.pause()
        }
        btnStop.setOnClickListener {
            mediaPlayer.stop()
            mediaPlayer.reset()
            mediaPlayer.release()
        }


        //when user changes the time stamp of music,reflectthat change
        seekBarMusic.max=totalTime
        seekBarMusic.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {

                if(fromUser){
                    mediaPlayer.seekTo(progress)
                }
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {}

            override fun onStopTrackingTouch(p0: SeekBar?) {}

        })

        //change the seekbar music based  the music
        val handler=Handler()

        handler.postDelayed(object:Runnable{
            override fun run() {
                try {
                    seekBarMusic.progress = mediaPlayer.currentPosition
                    handler.postDelayed(this, 1000)
                }catch (exception:Exception){
                    seekBarMusic.progress=0
                }


            }

        },0)


    }
}