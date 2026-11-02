# OWN CLIENT — Minecraft Java 26.2

**Your Game. Your Rules.**

This repository is the initial Fabric client core for OWN CLIENT. It is a real
Minecraft client-side mod project, not a launcher mockup. It is deliberately
split into small modules so HUD rendering, keybinds, config screens, mod
management and launcher integration can be added without one giant class.

## Target toolchain

- Minecraft Java Edition: **26.2**
- Java: **25**
- Fabric Loader: **0.19.3**
- Fabric Loom: **1.17.13**
- Fabric API: **0.154.2+26.2**
- Gradle: **9.5.1**

Check the official Fabric 26.2 porting/development pages before updating any
version pins. Minecraft 26.2 changed rendering internals, so rendering hooks
must be implemented against the exact 26.2 API rather than copied blindly
from older 1.21 tutorials.

## Build (Windows / Linux / macOS)

1. Install a JDK 25 distribution.
2. Install Gradle 9.5.1, or generate a wrapper in this folder:
   `gradle wrapper --gradle-version 9.5.1`
3. Build:
   - Windows: `gradlew.bat build`
   - Linux/macOS: `./gradlew build`
4. The mod jar will be in `build/libs/`.

## Android / Acode note

Acode is suitable for editing these source files. A complete Java/Fabric build
requires JDK 25, Gradle and Minecraft's development dependencies. Acode alone
does not provide a desktop Minecraft runtime or a full Java launcher backend.
Build on a compatible computer or remote build environment, then install the
resulting jar into a Minecraft Java 26.2 Fabric instance.

## Current implementation status

- [x] Fabric client entrypoint
- [x] 26.2 dependency/toolchain configuration
- [x] JSON config load/save foundation
- [x] Central feature registry
- [ ] In-game HUD drawing and HUD editor
- [ ] Keybind registration and input handling
- [ ] Config screen and preset editor
- [ ] Resource-pack integration
- [ ] Modrinth/CurseForge metadata-based mod manager
- [ ] Separate desktop launcher with Microsoft account authentication
- [ ] Installer, update channel and crash diagnostics

The feature registry is a catalogue only; features marked there are not yet
implemented as working in-game overlays. Do not treat this starter milestone
as a finished client.

## Design rules

- Client-side only unless a feature explicitly requires server support.
- No packet manipulation, anti-cheat bypass, or unfair multiplayer automation.
- Optional features must be independently switchable.
- Never bundle third-party mod jars without checking their licence and
  Minecraft 26.2 compatibility.
- Back up worlds before testing new mod combinations.

## Third-party performance mods

Sodium, Lithium, FerriteCore, ImmediatelyFast, Entity Culling and Dynamic FPS
are separate projects. Each must have a confirmed Minecraft 26.2 + Fabric
release before it is offered as an installable option. The launcher should
display a clear incompatible/unavailable state instead of silently installing
a mismatched jar.
