package github.learn.movie.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import github.learn.movie.databinding.ItemMovieBinding
import github.learn.movie.model.Movie

class TrendingMovieAdapter : RecyclerView.Adapter<TrendingMovieViewHolder>() {

    private var data = listOf<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendingMovieViewHolder {
        return TrendingMovieViewHolder.create(parent)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: TrendingMovieViewHolder, position: Int) {
        holder.bind(data[position])
    }

    fun submitData(newItems: List<Movie>) {
        val diffCallback = MovieDiffCallback(data, newItems)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        data = newItems
        diffResult.dispatchUpdatesTo(this)
    }
}

class TrendingMovieViewHolder(private val binding: ItemMovieBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Movie){
        binding.tvTitle.text = item.title
        Glide.with(binding.ivPoster.context).load(item.imgPoster).into(binding.ivPoster)
    }

    companion object {
        fun create(parent: ViewGroup): TrendingMovieViewHolder {
            val view = ItemMovieBinding.inflate(LayoutInflater.from(parent.context))
            return TrendingMovieViewHolder(view)
        }
    }
}

class MovieDiffCallback(private val oldList: List<Movie>, private val newList: List<Movie>) :
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
