package br.com.dionataferraz.vendas.model

import br.com.dionataferraz.vendas.balance.data.local.TransactionType

data class TransactionModel(
    val id: Int,
    val value: Double,
//    val transactionDate: String,
    var description: String,
    var transactionType: TransactionType,
)