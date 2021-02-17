package ir.cleverguy.students.data.repo.source

import androidx.lifecycle.LiveData
import io.reactivex.Completable
import ir.cleverguy.students.data.Student
import ir.cleverguy.students.services.StudentDao

class UserLocalDataSource(val studentDao: StudentDao):UserDataSource {
    override fun refreshStudent(): Completable {
        TODO("Not yet implemented")
    }

    override fun getStudent(): LiveData<List<Student>> = studentDao.getAll()
}