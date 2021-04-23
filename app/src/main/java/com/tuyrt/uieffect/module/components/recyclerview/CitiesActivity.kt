package com.tuyrt.uieffect.module.components.recyclerview

import android.os.Bundle
import com.tuyrt.uieffect.R
import com.tuyrt.uieffect.arch.BaseActivity
import com.tuyrt.uieffect.arch.NoViewModel
import com.tuyrt.uieffect.module.components.recyclerview.adapter.CityAdapter
import com.tuyrt.uieffect.data.model.Province
import com.tuyrt.uieffect.databinding.ActivityRecyclerCitiesBinding

/**
 * Created by tuyrt7 on 2021/4/22.
 */
class CitiesActivity: BaseActivity<NoViewModel,ActivityRecyclerCitiesBinding>(){

    override val layoutId: Int
        get() = R.layout.activity_recycler_cities

    override fun initView(savedInstanceState: Bundle?) {
        val cityList = ArrayList<Province>()
        cityList.add(Province("北京", "110", "A"))
        cityList.add(Province("北京", "110", "A"))
        cityList.add(Province("北京", "110", "B"))
        cityList.add(Province("北京", "110", "B"))
        cityList.add(Province("北京", "110", "C"))
        cityList.add(Province("北京", "110", "C"))
        cityList.add(Province("北京", "110", "C"))
        cityList.add(Province("北京", "110", "D"))
        cityList.add(Province("北京", "110", "E"))
        cityList.add(Province("北京", "110", "E"))
        cityList.add(Province("北京", "110", "E"))
        cityList.add(Province("北京", "110", "E"))
        cityList.add(Province("北京", "110", "F"))

        binding.stickyRecyclerView.setAdapter(CityAdapter(this, cityList))
    }
}