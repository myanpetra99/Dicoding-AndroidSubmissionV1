package com.dicoding.dicodingsubmissionandroidv1

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val moveToMain = Intent(this@SplashScreenActivity, MainActivity::class.java)
        val ivCookies: ImageView = findViewById(R.id.iv_cookies)

        ivCookies.alpha = 0f
        ivCookies.animate().setDuration(1000).alpha(1f).withEndAction(Runnable {
            startActivity(moveToMain)
        })
    }

}