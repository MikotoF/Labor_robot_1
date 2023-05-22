package com.example.laborrobot1

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.laborrobot1.Animal


class DetailsActivity : AppCompatActivity() {
    private lateinit var animalImageDetails: ImageView
    private lateinit var animalNameDetails: TextView
    private lateinit var animalDescriptionDetails: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        animalImageDetails = findViewById(R.id.animalImageDetails)
        animalNameDetails = findViewById(R.id.animalNameDetails)
        animalDescriptionDetails = findViewById(R.id.animalDescriptionDetails)

        // Retrieve the selected animal data from the intent
        val animal = intent.getSerializableExtra("animal") as Animal
        updateAnimalDetails(animal)
    }

    private fun updateAnimalDetails(animal: Animal) {
        animalImageDetails.setImageResource(animal.imageResId)
        animalNameDetails.text = animal.name
        animalDescriptionDetails.text = animal.description
    }
}
