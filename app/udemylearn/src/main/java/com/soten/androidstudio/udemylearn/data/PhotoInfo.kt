package com.soten.androidstudio.udemylearn.data

data class PhotoInfo(
    val photo: PhotoDetail,
    val stat: String //ok
)

data class PhotoDetail(
    val id: String, //38347231961
    private val secret: String, //e4006a52b7
    private val server: String, //4525
    private val farm: Int, //5
    val dateuploaded: String, //1510453173
    val isfavorite: Int, //0
    val license: Int, //0
    val safety_level: Int, //0
    val rotation: Int, //0
    val originalsecret: String, //c3f44e5d9b
    val originalformat: String, //jpg
    val owner: Owner,
    val title: Title,
    val description: Description,
    val visibility: Visibility,
    val dates: Dates,
    val views: Int, //2
    val editability: Editability,
    val publiceditability: Publiceditability,
    val usage: Usage,
    val comments: Comments,
    val notes: Notes,
    val people: People,
    val tags: Tags,
    val urls: Urls,
    val media: String //photo
) {
    fun getImageUrl() = "https://farm$farm.staticflickr.com/$server/${id}_$secret.jpg"
}

data class Comments(
    val _content: Int //0
)

data class Owner(
    val nsid: String, //138147998@N05
    val username: String, //illustrationvintage
    val realname: String, //illustration vintage
    val location: String,
    val iconserver: String, //4551
    val iconfarm: Int, //5
    val path_alias: String
) {
    fun getBuddyIcons() = "http://farm$iconfarm.staticflickr.com/$iconserver/buddyicons/$nsid.jpg"
}

data class Editability(
    val cancomment: Int, //1
    val canaddmeta: Int //0
)

data class Urls(
    val url: List<Url>
)

data class Url(
    val type: String, //photopage
    val _content: String //https://www.flickr.com/photos/138147998@N05/38347231961/
)

data class Visibility(
    val ispublic: Int, //1
    val isfriend: Int, //0
    val isfamily: Int //0
)

data class Notes(
    val note: List<Any>
)

data class People(
    val haspeople: Int //0
)

data class Tags(
    val tag: List<Tag>
)

data class Tag(
    val id: String,
    val author: String,
    val authorname: String,
    val raw: String,
    val _content: String
)

data class Description(
    val _content: String
)

data class Dates(
    val posted: String,
    val taken: String,
    val takengranularity: Int,
    val takenunknown: Int,
    val lastupdate: String
)

data class Publiceditability(
    val cancomment: Int,
    val canaddmeta: Int
)

data class Title(
    val _content: String
)

data class Usage(
    val candownload: Int,
    val canblog: Int,
    val canprint: Int,
    val canshare: Int
)