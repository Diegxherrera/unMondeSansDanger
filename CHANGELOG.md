# Changelog

## (1.0-alpha) - 10th Oct 2023

### Changed
  - Replaced the if-else to a switch case for each game over path.

### Fixed
  - Button in phase 2D do not appear and the unique button "Continue" now works as expected.

### Deprecated
  - Complexity fix is deprecated and not supported anymore.

### Security
  - Unused arguments were discontinued and put aside.

## (1.0.2-alpha) - 25th Oct 2023

### Changed
  - Maven used for building purposes

### Fixed
  - gameOverFrame().O1 that was calling a non-existing window in Languages is now working as expected.

## (1.1-alpha) - 27th Oct 2023

### Added
  - New class `Frame` with the purpose of replacing openStoryFrame() function.

### Changed
  - Buttons action listeners now using lambdas instead of old functions.
  - JFrame now is not generated as a whole each time we call `openStoryFrame()`, instances are doing so from `Frame` class.

### Fixed
  - None

## (1.1.1-alpha) - 27th Oct 2023

### Fixed
  - Met quality gates by fixing longer lines than allowed.

## (2.0-alpha) - 6th Nov 2023

### Added
  - Database <---> Client system for retrieving phases data.
  - Phases System now working using a database with a CSV column.
  - Frame class method: `updateUI()` that will update texts according to the phase key.
  - Frame class method: `retrieveDataFromDatabase()` which may run the requested query to the database.
  - Dark mode on the works.

## (2.1-alpha) - 12th Nov 2023

### Added
  - `Frame.startGameFrame()` now features a panel for Location and Body. 
  - `Frame`
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