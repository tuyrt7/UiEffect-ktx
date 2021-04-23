package com.tuyrt.uieffect.arch

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import java.lang.reflect.ParameterizedType

/**
 * Created by tuyrt7 on 2021/4/21.
 */
abstract class BaseActivity<VM : BaseViewModel, DB : ViewDataBinding> : AppCompatActivity() {

    protected lateinit var viewModel: VM
    protected lateinit var binding: DB

    @get:LayoutRes
    abstract val layoutId: Int
    protected open fun bindData() {}

    abstract fun initView(savedInstanceState: Bundle?)
    open fun initData() {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewDataBinding()
        lifecycle.addObserver(viewModel)
        initView(savedInstanceState)
        initData()
    }

    private fun initViewDataBinding() {
        val cls = (javaClass.genericSuperclass as ParameterizedType)
            .actualTypeArguments[1] as Class<*>
        if (ViewDataBinding::class.java != cls && ViewDataBinding::class.java.isAssignableFrom(cls)) {
            binding = DataBindingUtil.setContentView(this, layoutId)
            binding.lifecycleOwner = this
            bindData()
        } else {
            setContentView(layoutId)
        }
        createViewModel()
    }

    private fun createViewModel() {
        val type = javaClass.genericSuperclass
        if (type is ParameterizedType) {
            val tp = type.actualTypeArguments[0]
            val tClass = tp as? Class<VM> ?: BaseViewModel::class.java
            viewModel = ViewModelProvider(this)[tClass] as VM
        }
    }

    fun Context.toast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    fun log(msg: String) = Log.d("aaaa", msg)
}