CREATE TABLE notes
(
    id          INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    title       VARCHAR(100),
    description VARCHAR(2500)
);