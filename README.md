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
<img width="360" alt="Screenshot 2023-01-04 at 4 57 12 PM" src="https://user-images.githubusercontent.com/11786840/210550551-d0c78ed1-68dc-4517-bdef-f4260f8a8990.png">
<img width="367" alt="Screenshot 2023-01-04 at 4 57 22 PM" src="https://user-images.githubusercontent.com/11786840/210550565-de9bb5a6-a3f3-459c-aa37-5b0ae75a2b12.png">
<img width="363" alt="Screenshot 2023-01-04 at 4 57 45 PM" src="https://user-images.githubusercontent.com/11786840/210550572-f3522b82-dcc8-46b5-ad34-6f9dd2349d89.png">
<img width="363" alt="Screenshot 2023-01-04 at 4 58 17 PM" src="https://user-images.githubusercontent.com/11786840/210550587-87d754b1-1299-4a58-be42-8572130c6439.png">
<img width="364" alt="Screenshot 2023-01-04 at 4 58 34 PM" src="https://user-images.githubusercontent.com/11786840/210550609-5ccb5532-6b4c-437a-8761-45681a106396.png">



## Project contains three basic layers of Clean Architecture ##
* Data Layer
* Domain Layer
* Presentation Layer

Data Layer contains remote and local data repositories. In this project there is no Local scope that's why only remote repository exist.

Domain layer contains Data Repository which handle the logic get the data from local or repository according to certain business rules. In this project no loacal repository involved so it handles only remote data. Here you can add Domain DTO's and mappers. But the current scope I don’t feel this to add separate domain DTO's to just mainatin the layer that's Why i'm using only initial DTO's coming from Data layer.

Basically in Domain Layer we Add USE CASES according to Clean Architecture Documentation normally I there is no need of USECASES with Repository pattern but I implemented them just for demo  USE CASES in Domain Layer.

Presentation layer contains the UI and ViewModels. 

