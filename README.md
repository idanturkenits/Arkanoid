# Arkanoid

Arkanoid is a 1986 block breaker arcade game developed and published by Taito. In North America, it was published by Romstar. Controlling a paddle-like craft known as the Vaus, the player is tasked with clearing a formation of colorful blocks by deflecting a ball towards it without letting the ball leave the bottom edge of the playfield.

During my first year in university, we were asked to create our own version of the Arkanoid game.

## What is in the folder
1. inside the src folder there are all the java files you need to run the game.
2. biuoop-1.4.jar is the graphics library(dont need to deal with it)
3. build.xml is the build file for the project.

## How to compile & run the project
first, clone into the project using
```
git clone https://github.com/idanturkenits/Arkanoid/edit/main/README.md
```
in order to compile the code, cd to the inner project folder (named Arkanoid) and type
```
ant compile
```
In this game, you have the option to play which levels you want, and in the order you like.
For exmaple, you have the options you want to play level 3 and then level 4 and then level 1.
To do it, go into CMD, cd to the project, and type
```
ant -Dargs="3 4 1" run
```

## Instructions 
1. You win when you complete all levels, and lose when you lose a level (all balls are gone).
2. When lose/win screen appears, press 'm' to exit the game.
3. In order to move the paddle, use the arrow keys.

## Images from the game
<img width="791" alt="Screen Shot 2021-07-22 at 8 29 23" src="https://user-images.githubusercontent.com/60852129/126594968-43ecaa8d-1b4f-42ee-a6a5-e954c7e7d661.png">
<img width="791" alt="Screen Shot 2021-07-22 at 8 30 47" src="https://user-images.githubusercontent.com/60852129/126594993-1a4b08cc-34d2-4ed6-8562-a272f7f732f0.png">
<img width="791" alt="Screen Shot 2021-07-22 at 8 32 48 1" src="https://user-images.githubusercontent.com/60852129/126595002-103c9c22-73ca-4c31-a3ea-14b332a0bd8b.png">

