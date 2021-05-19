package com.tuyrt.uieffect.module.extends

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.cs.recyclerview.ui.decoration.MarginDecoration
import com.tuyrt.uieffect.R
import com.tuyrt.uieffect.arch.BaseFragment
import com.tuyrt.uieffect.databinding.FragmentModuleCommonBinding
import com.tuyrt.uieffect.module.ComponentAdapter
import com.tuyrt.uieffect.module.ComponentViewModel

/**
 * Created by tuyrt7 on 2021/4/23.
 */
class ExtendFragment : BaseFragment<ComponentViewModel, FragmentModuleCommonBinding>() {

    override val layoutId: Int
        get() = R.layout.fragment_module_common

    override fun initView(savedInstanceState: Bundle?) {
        binding.gridListRv.apply {
            layoutManager = GridLayoutManager(mContext, 3)
            adapter = ComponentAdapter(viewModel.extendItemList).apply {
                setItemClick { item -> startActivity(Intent(mActivity, item.clazz)) }
            }
            addItemDecoration(MarginDecoration(6,6,6,6))
        }
    }
}