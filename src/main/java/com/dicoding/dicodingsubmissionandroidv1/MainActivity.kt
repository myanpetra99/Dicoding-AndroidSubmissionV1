package com.dicoding.dicodingsubmissionandroidv1

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    private lateinit var rvFood: RecyclerView
    private val list = ArrayList<Food>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.setTitle("Recipe Book")


        rvFood = findViewById(R.id.rv_list)
        rvFood.setHasFixedSize(true)

        list.addAll(getListFood())
        showRecyclerList()
    }


    private fun getListFood(): ArrayList<Food> {
        val foodName = resources.getStringArray(R.array.food_name)
        val foodIngredients = resources.getStringArray(R.array.food_ingredients)
        val foodPhoto = resources.obtainTypedArray(R.array.food_photo)
        val foodPreparations = resources.getStringArray(R.array.food_preparation)
        val listFood = ArrayList<Food>()
        for (i in foodName.indices) {
            val food = Food(foodName[i], foodIngredients[i], foodPhoto.getResourceId(i,-1),foodPreparations[i])
            listFood.add(food)
        }

        return listFood
    }

    private fun showRecyclerList() {
        rvFood.layoutManager = LinearLayoutManager(this)
        val listFoodAdapter = ListFoodAdapter(list)
        rvFood.adapter = listFoodAdapter
        listFoodAdapter.setOnItemClickCallback(object : ListFoodAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Food) {
                showDetailFood(data)
            }
        })
    }

    private fun showDetailFood(food: Food) {
        val foodObj = Food(
            food.name,
            food.ingredients,
            food.photo,
            food.preparation
        )

        val moveObjIntent = Intent(this@MainActivity,FoodDetails::class.java)
        moveObjIntent.putExtra(FoodDetails.EXTRA_FOOD, foodObj)
        startActivity(moveObjIntent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_profile -> {
                val moveObjProfile = Intent(this@MainActivity,CreatorDetails::class.java)
                startActivity(moveObjProfile)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}