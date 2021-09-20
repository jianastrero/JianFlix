# JianFlix
A Coding Challenge Submission

## Timeline - 41 hours, 57 minutes
Started on *9/18/2021 at 10:58 PM* <br />
Ended on *9/20/2021 at 4:55 PM*

## Architecture
Clean Architecture<br />
[Read more at Uncle Bob's blog](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html)

## Libraries Used
| Type                 | Library                  | Link                                                         |
|----------------------|--------------------------|--------------------------------------------------------------|
| Dependency Injection | Koin                     | https://insert-koin.io/                                      |
| Image Loading        | Coil                     | https://github.com/coil-kt/coil                              |
| Data Persistence     | Room Persistence Library | https://developer.android.com/jetpack/androidx/releases/room |
| Rest API Client      | Retrofit                 | https://square.github.io/retrofit/                           |
| UI                   | Jetpack Compose          | https://developer.android.com/jetpack/compose                |

## UI Inspiration
- [Artstation - Mobile Application Concept](https://www.pinterest.ph/pin/644155552948637809/)
- [cinema_mobile_app.jpg by Tomas Skarba](https://www.pinterest.ph/pin/292452569544436426/)

## API endpoint
[iTunes Search API](https://affiliate.itunes.apple.com/resources/documentation/itunes-store-web-service-search-api/#searching) <br />
specific url: [https://itunes.apple.com/search?term=star&amp;country=au&amp;media=movie&amp;all](https://itunes.apple.com/search?term=star&amp;country=au&amp;media=movie&amp;all)

## Steps Done in development
1. Design Architecture
    - I opted for a Modular Clean Architecture
    - Modules:
        - App Module - the main app module
        - Core Module - kotlin module - has core utilities and resources i could use
        - Constant Module - kotlin module - has all the constants i need
        - Common UI Module - ui module common to all modules that will show UI
        - Movie Module
            - Movie Domain Module - has model used by the ui and contract of repository
            - Movie Data Module - has implementation of repository, data sources - both local and remote, Entity and Dto for local and remote models
            - Movie Use-Case Module - use-cases to be used by the view models. this is where the view model gets all its data. the data will only be from the domain
            - Movie Main List Module - UI module - for the main movie list screen. has components, screen, view model and state
            - Movie Detail Module - UI module - for the movie detail screen. has components, screen, view model and state
2. Backend Development
    1. Create Logging utility on Core Module
    2. Implement Dependency Injection Starting Point
         - on app module first, then extended on modules that need/has dependency injection
    3. Define What Modules I needed - Movie
    4. Create Domain for Movie
    5. Create Data for Movie
    6. Create Use-Cases for Movie
    7. Create Movie Main List Screen
        - The Initial idea was a simple list with 2 collumns showing movies that you could scroll to
        - Extended the idea by adding a New Release Movie Portion on the screen
        - Extended the idea by categorizing the movies and using horizontally scrollable movie lists
        - Show if movie is viewed
    8. Create Movie Detail Screen
        - Show details of the movie
        - Show if movie was viewed or not
    9. Extend Movie Detail Screen
        - Suggest movies like the current movie
        - To show scalability

## Struggles:
- General
    - Importing missing libraries that other libraries require
- Architecture
    - Hard to settle on a single structure
    - Had to implement my own understanding of clean architecture with a mix of modular architecture to keep the code for each module small but still keeping the code easy to maintain and could scale well
- Jetpack Compose
    - Has a lot of struggles with ui dev in general
    - Libraries are not straightforward in documentation, had to learn that the hard way
- Koin
    - Dependency injection  was a struggle to implement in the architecture until i understood that as long as i have added the module in koin, if i try to access it anywhere in my modules, i could still get it
- Coil
    - Couldn't load my images at first, had to research and found out i had to import more dependencies
- ViewModel
    - Updating state in concurrent use-case calls. had to call the use-case calls one after the other using invokeOnCompletion
- Navigation
    - States on navigation using Dependency Injection on Dagger Hilt is not the same in Koin
    - You need to pass the bundle from the navigation to the composable screen