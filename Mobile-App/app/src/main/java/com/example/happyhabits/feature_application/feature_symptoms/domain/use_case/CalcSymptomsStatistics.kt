package com.example.happyhabits.feature_application.feature_symptoms.domain.use_case

import com.example.happyhabits.feature_application.feature_symptoms.data.model.SymptomStatistics
import com.example.happyhabits.feature_application.feature_symptoms.data.repository.SymptomRepository
import com.example.happyhabits.feature_application.feature_symptoms.domain.repository.ISymptomRepository

class CalcSymptomsStatistics (
    private val symptomRepository: ISymptomRepository
){
    suspend  operator fun invoke(userId: String, monthNumber : Int, yearNumber : Int) : SymptomStatistics?{
        try{
            return symptomRepository.calcSymptomStatistics(userId, monthNumber,  yearNumber)
        }
        catch (e : Exception){
            throw e;
        }
    }
}