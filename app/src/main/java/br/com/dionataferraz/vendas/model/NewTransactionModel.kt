package br.com.dionataferraz.vendas.model

import br.com.dionataferraz.vendas.balance.data.local.TransactionType

data class NewTransactionModel (
    val value: Double,
    val description: String,
    val transactionType: TransactionType
)