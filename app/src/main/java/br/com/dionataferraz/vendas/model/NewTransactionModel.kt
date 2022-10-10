package br.com.dionataferraz.vendas.model

import br.com.dionataferraz.vendas.balance.data.local.TransactionType

data class NewTransactionModel (
    val value: Double,
//    val date: String,
    var description: String,
    var transactionType: TransactionType,
)