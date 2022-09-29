package br.com.dionataferraz.vendas.balance.data.model

import br.com.dionataferraz.vendas.balance.data.local.TypeDeposit

data class BalanceModel(
    val value: Double,
    val typeDeposit: TypeDeposit,
)