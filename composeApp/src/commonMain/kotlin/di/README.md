> [!NOTE]
> Due to the loading order of Koin (or just the programming language itself),
> the Module with `includes()` must be at the last order of the loading order
>
> See Reference at [this issue](https://github.com/InsertKoinIO/koin/issues/1702)
 
This DI depends on the following directories:
* platformModule
  * iosMain/kotlin/di/Koin.android.kt
  * androidMain/kotlin/di/Koin.ios.kt

