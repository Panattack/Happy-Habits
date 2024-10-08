package com.example.happyhabits.feature_application.feature_symptoms.presentation.symptoms_statistics_screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.happyhabits.R
import com.example.happyhabits.core.data.model.Manager
import com.example.happyhabits.core.domain.use_case.CoreUseCases
import com.example.happyhabits.feature_application.feature_chat.domain.use_case.FriendChatUseCases
import com.example.happyhabits.feature_application.feature_symptoms.domain.use_case.SymptomUseCases
import com.example.happyhabits.feature_application.feauture_sleep.presentation.sleep_statistics_screen.SleepStatisticsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.Month
import java.time.format.TextStyle
import java.util.Calendar
import java.util.Locale
import javax.inject.Inject

@RequiresApi(Build.VERSION_CODES.O)
@HiltViewModel
class SymptomsStatisticsPageViewModel @Inject constructor(
    private val friendChatUseCases: FriendChatUseCases,
    private val coreUseCases: CoreUseCases,
    private val symptomUseCases: SymptomUseCases
) : ViewModel() {

    @RequiresApi(Build.VERSION_CODES.O)
    private val _state = mutableStateOf(SymptomStatisticsState())
    @RequiresApi(Build.VERSION_CODES.O)
    val state: State<SymptomStatisticsState> = _state ;


    init {
        val calendar = Calendar.getInstance()
        val currentMonth = LocalDate.now().month.value
        val currentYear = LocalDate.now().year
        val userId: String = Manager.currentUser?.id.toString()
        viewModelScope.launch {
            val friends = friendChatUseCases.getFriendList(userId)
            _state.value = _state.value.copy(clientsList = friends)
            Manager.currentUser?.let{
                val symptomStat = symptomUseCases.calcSymptomsStatistics(
                    it.id,
                    currentMonth,
                    currentYear
                )
                if(symptomStat != null){
                    setList(symptomStat.symptomList)

                }
            }
        }
    }


    @RequiresApi(Build.VERSION_CODES.O)
    fun onEvent(event : SymptomStatisticsPageEvent){
        when(event){
            is SymptomStatisticsPageEvent.MonthHasChanged->{
                viewModelScope.launch {
                    Manager.currentUser?.let {
                        val symptomStat = symptomUseCases.calcSymptomsStatistics(
                            it.id,
                            event.monthNumber,
                            LocalDate.now().year
                        )
                        if(symptomStat != null){
                            setList(symptomStat.symptomList)
                            setMonth(event.monthNumber)
                        }
                    }
                }
            }
            is SymptomStatisticsPageEvent.SendStatistics-> {
                val symptomsStatisticsDictionary =  mapOf(
                    "symptomList" to _state.value.symptomList
                )
                viewModelScope.launch {
                    val response = coreUseCases.sendStatistics(
                        senderId = Manager.currentUser?.id.toString(),
                        groupId = _state.value.clientsList[event.indexOfFriend].groupId,
                        type = "Symptom",
                        statistics = symptomsStatisticsDictionary,
                        friendUsername = _state.value.clientsList[event.indexOfFriend].friendUsername
                    )
                }
            }
        }
    }
    @RequiresApi(Build.VERSION_CODES.O)
    fun setList(list : List<String>){
        _state.value = _state.value.copy(symptomList = list)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun setMonth(monthNumber : Int){
        _state.value = _state.value.copy(month= Month.of(monthNumber).getDisplayName(TextStyle.FULL, Locale.getDefault()))
    }


    fun getImage(name: String): Int {
        if (name == "Fever" || name == "Headaches" || name == "Dizziness" || name == "Vision Disturbances" || name == "Earaches"
            || name == "Nasal Congestion" || name == "Sore Throats" || name == "Swollen Lymph Nodes"
        ) {
            return R.drawable.head_neck
        }
        if (name == "Urinary Urgency" || name == "Painful Urination" || name == "Pelvic Pain" || name == "Menstrual Cramps" || name == "Erectile Dysfunction") {
            return R.drawable.pelvic_icon
        }
        if (name == "Chest Pain" || name == "Shortness of Breath" || name == "Coughing" || name == "Heart Palpitations" || name == "Back Pain") {
            return R.drawable.back_icon
        }
        if (name == "Abdominal Pain" || name == "Nausea" || name == "Vomiting" || name == "Diarrhea" || name == "Constipation" || name == "Bloating" || name == "Gas" || name == "Cramping") {
            return R.drawable.abdomen
        }
        if (name == "Seizure" || name == "Loss of Consciousness" || name == "Memory Loss" || name == "Tremor" || name == "Involuntary movements" || name == "Balance Issues") {
            return R.drawable.neuro_icon
        }
        if (name == "Joint Pain" || name == "Swelling" || name == "Muscle Pain" || name == "Weakness" || name == "Numbness" || name == "Tingling Sensation") {
            return R.drawable.limbs_icon
        }

        return R.drawable.skin_icon

    }
}




