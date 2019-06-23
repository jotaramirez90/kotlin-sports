package es.jota.sports.common

import android.content.Context
import android.graphics.Canvas
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.widget.RecyclerView
import es.jota.sports.R

class RecyclerDividerItemDecoration(
    private val context: Context,
    private val marginLeft: Int = 0
) : RecyclerView.ItemDecoration() {

    private var mDivider = ResourcesCompat.getDrawable(context.resources, R.drawable.separator_gray, null)

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        mDivider?.let {
            val left = context.resources.dpToPx(marginLeft)
            val right = parent.width - parent.paddingRight
            val childCount = parent.childCount
            for (i in 0 until childCount) {
                val child = parent.getChildAt(i)
                val params = child.layoutParams as RecyclerView.LayoutParams
                val top = child.bottom + params.bottomMargin
                val bottom = top + it.intrinsicHeight

                it.setBounds(left, top, right, bottom)
                it.draw(c)
            }
        }
    }
}