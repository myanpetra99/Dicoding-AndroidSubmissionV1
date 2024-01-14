package com.dicoding.dicodingsubmissionandroidv1

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FoodDetails : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val EXTRA_FOOD = "extra_food"
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_details)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvObject: TextView = findViewById(R.id.tv_food_name)
        val ivObject: ImageView = findViewById(R.id.iv_food)
        val btnShare: Button = findViewById(R.id.btn_share_food)

        btnShare.setOnClickListener(this)


        val food = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Food>(EXTRA_FOOD, Food::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Food>(EXTRA_FOOD)
        }

        if (food != null) {
            val text = "${food.name.toString()},\n \n Ingredients : ${food.ingredients},\n \nPreparations : ${food.preparation}"
            tvObject.text = text

            ivObject.setImageResource(food.photo)
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_share_food -> {
                val shareIntent = Intent(Intent.ACTION_SEND)
                val food = if (Build.VERSION.SDK_INT >= 33) {
                    intent.getParcelableExtra<Food>(EXTRA_FOOD, Food::class.java)
                } else {
                    @Suppress("DEPRECATION")
                    intent.getParcelableExtra<Food>(EXTRA_FOOD)
                }

                if (food != null) {
                    val shareText = "Here i share the recipe of : ${food.name},\n\nIngredients: ${food.ingredients},\n\nPreparations: ${food.preparation}"

                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareText)
                    shareIntent.type = "text/plain"
                    startActivity(shareIntent)
                }
            }
        }
    }

}