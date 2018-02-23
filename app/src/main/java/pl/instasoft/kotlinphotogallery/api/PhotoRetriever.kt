package pl.instasoft.kotlinphotogallery.api

import pl.instasoft.kotlinphotogallery.model.PhotoList
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by pzarzycki on 23.02.2018.
 */
class PhotoRetriever {
    private val service: PhotoApi

    init {
        val retrofit = Retrofit.Builder().baseUrl("http://pixabay.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        service = retrofit.create(PhotoApi::class.java)
    }

    fun getPhotos(callback: Callback<PhotoList>) {
        val call = service.getPhotos()
        call.enqueue(callback)
    }
}