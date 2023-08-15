package com.rig.todoapps.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.rig.todoapps.data.TaskEntity
import com.rig.todoapps.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var recyclerAdapter: RecyclerAdapter
    private val viewmodel: MyViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewmodel.addTask(TaskEntity(0, "Fix Error", true))

        viewmodel.mutableLiveData.observe(this){
            recyclerAdapter = RecyclerAdapter(it)
            binding.recyclerView.apply {
                adapter = recyclerAdapter
                layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }

        viewmodel.getAllTask()



//        val phoneNumber = ""
//        val message = "I love you"
//        binding.test.setOnClickListener {
//            val uri = Uri.parse("smsto:$phoneNumber")
//            val intent = Intent(Intent.ACTION_SENDTO, uri)
//            intent.putExtra("sms_body", message)
//            startActivity(intent)
//        }

    }
}