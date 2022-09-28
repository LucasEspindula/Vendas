package br.com.dionataferraz.vendas

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.dionataferraz.vendas.databinding.ItemListBinding

class TransactionAdapter : RecyclerView.Adapter<TransactionViewHolder>() {

    private val listItem: MutableList<__TransactionModel> = mutableListOf()

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

    fun addList(list: List<__TransactionModel>) {
        listItem.addAll(list)
    }

    fun addNewList(list: List<__TransactionModel>) {
        listItem.clear()
        notifyItemRangeRemoved(0, listItem.size)
        listItem.addAll(list)
    }

    fun updateItem(item: __TransactionModel, position: Int) {
        listItem[position] = item
        notifyItemChanged(position)
    }
}

class TransactionViewHolder(
    private val binding: ItemListBinding
) : RecyclerView.ViewHolder(binding.root) {

    private fun Double.formats(scale: Int) = "%.${scale}f".format(this)

    fun bind(transactionModel: __TransactionModel) {

        "R$ ${transactionModel.value.formats(2)}".also { binding.tvValue.text = it }
        binding.tvDescription.text = transactionModel.description
        (transactionModel.time.hours.toString() + ":" + transactionModel.time.minutes.toString()).also { binding.tvTime.text = it }

        when (transactionModel.transactionType) {
            __TransactionType.GAS_STATION -> binding.icon.setImageResource(R.drawable.ic_baseline_local_gas_station_24)
            __TransactionType.MARKET -> binding.icon.setImageResource(R.drawable.ic_baseline_shopping_cart_24)
            __TransactionType.PUB -> binding.icon.setImageResource(R.drawable.ic_baseline_sports_bar_24)
        }
    }
}