CREATE TABLE USERS
(
    username VARCHAR(64) NOT NULL PRIMARY KEY,
    password VARCHAR(64) NOT NULL,
    enabled  BOOLEAN     NOT NULL
);

CREATE TABLE AUTHORITIES
(
    username  VARCHAR(64) NOT NULL,
    authority VARCHAR(64) NOT NULL,
    CONSTRAINT FK_Authorities_Users FOREIGN KEY (username) REFERENCES USERS (username)
);

CREATE TABLE USER_DETAILS_EXTRA
(
    username   VARCHAR(64) PRIMARY KEY,
    first_name VARCHAR(64),
    last_name  VARCHAR(64),
    mail       VARCHAR(64),
    birth_date DATE,
    CONSTRAINT FK_UserDetailsExtra_Users FOREIGN KEY (username) REFERENCES USERS (username)
);
