package ir.cleverguy.students.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Students")
data class Student(
    @PrimaryKey
    val id: Long,
    val course: String,
    val created_at: String,
    val first_name: String,
    val last_name: String,
    val score: Int,
    val updated_at: String
)
