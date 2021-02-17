package ir.cleverguy.students

import android.app.Application
import android.content.Context
import ir.cleverguy.students.data.repo.UserRepository
import ir.cleverguy.students.data.repo.UserRepositoryImpl
import ir.cleverguy.students.data.repo.source.UserLocalDataSource
import ir.cleverguy.students.data.repo.source.UserRemoteDataSource
import ir.cleverguy.students.feature.MainViewModel
import ir.cleverguy.students.feature.StudentAdapter
import ir.cleverguy.students.services.AppDatabase
import ir.cleverguy.students.services.createApiServiceInstance
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module
import timber.log.Timber

class App : Application() {


    companion object {
        lateinit var myContext: Context
            private set
    }


    override fun onCreate() {
        super.onCreate()

        myContext = this

        Timber.plant(Timber.DebugTree())
        val myModules = module {
            single { createApiServiceInstance() }

            single { AppDatabase.getInstance(applicationContext).getStudentDao() }

            single<UserRepository> {
                UserRepositoryImpl(
                    UserRemoteDataSource(get(), get()),
                    UserLocalDataSource(get())
                )
            }

            factory { StudentAdapter() }

            viewModel { MainViewModel(get()) }
        }

        startKoin {
            androidContext(this@App)
            modules(myModules)
        }
    }
}