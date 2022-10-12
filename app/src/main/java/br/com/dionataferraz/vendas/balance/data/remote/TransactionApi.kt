package br.com.dionataferraz.vendas.balance.data.remote

import br.com.dionataferraz.vendas.model.NewTransactionModel
import retrofit2.http.*

interface TransactionApi {

    @POST("api/transaction/{idUser}")
    suspend fun register(
        @Path("idUser") idUser: String,
        @Body newTransactionModel: NewTransactionModel
    )

    @GET("api/transaction/{idUser}")
    suspend fun fetch(
        @Path("idUser") idUser: String
    ): List<TransactionResponse>

    @DELETE("api/transaction/{idTransaction}")
    suspend fun delete(
        @Path("idTransaction") idTransaction: String
    )
}