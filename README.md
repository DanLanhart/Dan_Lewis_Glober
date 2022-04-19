## Glober - Geographic Location Based Game

Navigation Links
- [Daily Progress Updates](#Daily-Progress)
- [User Stories](#User-Stories)
- [Technical Architecture](#Technical-Architecture)
- [Wire Frame](#Wire-Frame)
- [Datebase Schema](#Datebase-Schema)
- [Technical Challenges](#Technical-Challenges)

## Daily Progress Updates

- April 19, 2022 (90% Complete)
  - Difficult difficult day. I started with scrapping the score idea as many users on StacOverflow advised me against attempting to send data from JS to my Spring controller. With the help of my coworkers, I was able to figure out how to create chat functionality so that a user could write a chat message and see what all other users have also written in the chat. In addition, I've added my schema visual and wireframe visual to my project. I've also began completing the three required custom queries inside of my service/repository classes. For the rest of the week, I need to get working on my testing methods.

- April 18, 2022 (85% Complete)  
  - Today I completed my custom exception for handling players not found by id, when invalid. I also organized my package/class structure to fit the requirments. In addition, I've added my wireframe to the project files. The current challenge I'm facing is getting variable data handled in JavaScript over to the Spring Controller so that I can display score history on the player's profile. Lastly, I updated my README file to fit the requirments.

- April 13, 2022  I finished implementing Spring Security for my player models and the player remains active until logging out. I've also used the player persistence to start the
player profile page. My goal for tomorrow is to complete all of the backend wiring for my remaining models.

- 4/14: I was able to get my js working with my game page using thymeleaf syntax. I also added a navigation bar to the game page so users can travel out easier. In 
addition, I engineered a new calculation formula for the scoring system so that players are now rewarded with points instead of being burdened with them. Finally, I 
re-organized my package structure to optimize my compatability with thymeleaf.

- 4/15: Today I was able to get the landing page linked up with the log in system to display upon logging in. In addition, I also populated the page with all the 
"fixings" to make it presentable. I also created an update function for the player profile that uses the persistent player in order to avoid messing with other user data.

## User Stories
##### (organized by site pages)

### Registration Page
- As a user, I want to have registration functionality, so that I can create an account with the application.
- As a user, I want to enter my information and have it associated with my account (name, username, email, password), so that I can create an account with my information.
- As a user, I want the registration form to perform checks on the email and password fields, so that I enter the correct information.
- As a user, I want my password to be encrypted in the database, so that my information is safely secured/stored.

### Login Page
- As a user, I want login functionality, so that I can use the application with the account I've created.
- As a user, I want the login page to check my entered information, so that I login using the correct credentials.

### Home Page
- As a user, I want a navigation bar/menu across all pages, so that I can easily navigate throughout the app.
- As a user, I want a home page (landing page/index), so that I have a central hub within the app.

### Game Page
- As a user, I want a navigation bar/menu across all pages, so that I can easily navigate throughout the app.
- As a user, I want to be presented with a google panoramic/street view of a random location within the USA, so that I can figure out where the location is.
- As a user, I want a "guessing" map with marker functionality, so that I can select the location I have determined I am in within the USA.
- As a user, I want to be shown a results display that shows how far away my guess location was from the actual, so that I can view my results.
- As a user, I want to be given points associated with how far away from the actual location my choice was, so that I can view how well I did.
- As a user, I want to given 5 different locations and a maximum score of 500 points (100 points per location), so that I can have multiple attempts at guessing.
- As a user, I want my points to be added up and displayed at the end of the 5 rounds, so that I can view my total score.

### Profile Page
- As a user, I want a navigation bar/menu across all pages, so that I can easily navigate throughout the app.
- As a user, I want to view my current username, name, and email, so that I can verify my information.
- As a user, I want the option to update my name and username, so that I can manipulate my information.
- As a user, I want to view the scores of my last games, so that I can gauge my skills at the game.

### About Page
- As a user, I want a navigation bar/menu across all pages, so that I can easily navigate throughout the app.
- As a user, I want to know some information about the application, so that I can have a better understanding of the project.
- As a user, I want to see a "how to play" section, so I can learn how the game functions.
- As a user, I want to see a list of all available locations, so that I can see all the possible options of locations within the game.

### Report A Bug Page
- As a user, I want a navigation bar/menu across all pages, so that I can easily navigate throughout the app.
- As a user, I want the functionality to report any bugs/issues I find on the application, so that I can help improve the application.

## Technical Architecture


## Wire Frame


## Database Schema


## Technical Challenges


Daily Updates:

- (4/13) I finished implementing Spring Security for my player models and the player remains active until logging out. I've also used the player persistence to start the
player profile page. My goal for tomorrow is to complete all of the backend wiring for my remaining models.

- 4/14: I was able to get my js working with my game page using thymeleaf syntax. I also added a navigation bar to the game page so users can travel out easier. In 
addition, I engineered a new calculation formula for the scoring system so that players are now rewarded with points instead of being burdened with them. Finally, I 
re-organized my package structure to optimize my compatability with thymeleaf.

- 4/15: Today I was able to get the landing page linked up with the log in system to display upon logging in. In addition, I also populated the page with all the 
"fixings" to make it presentable. I also created an update function for the player profile that uses the persistent player in order to avoid messing with other user data.
Overall progress (for meeting requirements): 85%.
