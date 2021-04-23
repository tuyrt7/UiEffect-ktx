package com.tuyrt.uieffect.module.components.recyclerview.touch

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.tuyrt.uieffect.R
import com.tuyrt.uieffect.module.components.recyclerview.adapter.DragAdapter

/**
 * Created by tuyrt7 on 2021/4/22.
 *  拖拽切换列表 item 的位置
 */
class DragCallBack(private val adapter: DragAdapter) : ItemTouchHelper.Callback() {

    /**
     * 返回一个整数类型的标识，用于判断Item那种移动行为是允许的
     */
    override fun getMovementFlags(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ): Int {
        return makeMovementFlags(
            ItemTouchHelper.RIGHT or ItemTouchHelper.LEFT or ItemTouchHelper.DOWN or ItemTouchHelper.UP,
            0
        )
    }

    /**
     * Item是否支持长按拖动（ true 支持）
     */
    override fun isLongPressDragEnabled(): Boolean {
        return true
    }

    /**
     * Item是否支持滑动 （ true 支持）
     */
    override fun isItemViewSwipeEnabled(): Boolean {
        return false
    }

    /**
     * 拖拽切换Item的回调
     * @return  如果Item切换了位置，返回true；反之，返回false
     */
    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        adapter.move(viewHolder.adapterPosition,target.adapterPosition)
        return true
    }

    /**
     * Item被选中时候回调
     *
     * @param viewHolder
     * @param actionState 当前Item的状态
     *          ItemTouchHelper.ACTION_STATE_IDLE   闲置状态
     *          ItemTouchHelper.ACTION_STATE_SWIPE  滑动中状态
     *          ItemTouchHelper#ACTION_STATE_DRAG   拖拽中状态
     */
    override fun onSelectedChanged(viewHolder: RecyclerView.ViewHolder?, actionState: Int) {
        // item 被选中的操作
        if (actionState != ItemTouchHelper.ACTION_STATE_IDLE) {
            viewHolder?.itemView?.setBackgroundResource(R.color.gray)
        }
        super.onSelectedChanged(viewHolder, actionState)
    }

    /**
     * 用户操作完毕或者动画完毕后会被调用
     */
    override fun clearView(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder) {
        // 操作完毕后恢复颜色
        viewHolder.itemView.setBackgroundResource(R.drawable.border_gray)
        super.clearView(recyclerView, viewHolder)
    }

    /**
     * 滑动删除Item
     */
    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
    }
}