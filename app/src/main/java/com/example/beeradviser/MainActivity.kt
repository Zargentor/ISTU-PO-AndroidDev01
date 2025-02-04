package com.example.beeradviser

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val findBeer = findViewById<Button>(R.id.find_beer)
        val beerColorSpinner = findViewById<Spinner>(R.id.beer_color)
        val brandsTextView = findViewById<TextView>(R.id.brands)
        val imageView1 = findViewById<ImageView>(R.id.imageView1)
        val imageView2 = findViewById<ImageView>(R.id.imageView2)

        findBeer.setOnClickListener {

            val selectedColor = beerColorSpinner.selectedItem.toString()
            val beerList = getBeers(selectedColor)
            val beerNames = beerList.joinToString(separator = "\n")

            brandsTextView.text = beerNames

            updateImages(selectedColor, imageView1, imageView2)
        }
    }
}

fun getBeers(color: String): List<String> {
    return when (color) {
        "Light" -> listOf("Jail Pale Ale", "Lager Lite")
        "Amber" -> listOf("Jack Amber", "Red Moose")
        "Brown" -> listOf("Brown Bear Beer", "Bock Brownie")
        "Red" -> listOf("Tomato pepper beer", "Red Sea Ale")
        else -> listOf("Gout Stout", "Dark Daniel")
    }
}

fun updateImages(color: String, imageView1: ImageView, imageView2: ImageView) {
    when (color) {
        "Light" -> {
            imageView1.setImageResource(R.drawable.lager)
            imageView2.setImageResource(R.drawable.ipa)
        }

        "Amber" -> {
            imageView1.setImageResource(R.drawable.amber)
            imageView2.setImageResource(R.drawable.redmoose)
        }
    }
}
