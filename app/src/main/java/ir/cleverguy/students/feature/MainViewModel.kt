package ir.cleverguy.students.feature

import android.widget.Toast
import androidx.lifecycle.LiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ir.cleverguy.students.App
import ir.cleverguy.students.common.AppCompletableObserver
import ir.cleverguy.students.common.AppViewModel
import ir.cleverguy.students.data.Student
import ir.cleverguy.students.data.repo.UserRepository
import timber.log.Timber

class MainViewModel(val userRepository: UserRepository) : AppViewModel() {
    init {

        Toast.makeText(App.myContext,"MainViewModel Done",Toast.LENGTH_LONG).show()



        progressBarLiveData.value = true
        userRepository.refreshStudent()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doFinally { progressBarLiveData.value = false }
            .subscribe(object : AppCompletableObserver(compositeDisposable){
                override fun onComplete() {
                    Timber.i("Success")
                }
            })
    }

    fun getStudent():LiveData<List<Student>> = userRepository.getStudent()
}