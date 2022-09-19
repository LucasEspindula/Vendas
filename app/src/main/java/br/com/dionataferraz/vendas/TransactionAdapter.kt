package br.com.dionataferraz.vendas

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.dionataferraz.vendas.databinding.ItemListBinding
import java.text.SimpleDateFormat

class TransactionAdapter(private val listener: Listener) :
    RecyclerView.Adapter<TransactionViewHolder>() {

    interface Listener {
        fun onItemClick(text: String)
    }

    private val listItem: MutableList<TransactionModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TransactionViewHolder(binding, listener)
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
}

class TransactionViewHolder(
    private val binding: ItemListBinding,
    private val listener: TransactionAdapter.Listener
) : RecyclerView.ViewHolder(binding.root) {

    private val formatter = SimpleDateFormat("hh:mm")

    fun bind(TransactionModel: TransactionModel) {

        val value = TransactionModel.value.toString()

        binding.tvDescription.text = TransactionModel.description
        binding.tvTime.text = formatter.format(TransactionModel.date)
        "R$ $value".also { binding.tvValue.text = it }

        when (TransactionModel.transactionType) {
            TransactionType.GAS_STATION -> binding.icon.setImageResource(R.drawable.ic_baseline_local_gas_station_24)
            TransactionType.MARKET -> binding.icon.setImageResource(R.drawable.ic_baseline_shopping_cart_24)
            TransactionType.PUB -> binding.icon.setImageResource(R.drawable.ic_baseline_sports_bar_24)
        }
    }
}