package di

import org.koin.core.module.dsl.viewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import ui.viewModels.CalculationViewModel

val commonModule = module {
    viewModelModule
}

private val viewModelModule = module {
//    viewModel<CalculationViewModel>{ CalculationViewModel() }
    viewModelOf(::CalculationViewModel)
}
