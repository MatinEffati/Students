package ir.cleverguy.students.data.repo

import androidx.lifecycle.LiveData
import io.reactivex.Completable
import ir.cleverguy.students.data.Student

interface UserRepository {
    fun refreshStudent(): Completable
    fun getStudent():LiveData<List<Student>>
}