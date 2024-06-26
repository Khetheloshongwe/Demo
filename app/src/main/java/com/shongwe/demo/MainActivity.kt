package com.shongwe.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    // Declare UI components
    private lateinit var generateHistoryButton: Button
    private lateinit var clearButton: Button
    private lateinit var ageInput: EditText
    private lateinit var resultTextView: TextView
    private lateinit var personImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        generateHistoryButton = findViewById(R.id.GenerateHistory)
        clearButton = findViewById(R.id.clear_button)
        ageInput = findViewById(R.id.AgeInput)
        resultTextView =findViewById(R.id.resultTextView)
        personImage = findViewById(R.id.personImage)


        // Initialize UI components
        generateHistoryButton.setOnClickListener {
            // Retrieve age input and convert to Int
            val age = ageInput.text.toString().toIntOrNull()
            // Check if age is valid and within range
            if (age != null && age in 20..100) {
                val historyName = getHistoryName(age)
                if (historyName != null) {
                    // Display historical figure name
                    resultTextView.text = "$historyName."
                    // Set image for the historical figure if available
                    val imageResId = getImageResourceId(age)
                    if (imageResId != 0) {
                        personImage.setImageResource(imageResId)
                        personImage.visibility = View.VISIBLE
                    } else {
                        personImage.visibility = View.GONE
                    }
                } else {
                    // If no historical figure found for the entered age
                    resultTextView.text = "No historical figure found for the entered age."
                    personImage.visibility = View.GONE
                }
            } else {
                // If age input is invalid or out of range
                resultTextView.text = "Invalid input. Please enter a valid age between 20 and 100."
                personImage.visibility = View.GONE
            }
        }
        // Set click listener for Clear button
        clearButton.setOnClickListener {
            // Clear age input, result text, and make ImageView invisible
            ageInput.text.clear()
            resultTextView.text = ""
            personImage.visibility = View.GONE
        }
    }

    // Function to get historical figure name based on age

    private fun getHistoryName(age: Int): String? {
        // Return historical figure name based on age using when expression
        return when (age) {
            // Cases for different ages and their associated historical figures
            30 -> "Stephen Bantu Biko\n\n"+
                    "Stephen Bantu Biko led the Black Consciousness Movement, " +
                    "empowering marginalized black communities against apartheid" +
                    " in South Africa by emphasizing self-reliance and pride in " +
                    "black heritage, filling a crucial void left by banned political organizations, " +
                    "and inspiring a new wave of resistance for equality and justice."

            52 -> "William Shakespeare\n\n" +
                    "William Shakespeare, the renowned playwright and poet of the Elizabethan era." +
                    "Shakespeare's legacy as one of the greatest writers " +
                    "in the English language continues to inspire scholars, performers, and readers worldwide," +
                    " cementing his place in literary history"

            81 -> "Winnie Madikizela Mandela\n\n" +
                    "Winnie Madikizela Mandela, a fearless anti-apartheid activist and politician, was born in Mbongweni, South Africa. " +
                    " Throughout her life, she challenged gender norms and societal expectations, earning the nickname \"Mother of the" +
                    " Nation\" for her unwavering commitment to the cause. "

            33 -> "Anton Muziwakhe Lembede\n\n" +
                    "Anton Muziwakhe Lembede, born in 1914 in Natal, South Africa, hailed from a peasant family." +
                    " Lembede's commitment to learning was evident " +
                    "from a young age, as he immersed himself in studies even while tending to household chores."

            90 -> "Desmond Mpilo Tutu\n\n" +
                    "Desmond Mpilo Tutu, a prominent Anglican Archbishop and anti-apartheid activist, was born in Klerksdorp," +
                    " South Africa. As the first black " +
                    "Archbishop of Cape Town, Tutu used his position to challenge the apartheid regime and promote social justice and equality."

            41 -> "Shaka Zulu" +
                    " Shaka Zulu, the legendary warrior-king of the Zulu Kingdom, was born into adversity in what is now South Africa. " +
                    "His legacy as a unifier and nation-builder endures to this day, influencing the culture, traditions, and identity of " +
                    "the Zulu people and leaving an indelible mark on African history."

            50 -> "Michael Jackson" +
                   "Michael Jackson, the \"King of Pop,\" was an iconic American singer, songwriter, " +
                    "and dancer who revolutionized the music industry with his " +
                    "groundbreaking performances and innovative style. Despite facing personal challenges and " +
                    "controversies, his enduring legacy as a global cultural icon and humanitarian continues to inspire millions worldwide."

            72 -> "King Goodwill Zwelithini" +
                    "King Goodwill Zwelithini kaBhekuzulu, the reigning monarch of the Zulu Kingdom, was born in Nongoma, South Africa." +
                    " Despite the constitutional limitations on his powers as a traditional monarch in post-apartheid South Africa, " +
                    "King Zwelithini remained a respected and influential figure, revered by his subjects for his wisdom and leadership"

            95 -> "Robert Gabriel Mugabe" +
                    " Robert Gabriel Mugabe, the controversial former President of Zimbabwe, was born in Katama, Southern Rhodesia (now Zimbabwe)." +
                    "Mugabe's presidency was marked by political repression, corruption, and economic decline, tarnishing his once-revered " +
                    "image and leaving a legacy of turmoil and uncertainty in Zimbabwean history."

            47 -> "Paul William Walker" +
                    " Paul William Walker IV, an American actor best known for his role in the \"Fast and Furious\" film series," +
                    " was born in Glendale, California. With his " +
                    " Tragically, his life was cut " +
                    "short in a car accident in 2013, leaving behind a legacy of talent, generosity," +
                    " and kindness that continues to inspire and resonate with fans around the world."











            // Add more cases for other ages and their associated historical figures
            else -> null
        }
    }

    // Function to get image resource ID based on age

    private fun getImageResourceId(age: Int): Int {
        return when (age) {
            // Cases for different ages and their associated images
            30 -> R.drawable.stevebiko
            52 -> R.drawable.williams
            81 -> R.drawable.winnie
            33 -> R.drawable.lembede
            90 -> R.drawable.desmond
            41 -> R.drawable.shaka
            50 -> R.drawable.michaeljackson
            72 -> R.drawable.king
            95 -> R.drawable.mugabe
            47 -> R.drawable.paul

            // Add more cases for other ages and their associated images
            else -> 0 // Return 0 for cases where no image is available
        }
    }
}