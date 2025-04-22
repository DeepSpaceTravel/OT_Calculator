# OT_Calculator
An offline calculator for calculating extra salary paid

## Intro
This is a hobby project.
The aim for this project is to teach myself how to build a multiplatform app that runs on both iOS and Android.

[//]: # (Also, to make my life easier.)

[Back to Top](#overtime_calculator)

#
![App-Screenshot]

[App-Screenshot]: ./readme.d/app-screenshot.png

## If things go sideways:
type `./gradlew cleanBuildCache`

## Roadmap
- [ ] Learn how to use the navigation library
- [ ] Make sense of Koin
- [ ] Learn how to manipulate the Database
- [ ] Learn how to insert an entry
- [ ] Read the entries from the Database and display them using LazyColumn
- [ ] A properly working prototype
- [ ] Log-in using OAuth2

[Back to Top](#overtime_calculator)

## Libraries Used
| Libraries Used |            |
|:---------------|:-----------|
| Storage        | SQLDelight |
| Logging        | Kermit     |(Yet implemented)
| Network        | Ktor       |(Yet implemented)

[//]: # (|Nav    |Native   |)

[Back to Top](#overtime_calculator)

## Database Naming Convention

| Database Naming Convention |                   |
|:---------------------------|:------------------|
| Database Name              | lowerCamelCase    |
| Table                      | UpperCamelCase(s) |
| Column                     | snake_case        |

[Back to Top](#overtime_calculator)

## Notable examples I visit 
- [People In Space by Koreilly](https://github.com/joreilly/PeopleInSpace/)
- [Shopping By KMP by razaghimahdi](https://github.com/razaghimahdi/Shopping-By-KMP/)
- [Create a multiplatform app using Ktor and SQLDelight by Jetbrains](https://www.jetbrains.com/help/kotlin-multiplatform-dev/multiplatform-ktor-sqldelight.html)
- [Hello-KMP](https://github.com/touchlab/DroidconKotlin)


#### This is a Kotlin Multiplatform project targeting Android, iOS.

* `/composeApp` is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - `commonMain` is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
    `iosMain` would be the right folder for such calls.

* `/iosApp` contains iOS applications. Even if you’re sharing your UI with Compose Multiplatform, 
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.


Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)…