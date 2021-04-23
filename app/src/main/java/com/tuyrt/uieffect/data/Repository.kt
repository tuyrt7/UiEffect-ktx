package com.tuyrt.uieffect.data

import android.util.Log
import androidx.lifecycle.liveData
import com.tuyrt.uieffect.data.network.WelfareNetwork
import kotlinx.coroutines.Dispatchers
import java.lang.RuntimeException
import kotlin.coroutines.CoroutineContext

/**
 * Created by tuyrt7 on 2021/4/21.
 */
object Repository {

    fun getMeiZi(num: Int, page: Int) = fire(Dispatchers.IO) {
        val meiZis = WelfareNetwork.getMeiZis(num, page)
        if (!meiZis.error) {
            Log.d("aaaa", "success getMeiZi: ${meiZis.results}")
            Result.success(meiZis.results)
        } else {
            Result.failure(RuntimeException("response status is error"))
        }
    }

    private fun <T> fire(context: CoroutineContext, block: suspend () -> Result<T>) =
        liveData(context) {
            val result = try {
                block()
            } catch (e: Exception) {
                Result.failure(e)
            }
            emit(result)
        }

}