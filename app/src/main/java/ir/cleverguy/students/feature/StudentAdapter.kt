package ir.cleverguy.students.feature

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ir.cleverguy.students.R
import ir.cleverguy.students.data.Student

class StudentAdapter : RecyclerView.Adapter<StudentAdapter.ViewHolder>() {
    var students = ArrayList<Student>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val fullNameTv: TextView = itemView.findViewById(R.id.tv_student_fullName)
        val courseTitleTv: TextView = itemView.findViewById(R.id.tv_student_course)
        val scoreTv: TextView = itemView.findViewById(R.id.tv_student_score)
        val firstCharacterTv: TextView = itemView.findViewById(R.id.tv_student_firstCharacter)
        fun bindProduct(student: Student) {
            fullNameTv.text = student.first_name+ " " + student.last_name
            courseTitleTv.text = student.course
            scoreTv.text = student.score.toString()
            firstCharacterTv.text = student.first_name.substring(0, 1)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_student, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindProduct(students[position])
    }

    override fun getItemCount(): Int = students.size


}