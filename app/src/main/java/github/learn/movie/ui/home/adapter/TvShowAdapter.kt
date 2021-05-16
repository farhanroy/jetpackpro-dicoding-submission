package github.learn.movie.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import github.learn.movie.databinding.ItemTvBinding
import github.learn.movie.model.TV

class TvShowAdapter (
    private val onClickListener: (TV) -> Unit
) : RecyclerView.Adapter<TrendingTvViewHolder>() {

    private var data = listOf<TV>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendingTvViewHolder {
        return TrendingTvViewHolder.create(parent)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: TrendingTvViewHolder, position: Int) {
        holder.bind(data[position]){ onClickListener(data[position]) }
    }

    fun submitData(newItems: List<TV>) {
        val diffCallback = TvDiffCallback(data, newItems)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        data = newItems
        diffResult.dispatchUpdatesTo(this)
    }
}

class TrendingTvViewHolder(private val binding: ItemTvBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: TV, onItemClicked: (Int) -> Unit){
        binding.tvTitle.text = item.title
        Glide.with(binding.ivPoster.context).load(item.imgPoster).into(binding.ivPoster)
        binding.root.setOnClickListener { onItemClicked(adapterPosition) }
    }

    companion object {
        fun create(parent: ViewGroup): TrendingTvViewHolder {
            val view = ItemTvBinding.inflate(LayoutInflater.from(parent.context))
            return TrendingTvViewHolder(view)
        }
    }
}

class TvDiffCallback(private val oldList: List<TV>, private val newList: List<TV>) :
    DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size
    override fun getNewListSize(): Int = newList.size
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition].id == newList[newItemPosition].id

    override fun areContentsTheSame(oldPosition: Int, newPosition: Int): Boolean =
        oldList[oldPosition].id == newList[newPosition].id


    @Nullable
    override fun getChangePayload(oldPosition: Int, newPosition: Int): Any? {
        return super.getChangePayload(oldPosition, newPosition)
    }
}


