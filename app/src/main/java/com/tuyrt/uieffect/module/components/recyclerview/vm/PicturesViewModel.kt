package com.tuyrt.uieffect.module.components.recyclerview.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.tuyrt.uieffect.arch.BaseViewModel
import com.tuyrt.uieffect.data.Repository

/**
 * Created by tuyrt7 on 2021/4/22.
 */
class PicturesViewModel : BaseViewModel() {

    var num = 100 //默认取 100条

    private val pageLiveData = MutableLiveData<Int>()

    val meizisLiveData = Transformations.switchMap(pageLiveData) { page ->
        Repository.getMeiZi(num, page)
    }

    fun getMeiZis(page: Int = 2) {
        pageLiveData.value = page
    }
}