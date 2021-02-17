package ir.cleverguy.students.data.repo

import androidx.lifecycle.LiveData
import io.reactivex.Completable
import ir.cleverguy.students.data.Student
import ir.cleverguy.students.data.repo.source.UserDataSource


class UserRepositoryImpl(val userRemoteDataSource: UserDataSource,val userLocalDataSource: UserDataSource) : UserRepository {
    override fun refreshStudent(): Completable = userRemoteDataSource.refreshStudent()

    override fun getStudent(): LiveData<List<Student>> = userLocalDataSource.getStudent()
}