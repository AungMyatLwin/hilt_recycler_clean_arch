//import android.app.Application
//import android.content.Context
//import android.os.Bundle
//import android.util.Log
//import androidx.activity.viewModels
//import androidx.appcompat.app.AppCompatActivity
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.liveData
//import androidx.room.ColumnInfo
//import androidx.room.Dao
//import androidx.room.Database
//import androidx.room.Entity
//import androidx.room.Insert
//import androidx.room.OnConflictStrategy
//import androidx.room.PrimaryKey
//import androidx.room.Query
//import androidx.room.Room
//import androidx.room.RoomDatabase
//import com.rig.todoapps.MyViewModel
//import com.rig.todoapps.Repository
//import com.rig.todoapps.TaskDao
//import com.rig.todoapps.TaskEntity
//import com.rig.todoapps.TodoDatabase
//import com.rig.todoapps.databinding.ActivityMainBinding
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.android.AndroidEntryPoint
//import dagger.hilt.android.HiltAndroidApp
//import dagger.hilt.android.lifecycle.HiltViewModel
//import dagger.hilt.android.qualifiers.ApplicationContext
//import dagger.hilt.components.SingletonComponent
//import javax.inject.Inject
//
//@HiltAndroidApp
//class HiltApplication: Application() {
//}
//
//
//@AndroidEntryPoint
//class MainActivity : AppCompatActivity() {
//    private lateinit var binding: ActivityMainBinding
//    private val viewmodel: MyViewModel by viewModels()
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//        viewmodel.addTask(TaskEntity(0, "Fix Error", true))
//        viewmodel.getAllTask().observe(this){
//            Log.d("Task", "onCreate: ${it}")
//        }
//        viewmodel.getAllTask()
//    }
//}
//
//@HiltViewModel
//class MyViewModel @Inject constructor(private val repository: Repository): ViewModel(){
//    fun getAllTask() = liveData {
//        emit( repository.getAllTask())
//    }
//
//    fun addTask(task:TaskEntity) = liveData {
//        repository.addTask(task)
//        emit(task)
//    }
//}
//
//open class Repository @Inject constructor(private val dao: TaskDao) {
//    open suspend fun getAllTask( ): LiveData<List<TaskEntity>> = dao.getAllTask()
//    open suspend fun addTask(task:TaskEntity) = dao.insertTask(task)
//}
//
//
//@Module
//@InstallIn(SingletonComponent::class)
//object RoomModule {
//    @Provides
//    fun providesRoomDb(@ApplicationContext context: Context): TodoDatabase = Room.databaseBuilder(
//        context, TodoDatabase::class.java, "todoDb"
//    ).build()
//
//    @Provides
//    fun providesDao(taskDb: TodoDatabase):TaskDao = taskDb.dao()
//
//    @Provides
//    fun providesRepository(dao: TaskDao):Repository = Repository(dao)
//}
//
//
//@Dao
//interface TaskDao {
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insertTask(task:TaskEntity)
//
//    @Query("Select * from task_table")
//    fun getAllTask():LiveData<List<TaskEntity>>
//}
//
//@Entity(tableName = "task_table")
//data class TaskEntity(
//    @PrimaryKey(autoGenerate = true)
//    @ColumnInfo("id")
//    var id:Int,
//    @ColumnInfo("taskName")
//    var taskName:String,
//    @ColumnInfo("progress")
//    var progress:Boolean
//)
//
//@Database(entities = [TaskEntity::class], version = 1, exportSchema = false )
//abstract class TodoDatabase: RoomDatabase() {
//    abstract fun dao():TaskDao
//}