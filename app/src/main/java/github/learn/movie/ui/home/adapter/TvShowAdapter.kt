package github.learn.movie.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import github.learn.movie.data.source.local.entity.TvShowEntity
import github.learn.movie.databinding.ItemTvBinding

class TvShowAdapter (
    private val onClickListener: (TvShowEntity) -> Unit
) : RecyclerView.Adapter<TvShowViewHolder>() {

    private var data = listOf<TvShowEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        return TvShowViewHolder.create(parent)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        holder.bind(data[position]){ onClickListener(data[position]) }
    }

    fun submitData(newItems: List<TvShowEntity>) {
        val diffCallback = TvDiffCallback(data, newItems)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        data = newItems
        diffResult.dispatchUpdatesTo(this)
    }
}

class TvShowViewHolder(private val binding: ItemTvBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: TvShowEntity, onItemClicked: (Int) -> Unit){
        binding.tvTitle.text = item.name
        Glide.with(binding.ivPoster.context).load(item.posterPath).into(binding.ivPoster)
        binding.root.setOnClickListener { onItemClicked(adapterPosition) }
    }

    companion object {
        fun create(parent: ViewGroup): TvShowViewHolder {
            val view = ItemTvBinding.inflate(LayoutInflater.from(parent.context))
            return TvShowViewHolder(view)
        }
    }
}

class TvDiffCallback(private val oldList: List<TvShowEntity>, private val newList: List<TvShowEntity>) :
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


