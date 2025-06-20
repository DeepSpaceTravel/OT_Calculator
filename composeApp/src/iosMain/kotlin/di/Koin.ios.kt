package di

import data.database.DatabaseDriverFactory
import data.datastore.dataStore
import org.koin.dsl.module

actual fun platformModule() = module {
    single { DatabaseDriverFactory() }
    single { dataStore() }
}