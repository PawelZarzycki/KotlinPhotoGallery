package pl.instasoft.kotlinphotogallery.model

import java.io.Serializable

/**
 * Created by pzarzycki on 23.02.2018.
 */
data class Photo(val id: String,
                 val likes: Int,
                 val favorites: Int,
                 val tags: String,
                 val previewUrl: String,
                 val webFormatUrl: String) : Serializable {
}