package di

import org.koin.core.KoinApplication
import org.koin.core.context.startKoin

fun initKoin(): KoinApplication {
    val koinApplication: KoinApplication = startKoin {
        modules(
            platformModule,
            commonModule
        )
    }
    return koinApplication
}