INSERT INTO USERS(username, password, enabled)
VALUES ('admin', '$2a$12$/x6QXEB1/jqBMBJgIDql8.hdbX2agK9KFXf05tU1r7ZTWZrMbHi7m', true), -- pwd=1234
       ('user1', '$2a$12$/1c5qJPx2l2PPuhE.4eGXeDhP6HamxGUogt3.rxK4dIlc09bKQLpe', true); -- pwd=u1

INSERT INTO AUTHORITIES(username, authority)
VALUES ('admin', 'ROLE_ADMIN'),
       ('user1', 'ROLE_USER');

INSERT INTO USER_DETAILS_EXTRA(username, first_name, last_name, mail, birth_date)
VALUES ('admin', 'Alice', 'Rossi', 'alice.rossi@example.com', '1995-03-21'),
       ('user1', 'Marco', 'Bianchi', 'marco.bianchi@example.com', '1990-11-05');

INSERT INTO review (username, rating, text, created_at)
VALUES ('admin', 5, 'Servizio eccellente, tornerò sicuramente!', CURRENT_TIMESTAMP - 10 DAY),
       ('admin', 4, 'Buona esperienza complessiva, ma i tempi di attesa un po’ lunghi.', CURRENT_TIMESTAMP - 7 DAY),
       ('admin', 3, 'Normale, niente di speciale. Ci sono margini di miglioramento.', CURRENT_TIMESTAMP - 3 DAY),
       ('user1', 2, 'Non sono rimasto soddisfatto, troppo costoso per quello che offre.', CURRENT_TIMESTAMP - 1 DAY),
       ('user1', 5, 'Esperienza fantastica, lo consiglio a tutti!', CURRENT_TIMESTAMP);
