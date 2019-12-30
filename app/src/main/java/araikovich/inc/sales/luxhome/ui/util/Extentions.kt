package araikovich.inc.sales.luxhome.ui.util

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

fun Context.color(colorRes: Int) = this.getColor(colorRes)

@Suppress("detekt.UnsafeCast")
fun <T> MutableLiveData<T>.toLiveData() = this as LiveData<T>

fun <T> LifecycleOwner.observe(liveData: LiveData<T>, observer: Observer<T>) {
    liveData.observe(this, observer)
}