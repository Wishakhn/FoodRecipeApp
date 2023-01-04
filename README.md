# FoodRecipeApp
###Food Recipe mobile application which fetch the list of different recipes and also shows the details of any specific recipe. The application is created in KMM and supports the shared viewModel approach. The tool set use in this application inclides###
### Using Technologies ###
* Kotlin
* Koin (For Dependency Injection)
* KTOR (For Networking)
* Kotlin coroutines (For MultiThreading)
* Coroutines Flow (For state Handling)
* MOKO (For Shared ViewModel)
* Jetpack Compose (For UI)
* Repository pattern
* Clean Architecture (For Code Segrigation)
* Kotlin DSL (Gradle files)
* COIL (For Image Loading)
* KSP (For ktx libs)
* MVI  (For Unidirectional Structure)
* Clean Architecture (For Code Segrigation)
* SOLID Principles (Interface segrigation, dependency inversion)

### Demonstration of Base, Repository layer, with some Custom widgets OR components ###

## Project contains three basic layers of Clean Architecture ##
* Data Layer
* Domain Layer
* Presentation Layer

Data Layer contains remote and local data repositories. In this project there is no Local scope that's why only remote repository exist.

Domain layer contains Data Repository which handle the logic get the data from local or repository according to certain business rules. In this project no loacal repository involved so it handles only remote data. Here you can add Domain DTO's and mappers. But the current scope I don’t feel this to add separate domain DTO's to just mainatin the layer that's Why i'm using only initial DTO's coming from Data layer.

Basically in Domain Layer we Add USE CASES according to Clean Architecture Documentation normally I there is no need of USECASES with Repository pattern but I implemented them just for demo  USE CASES in Domain Layer.

Presentation layer contains the UI and ViewModels. 

