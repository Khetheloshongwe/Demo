package com.shongwe.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
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

        generateHistoryButton.setOnClickListener {
            val age = ageInput.text.toString().toIntOrNull()
            if (age != null && age in 20..100) {
                val historyName = getHistoryName(age)
                if (historyName != null) {
                    resultTextView.text = "$historyName."
                    val imageResId = getImageResourceId(age)
                    if (imageResId != 0) {
                        personImage.setImageResource(imageResId)
                        personImage.visibility = View.VISIBLE
                    } else {
                        personImage.visibility = View.GONE
                    }
                } else {
                    resultTextView.text = "No historical figure found for the entered age."
                    personImage.visibility = View.GONE
                }
            } else {
                resultTextView.text = "Invalid input. Please enter a valid age between 20 and 100."
                personImage.visibility = View.GONE
            }
        }

        clearButton.setOnClickListener {
            ageInput.text.clear()
            resultTextView.text = ""
            personImage.visibility = View.GONE
        }
    }

    private fun getHistoryName(age: Int): String? {
        return when (age) {
            30 -> "Stephen Bantu Biko\n\n"+
                    "Stephen Bantu Biko: Stephen Bantu Biko, an influential anti-apartheid activist in South Africa, led the Black Consciousness Movement (BCM) " +
                    "during the late 1960s and 1970s. Through the BCM, Biko aimed to empower marginalized black communities, particularly the youth, against the " +
                    "oppressive apartheid regime. His leadership filled a crucial void left by the banning of established political organizations like the African " +
                    "National Congress (ANC) and Pan Africanist Congress (PAC). By emphasizing self-reliance and pride in black heritage, Biko inspired a new wave of " +
                    "resistance against racial segregation and discrimination, laying the foundation for future struggles for equality and justice in South Africa."

            52 -> "William Shakespeare\n\n" +
                    "William Shakespeare, the renowned playwright and poet of the Elizabethan era, was born and raised in Stratford-upon-Avon, England. His works, " +
                    "including plays, sonnets, and poems, have had an enduring impact on literature and the arts. Despite limited records of his personal life, " +
                    "Shakespeare's literary genius is widely celebrated and studied. His plays, such as \"Hamlet,\" \"Romeo and Juliet,\" and \"Macbeth,\" explore " +
                    "universal themes of love, ambition, and tragedy, captivating audiences across generations. Shakespeare's legacy as one of the greatest writers " +
                    "in the English language continues to inspire scholars, performers, and readers worldwide, cementing his place in literary histor"

            81 -> "Winnie Madikizela Mandela\n\n" +
                    "Winnie Madikizela Mandela, a fearless anti-apartheid activist and politician, was born in Mbongweni, South Africa. Despite facing adversity from a" +
                    " young age, including the loss of her father and enduring the injustices of apartheid, Madikizela Mandela emerged as a formidable leader in the " +
                    "struggle for freedom and equality. Throughout her life, she challenged gender norms and societal expectations, earning the nickname \"Mother of the" +
                    " Nation\" for her unwavering commitment to the cause. Despite facing persecution, imprisonment, and personal hardship, Madikizela Mandela remained " +
                    "resolute in her fight against apartheid, inspiring millions with her courage, resilience, and determination to create a better future for all South Africans."

            33 -> "Anton Muziwakhe Lembede\n\n" +
                    "Anton Muziwakhe Lembede, born in 1914 in Natal, South Africa, hailed from a peasant family. Despite humble beginnings, his parents " +
                    "prioritized education, leading to his enrollment in a Catholic school at age 13. Lembede's commitment to learning was evident " +
                    "from a young age, as he immersed himself in studies even while tending to household chores. His transition from Anglicanism to " +
                    "Catholicism and his early academic achievements shaped his later activism and leadership within the African National Congress " +
                    "Youth League, where he championed African nationalism and the struggle against apartheid.He passed away when he was 33 years old"

            90 -> "Desmond Mpilo Tutu\n\n" +
                    "Desmond Mpilo Tutu, a prominent Anglican Archbishop and anti-apartheid activist, was born in Klerksdorp, South Africa. Throughout his life, " +
                    "Tutu tirelessly campaigned against the injustices of apartheid, advocating for nonviolent resistance and reconciliation. As the first black " +
                    "Archbishop of Cape Town, Tutu used his position to challenge the apartheid regime and promote social justice and equality. His efforts earned " +
                    "him international recognition, including the Nobel Peace Prize in 1984, for his role in the peaceful transition to democracy in South Africa. " +
                    "Tutu's legacy as a moral leader and champion of human rights continues to inspire generations around the world."

            41 -> "Shaka Zulu" +
                    " Shaka Zulu, the legendary warrior-king of the Zulu Kingdom, was born into adversity in what is now South Africa. Despite facing numerous challenges and " +
                    "hardships in his early life, including the loss of his father and exile from his homeland, Shaka emerged as a military genius and visionary leader. Through " +
                    "his innovative tactics and strategies, Shaka transformed the Zulu Kingdom into a formidable military power, conquering vast territories and reshaping the " +
                    "political landscape of Southern Africa. His legacy as a unifier and nation-builder endures to this day, influencing the culture, traditions, and identity of " +
                    "the Zulu people and leaving an indelible mark on African history."

            50 -> "Michael Jackson" +
                   "Michael Jackson, the \"King of Pop,\" was an iconic American singer, songwriter, and dancer who revolutionized the music industry with his " +
                    "groundbreaking performances and innovative style. From his early days as the lead vocalist of the Jackson 5 to his record-breaking solo career," +
                    " Jackson's influence transcended genres and generations, earning him widespread acclaim and adulation. With timeless hits like \"Thriller,\" \"Billie Jean,\" and \"Beat It,\" " +
                    "Jackson captivated audiences around the world, breaking barriers and redefining the possibilities of popular music. Despite facing personal challenges and " +
                    "controversies, his enduring legacy as a global cultural icon and humanitarian continues to inspire millions worldwide."

            72 -> "King Goodwill Zwelithini" +
                    "King Goodwill Zwelithini kaBhekuzulu, the reigning monarch of the Zulu Kingdom, was born in Nongoma, South Africa. As the custodian of Zulu " +
                    "traditions and customs, King Zwelithini played a crucial role in preserving the cultural heritage of his people and promoting unity and " +
                    "cohesion within the Zulu nation. Despite the constitutional limitations on his powers as a traditional monarch in post-apartheid South Africa, " +
                    "King Zwelithini remained a respected and influential figure, revered by his subjects for his wisdom, leadership, and dedication to their well-being." +
                    " His reign symbolized continuity and resilience in the face of changing times, ensuring the enduring legacy of the Zulu monarchy for future generations"

            95 -> "Robert Gabriel Mugabe" +
                    " Robert Gabriel Mugabe, the controversial former President of Zimbabwe, was born in Katama, Southern Rhodesia (now Zimbabwe). From his early days as" +
                    " a revolutionary leader fighting against colonial rule to his later years as a divisive political figure, Mugabe's legacy remains deeply polarizing and" +
                    " complex. While celebrated by some as a liberation hero who led Zimbabwe to independence, others condemn him for his authoritarian rule, human rights " +
                    "abuses, and economic mismanagement. Mugabe's presidency was marked by political repression, corruption, and economic decline, tarnishing his once-revered " +
                    "image and leaving a legacy of turmoil and uncertainty in Zimbabwean history."

            47 -> "Paul William Walker" +
                    " Paul William Walker IV, an American actor best known for his role in the \"Fast and Furious\" film series, was born in Glendale, California. With his " +
                    "charming demeanor and action-packed performances, Walker captivated audiences worldwide, earning him a devoted fan base and widespread acclaim. Despite " +
                    "his success in Hollywood, Walker remained humble and grounded, prioritizing family and philanthropy over fame and fortune. Tragically, his life was cut " +
                    "short in a car accident in 2013, leaving behind a legacy of talent, generosity, and kindness that continues to inspire and resonate with fans around the world."











            // Add more cases for other ages and their associated historical figures
            else -> null
        }
    }

    private fun getImageResourceId(age: Int): Int {
        return when (age) {
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