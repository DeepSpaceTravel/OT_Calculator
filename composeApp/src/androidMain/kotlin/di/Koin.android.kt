package di

import data.Database
import data.EntryRepoImpl
import org.example.project.databaseFactory.AndroidDatabaseDriverFactory
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module

actual val platformModule: Module = module {
    single { androidRepoModule }
}

private val androidRepoModule: Module = module {
    single<Database>() {
        Database(databaseDriverFactory = AndroidDatabaseDriverFactory(androidContext()))
    }
    println("Android injected")
}