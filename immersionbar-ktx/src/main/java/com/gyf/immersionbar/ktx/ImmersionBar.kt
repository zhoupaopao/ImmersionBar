package com.gyf.immersionbar.ktx

import android.app.Activity
import android.app.Dialog
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.view.View
import com.gyf.immersionbar.ImmersionBar

/**
 * @author geyifeng
 * @date 2019/3/27 5:45 PM
 */

// 初始化ImmersionBar
inline fun Activity.immersionBar(block: ImmersionBar.() -> Unit) = ImmersionBar.with(this).apply { block(this) }.init()

inline fun Fragment.immersionBar(block: ImmersionBar.() -> Unit) = ImmersionBar.with(this).apply { block(this) }.init()

inline fun DialogFragment.immersionBar(block: ImmersionBar.() -> Unit) = ImmersionBar.with(this).apply { block(this) }.init()

inline fun Dialog.immersionBar(activity: Activity, block: ImmersionBar.() -> Unit) = ImmersionBar.with(activity, this).apply { block(this) }.init()

inline fun Activity.immersionBar(dialog: Dialog, block: ImmersionBar.() -> Unit) = ImmersionBar.with(this, dialog).apply { block(this) }.init()

inline fun Fragment.immersionBar(dialog: Dialog, block: ImmersionBar.() -> Unit) = activity?.run { ImmersionBar.with(this, dialog).apply { block(this) }.init() }
        ?: Unit

fun Activity.immersionBar() = immersionBar { }

fun Fragment.immersionBar() = immersionBar { }

fun DialogFragment.immersionBar() = immersionBar { }

fun Dialog.immersionBar(activity: Activity) = immersionBar(activity) {}

fun Activity.immersionBar(dialog: Dialog) = immersionBar(dialog) {}

fun Fragment.immersionBar(dialog: Dialog) = immersionBar(dialog) {}

fun Activity.destroyImmersionBar(dialog: Dialog) = ImmersionBar.destroy(this, dialog)

fun Fragment.destroyImmersionBar(dialog: Dialog) = activity?.run { ImmersionBar.destroy(this, dialog) }
        ?: Unit

// 状态栏扩展
val Activity.statusBarHeight get() = ImmersionBar.getStatusBarHeight(this)

val Fragment.statusBarHeight get() = activity?.run { ImmersionBar.getStatusBarHeight(this) } ?: 0

// 导航栏扩展
val Activity.navigationBarHeight get() = ImmersionBar.getNavigationBarHeight(this)

val Fragment.navigationBarHeight
    get() = activity?.run { ImmersionBar.getNavigationBarHeight(this) } ?: 0

val Activity.navigationBarWidth get() = ImmersionBar.getNavigationBarWidth(this)

val Fragment.navigationBarWidth
    get() = activity?.run { ImmersionBar.getNavigationBarWidth(this) } ?: 0

// ActionBar扩展
val Activity.actionBarHeight get() = ImmersionBar.getActionBarHeight(this)

val Fragment.actionBarHeight get() = activity?.run { ImmersionBar.getActionBarHeight(this) } ?: 0

// 是否有导航栏
val Activity.hasNavigationBar get() = ImmersionBar.hasNavigationBar(this)

val Fragment.hasNavigationBar get() = activity?.run { ImmersionBar.hasNavigationBar(this) } ?: false

// 是否有刘海屏
val Activity.hasNotchScreen get() = ImmersionBar.hasNotchScreen(this)

val Fragment.hasNotchScreen get() = activity?.run { ImmersionBar.hasNotchScreen(this) } ?: false

val View.hasNotchScreen get() = ImmersionBar.hasNotchScreen(this)

// 是否支持状态栏字体变色
val isSupportStatusBarDarkFont get() = ImmersionBar.isSupportStatusBarDarkFont()

// 师傅支持导航栏图标
val isSupportNavigationIconDark get() = ImmersionBar.isSupportNavigationIconDark()

// 检查view是否使用了fitsSystemWindows
val View.checkFitsSystemWindows get() = ImmersionBar.checkFitsSystemWindows(this)

// 导航栏是否在底部
val Activity.isNavigationAtBottom get() = ImmersionBar.isNavigationAtBottom(this)
val Fragment.isNavigationAtBottom
    get() = activity?.run { ImmersionBar.isNavigationAtBottom(this) } ?: false

// statusBarView扩展
fun Activity.fitsStatusBarView(view: View) = ImmersionBar.setStatusBarView(this, view)

fun Fragment.fitsStatusBarView(view: View) = activity?.run { ImmersionBar.setTitleBarMarginTop(this, view) }
        ?: Unit

// titleBar扩展
fun Activity.fitsTitleBar(view: View) = ImmersionBar.setTitleBar(this, view)

fun Fragment.fitsTitleBar(view: View) {
    activity?.apply { ImmersionBar.setTitleBar(this, view) }
}

fun Activity.fitsTitleBarMarginTop(view: View) = ImmersionBar.setTitleBarMarginTop(this, view)

fun Fragment.fitsTitleBarMarginTop(view: View) = activity?.run { ImmersionBar.setTitleBarMarginTop(this, view) }
        ?: Unit

// 隐藏状态栏
fun Activity.hideStatusBar() = ImmersionBar.hideStatusBar(window)

fun Fragment.hideStatusBar() {
    activity?.apply {
        ImmersionBar.hideStatusBar(window)
    }
}

// 显示状态栏
fun Activity.showStatusBar() = ImmersionBar.showStatusBar(window)

fun Fragment.showStatusBar() {
    activity?.apply {
        ImmersionBar.showStatusBar(window)
    }
}

// 解决顶部与布局重叠问题，不可逆
fun Activity.setFitsSystemWindows() = ImmersionBar.setFitsSystemWindows(this)

fun Fragment.setFitsSystemWindows() {
    activity?.apply {
        ImmersionBar.setFitsSystemWindows(this)
    }
}




