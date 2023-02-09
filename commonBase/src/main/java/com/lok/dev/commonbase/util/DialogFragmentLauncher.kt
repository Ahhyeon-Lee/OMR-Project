package com.lok.dev.commonbase.util

import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import com.lok.dev.commonbase.BaseBottomSheetDialogFragment
import com.lok.dev.commonbase.BaseDialogFragment
import kotlinx.coroutines.Job

// DialogFragment 런처
fun <Binding : ViewDataBinding, Result> Fragment.launchDialogFragment(
    dialogFragment: BaseDialogFragment<Binding, Result>,
    fragmentManager: FragmentManager = childFragmentManager,
    cancelableOnTouchOutside: Boolean = true,
    fullScreen: Boolean = false,
    bottomSlideAnimation: Boolean = false,
    result: (Result?) -> Unit = {},
    cancel: () -> Unit = {}
): Job = showDialogFragment(
    dialogFragment = dialogFragment,
    fragmentManager = fragmentManager,
    cancelableOnTouchOutside = cancelableOnTouchOutside,
    fullScreen = fullScreen,
    bottomSlideAnimation = bottomSlideAnimation,
    result = result,
    cancel = cancel
)

fun <Binding : ViewDataBinding, Result> FragmentActivity.launchDialogFragment(
    dialogFragment: BaseDialogFragment<Binding, Result>,
    fragmentManager: FragmentManager = supportFragmentManager,
    cancelableOnTouchOutside: Boolean = true,
    fullScreen: Boolean = false,
    bottomSlideAnimation: Boolean = false,
    result: (Result?) -> Unit = {},
    cancel: () -> Unit = {}
): Job = showDialogFragment(
    dialogFragment = dialogFragment,
    fragmentManager = fragmentManager,
    cancelableOnTouchOutside = cancelableOnTouchOutside,
    fullScreen = fullScreen,
    bottomSlideAnimation = bottomSlideAnimation,
    result = result,
    cancel = cancel
)

// BottomSheetDialogFragment 런처
fun <Binding : ViewDataBinding, Result> Fragment.launchDialogFragment(
    dialogFragment: BaseBottomSheetDialogFragment<Binding, Result>,
    fragmentManager: FragmentManager = childFragmentManager,
    cancelableOnTouchOutside: Boolean = true,
    fullScreen: Boolean = false,
    bottomSlideAnimation: Boolean = false,
    result: (Result?) -> Unit = {},
    cancel: () -> Unit = {}
): Job = showDialogFragment(
    dialogFragment = dialogFragment,
    fragmentManager = fragmentManager,
    cancelableOnTouchOutside = cancelableOnTouchOutside,
    fullScreen = fullScreen,
    bottomSlideAnimation = bottomSlideAnimation,
    result = result,
    cancel = cancel
)

private fun <VB : ViewDataBinding, Result> LifecycleOwner.showDialogFragment(
    dialogFragment: BaseDialogFragment<VB, Result>,
    fragmentManager: FragmentManager,
    tag: String? = null,
    cancelableOnTouchOutside: Boolean,
    fullScreen: Boolean = false,
    bottomSlideAnimation: Boolean = false,
    result: (Result?) -> Unit,
    cancel: () -> Unit
): Job = lifecycleScope.launchWhenStarted {
    dialogFragment.canceledOnTouchOutside = cancelableOnTouchOutside
    dialogFragment.fullScreen = fullScreen
    dialogFragment.bottomSlideAnimation = bottomSlideAnimation
    dialogFragment.result = result
    dialogFragment.cancel = cancel
    dialogFragment.show(fragmentManager, tag)
}

private fun <VB : ViewDataBinding, Result> LifecycleOwner.showDialogFragment(
    dialogFragment: BaseBottomSheetDialogFragment<VB, Result>,
    fragmentManager: FragmentManager,
    tag: String? = null,
    cancelableOnTouchOutside: Boolean,
    fullScreen: Boolean = false,
    bottomSlideAnimation: Boolean = false,
    result: (Result?) -> Unit,
    cancel: () -> Unit
): Job = lifecycleScope.launchWhenStarted {
    dialogFragment.result = result
    dialogFragment.cancel = cancel
    dialogFragment.show(fragmentManager, tag)
}