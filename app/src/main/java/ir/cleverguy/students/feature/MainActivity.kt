package ir.cleverguy.students.feature

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ir.cleverguy.students.R
import ir.cleverguy.students.common.AppActivity
import ir.cleverguy.students.data.Student
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppActivity() {
    val viewModel:MainViewModel by viewModel()
    val studentAdapter : StudentAdapter by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        rv_main_students.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)
        rv_main_students.adapter = studentAdapter

        viewModel.getStudent().observe(this){
            studentAdapter.students = it as ArrayList<Student>
        }

        viewModel.progressBarLiveData.observe(this){
            setProgressIndicator(it)
        }
    }
}