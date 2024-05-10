package com.example.playaudiotest

import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.playaudiotest.databinding.ActivityMainBinding
import with

class MainActivity : AppCompatActivity() {


    private val mediaPlayer = MediaPlayer()

    private lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initMediaPlayer()
        mBinding.play.setOnClickListener {
            if (!mediaPlayer.isPlaying) {
                mediaPlayer.start()
            }
        }
        mBinding.pause.setOnClickListener {
            if (mediaPlayer.isPlaying) {
                mediaPlayer.pause()
            }
        }
        mBinding.stop.setOnClickListener {
            if (mediaPlayer.isPlaying) {
                mediaPlayer.reset()
                initMediaPlayer()
            }
        }
    }

    private fun initMediaPlayer() {
        val assetManager = assets
        val fd = assetManager.openFd("faraway.mp3")
        mediaPlayer.setDataSource(fd.fileDescriptor, fd.startOffset, fd.length)
        mediaPlayer.prepare()
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.stop()
        mediaPlayer.release()
    }


    fun test() {
        if ("Hello Kotlin".startsWith("Hello")) {
            //
        }
        if ("Hello World" beginsWith "Hello") {

        }

        val list = listOf("Apple", "Banana", "Orange")
        if (list has "Banana") {

        }

        val map = mapOf("Apple" with 1, "Banana" with 2)
    }

    private infix fun String.beginsWith(prefix: String) = startsWith(prefix)

    infix fun <T> Collection<T>.has(element: T) = contains(element)

}