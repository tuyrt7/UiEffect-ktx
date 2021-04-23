package com.tuyrt.uieffect.data.model


import com.google.gson.annotations.SerializedName

data class MeiziResponse(
    val error: Boolean,
    val results: List<MeiZi>
)

data class MeiZi(
    /*
    {
        "_id": "5a03b502421aa90fe7253618",
        "createdAt": "2017-11-09T09:53:06.802Z",
        "desc": "11-9",
        "publishedAt": "2017-11-10T08:10:02.838Z",
        "source": "chrome",
        "type": "福利",
        "url": "http://7xi8d6.com1.z0.glb.clouddn.com/20171109095254_dOw5qh_bluenamchu_9_11_2017_9_52_47_256.jpeg",
        "used": true,
        "who": "daimajia"
    }
    */
    @SerializedName("_id")
    val id: String,
    val createdAt: String,
    val desc: String,
    val publishedAt: String,
    val source: String,
    val type: String,
    val url: String,
    val used: Boolean,
    val who: String
)