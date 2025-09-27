package com.example.vokabeltrainer

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner // Import für Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var listSpinner: Spinner // Spinner-Variable
    private lateinit var currentListTextView: TextView // Kann optional bleiben
    private lateinit var wordToTranslateTextView: TextView
    private lateinit var translationEditText: EditText
    private lateinit var checkButton: Button
    private lateinit var resultTextView: TextView

    private var currentVocabularyEntry: VocabularyEntry? = null
    private var isGermanToEnglish: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listSpinner = findViewById(R.id.listSpinner)
        currentListTextView = findViewById(R.id.currentListTextView) // Behalte es oder entferne es
        wordToTranslateTextView = findViewById(R.id.wordToTranslateTextView)
        translationEditText = findViewById(R.id.translationEditText)
        checkButton = findViewById(R.id.checkButton)
        resultTextView = findViewById(R.id.resultTextView)

        setupSpinner() // Neue Methode zum Initialisieren des Spinners

        // Entferne die Listener für die alten Buttons
        // buttonListOne.setOnClickListener { ... }
        // buttonListTwo.setOnClickListener { ... }

        checkButton.setOnClickListener {
            checkTranslation()
        }

        // Initiales Laden basierend auf der Vorauswahl im Spinner (oder der ersten Liste)
        // updateCurrentListInfo() // Wird jetzt durch Spinner-Auswahl gesteuert
        // loadNewWord() // Wird auch durch Spinner-Auswahl gesteuert oder beim ersten Setup
    }

    private fun setupSpinner() {
        val listNames = VocabularyData.allLists.keys.toList()

        if (listNames.isEmpty()) {
            listSpinner.isEnabled = false
            wordToTranslateTextView.text = "Keine Vokabellisten vorhanden."
            translationEditText.isEnabled = false
            checkButton.isEnabled = false
            return
        }

        // Adapter für den Spinner erstellen
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item, // Standard-Layout für ausgewählten Eintrag
            listNames
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item) // Standard-Layout für Dropdown-Einträge
        listSpinner.adapter = adapter

        // Listener für Elementauswahl im Spinner
        listSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val selectedListName = parent.getItemAtPosition(position) as String
                VocabularyData.currentListName = selectedListName
                updateCurrentListInfoText() // Optional: Aktualisiere das separate TextView
                loadNewWord() // Lade ein Wort aus der neu ausgewählten Liste
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Kann ignoriert werden oder um einen Standardzustand zu setzen
                VocabularyData.currentListName = null
                updateCurrentListInfoText()
                loadNewWord() // Lädt möglicherweise "Wähle eine Liste..."
            }
        }

        // Setze eine Vorauswahl, falls vorhanden, oder die erste Liste
        VocabularyData.currentListName?.let { name ->
            val initialPosition = listNames.indexOf(name)
            if (initialPosition >= 0) {
                listSpinner.setSelection(initialPosition)
            }
        } ?: if (listNames.isNotEmpty()) {
            // Wenn kein currentListName gesetzt ist, wähle die erste Liste
            listSpinner.setSelection(0)
            // Der onItemSelectedListener wird hier automatisch getriggert
        } else {

        }
    }

    // Optional: Wenn du das currentListTextView behalten möchtest
    private fun updateCurrentListInfoText() {
        currentListTextView.visibility = if (VocabularyData.currentListName != null) View.VISIBLE else View.GONE
        currentListTextView.text = "Aktuelle Liste: ${VocabularyData.currentListName ?: "Keine ausgewählt"}"
    }


    private fun loadNewWord() {
        val currentList = VocabularyData.getCurrentVocabularyList()

        if (currentList == null || currentList.isEmpty()) {
            wordToTranslateTextView.text = if (VocabularyData.allLists.isEmpty()) "Keine Listen vorhanden" else "Wähle eine Liste oder keine Wörter vorhanden"
            translationEditText.isEnabled = false
            checkButton.isEnabled = false
            currentVocabularyEntry = null
            return
        }

        currentVocabularyEntry = currentList.random()
        isGermanToEnglish = Random.nextBoolean()

        currentVocabularyEntry?.let { entry ->
            if (isGermanToEnglish) {
                val wordToShow = entry.germanWords.random()
                wordToTranslateTextView.text = "Deutsch: $wordToShow"
            } else {
                val wordToShow = entry.englishWords.random()
                wordToTranslateTextView.text = "Englisch: $wordToShow"
            }
        }

        translationEditText.text.clear()
        resultTextView.text = ""
        translationEditText.isEnabled = true
        checkButton.isEnabled = true
    }

    private fun checkTranslation() {
        val userAnswer = translationEditText.text.toString().trim()
        if (userAnswer.isEmpty()) {
            resultTextView.text = "Bitte gib eine Übersetzung ein."
            return
        }

        currentVocabularyEntry?.let { entry ->
            val correctAnswers: List<String>
            val allPossibleCorrectAnswersFormatted: String

            if (isGermanToEnglish) {
                correctAnswers = entry.englishWords
                allPossibleCorrectAnswersFormatted = entry.englishWords.joinToString(" / ")
            } else {
                correctAnswers = entry.germanWords
                allPossibleCorrectAnswersFormatted = entry.germanWords.joinToString(" / ")
            }

            if (correctAnswers.any { it.equals(userAnswer, ignoreCase = true) }) {
                resultTextView.text = "Richtig!"
                loadNewWord()
            } else {
                resultTextView.text = "Falsch. Richtige Antwort(en): $allPossibleCorrectAnswersFormatted"
            }
        } ?: run {
            resultTextView.text = "Bitte zuerst eine Liste auswählen und ein Wort laden."
        }
    }
}
