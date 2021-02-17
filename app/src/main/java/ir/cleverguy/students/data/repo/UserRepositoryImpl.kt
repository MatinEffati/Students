package ir.cleverguy.students.data.repo

import androidx.lifecycle.LiveData
import io.reactivex.Completable
import ir.cleverguy.students.data.Student

class UserRepositoryImpl : UserRepository {
    override fun refreshStudent(): Completable {
        TODO("Not yet implemented")
    }

    override fun getStudent(): LiveData<List<Student>> {
        TODO("Not yet implemented")
    }
}