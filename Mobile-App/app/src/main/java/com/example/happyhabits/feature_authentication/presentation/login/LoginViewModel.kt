package com.example.happyhabits.feature_authentication.presentation.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.happyhabits.feature_authentication.domain.use_case.AuthenticationUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authenticationUseCases: AuthenticationUseCases
): ViewModel() {
    private val _state = mutableStateOf(LoginState())
    val state: State<LoginState> = _state;

    fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.Validate -> {
                viewModelScope.launch {
                    authenticationUseCases.authenticateUser(event.password, event.email);
                }
            }
        }
    }
}