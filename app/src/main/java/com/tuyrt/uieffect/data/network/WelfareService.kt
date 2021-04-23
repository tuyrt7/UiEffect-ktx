package com.tuyrt.uieffect.data.network

import com.tuyrt.uieffect.data.model.MeiziResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by tuyrt7 on 2021/4/21.
 */
interface WelfareService {

    //https://gank.io/api/data/%E7%A6%8F%E5%88%A9/100/2

    @GET("data/%E7%A6%8F%E5%88%A9/{num}/{page}")
    fun getMeiZis(@Path("num") num: Int, @Path("page") page: Int): Call<MeiziResponse>

}