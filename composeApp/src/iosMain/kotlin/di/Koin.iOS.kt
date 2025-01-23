package di

import data.Database
import org.example.project.databaseFactory.IOSDatabaseDriverFactory
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module

actual val platformModule: Module = module {
    single { iosRepoModule }
}

private val iosRepoModule: Module = module {
    single<Database>(named("iOS Database Driver Factory")) {
        Database(databaseDriverFactory = IOSDatabaseDriverFactory())
    }
}