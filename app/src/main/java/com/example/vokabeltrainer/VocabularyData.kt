package com.example.vokabeltrainer // Stelle sicher, dass der Paketname korrekt ist

// Datenklasse für Vokabeleinträge (kann auch hier bleiben oder in einer eigenen Datei sein)
data class VocabularyEntry(
    val germanWords: List<String>,
    val englishWords: List<String>
)

object VocabularyData {
    val listOne = listOf(
        VocabularyEntry(germanWords = listOf("Hund", ), englishWords = listOf("dog")),
        VocabularyEntry(germanWords = listOf("Maus"), englishWords = listOf("mice")),
        VocabularyEntry(germanWords = listOf("Ball"), englishWords = listOf("ball")),
        VocabularyEntry(germanWords = listOf("verschieden", "unterschiedlich"), englishWords = listOf("different")),
        VocabularyEntry(germanWords = listOf("knapp", "geschlossen"), englishWords = listOf("close")),
        VocabularyEntry(germanWords = listOf("See"), englishWords = listOf("lake")),
        VocabularyEntry(germanWords = listOf("Boot"), englishWords = listOf("boat")),
        VocabularyEntry(germanWords = listOf("Rätsel"), englishWords = listOf("puzzle")),
        VocabularyEntry(germanWords = listOf("Angst haben", "sich fürchten"), englishWords = listOf("scared")),
        VocabularyEntry(germanWords = listOf("Freund"), englishWords = listOf("friend")),
        VocabularyEntry(germanWords = listOf("Wort"), englishWords = listOf("word")),
        VocabularyEntry(germanWords = listOf("essen"), englishWords = listOf("eat")),
        VocabularyEntry(germanWords = listOf("derselbe", "der gleiche"), englishWords = listOf("the same")),
        VocabularyEntry(germanWords = listOf("deutsch"), englishWords = listOf("German"))
        // Füge hier bei Bedarf weitere Einträge hinzu
    )

    val Pick_up_A = listOf(
        VocabularyEntry(germanWords = listOf("Greenwich"), englishWords = listOf("Greenwich")),
                VocabularyEntry(germanWords = listOf("Park"), englishWords = listOf("park")),
                VocabularyEntry(germanWords = listOf("Junge"), englishWords = listOf("boy")),
                VocabularyEntry(germanWords = listOf("Mädchen"), englishWords = listOf("girl")),
                VocabularyEntry(germanWords = listOf("Hund"), englishWords = listOf("dog")),
                VocabularyEntry(germanWords = listOf("Katze"), englishWords = listOf("cat")),
                VocabularyEntry(germanWords = listOf("Maus"), englishWords = listOf("mouse")),
                VocabularyEntry(germanWords = listOf("verrückt"), englishWords = listOf("crazy")),
                VocabularyEntry(germanWords = listOf("nett"), englishWords = listOf("nice")),
                VocabularyEntry(germanWords = listOf("ich"), englishWords = listOf("I")),
                VocabularyEntry(germanWords = listOf("mein", "meine"), englishWords = listOf("my")),
                VocabularyEntry(germanWords = listOf("Name"), englishWords = listOf("name")),
                VocabularyEntry(germanWords = listOf("schau"), englishWords = listOf("look")),
                VocabularyEntry(germanWords = listOf("hallo"), englishWords = listOf("hello")),
                VocabularyEntry(germanWords = listOf("Entschuldigung"), englishWords = listOf("sorry")),
                VocabularyEntry(germanWords = listOf("danke"), englishWords = listOf("thank")),
                VocabularyEntry(germanWords = listOf("das"), englishWords = listOf("this")),
                VocabularyEntry(germanWords = listOf("zwei"), englishWords = listOf("two")),
                VocabularyEntry(germanWords = listOf("und"), englishWords = listOf("and")),
                VocabularyEntry(germanWords = listOf("ein", "eine"), englishWords = listOf("a")),
                VocabularyEntry(germanWords = listOf("nicht"), englishWords = listOf("not")),
                VocabularyEntry(germanWords = listOf("Freunde"), englishWords = listOf("friends")),
                VocabularyEntry(germanWords = listOf("du", "Sie"), englishWords = listOf("you")),
                VocabularyEntry(germanWords = listOf("dein", "Ihre"), englishWords = listOf("your")),

    )

    val allLists: Map<String, List<VocabularyEntry>> = mapOf(
        "Liste 1:" to listOne,
        "Liste 2: Pick up A " to Pick_up_A
        // Füge hier weitere Listen hinzu, z.B. "Liste 3: Verben" to listThree
    )

    // Standardmäßig ausgewählte Liste oder null, wenn keine Vorauswahl getroffen werden soll
    var currentListName: String? = allLists.keys.firstOrNull() // Wählt die erste Liste als Standard

    fun getCurrentVocabularyList(): List<VocabularyEntry>? {
        return currentListName?.let { allLists[it] }
    }
}