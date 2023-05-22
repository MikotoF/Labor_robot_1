package com.example.laborrobot1

import Animal
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.laborrobot1.Animal


class MainActivity : AppCompatActivity() {
    private lateinit var animalImage: ImageView
    private lateinit var animalName: TextView
    private lateinit var animalDescription: TextView
    private lateinit var detailsButton: Button

    private val animals = listOf(
        Animal("Cat", "This is a cat.", R.drawable.cat),
        Animal("Dog", "This is a dog.", R.drawable.dog),
        Animal("Rabbit", "This is a rabbit.", R.drawable.rabbit)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        animalImage = findViewById(R.id.animalImage)
        animalName = findViewById(R.id.animalName)
        animalDescription = findViewById(R.id.animalDescription)
        detailsButton = findViewById(R.id.detailsButton)

        val initialAnimal = animals[0]
        updateAnimalDetails(initialAnimal)

        detailsButton.setOnClickListener {
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("animal", initialAnimal)
            startActivity(intent)
        }

        // Set click listeners for the other animal buttons
        val catButton = findViewById<Button>(R.id.detailsButton)
        catButton.setOnClickListener {
            val animal = animals[0]
            updateAnimalDetails(animal)
        }

        val dogButton = findViewById<Button>(R.id.detailsButton)
        dogButton.setOnClickListener {
            val animal = animals[1]
            updateAnimalDetails(animal)
        }

        val rabbitButton = findViewById<Button>(R.id.detailsButton)
        rabbitButton.setOnClickListener {
            val animal = animals[2]
            updateAnimalDetails(animal)
        }
    }

    private fun updateAnimalDetails(animal: Animal) {
        animalImage.setImageResource(animal.imageResId)
        animalName.text = animal.name
        animalDescription.text = animal.description
    }
}

