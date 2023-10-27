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