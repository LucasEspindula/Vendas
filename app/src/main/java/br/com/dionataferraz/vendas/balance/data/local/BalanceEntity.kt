package br.com.dionataferraz.vendas.balance.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "balanceTable")
data class BalanceEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
//    val date: Date,
    val value: Double,
    val typeDeposit: TypeDeposit,
)
