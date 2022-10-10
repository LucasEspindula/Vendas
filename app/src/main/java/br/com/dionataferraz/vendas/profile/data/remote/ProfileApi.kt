package br.com.dionataferraz.vendas.profile.data.remote

import br.com.dionataferraz.vendas.model.UserModel
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query

interface ProfileApi {
    @POST("api/login")
    suspend fun profile(
        @Body userModel: UserModel
    ): UserModel
}