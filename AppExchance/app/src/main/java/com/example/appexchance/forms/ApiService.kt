package com.example.appexchance.forms

import com.example.appexchance.forms.models.LoginRequest
import com.example.appexchance.forms.models.RespostaDoServidor
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("/estudantes/login")
    fun login(@Body loginRequest: LoginRequest): Call<RespostaDoServidor>
}
