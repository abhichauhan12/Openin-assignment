package com.abhishek.openinapp.data.network.apiresponse

import com.abhishek.openinapp.domian.model.Links

data class TopLink(
    val app: String,
    val created_at: String,
    val domain_id: String,
    val is_favourite: Boolean,
    val original_image: String,
    val smart_link: String,
    val thumbnail: Any,
    val times_ago: String,
    val title: String,
    val total_clicks: Int,
    val url_id: Int,
    val url_prefix: String,
    val url_suffix: String,
    val web_link: String
){
    fun toLinks() : Links {
        return Links(
            times_ago = times_ago,
            titleName = title,
            total_clicks = total_clicks,
            web_link = web_link,
            original_image = original_image
        )

    }
}