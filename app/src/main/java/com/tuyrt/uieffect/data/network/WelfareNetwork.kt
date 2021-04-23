package com.tuyrt.uieffect.data.network

import retrofit2.await

/**
 * Created by tuyrt7 on 2021/4/21.
 */
object WelfareNetwork {

    val service = ServiceCreator.create<WelfareService>()

    suspend fun getMeiZis(num: Int, page: Int) = service.getMeiZis(num, page).await()

}