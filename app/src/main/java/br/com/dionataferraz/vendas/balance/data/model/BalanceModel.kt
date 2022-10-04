package br.com.dionataferraz.vendas.balance.data.model

import br.com.dionataferraz.vendas.balance.data.local.TypeDeposit
import java.util.*

data class BalanceModel(
    val value: Double,
    val date: Date,
    val nameTypeBalance: String,
    val typeDeposit: TypeDeposit,
)