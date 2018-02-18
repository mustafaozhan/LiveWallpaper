package mustafaozhan.github.com.livewallpaper.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import mustafaozhan.github.com.livewallpaper.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            startActivity(Intent(this, HomeActivity::class.java)).apply { finish() }
        }, 3000)
    }
}
