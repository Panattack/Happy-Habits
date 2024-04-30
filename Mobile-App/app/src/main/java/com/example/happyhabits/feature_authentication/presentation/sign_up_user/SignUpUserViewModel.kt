package com.example.happyhabits.feature_authentication.presentation.sign_up_user

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.happyhabits.feature_authentication.domain.use_case.AuthenticationUseCases
import com.example.happyhabits.feature_authentication.domain.model.InvalidUserException
import com.example.happyhabits.feature_authentication.domain.model.Type
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpUserViewModel @Inject constructor(
    private val authenticationUseCases: AuthenticationUseCases
): ViewModel() {
    private val _state = mutableStateOf(SignUpUserState())
    val state: State<SignUpUserState> = _state;

    fun onEvent(event: SignUpUserEvent) {

        when (event) {
            is SignUpUserEvent.AddUser -> {

                viewModelScope.launch {
                    // TODO Sign up user
                    println(event.firstName + "" + event.lastName + "" + event.email + "" + event.password + "" + event.birthdate + "" + event.speciality)
                    try {
                        val user = authenticationUseCases.addUser(event.firstName, event.lastName, event.email, event.password, event.birthdate, event.speciality, type= Type.CLIENT)
                        println(user)
                        _state.value = _state.value.copy(isSuccess = true)
                    }
                    catch (exception: InvalidUserException) {
                        _state.value = _state.value.copy(isSuccess = false, wrongField = exception.message)
                        when(exception.message) {
                            "Birthdate"-> {
                                _state.value = _state.value.copy(error = "The birth date cannot be empty !")
                            }
                            "Email"-> {
                                _state.value = _state.value.copy(error = "The email cannot be empty !")
                            }

                            "Last Name"-> {
                                _state.value = _state.value.copy(error = "The last name cannot be empty !")
                            }
                            "First Name"-> {
                                _state.value = _state.value.copy(error = "The first name cannot be empty !")
                            }
                            "Password"-> {
                                _state.value = _state.value.copy(error = "The password cannot be empty !")
                            }
                        }
                    }
                }
            }
        }
    }
}

