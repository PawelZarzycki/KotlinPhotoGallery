package pl.instasoft.kotlinphotogallery

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import pl.instasoft.kotlinphotogallery.model.Photo

/**
 * Created by pzarzycki on 23.02.2018.
 */
class MainAdapter(var photos: List<Photo>, var clickListener: View.OnClickListener)
    : RecyclerView.Adapter<MainAdapter.PhotoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PhotoViewHolder {
        return PhotoViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.photo_item, parent, false))
    }

    override fun getItemCount(): Int {
        return photos.size
    }

    override fun onBindViewHolder(holder: PhotoViewHolder?, position: Int) {
        val photo = photos[position]
        holder?.tags?.text = photo.tags
        holder?.favourites?.text = photo.favorites.toString()
        holder?.likes?.text = photo.likes.toString()
        if (photo.previewURL.isNotEmpty()) {
            Glide.with(holder?.tags?.context!!)
                    .load(photo.previewURL)
                    .load(holder?.photoItem)
        }

    }

    fun getPhoto(adapterPosition: Int) :Photo{
        return photos[adapterPosition]
    }

    inner class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tags: TextView
        var likes: TextView
        var favourites: TextView
        var photoItem: ImageView

        init {
            if (clickListener != null) {
                itemView.setOnClickListener(clickListener)
            }
            itemView.tag = this
            tags = itemView.findViewById(R.id.tags) as TextView
            likes = itemView.findViewById(R.id.likes) as TextView
            favourites = itemView.findViewById(R.id.favorites) as TextView
            photoItem = itemView.findViewById(R.id.photo_item) as ImageView
        }
    }
}