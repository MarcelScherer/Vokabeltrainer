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
        VocabularyEntry(germanWords = listOf("deutsch"), englishWords = listOf("German")),
        VocabularyEntry(germanWords = listOf("rot"), englishWords = listOf("red")),
        VocabularyEntry(germanWords = listOf("grün"), englishWords = listOf("green")),
        VocabularyEntry(germanWords = listOf("gelb"), englishWords = listOf("yellow")),
        VocabularyEntry(germanWords = listOf("blau"), englishWords = listOf("blue")),
        VocabularyEntry(germanWords = listOf("grau"), englishWords = listOf("grey")),
        VocabularyEntry(germanWords = listOf("schwarz"), englishWords = listOf("black")),
        VocabularyEntry(germanWords = listOf("weis"), englishWords = listOf("white")),
        VocabularyEntry(germanWords = listOf("orange"), englishWords = listOf("orange")),
        VocabularyEntry(germanWords = listOf("Lila"), englishWords = listOf("purple")),
        VocabularyEntry(germanWords = listOf("braun"), englishWords = listOf("brown")),
        VocabularyEntry(germanWords = listOf("pink"), englishWords = listOf("pink")),
        VocabularyEntry(germanWords = listOf("null", "0"), englishWords = listOf("zero")),
        VocabularyEntry(germanWords = listOf("eins", "1"), englishWords = listOf("one")),
        VocabularyEntry(germanWords = listOf("zwei", "2"), englishWords = listOf("two")),
        VocabularyEntry(germanWords = listOf("drei", "3"), englishWords = listOf("three")),
        VocabularyEntry(germanWords = listOf("vier", "4"), englishWords = listOf("four")),
        VocabularyEntry(germanWords = listOf("fünf", "5"), englishWords = listOf("five")),
        VocabularyEntry(germanWords = listOf("sechs", "6"), englishWords = listOf("six")),
        VocabularyEntry(germanWords = listOf("sieben", "7"), englishWords = listOf("seven")),
        VocabularyEntry(germanWords = listOf("acht", "8"), englishWords = listOf("eight")),
        VocabularyEntry(germanWords = listOf("neun", "9"), englishWords = listOf("nine")),
        VocabularyEntry(germanWords = listOf("zehn", "10"), englishWords = listOf("ten")),
        VocabularyEntry(germanWords = listOf("elf", "11"), englishWords = listOf("eleven")),
        VocabularyEntry(germanWords = listOf("zwölf", "12"), englishWords = listOf("twelve")),
        // Füge hier bei Bedarf weitere Einträge hinzu
    )

    val Unit1_check_in = listOf(
        VocabularyEntry(germanWords = listOf("zu Hause"), englishWords = listOf("at home")),
        VocabularyEntry(germanWords = listOf("Familie"), englishWords = listOf("family")),
        VocabularyEntry(germanWords = listOf("wohnen", "leben"), englishWords = listOf("to live")),
        VocabularyEntry(germanWords = listOf("Wohnung"), englishWords = listOf("flat")),
        VocabularyEntry(germanWords = listOf("in der Straße", "auf der Straße"), englishWords = listOf("in the street")),
        VocabularyEntry(germanWords = listOf("Haus"), englishWords = listOf("house")),
        VocabularyEntry(germanWords = listOf("Tür"), englishWords = listOf("door")),
        VocabularyEntry(germanWords = listOf("Fernsehen", "Fernseher"), englishWords = listOf("TV", "television")),
        VocabularyEntry(germanWords = listOf("Stuhl", "Sessel"), englishWords = listOf("chair")),
        VocabularyEntry(germanWords = listOf("Tisch"), englishWords = listOf("table")),
        VocabularyEntry(germanWords = listOf("Dusche"), englishWords = listOf("shower")),
        VocabularyEntry(germanWords = listOf("Bad", "Badewanne"), englishWords = listOf("bath")),
        VocabularyEntry(germanWords = listOf("Toilette"), englishWords = listOf("toilet")),
        VocabularyEntry(germanWords = listOf("Bett"), englishWords = listOf("bed")),
        VocabularyEntry(germanWords = listOf("Uhr"), englishWords = listOf("clock")),
        VocabularyEntry(germanWords = listOf("Kleiderschrank"), englishWords = listOf("wardrobe")),
        VocabularyEntry(germanWords = listOf("Küchenschrank", "Schrank"), englishWords = listOf("cupboard")),
        VocabularyEntry(germanWords = listOf("Herd"), englishWords = listOf("cooker")),
        VocabularyEntry(germanWords = listOf("Wohnzimmer"), englishWords = listOf("living room")),
        VocabularyEntry(germanWords = listOf("Schlafzimmer"), englishWords = listOf("bedroom")),
        VocabularyEntry(germanWords = listOf("Küche"), englishWords = listOf("kitchen")),
        VocabularyEntry(germanWords = listOf("Bad", "Badezimmer"), englishWords = listOf("bathroom")),
        VocabularyEntry(germanWords = listOf("gut"), englishWords = listOf("good")),
        VocabularyEntry(germanWords = listOf("Keks"), englishWords = listOf("biscuit")),
        VocabularyEntry(germanWords = listOf("unter"), englishWords = listOf("under")),
        VocabularyEntry(germanWords = listOf("helfen"), englishWords = listOf("help")),
        VocabularyEntry(germanWords = listOf("sammeln"), englishWords = listOf("collect")),
        VocabularyEntry(germanWords = listOf("neu"), englishWords = listOf("new")),
        VocabularyEntry(germanWords = listOf("klein"), englishWords = listOf("small")),
    )

    val Unit1_this_is_my_family = listOf(
        VocabularyEntry(germanWords = listOf("Schwester"), englishWords = listOf("sister")),
        VocabularyEntry(germanWords = listOf("Bruder"), englishWords = listOf("brother")),
        VocabularyEntry(germanWords = listOf("Vater"), englishWords = listOf("father")),
        VocabularyEntry(germanWords = listOf("Mutter"), englishWords = listOf("mother")),
        VocabularyEntry(germanWords = listOf("Cousin", "Cousine"), englishWords = listOf("cousin")),
        VocabularyEntry(germanWords = listOf("ein", "eine"), englishWords = listOf("an", "a")),
        VocabularyEntry(germanWords = listOf("Einzelkind"), englishWords = listOf("only child")),
        VocabularyEntry(germanWords = listOf("Papa"), englishWords = listOf("dad")),
        VocabularyEntry(germanWords = listOf("sie ist"), englishWords = listOf("she's")),
        VocabularyEntry(germanWords = listOf("ist nicht"), englishWords = listOf("isn't", "is not")),
        VocabularyEntry(germanWords = listOf("immer", "ständig"), englishWords = listOf("always")),
        VocabularyEntry(germanWords = listOf("einfach", "leicht"), englishWords = listOf("easy")),
        VocabularyEntry(germanWords = listOf("er ist"), englishWords = listOf("he's")),
        VocabularyEntry(germanWords = listOf("Mama"), englishWords = listOf("mum")),
        VocabularyEntry(germanWords = listOf("Onkel"), englishWords = listOf("uncle")),
        VocabularyEntry(germanWords = listOf("Tante"), englishWords = listOf("aunt")),
        VocabularyEntry(germanWords = listOf("Opa"), englishWords = listOf("grandad")),
        VocabularyEntry(germanWords = listOf("Oma"), englishWords = listOf("grandma")),
        VocabularyEntry(germanWords = listOf("Stammbaum"), englishWords = listOf("family tree")),
        VocabularyEntry(germanWords = listOf("Erzähle mir von"), englishWords = listOf("Tell me about")),
        VocabularyEntry(germanWords = listOf("Meerschweinchen"), englishWords = listOf("guinea pig")),
        VocabularyEntry(germanWords = listOf("still", "ruhig", "leise"), englishWords = listOf("quiet")),
        VocabularyEntry(germanWords = listOf("Sprache"), englishWords = listOf("language")),
        VocabularyEntry(germanWords = listOf("erst", "bloß", "nur"), englishWords = listOf("only")),
        VocabularyEntry(germanWords = listOf("falsch"), englishWords = listOf("wrong")),
        VocabularyEntry(germanWords = listOf("Danke"), englishWords = listOf("Thanks")),
        VocabularyEntry(germanWords = listOf("sehr"), englishWords = listOf("very")),
        VocabularyEntry(germanWords = listOf("einige", "ein paar", "etwas"), englishWords = listOf("some")),
        VocabularyEntry(germanWords = listOf("von"), englishWords = listOf("of")),
        VocabularyEntry(germanWords = listOf("grüßen", "Grüße ausrichten"), englishWords = listOf("to say hello")),
        VocabularyEntry(germanWords = listOf("zu", "nach", "auf", "in"), englishWords = listOf("to")),
        VocabularyEntry(germanWords = listOf("nett"), englishWords = listOf("nice")),
        VocabularyEntry(germanWords = listOf("cool"), englishWords = listOf("cool")),
        VocabularyEntry(germanWords = listOf("großartig"), englishWords = listOf("great")),
        VocabularyEntry(germanWords = listOf("witzig"), englishWords = listOf("fun")),
        VocabularyEntry(germanWords = listOf("in Ordnung"), englishWords = listOf("OK")),
        VocabularyEntry(germanWords = listOf("verrückt"), englishWords = listOf("crazy")),
        VocabularyEntry(germanWords = listOf("ruhig"), englishWords = listOf("quiet")),
        VocabularyEntry(germanWords = listOf("klein"), englishWords = listOf("small")),
        VocabularyEntry(germanWords = listOf("groß"), englishWords = listOf("tall")),
        VocabularyEntry(germanWords = listOf("freundlich"), englishWords = listOf("friendly")),
        VocabularyEntry(germanWords = listOf("schlau"), englishWords = listOf("clever")),
        VocabularyEntry(germanWords = listOf("albern", "dumm"), englishWords = listOf("silly")),
        VocabularyEntry(germanWords = listOf("laut"), englishWords = listOf("noisy")),
        VocabularyEntry(germanWords = listOf("klein"), englishWords = listOf("short"))
    )

    val Unit1_whats_the_problem = listOf(
        VocabularyEntry(germanWords = listOf("Problem", "Schwierigkeit"), englishWords = listOf("problem")),
        VocabularyEntry(germanWords = listOf("da ist/sind", "es gibt"), englishWords = listOf("there is/are")),
        VocabularyEntry(germanWords = listOf("da", "dort", "dahin", "dorthin"), englishWords = listOf("there")),
        VocabularyEntry(germanWords = listOf("Garten"), englishWords = listOf("garden")),
        VocabularyEntry(germanWords = listOf("hinter"), englishWords = listOf("behind")),
        VocabularyEntry(germanWords = listOf("nett"), englishWords = listOf("nice")),
        VocabularyEntry(germanWords = listOf("cool"), englishWords = listOf("cool")),
        VocabularyEntry(germanWords = listOf("großartig"), englishWords = listOf("great")),
        VocabularyEntry(germanWords = listOf("witzig"), englishWords = listOf("fun")),
        VocabularyEntry(germanWords = listOf("in Ordnung"), englishWords = listOf("OK")),
        VocabularyEntry(germanWords = listOf("verrückt"), englishWords = listOf("crazy")),
        VocabularyEntry(germanWords = listOf("klein"), englishWords = listOf("small", "little")),
        VocabularyEntry(germanWords = listOf("groß"), englishWords = listOf("tall")),
        VocabularyEntry(germanWords = listOf("freundlich"), englishWords = listOf("friendly")),
    )

    val combinedList = listOne + Unit1_check_in + Unit1_this_is_my_family + Unit1_whats_the_problem

    val allLists: Map<String, List<VocabularyEntry>> = mapOf(
        "Wiederholung (alle Vokabeln)" to listOne,
        "Unit 1 - check in " to Unit1_check_in,
        "Unit 1 - this is my family " to Unit1_this_is_my_family,
        "Unit 1 - what's the problem? " to Unit1_whats_the_problem
        // Füge hier weitere Listen hinzu, z.B. "Liste 3: Verben" to listThree
    )

    // Standardmäßig ausgewählte Liste oder null, wenn keine Vorauswahl getroffen werden soll
    var currentListName: String? = allLists.keys.firstOrNull() // Wählt die erste Liste als Standard

    fun getCurrentVocabularyList(): List<VocabularyEntry>? {
        return currentListName?.let { allLists[it] }
    }
}