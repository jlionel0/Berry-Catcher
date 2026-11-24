# Berry Catcher

A simple arcade game written in Java with Swing, made as a fun side project. Berries fall from the top of the screen and you move a paddle to catch them before they hit the bottom.
(sidenote: this readme is the only thing written by claude)

## How to play

- Catch a berry with your paddle: **+1 point**
- Miss a berry: **-1 point** (your score never drops below 0)
- Berries spawn randomly and fall continuously, so keep moving!

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

## Possible future ideas

- Game over / lives system
- Increasing difficulty over time
- Keeping the paddle within the window bounds
- Different berry types with different point values
