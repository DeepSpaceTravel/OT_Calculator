package di

import data.database.DatabaseDriverFactory
import org.koin.dsl.module

actual fun platformModule() = module {
    single { DatabaseDriverFactory() }
    single { dataStore() }
}