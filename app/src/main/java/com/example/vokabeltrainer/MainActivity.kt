package com.example.vokabeltrainer

import android.os.Bundle
import android.os.Handler
import android.os.Looper
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
    private lateinit var solutionButton: Button // NEU: Variable für den Lösungs-Button
    private lateinit var resultTextView: TextView
    private lateinit var directionRadioGroup: RadioGroup

    private var currentVocabularyEntry: VocabularyEntry? = null
    private var isGermanToEnglish: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // UI-Elemente initialisieren
        listSpinner = findViewById(R.id.listSpinner)
        wordToTranslateTextView = findViewById(R.id.wordToTranslateTextView)
        translationEditText = findViewById(R.id.translationEditText)
        checkButton = findViewById(R.id.checkButton)
        solutionButton = findViewById(R.id.solutionButton) // NEU: Lösungs-Button initialisieren
        resultTextView = findViewById(R.id.resultTextView)
        directionRadioGroup = findViewById(R.id.directionRadioGroup)

        setupSpinner()

        directionRadioGroup.setOnCheckedChangeListener { _, _ ->
            loadNewWord()
        }

        checkButton.setOnClickListener {
            checkTranslation()
        }

        // NEU: Click-Listener für den Lösungs-Button
        solutionButton.setOnClickListener {
            showSolution()
        }
    }

    private fun setupSpinner() {
        val listNames = VocabularyData.allLists.keys.toList()
        if (listNames.isEmpty()) {
            // UI für leeren Zustand deaktivieren
            listSpinner.isEnabled = false
            checkButton.isEnabled = false
            solutionButton.isEnabled = false // NEU: Auch Lösungs-Button deaktivieren
            translationEditText.isEnabled = false
            return
        }
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
        }else{
            listSpinner.isEnabled = false
        }
    }

    private fun loadNewWord() {
        val currentList = VocabularyData.getCurrentVocabularyList()

        if (currentList.isNullOrEmpty()) {
            wordToTranslateTextView.text = if (VocabularyData.allLists.isEmpty()) "Keine Listen vorhanden" else "Wähle eine Liste"
            translationEditText.isEnabled = false
            checkButton.isEnabled = false
            solutionButton.isEnabled = false // NEU: Auch Lösungs-Button deaktivieren
            currentVocabularyEntry = null
            return
        }

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
                if (entry.englishWords.isNotEmpty()) {
                    val wordToShow = entry.englishWords.random()
                    wordToTranslateTextView.text = "Englisch: $wordToShow"
                } else {
                    loadNewWord()
                    return@let
                }
            }
        }

        translationEditText.text.clear()
        resultTextView.text = ""
        translationEditText.isEnabled = true
        checkButton.isEnabled = true
        solutionButton.isEnabled = true // NEU: Lösungs-Button aktivieren
    }

    private fun checkTranslation() {
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
                // Mit einer kleinen Verzögerung ein neues Wort laden
                Handler(Looper.getMainLooper()).postDelayed({
                    loadNewWord()
                }, 1000) // 1 Sekunde Verzögerung
            } else {
                resultTextView.text = "Falsch. Richtige Antwort(en): $allPossibleCorrectAnswersFormatted"
            }
        } ?: run {
            resultTextView.text = "Bitte zuerst eine Liste auswählen."
        }
    }

    // Angepasste Methode zum Anzeigen der Lösung
    private fun showSolution() {
        currentVocabularyEntry?.let { entry ->
            val correctAnswers = if (isGermanToEnglish) entry.englishWords else entry.germanWords
            val allPossibleCorrectAnswersFormatted = correctAnswers.joinToString(" / ")
            resultTextView.text = "Lösung: $allPossibleCorrectAnswersFormatted"

            // Deaktiviere die Buttons, um doppelte Klicks zu verhindern
            checkButton.isEnabled = false
            solutionButton.isEnabled = false

            // Lade nach einer kurzen Verzögerung ein neues Wort
            Handler(Looper.getMainLooper()).postDelayed({
                loadNewWord()
            }, 2000) // 2 Sekunden Verzögerung
        } ?: run {
            resultTextView.text = "Kein Wort geladen, um eine Lösung anzuzeigen."
        }
    }
}
