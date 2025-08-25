CREATE TABLE USERS
(
    username VARCHAR(64) NOT NULL PRIMARY KEY,
    password VARCHAR(64) NOT NULL,
    enabled  BOOLEAN     NOT NULL
);

CREATE TABLE AUTHORITIES
(
    username  VARCHAR(64) NOT NULL PRIMARY KEY,
    authority VARCHAR(64) NOT NULL,
    CONSTRAINT FK_Authorities_Users FOREIGN KEY (username) REFERENCES USERS (username)
);

CREATE TABLE USER_DETAILS_EXTRA
(
    username   VARCHAR(64) NOT NULL PRIMARY KEY,
    first_name VARCHAR(64) NOT NULL,
    last_name  VARCHAR(64) NOT NULL,
    mail       VARCHAR(64) NOT NULL,
    birth_date DATE        NOT NULL,
    sport      VARCHAR(20) NOT NULL,
    fav_team   VARCHAR(64) NOT NULL,
    CONSTRAINT FK_UserDetailsExtra_Users FOREIGN KEY (username) REFERENCES USERS (username)
);


CREATE TABLE IF NOT EXISTS REVIEW
(
    id
    BIGINT
    AUTO_INCREMENT
    PRIMARY
    KEY,
    username
    VARCHAR
(
    64
) NOT NULL,
    rating INT NOT NULL,
    text VARCHAR
(
    1024
),
    created_at TIMESTAMP NOT NULL
    );

CREATE TABLE IF NOT EXISTS PRIZE
(
    id
    BIGINT
    AUTO_INCREMENT
    PRIMARY
    KEY,
    username
    VARCHAR
(
    64
) NOT NULL,
    description VARCHAR
(
    64
) NOT NULL,
    assigned_at TIMESTAMP NOT NULL,
    CONSTRAINT FK_Prize_Users FOREIGN KEY
(
    username
) REFERENCES USERS
(
    username
)
    );

CREATE TABLE IF NOT EXISTS BET
(
    username
    VARCHAR
(
    64
) NOT NULL,
    played_at TIMESTAMP NOT NULL,
    score INT NOT NULL,
    CONSTRAINT FK_Bet_Users FOREIGN KEY
(
    username
) REFERENCES USERS
(
    username
)
    );
