CREATE TABLE es_ESPhases
(
    DatabaseID int AUTO_INCREMENT PRIMARY KEY,
    phaseKey   VARCHAR(255)  NOT NULL,
    Location   VARCHAR(255)  NULL,
    Body       VARCHAR(3072) NULL,
    Option1    VARCHAR(255)  NULL,
    Option2    VARCHAR(1024) NULL,
    NextPhase  VARCHAR(255)  NULL,
    GameOver   VARCHAR(3072) NULL
);