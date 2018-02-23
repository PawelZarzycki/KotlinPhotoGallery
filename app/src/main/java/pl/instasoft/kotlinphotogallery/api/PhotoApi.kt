package pl.instasoft.kotlinphotogallery.api

import pl.instasoft.kotlinphotogallery.model.PhotoList
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by pzarzycki on 23.02.2018.
 */
interface PhotoApi {
    @GET("?key=4848099-9d97bf026a7f1cb9121fbb5c1&q=nature&image_type=photo")
    fun getPhotos(): Call<PhotoList>
}