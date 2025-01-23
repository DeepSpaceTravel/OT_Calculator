package di

import data.Database
import data.EntryRepoInterface
import data.EntryRepoImpl
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import ui.viewmodels.EntryListViewModel

expect val platformModule: Module

val commonModule: Module = module {
    single<EntryRepoInterface>{ EntryRepoImpl(database = get()) }
    viewModel<EntryListViewModel> { EntryListViewModel(entryRepo = get()) }
    println("Repo injected")
}