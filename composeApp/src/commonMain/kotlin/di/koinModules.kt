package di

import org.koin.core.module.Module
import org.koin.dsl.module

val koinModules: Module = module {
    single { repoModule }

}

private val repoModule: Module = module {

}