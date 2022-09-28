package br.com.dionataferraz.vendas.balance.data.local

import androidx.room.Entity
import java.util.*

@Entity(tableName = "balanceTable")
data class BalanceEntity (
    val date: Date,
    val value: Double,
    val typeDeposit: TypeDeposit,
)
