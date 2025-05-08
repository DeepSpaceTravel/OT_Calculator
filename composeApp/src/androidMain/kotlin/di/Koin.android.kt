package di

import data.database.DatabaseDriverFactory
import data.datastore.dataStore
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

actual fun platformModule() = module {
    single { DatabaseDriverFactory(context = androidContext()) }
    single { dataStore(context = androidContext()) }
}