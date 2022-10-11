package br.com.dionataferraz.vendas.model

import br.com.dionataferraz.vendas.balance.data.local.TransactionType

data class TransactionModel(
    val id: Int,
    val value: Double,
    val description: String,
    val transactionType: TransactionType,
)