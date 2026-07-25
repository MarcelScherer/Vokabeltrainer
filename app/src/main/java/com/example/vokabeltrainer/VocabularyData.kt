package com.example.vokabeltrainer

import com.example.vokabeltrainer.Vocabulary_cl_5.cl_5_unit_1
import com.example.vokabeltrainer.Vocabulary_cl_5.cl_5_unit_2
import com.example.vokabeltrainer.Vocabulary_cl_5.cl_5_unit_3
import com.example.vokabeltrainer.Vocabulary_cl_5.cl_5_unit_4
import com.example.vokabeltrainer.Vocabulary_cl_5.cl_5_unit_5
import com.example.vokabeltrainer.Vocabulary_cl_5.cl_5_unit_6

object VocabularyData {



    val combinedList_green_line_1 = cl_5_unit_1 + cl_5_unit_2 + cl_5_unit_3 + cl_5_unit_4 + cl_5_unit_5 + cl_5_unit_6

    val allLists: Map<String, List<VocabularyEntry>> = mapOf(
        "Green Line 1 - Unit 1" to cl_5_unit_1,
        "Green Line 1 - Unit 2" to cl_5_unit_2,
        "Green Line 1 - Unit 3" to cl_5_unit_3,
        "Green Line 1 - Unit 4" to cl_5_unit_4,
        "Green Line 1 - Unit 5" to cl_5_unit_5,
        "Green Line 1 - Unit 6" to cl_5_unit_6,
        "Green Line 1 (alle Vokabeln)" to combinedList_green_line_1,
    )

    // Standardmäßig ausgewählte Liste oder null, wenn keine Vorauswahl getroffen werden soll
    var currentListName: String? = allLists.keys.firstOrNull() // Wählt die erste Liste als Standard

    fun getCurrentVocabularyList(): List<VocabularyEntry>? {
        return currentListName?.let { allLists[it] }
    }
}