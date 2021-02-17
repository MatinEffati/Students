package ir.cleverguy.students.data.repo.source

import androidx.lifecycle.LiveData
import io.reactivex.Completable
import ir.cleverguy.students.data.Student
import ir.cleverguy.students.services.ApiService
import ir.cleverguy.students.services.StudentDao

class UserRemoteDataSource(val apiService: ApiService,val studentDao: StudentDao) : UserDataSource {
    override fun refreshStudent(): Completable = apiService.getStudent().doOnSuccess { studentDao.insert(it) }.ignoreElement()

    override fun getStudent(): LiveData<List<Student>> {
        TODO("Not yet implemented")
    }
}