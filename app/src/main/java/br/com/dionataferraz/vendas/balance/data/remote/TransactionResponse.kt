package br.com.dionataferraz.vendas.balance.data.remote

import br.com.dionataferraz.vendas.balance.data.local.TransactionType

data class TransactionResponse(
    val id: Int,
    val value: Double,
    val description: String,
    val transactionType: TransactionType,
)
