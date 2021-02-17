package ir.cleverguy.students.services

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ir.cleverguy.students.data.Student

@Dao
interface StudentDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(student: List<Student>)

    @Query("select * from students")
    fun getAll(): LiveData<List<Student>>

}