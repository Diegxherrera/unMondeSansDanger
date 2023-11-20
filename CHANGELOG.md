# Changelog

## (2.3-alpha) - 20/11/2023

### Added
- JUnit Testing dependency added.
- `GameController` has been created to handle game logic.
- `DatabaseManager` has been created and handles database connections and interactions.

### Changed
- Refactoring is being made to comply to Single Responsibility Principle.
- From now on, `GameFrame`, formerly known as `Frame` will only contain methods and fields related to UI.

### Fixed
- Changelog was badly structured. From now on, newer versions will appear on top.

## (2.2-alpha) - 17/11/2023

### Added
- Now, `Un Monde Sans Danger` has the Log4j logger to improve mainteinance and promote a better understanding
  of the errors.
- The project now has a README with information on how to set up the project and insights.

### Changed
- Package name changed from 'unMondeSansDanger' to 'umsd' to comply with naming conventions.
- `printStackTrace()` method was replaced as a logger with log4j.

### Fixed
- Phases 2D and 3G featured a single-button panel, but wrongly two buttons were being rendered.

## (2.1-alpha) - 12/11/2023

### Added
- `Frame.startGameFrame()` now features a panel for Location and Body. 

### Changed
- `Frame` constructor not asking anymore for the phaseKey as an argument (Avoided unnecessary arguments).
- Triggering characters for `showEndingFrames()` now changed characters from 'D' and 'G' to 'O' and 'W'.
- Button panel renamed from `Panel` to `buttonPanel` to clarify its use.

### Fixed
- `Frame.showEndingFrames()` method was searching for the trigger character wrongly. Condition was always false.
- `Frame.nextPhaseKey()` method now makes the query and separates effectively the final phases screens.

### Deprecated
- Dark mode not in the works anymore.
- Phase processor to make 'O4B' be '4B' removed due to being inefficient. 

## (2.0-alpha) - 06/11/2023

### Added
- Database <---> Client system for retrieving phases data.
- Phases System now working using a database with a CSV column.
- Frame class method: `updateUI()` that will update texts according to the phase key.
- Frame class method: `retrieveDataFromDatabase()` which may run the requested query to the database.
- Dark mode on the works.

## (1.1.1-alpha) - 27/10/2023

### Fixed
- Met quality gates by fixing longer lines than allowed.

## (1.1-alpha) - 27/10/2023

### Added
- New class `Frame` with the purpose of replacing openStoryFrame() function.

### Changed
- Buttons action listeners now using lambdas instead of old functions.
- JFrame now is not generated as a whole each time we call `openStoryFrame()`, instances are doing so from `Frame` class.


## (1.0.2-alpha) - 25/10/2023

### Changed
- Maven used for building purposes

### Fixed
- gameOverFrame().O1 that was calling a non-existing window in Languages is now working as expected.

## (1.0-alpha) - 10/10/2023

### Changed
- Replaced the if-else to a switch case for each game over path.

### Fixed
- Button in phase 2D do not appear and the unique button "Continue" now works as expected.

### Deprecated
- Complexity fix is deprecated and not supported anymore.

### Security
- Unused arguments were discontinued and put aside.
