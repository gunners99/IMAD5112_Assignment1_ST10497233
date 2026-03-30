package com.kora.socialsparks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.ImageView
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {

    private lateinit var etTimeOfDay: EditText
    private lateinit var btnGetSpark: Button
    private lateinit var btnReset: Button
    private lateinit var tvSpark: TextView
    private lateinit var tvEmoji: TextView
    private lateinit var tvSparkLabel: TextView
    private lateinit var cardSpark: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etTimeOfDay = findViewById(R.id.etTimeOfDay)
        btnGetSpark = findViewById(R.id.btnGetSpark)
        btnReset = findViewById(R.id.btnReset)
        tvSpark = findViewById(R.id.tvSpark)
        tvEmoji = findViewById(R.id.tvEmoji)
        tvSparkLabel = findViewById(R.id.tvSparkLabel)
        cardSpark = findViewById(R.id.cardSpark)

        btnGetSpark.setOnClickListener {
            val input = etTimeOfDay.text.toString().trim()
            getSocialSpark(input)
        }

        btnReset.setOnClickListener {
            resetApp()
        }
    }

    private fun getSocialSpark(input: String) {
        if (input.isEmpty()) {
            showError("⚠️ Oops! Please type a time of day to get your spark!")
            return
        }

        val normalised = input.lowercase().trim()

        val (emoji, spark) = when {
            normalised.contains("morning") && (normalised.contains("mid") || normalised.contains("mid-morning")) ->
                Pair("🤝", "Reach out to a colleague with a quick \"Thank You\" — small gestures build big bonds!")

            normalised.contains("morning") ->
                Pair("☀️", "Send a warm \"Good Morning\" text to a family member — brighten their day before it begins!")

            normalised.contains("mid-morning") || normalised == "mid morning" ->
                Pair("🤝", "Reach out to a colleague with a quick \"Thank You\" — small gestures build big bonds!")

            normalised.contains("afternoon") && (normalised.contains("snack") || normalised.contains("tea")) ->
                Pair("💭", "Send a quick \"Thinking of you\" message to someone special — let them know they matter!")

            normalised.contains("afternoon") ->
                Pair("😂", "Share a funny meme or interesting link with a friend — laughter is the best connector!")

            normalised.contains("snack") ->
                Pair("💭", "Send a quick \"Thinking of you\" message to someone special — let them know they matter!")

            normalised.contains("dinner") || normalised.contains("supper") ->
                Pair("📞", "Call a friend or relative for a 5-minute catch-up — your voice is the best gift you can give!")

            normalised.contains("night") || normalised.contains("evening") || normalised.contains("after dinner") ->
                Pair("💬", "Leave a thoughtful comment on a friend's post — a few kind words can light up someone's night!")

            normalised.contains("lunch") ->
                Pair("🍽️", "Share a funny meme or interesting link with a friend over your lunch break!")

            else ->
                Pair("❓", null)
        }

        if (spark == null) {
            showError("🤔 Hmm, \"$input\" isn't something I recognise yet!\nTry: Morning, Mid-Morning, Afternoon, Snack Time, Dinner, or Evening.")
        } else {
            showSpark(emoji, spark)
        }
    }

    private fun showSpark(emoji: String, spark: String) {
        tvEmoji.text = emoji
        tvSpark.text = spark
        tvSparkLabel.text = "✨ Your Social Spark"
        tvSpark.setTextColor(resources.getColor(R.color.sparkText, theme))
        cardSpark.visibility = View.VISIBLE
    }

    private fun showError(message: String) {
        tvEmoji.text = "⚠️"
        tvSpark.text = message
        tvSparkLabel.text = "Try Again!"
        tvSpark.setTextColor(resources.getColor(R.color.errorText, theme))
        cardSpark.visibility = View.VISIBLE
    }

    private fun resetApp() {
        etTimeOfDay.text.clear()
        cardSpark.visibility = View.GONE
        tvSpark.text = ""
        tvEmoji.text = ""
    }
}
