package ir.cleverguy.students.data.repo.source

import androidx.lifecycle.LiveData
import io.reactivex.Completable
import ir.cleverguy.students.data.Student

interface UserDataSource {
    fun refreshStudent(): Completable
    fun getStudent():LiveData<List<Student>>
}