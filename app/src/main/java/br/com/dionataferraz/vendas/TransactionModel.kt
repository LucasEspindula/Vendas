package br.com.dionataferraz.vendas

import java.util.*

data class TransactionModel(
    val date: Date,
    val value: Double,
    val description: String,
    val transactionType: TransactionType
)

