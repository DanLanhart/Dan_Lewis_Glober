## Glober - Geographic Location Based Game

- [Daily Progress Updates] (#Daily-Progress)
- 


Daily Updates:

- (4/13) I finished implementing Spring Security for my player models and the player remains active until logging out. I've also used the player persistence to start the
player profile page. My goal for tomorrow is to complete all of the backend wiring for my remaining models.

- 4/14: I was able to get my js working with my game page using thymeleaf syntax. I also added a navigation bar to the game page so users can travel out easier. In 
addition, I engineered a new calculation formula for the scoring system so that players are now rewarded with points instead of being burdened with them. Finally, I 
re-organized my package structure to optimize my compatability with thymeleaf.

- 4/15: Today I was able to get the landing page linked up with the log in system to display upon logging in. In addition, I also populated the page with all the 
"fixings" to make it presentable. I also created an update function for the player profile that uses the persistent player in order to avoid messing with other user data.
Overall progress (for meeting requirements): 85%.



User Stories:
 - As a user, I want to be presented with my guessing results once I am finished, so that I can know how well I did at guessing. 
 - As a user, I want to have the option to create an account, so that I can save/track my results. 
 - As a user, I want to have the option to share my results as a copy/paste "thing", so that I can post my daily results. 
 - As a user, I want to see my standing (out of all daily players at that time) in score, so that I can measure my results against other players. 
 - As a user, once I've played the days game, I would like to see how much time is left before the next game is available, so that I know when I can play next.
 - As a user, I want to be presented with a fresh instance of a "game" every day (new games release at 12am Arizona Time), so that I can play a fresh game everyday. 
 - As a user, I want to see the game ready to play when I get onto the website, so that I can play quickly play. 
 - As a user, I want to be shown a 360 view of a random place on eart, so that I can guess where that location is. 
 - As a user, I want to be shown multiple choice answers on where my random location might be, so that I can be shown how far away from that point I am. 
 - As a user, I want to be presented with three random location per day to guess from, so that I can have multiple tries to guess a location.
