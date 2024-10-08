package com.example.happyhabits.feature_application.feature_medication.presentation.medication_screen

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.happyhabits.feature_application.feature_medication.Medicine
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject
import com.example.happyhabits.core.data.model.Manager
import com.example.happyhabits.feature_application.feature_medication.domain.use_case.MedicationUseCases
import com.example.happyhabits.feature_application.feature_workout.domain.use_case.WorkoutUseCases
import kotlinx.coroutines.delay
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


@HiltViewModel
class MedicationPageViewmodel @Inject constructor(
    private val medicationUseCases: MedicationUseCases
): ViewModel() {

    private val _state = mutableStateOf(MedicationScreenState())
    val state: State<MedicationScreenState> = _state;
    private var _scanError = mutableStateOf<String?>(null)
    val scanError: State<String?> = _scanError

    init{
        viewModelScope.launch {
            val medsList = Manager.currentUser?.id?.let { medicationUseCases.retrieveMedications(it) } ?: emptyList()
            val numOfPages =if((medsList.size)%9==0){(medsList.size)/9}else{((medsList.size)/9)+1}
            _state.value = _state.value.copy(usersMedications = medsList, numOfPages = numOfPages)
        }
    }
    fun initScanError() {
        _scanError.value = null
        _state.value = _state.value.copy(
            nameToBeAdded = "",
            dosageQuantityToBeAdded = null,
            dosageUnitMeasurementToBeAdded = null,
            startDayToBeAdded = "MM/DD/YY",
            endDayToBeAdded = "MM/DD/YY",
            timesShouldBeTakenTodayToBeAdded = -1,
            notesToBeAdded = ""
        )
    }
    fun onEvent(event: MedicationPageEvent) {

        when (event) {
            is MedicationPageEvent.ChangePage -> {
                viewModelScope.launch {
                    val userId = Manager.currentUser?.id ?: ""
                    val currentDate = Date()
                    val dateFormat = SimpleDateFormat("MM/dd/yy", Locale.getDefault())
                    val formattedDate = dateFormat.format(currentDate)
                    val theIdsOfMedicationsTaken = _state.value.idsOfMedicationsTaken.map { it }.toMutableList()
                    medicationUseCases.logMedication(userId = userId, date = formattedDate, medIds = theIdsOfMedicationsTaken)
                }
            }
            is MedicationPageEvent.MedicationTaken -> {
                viewModelScope.launch {
                    val copyOfTakenMedication = Medicine(_state.value.usersMedications[event.idOfMedication])
                    copyOfTakenMedication.updateTimesTakenToday()
                    val newMedications: MutableList<Medicine> = mutableListOf()
                    var i = 0
                    for (medication in _state.value.usersMedications) {
                        if (medication.getId() != copyOfTakenMedication.getId()) {
                            val medicationToBeAdded = Medicine(medication)
                            newMedications.add(medicationToBeAdded)
                        } else {
                            newMedications.add(copyOfTakenMedication)
                        }
                    }
                    val newIdsOfMedicationsTaken = _state.value.idsOfMedicationsTaken.map { it }.toMutableList()
                    newIdsOfMedicationsTaken.add(copyOfTakenMedication.getId().toString())
                    _state.value = _state.value.copy(usersMedications = newMedications, idsOfMedicationsTaken = newIdsOfMedicationsTaken)
                }
            }
            is MedicationPageEvent.RemoveMedication -> {
                viewModelScope.launch {
                    val copyOfTakenMedication = Medicine(_state.value.usersMedications[event.idOfMedication])
                    medicationUseCases.removeMedication(userId = (copyOfTakenMedication.getUserId())?:"", id = (copyOfTakenMedication.getId())?:"")
                    val medsList = Manager.currentUser?.id?.let { medicationUseCases.retrieveMedications(it) } ?: emptyList()
                    _state.value = _state.value.copy(usersMedications = medsList)
                    val newNumOfPages =if((_state.value.usersMedications.size)%9==0){(_state.value.usersMedications.size)/9}else{((_state.value.usersMedications.size)/9)+1}
                    var newCurrentPage = _state.value.currentPage
                    if(newNumOfPages==_state.value.currentPage)
                    {
                        newCurrentPage = _state.value.currentPage - 1
                    }
                    _state.value = _state.value.copy(numOfPages = newNumOfPages, currentPage = newCurrentPage)
                }
            }
            is MedicationPageEvent.AddMedication -> {
                viewModelScope.launch {
                    try{
                        if (_state.value.nameToBeAdded == "" ||
                            _state.value.dosageQuantityToBeAdded == null ||
                            _state.value.dosageUnitMeasurementToBeAdded == null ||
                            _state.value.dosageUnitMeasurementToBeAdded == "" ||
                            _state.value.startDayToBeAdded == "MM/DD/YY" ||
                            _state.value.endDayToBeAdded == "MM/DD/YY" ||
                            _state.value.timesShouldBeTakenTodayToBeAdded == -1)
                        {
                            // Log the state values to help identify the issue
                            Log.d("MedicineForm", "nameToBeAdded: ${_state.value.nameToBeAdded}")
                            Log.d("MedicineForm", "dosageQuantityToBeAdded: ${_state.value.dosageQuantityToBeAdded}")
                            Log.d("MedicineForm", "dosageUnitMeasurementToBeAdded: ${_state.value.dosageUnitMeasurementToBeAdded}")
                            Log.d("MedicineForm", "startDayToBeAdded: ${_state.value.startDayToBeAdded}")
                            Log.d("MedicineForm", "endDayToBeAdded: ${_state.value.endDayToBeAdded}")
                            Log.d("MedicineForm", "timesShouldBeTakenTodayToBeAdded: ${_state.value.timesShouldBeTakenTodayToBeAdded}")

                            throw Exception("Medicine couldn't be added.\nNot all necessary fields were filled.")
                        }
                        medicationUseCases.addMedication(
                            (Manager.currentUser?.id) ?: "",
                            name = _state.value.nameToBeAdded,
                            dosageQuantity = _state.value.dosageQuantityToBeAdded,
                            dosageUnitMeasurement = _state.value.dosageUnitMeasurementToBeAdded,
                            startDay = _state.value.startDayToBeAdded,
                            endDay = _state.value.endDayToBeAdded,
                            timesShouldBeTakenToday = _state.value.timesShouldBeTakenTodayToBeAdded,
                            notes = _state.value.notesToBeAdded
                        )
                        val medsList = Manager.currentUser?.id?.let {
                            medicationUseCases.retrieveMedications(it)
                        } ?: emptyList()
                        _state.value = _state.value.copy(
                            usersMedications = medsList,
                            nameToBeAdded = "",
                            dosageQuantityToBeAdded = null,
                            dosageUnitMeasurementToBeAdded = null,
                            startDayToBeAdded = "MM/DD/YY",
                            endDayToBeAdded = "MM/DD/YY",
                            timesShouldBeTakenTodayToBeAdded = -1,
                            notesToBeAdded = ""
                        )
                        val newNumOfPages = if ((_state.value.usersMedications.size) % 9 == 0) {
                            (_state.value.usersMedications.size) / 9
                        } else {
                            ((_state.value.usersMedications.size) / 9) + 1
                        }
                        _state.value = _state.value.copy(numOfPages = newNumOfPages)
                    } catch (e: Exception) {
                        _scanError.value = e.message
                    }
                }
            }
            is MedicationPageEvent.UpdatedAddMedication -> {
                viewModelScope.launch {
                    when (event.typeChanged) {
                        "name" -> {
                            _state.value =
                                _state.value.copy(nameToBeAdded = event.newValueString ?: "")
                        }

                        "dosage" -> {
                            _state.value =
                                _state.value.copy(dosageQuantityToBeAdded = event.newValueFloat)
                        }

                        "unitMeasurement" -> {
                            _state.value =
                                _state.value.copy(dosageUnitMeasurementToBeAdded = event.newValueString)
                        }

                        "startDate" -> {
                            _state.value =
                                _state.value.copy(startDayToBeAdded = event.newValueString?: "MM/DD/YY")
                        }

                        "endDate" -> {
                            _state.value =
                                _state.value.copy(endDayToBeAdded = event.newValueString?: "MM/DD/YY")
                        }

                        "perDay" -> {
                            _state.value =
                                _state.value.copy(timesShouldBeTakenTodayToBeAdded = event.newValueInt?:-1)
                        }

                        "notes" -> {
                            _state.value =
                                _state.value.copy(notesToBeAdded = event.newValueString)
                        }
                    }
                }
            }
            is MedicationPageEvent.NextPage -> {
                viewModelScope.launch {
                    if (_state.value.currentPage < _state.value.numOfPages - 1) {
                        val newCurrentPage = _state.value.currentPage + 1
                        _state.value = _state.value.copy(currentPage = newCurrentPage)
                    }
                }
            }
            is MedicationPageEvent.PrevPage -> {
                viewModelScope.launch {
                    if (_state.value.currentPage != 0) {
                        val newCurrentPage = _state.value.currentPage - 1
                        _state.value = _state.value.copy(currentPage = newCurrentPage)
                    }
                }
            }
        }
    }
}