# Pokemon Gym App

About:

The Pokemon Gym app is a mobile application built using Kotlin and Jetpack Compose.
It allows users to give text input for the Gym Name and Gym Leader, and as well provide a link to an image URL. It's an app used by Pokemon trainers to keep a current track of which gyms they have visited and beaten. 

This information inputted will be displayed on another screen which will render the image provided in the URL. 

As well this information is stored in a data class object called PokemonGymInformation, which is added to a list of pokemonGymList. This list can be displayed on the third screen, where the user can either access the information of a particular item or delete an item from the list. 

This app is using multiple screens, navigation, images and state management.



*Features:*

- Navigation: move from screen to screen to keep track of current items added.
- State managment: Using state management to keep the user interface dynamic and responsive to user input or actions.
- User input: The app takes in the user's input for a Gym Name, Gym Leader, and an image URL of the gym. This will then be stored in a data class of type PokemonGymInformation, which is added to a mutable list called pokemonGymList.



*Screens:*

First Screen: Main
This screen displays a text field input where the user is asked to input Pokemon Gym information. Once they have filled out the 3 fields with the appropriate information, they can then press on a button to submit this information. They are then redirected to the next screen.

Second Screen: Details
This screen displays all the information the user inputted in larger font and renders the image from the URL the user has provided. The user can navigate to either the List screen to see what the list contains with their recent additions, or return back to Main to input more data.
NOTE: The Details icon will only display on the bottom nav bar when there is a PokemonGymInformation item added to the list.

Third Screen: List
This screen displays a list of the currently added PokemonGymInformation objects, showing only the smaller image form and the name of the Gym. The user can click on an item in the list to navigate to the Details screen to see more information about that item. Or they can click on 'X' icon beside the item to delete the item from the list.

Fourth Screen: Information
This screen displays the information of what this app is and whom it is for. 


## How to Use:
1) Open the project in Android Studio or preferred IDE.
2) Build and run the app on the emulator or a physical device.
3) Input information in the text fields when on the Main screen.
4) Enter the information from the Main screen into the app by clicking on the button below the text fields.
5) Read information in the Details screen to validate proper input.
6) Click on the List icon to retrieve a list of currently added items. You can click on an item to go to Details screen for said item, or click on the 'X' to remove the item.
7) Click on the 'i' icon in the top-right corner to go to Information Screen. 

Technology Used:
- Kotlin
- Jetpack Compose
