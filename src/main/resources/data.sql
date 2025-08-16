INSERT INTO USERS(id, username, password, enabled)
VALUES (1, 'admin', '$2a$12$/x6QXEB1/jqBMBJgIDql8.hdbX2agK9KFXf05tU1r7ZTWZrMbHi7m', true), -- pwd=1234
       (2, 'user1', '$2a$12$/1c5qJPx2l2PPuhE.4eGXeDhP6HamxGUogt3.rxK4dIlc09bKQLpe', true); -- pwd=u1

INSERT INTO AUTHORITIES(user_id, username, authority)
VALUES (1,'admin', 'ROLE_ADMIN'),
       (2,'user1', 'ROLE_USER');

INSERT INTO USER_DETAILS_EXTRA(user_id, first_name, last_name, mail, birth_date)
VALUES (1, 'Alice', 'Rossi', 'alice.rossi@example.com', '1995-03-21'),
       (2, 'Marco', 'Bianchi', 'marco.bianchi@example.com', '1990-11-05');
