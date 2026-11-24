# Berry Catcher

A simple arcade game written in Java with Swing, made as a fun side project. Berries fall from the top of the screen and you move a paddle to catch them before they hit the bottom.
(sidenote: this readme is the only thing written by claude)

## How to play

- Catch a berry with your paddle: **+1 point**
- Blueberries are worth 10 points
- Miss a berry: **-1 point** (your score never drops below 0)
- Berries spawn randomly, so catch as many as you can within 30 seconds!

## Controls

| Key | Action |
| --- | --- |
| `←` Left arrow | Move left |
| `→` Right arrow | Move right |
| `Shift` (hold) | Dash: move at double speed (the paddle turns green) |

The dash is inspired by osu!catch, where holding shift lets you move faster.

## Running the game

You'll need the [Java Development Kit (JDK)](https://adoptium.net/) installed.

From the project folder:

```bash
javac *.java
java GameMain
```

## Project structure

| File | Description |
| --- | --- |
| `GameMain.java` | Entry point; creates the window and wires everything together |
| `GamePanel.java` | Main game loop (~60 FPS), berry spawning, collisions, scoring, and rendering |
| `GameController.java` | Keyboard input handling (arrows and shift) |
| `Player.java` | The paddle: movement, dash speed, and drawing |
| `Berry.java` | A falling berry: gravity, drawing, and hitbox |
| `Assets.java` | Loads each asset once to prevent slowdowns |
| `assets/` | A folder containing all the assets used in this game |

## Possible future ideas

- Game over / lives system
- Increasing difficulty over time
- Keeping the paddle within the window bounds

## Asset credits
All assets were found and downloaded off of (support the artists!)
https://opengameart.org/content/16x16-rpg-items-db32
https://alexkovacsart.itch.io/free-pixel-art-foods
https://craftpix.net/categorys/pixel-art-2d-game-backgrounds/

