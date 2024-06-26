package com.example.happyhabits.feature_application.feature_symptoms.presentation.syptoms_screen

import android.os.Build
import androidx.annotation.RequiresApi


data class  SymptomsState @RequiresApi(Build.VERSION_CODES.O) constructor(
    var symptom : String ="",
    var notes : String = "",
    var showErrorMessage : Boolean = false
)