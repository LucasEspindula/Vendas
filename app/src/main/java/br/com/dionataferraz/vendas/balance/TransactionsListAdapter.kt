package br.com.dionataferraz.vendas.balance

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.dionataferraz.vendas.R
import br.com.dionataferraz.vendas.balance.data.local.TransactionType
import br.com.dionataferraz.vendas.databinding.ItemListBinding
import br.com.dionataferraz.vendas.model.TransactionModel
import java.text.SimpleDateFormat
import java.util.*

class TransactionsListAdapter : RecyclerView.Adapter<TransactionViewHolder>() {

    private val listItem: MutableList<TransactionModel> =
        mutableListOf()

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

    fun addList(list: List<TransactionModel>) {
        listItem.addAll(list)
    }

    fun removeAt(index: Int): TransactionModel {
        notifyItemRemoved(index)
        return listItem.removeAt(index)
    }

    fun addNewList(list: List<TransactionModel>) {
        listItem.clear()
        notifyItemRangeRemoved(0, listItem.size)
        listItem.addAll(list)
    }

    fun updateItem(item: TransactionModel, position: Int) {
        listItem[position] = item
        notifyItemChanged(position)
    }
}

class TransactionViewHolder(
    private val binding: ItemListBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(transactionModel: TransactionModel) {
        transactionModel.description.also { binding.tvDescription.text = it }
        "R$ ${transactionModel.value.formats(2)}".also { binding.tvValue.text = it }
//        getFormatedDate(transactionModel.transactionDate).also { binding.tvDate.text = it }

        when (transactionModel.transactionType) {
            TransactionType.MARKET -> binding.icon.setImageResource(R.drawable.ic_baseline_shopping_cart_24)
            TransactionType.GAS_STATION -> binding.icon.setImageResource(R.drawable.ic_baseline_local_gas_station_24)
            TransactionType.PUB -> binding.icon.setImageResource(R.drawable.ic_baseline_sports_bar_24)
        }
    }

    private fun Double.formats(scale: Int) = "%.${scale}f".format(this)

//    private fun getFormatedDate(date: String): String =
//        SimpleDateFormat("dd MMM yyyy HH:mm", Locale("pt", "BR")).format(date)
}
