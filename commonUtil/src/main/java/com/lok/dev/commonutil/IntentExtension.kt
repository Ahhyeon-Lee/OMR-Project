package com.lok.dev.commonutil

import android.content.Intent
import android.os.Build
import android.os.Parcelable

inline fun <reified T : Parcelable> Intent?.safeParcelable(key: String): T? {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        this?.getParcelableExtra(key, T::class.java)
    } else {
        this?.getParcelableExtra(key)
    }
}
