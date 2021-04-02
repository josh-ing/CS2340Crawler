Project M4
Collaborators: 
-Justin Chau
-Joshua Ng
-Joanna Zheng
-Kane Du
-Andrew Phanmanee

Our Project Game:

We created the game "Quacked", a dungeon-crawler type game. 
Once you press "Play", a configuration screen will pop up. Here, you need to put in your name, select a duck character, 
select a weapon, and select a difficulty. The player must input a name and choose the options.
Once you've selected your options, you press the "play" button. This will lead to the initial game screen which displays the
roomGenerator and your starting gold based on the difficulty you selected. In the roomGenerator, currently we wanted to make sure it rendered
correctly, so each tile is labeled with either "NORTH" "SOUTH" "EAST" "WEST" "FLOOR" "WALL".
For M4, we implemented a new player sprite, as well as monsters in each room. The tileset of each room has also been updated, and monsters can attack the player, as well as
the player attacking monsters. There is now a death screen when the player's health reaches 0.

Current Tests:

-Tests if monster can attack player and update health, and vice versa
-Tests for lose screen after player death
-Tests if buttons of app were pressed or released
-Tests if the player creation intitializes the right image
-Tests the size of GameObjects in the room and their consistency

