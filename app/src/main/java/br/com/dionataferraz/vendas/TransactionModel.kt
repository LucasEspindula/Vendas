package br.com.dionataferraz.vendas

import com.squareup.moshi.JsonClass
import java.util.*

@JsonClass(generateAdapter = true)
class TransactionModel(
    val value: Double,
    val time: Date,
    val description: String,
    val transactionType: TransactionType
)

