package di

import data.database.LocalDatabase
import data.repo.OvertimeInfoRepo
import data.repo.OvertimeInfoRepoIface
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import ui.viewModels.CalculationViewModel
import ui.viewModels.EntryListViewModel

expect fun platformModule(): Module

private val viewModelModule = module {
//    viewModel<CalculationViewModel>{ CalculationViewModel() }
    viewModelOf(::CalculationViewModel)
//    viewModel<EntryListViewModel>{ EntryListViewModel() }
    viewModelOf(::EntryListViewModel)
}

private val repoModule = module {
    single { LocalDatabase(get()) }
    single { OvertimeInfoRepo(get()) }
    single<OvertimeInfoRepoIface> { OvertimeInfoRepo(get()) }
//    single { OvertimeInfoRepo(get()) }.bind<OvertimeInfoRepoIface>()
}

/*
Due to the loading order of Koin (or just the programming language itself),
the Module with `includes()` must be at the last order of the loading order.
 */
fun commonModule() = module {

    includes(
        //The following order is SPECIFIC and CAN"T BE CHANGED
        repoModule,
        viewModelModule
    )
}