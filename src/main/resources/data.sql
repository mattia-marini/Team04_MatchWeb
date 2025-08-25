INSERT INTO USERS(username, password, enabled)
VALUES ('admin', '$2a$12$/x6QXEB1/jqBMBJgIDql8.hdbX2agK9KFXf05tU1r7ZTWZrMbHi7m', true), -- pwd=1234
       ('user1', '$2a$12$/1c5qJPx2l2PPuhE.4eGXeDhP6HamxGUogt3.rxK4dIlc09bKQLpe', true); -- pwd=u1

INSERT INTO AUTHORITIES(username, authority)
VALUES ('admin', 'ROLE_ADMIN'),
       ('user1', 'ROLE_USER');

INSERT INTO USER_DETAILS_EXTRA(username, first_name, last_name, mail, birth_date, fav_team, sport)
VALUES ('admin', 'Alice', 'Rossi', 'alice.rossi@example.com', '1995-03-21', 'Milan', 'CALCIO'),
       ('user1', 'Marco', 'Bianchi', 'marco.bianchi@example.com', '1990-11-05', 'Inter', 'CALCIO');

INSERT INTO REVIEW (username, rating, text, created_at)
VALUES ('admin', 5, 'Servizio eccellente, tornerò sicuramente!', CURRENT_TIMESTAMP - 10 DAY),
       ('admin', 4, 'Buona esperienza complessiva, ma i tempi di attesa un po’ lunghi.', CURRENT_TIMESTAMP - 7 DAY),
       ('admin', 3, 'Normale, niente di speciale. Ci sono margini di miglioramento.', CURRENT_TIMESTAMP - 3 DAY),
       ('user1', 2, 'Non sono rimasto soddisfatto, troppo costoso per quello che offre.', CURRENT_TIMESTAMP - 1 DAY),
       ('user1', 5, 'Esperienza fantastica, lo consiglio a tutti!', CURRENT_TIMESTAMP);

INSERT INTO PRIZE (username, description, assigned_at)
VALUES ('admin', 'Bonus Benvenuto', '2025-08-01 10:30:00'),
       ('user1', 'Vittoria Giornata 3', '2025-08-05 18:45:00'),
       ('user1', 'Miglior Punteggio della Settimana', '2025-08-12 21:15:00');

INSERT INTO BET (username, played_at, score)
VALUES ('admin', '2025-08-01 15:00:00', 5),
       ('admin', '2025-08-05 16:20:00', 3),
       ('admin', '2025-08-12 14:00:00', 4),
       ('user1', '2025-08-01 15:10:00', 2),
       ('user1', '2025-08-03 17:00:00', 4),
       ('user1', '2025-08-06 19:30:00', 1),
       ('user1', '2025-08-10 20:00:00', 5),
       ('user1', '2025-08-13 21:45:00', 3);
