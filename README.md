# Godot Kotlin Multi Module Example

## Repro steps

1. Clone project
2. Open IntelliJ. Open cloned project in IntelliJ.
  a. If asked, import as gradle project.
3. Open `godot/src/main/kotlin/TestNode.kt`. It may take some time to load, but `Node` should appear red.
4. Run `./gradlew build`. It should succeed.