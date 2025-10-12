package com.example.vokabeltrainer

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup // Wichtig: Import hinzufügen
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var listSpinner: Spinner
    private lateinit var wordToTranslateTextView: TextView
    private lateinit var translationEditText: EditText
    private lateinit var checkButton: Button
    private lateinit var resultTextView: TextView
    private lateinit var directionRadioGroup: RadioGroup // NEU: Variable für die RadioGroup

    private var currentVocabularyEntry: VocabularyEntry? = null
    // 'isGermanToEnglish' wird jetzt in loadNewWord() gesetzt, nicht mehr hier
    private var isGermanToEnglish: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // UI-Elemente initialisieren
        listSpinner = findViewById(R.id.listSpinner)
        wordToTranslateTextView = findViewById(R.id.wordToTranslateTextView)
        translationEditText = findViewById(R.id.translationEditText)
        checkButton = findViewById(R.id.checkButton)
        resultTextView = findViewById(R.id.resultTextView)
        directionRadioGroup = findViewById(R.id.directionRadioGroup) // NEU

        setupSpinner()

        // NEU: Listener für die RadioGroup, um beim Wechsel der Richtung sofort ein neues Wort zu laden
        directionRadioGroup.setOnCheckedChangeListener { _, _ ->
            loadNewWord()
        }

        checkButton.setOnClickListener {
            checkTranslation()
        }
    }

    private fun setupSpinner() {
        // ... (deine bestehende setupSpinner Methode bleibt unverändert)
        val listNames = VocabularyData.allLists.keys.toList()
        if (listNames.isEmpty()) { /* ... */ return }
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, listNames)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        listSpinner.adapter = adapter
        listSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val selectedListName = parent.getItemAtPosition(position) as String
                VocabularyData.currentListName = selectedListName
                loadNewWord()
            }
            override fun onNothingSelected(parent: AdapterView<*>) {
                VocabularyData.currentListName = null
                loadNewWord()
            }
        }
        VocabularyData.currentListName?.let { name ->
            val initialPosition = listNames.indexOf(name)
            if (initialPosition >= 0) listSpinner.setSelection(initialPosition)
        } ?: if (listNames.isNotEmpty()) {
            listSpinner.setSelection(0)
        } else {

        }
    }

    private fun loadNewWord() {
        val currentList = VocabularyData.getCurrentVocabularyList()

        if (currentList.isNullOrEmpty()) {
            wordToTranslateTextView.text = if (VocabularyData.allLists.isEmpty()) "Keine Listen vorhanden" else "Wähle eine Liste"
            translationEditText.isEnabled = false
            checkButton.isEnabled = false
            currentVocabularyEntry = null
            return
        }

        // NEU: Übersetzungsrichtung basierend auf der RadioGroup festlegen
        isGermanToEnglish = when (directionRadioGroup.checkedRadioButtonId) {
            R.id.radioGermanToEnglish -> true
            R.id.radioEnglishToGerman -> false
            else -> Random.nextBoolean() // Für "Gemischt"
        }

        currentVocabularyEntry = currentList.random()

        currentVocabularyEntry?.let { entry ->
            if (isGermanToEnglish) {
                val wordToShow = entry.germanWords.random()
                wordToTranslateTextView.text = "Deutsch: $wordToShow"
            } else {
                // Sicherstellen, dass die englische Liste nicht leer ist
                if (entry.englishWords.isNotEmpty()) {
                    val wordToShow = entry.englishWords.random()
                    wordToTranslateTextView.text = "Englisch: $wordToShow"
                } else {
                    // Fallback, falls ein Eintrag keine englischen Wörter hat
                    loadNewWord()
                    return@let
                }
            }
        }

        translationEditText.text.clear()
        resultTextView.text = ""
        translationEditText.isEnabled = true
        checkButton.isEnabled = true
    }

    private fun checkTranslation() {
        // ... (deine bestehende checkTranslation Methode bleibt unverändert)
        val userAnswer = translationEditText.text.toString().trim()
        if (userAnswer.isEmpty()) {
            resultTextView.text = "Bitte gib eine Übersetzung ein."
            return
        }
        currentVocabularyEntry?.let { entry ->
            val correctAnswers = if (isGermanToEnglish) entry.englishWords else entry.germanWords
            val allPossibleCorrectAnswersFormatted = correctAnswers.joinToString(" / ")

            if (correctAnswers.any { it.equals(userAnswer, ignoreCase = true) }) {
                resultTextView.text = "Richtig!"
                loadNewWord()
            } else {
                resultTextView.text = "Falsch. Richtige Antwort(en): $allPossibleCorrectAnswersFormatted"
            }
        } ?: run {
            resultTextView.text = "Bitte zuerst eine Liste auswählen."
        }
    }
}
