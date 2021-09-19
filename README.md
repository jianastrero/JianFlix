# JianFlix
A Coding Challenge Submission

## Architecture
Clean Architecture
Read more at [Uncle Bob's blog](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html)

## Libraries Used
| Type                 | Library                  | Link                                                         |
|----------------------|--------------------------|--------------------------------------------------------------|
| Dependency Injection | Koin                     | https://insert-koin.io/                                      |
| Image Loading        | Coil                     | https://github.com/coil-kt/coil                              |
| Data Persistence     | Room Persistence Library | https://developer.android.com/jetpack/androidx/releases/room |
| Rest API Client      | Retrofit                 | https://square.github.io/retrofit/                           |

## Struggles:
- architecture
    - hard to settle on a single structure
    - had to implement my own understanding of clean architecture with a mix of modular architecture to keep the code for each module small but still keeping the code easy to maintain and could scale well
- jetpack compose
    - has a lot of struggles with ui dev in general
    - libraries are not straightforward in documentation, had to learn that the hard way
- koin
    - dependency injection  was a struggle to implement in the architecture until i understood that as long as i have added the module in koin, if i try to access it anywhere in my modules, i could still get it
- coil
    - couldn't load my images at first, had to research and found out i had to import more dependencies
- viewmodel
    - updating state in concurrent use-case calls. had to call the use-case calls one after the other using invokeOnCompletion