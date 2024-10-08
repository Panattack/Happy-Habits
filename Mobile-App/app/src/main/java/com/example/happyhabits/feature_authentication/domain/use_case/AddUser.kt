package com.example.happyhabits.feature_authentication.domain.use_case

import com.example.happyhabits.core.domain.model.InvalidUserException
import com.example.happyhabits.core.domain.model.Type
import com.example.happyhabits.core.domain.model.User
import com.example.happyhabits.feature_authentication.domain.repository.IUserRepository

class AddUser(
    private val repository: IUserRepository
) {

    @Throws(InvalidUserException::class)
    suspend operator fun invoke(firstName: String, lastName: String, email: String, password: String, birthdate: String, specialty: String, type: Type): User? {
        try {
        if (firstName.isBlank()) {
            throw InvalidUserException("First Name")
        }
        if (lastName.isBlank()) {
            throw InvalidUserException("Last Name")
        }
        if (email.isBlank()) {
            throw InvalidUserException("Email")
        }
        if(!email.endsWith("@gmail.com")){
            throw InvalidUserException("Email must be gmail for statistics !")
        }
        if (password.isBlank()) {
            throw InvalidUserException("Password")
        }
        if (birthdate == "DD/MM/YY") {
            throw InvalidUserException("Birthdate")
        }
        return repository.addNewUser(firstName= firstName, lastName= lastName, email= email, password= password, birthdate= birthdate, speciality= specialty, type= type)
        } catch (e: Exception) {
            throw e;
        }
    }
}
