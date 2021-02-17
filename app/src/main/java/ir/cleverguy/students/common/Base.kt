package ir.cleverguy.students.common

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.children
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import ir.cleverguy.students.R
import java.lang.IllegalStateException

abstract class AppActivity : AppCompatActivity(),AppView{
    override val rootView: CoordinatorLayout?
        get() {
            val viewGroup = window.decorView.findViewById(android.R.id.content) as ViewGroup
            if (viewGroup !is CoordinatorLayout) {
                viewGroup.children.forEach {
                    if (it is CoordinatorLayout) {
                        return it
                    }
                }
                throw IllegalStateException("ViewGroup must be instance of CoordinatorLayout!")
            } else
                return viewGroup
        }
    override val viewContext: Context?
        get() = this
}

abstract class AppViewModel : ViewModel(){
    val compositeDisposable = CompositeDisposable()
    val progressBarLiveData = MutableLiveData<Boolean>()
    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}

interface AppView {
    val rootView: CoordinatorLayout?
    val viewContext: Context?
    fun setProgressIndicator(mustShow: Boolean) {
        rootView?.let { rootViewIt ->
            viewContext?.let { context ->
                var loadingView = rootViewIt.findViewById<View>(R.id.loadingView)
                if (loadingView == null && mustShow) {
                    loadingView = LayoutInflater.from(context)
                        .inflate(R.layout.view_loading, rootViewIt, false)
                    rootViewIt.addView(loadingView)
                }

                loadingView?.visibility = if (mustShow) View.VISIBLE else View.GONE
            }
        }
    }
}