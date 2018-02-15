package com.think360.pro.healthguru.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.StrictMode
import android.view.WindowManager

import com.think360.pro.healthguru.R
//import com.think360.pro.healthguru.registration.RegistrationActivity

class SplashScreenActivity : AppCompatActivity() {
    private val handle = Handler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)//For disable Status bar
    }

    override fun onStart() {
        super.onStart()

        val t = object : Thread() {
            override fun run() {

                   try {
                    sleep(3000);
                   //    val intent =  Intent(applicationContext, RegistrationActivity::class.java)
                       startActivity(intent)
                       finish();



                } catch (e : InterruptedException ) {
                    e.printStackTrace();
                }


            }
        }
        t.start()
    }

/*    override fun onStop() {
        super.onStop()
    }

    override fun onResume() {
        super.onResume()
        StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.Builder().permitAll().build())

    }*/

    override fun onBackPressed() {
        super.onBackPressed()
        handle.removeCallbacksAndMessages(null)
    }

    override fun onDestroy() {
        super.onDestroy()
        handle.removeCallbacksAndMessages(null)
    }
}
