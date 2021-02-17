package ir.cleverguy.students.common

import io.reactivex.CompletableObserver
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import timber.log.Timber

abstract class AppCompletableObserver(val compositeDisposable: CompositeDisposable) :
    CompletableObserver {

    override fun onSubscribe(d: Disposable) {
        compositeDisposable.add(d)
    }

    override fun onError(e: Throwable) {
        Timber.e(e)
    }
}