package br.com.dionataferraz.vendas.balance

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.dionataferraz.vendas.R
import br.com.dionataferraz.vendas.balance.data.local.TypeDeposit
import br.com.dionataferraz.vendas.balance.data.model.BalanceModel
import br.com.dionataferraz.vendas.databinding.ItemListBinding
import java.text.SimpleDateFormat
import java.util.*

class TransactionAdapter : RecyclerView.Adapter<TransactionViewHolder>() {

    private val listItem: MutableList<BalanceModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TransactionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        val item = listItem[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return listItem.size
    }

    fun addList(list: List<BalanceModel>) {
        listItem.addAll(list)
    }

    fun addNewList(list: List<BalanceModel>) {
        listItem.clear()
        notifyItemRangeRemoved(0, listItem.size)
        listItem.addAll(list)
    }

    fun updateItem(item: BalanceModel, position: Int) {
        listItem[position] = item
        notifyItemChanged(position)
    }
}

class TransactionViewHolder(
    private val binding: ItemListBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(balanceModel: BalanceModel) {
        getFormatedDate(balanceModel.date).also { binding.tvDate.text = it }
        balanceModel.nameTypeBalance.also { binding.tvNameTypeDeposit.text = it }
        "R$ ${balanceModel.value.formats(2)}".also { binding.tvValue.text = it }

        when (balanceModel.typeDeposit) {
            TypeDeposit.Deposit -> binding.icon.setImageResource(R.drawable.ic_baseline_attach_money_24)
            TypeDeposit.Withdraw -> binding.icon.setImageResource(R.drawable.ic_baseline_money_off_24)
        }
    }

    private fun Double.formats(scale: Int) = "%.${scale}f".format(this)

    private fun getFormatedDate(date: Date): String =
        SimpleDateFormat("dd MMM yyyy HH:mm", Locale("pt", "BR")).format(date)
}
