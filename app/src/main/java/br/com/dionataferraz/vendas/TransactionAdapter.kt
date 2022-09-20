package br.com.dionataferraz.vendas

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.dionataferraz.vendas.databinding.ItemListBinding

class TransactionAdapter : RecyclerView.Adapter<TransactionViewHolder>() {

    private val listItem: MutableList<TransactionModel> = mutableListOf()

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

    private fun Double.formats(scale: Int) = "%.${scale}f".format(this)

    fun bind(transactionModel: TransactionModel) {

        val value = transactionModel.value
        "R$ ${value.formats(2)}".also { binding.tvValue.text = it }

        binding.tvDescription.text = transactionModel.description
//        binding.tvTime.text = transactionModel.time.hours.toString() + ":" + transactionModel.time.minutes.toString()

        when (transactionModel.transactionType) {
            TransactionType.GAS_STATION -> binding.icon.setImageResource(R.drawable.ic_baseline_local_gas_station_24)
            TransactionType.MARKET -> binding.icon.setImageResource(R.drawable.ic_baseline_shopping_cart_24)
            TransactionType.PUB -> binding.icon.setImageResource(R.drawable.ic_baseline_sports_bar_24)
        }
    }
}