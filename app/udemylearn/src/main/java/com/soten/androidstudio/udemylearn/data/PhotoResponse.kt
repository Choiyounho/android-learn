package com.soten.androidstudio.udemylearn.data

data class PhotoResponse(
    val photos: Photos,
    val stat: String,
    val code: Int,
    val message: String?
)

data class Photos(
    val page: Int,
    val pages: String,
    val perpage: Int,
    val photo: List<Photo>,
    val total: String
)

data class Photo(
    private val farm: Int,
    val id: String,
    val isfamily: Int,
    val isfriend: Int,
    val ispublic: Int,
    val owner: String,
    private val secret: String,
    private val server: String,
    val title: String
) {
    fun getImageUrl() = "https://farm$farm.staticflickr.com/$server/${id}_$secret.jpg"
}
