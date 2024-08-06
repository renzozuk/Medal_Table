CREATE TABLE country (
    id TEXT PRIMARY KEY UNIQUE NOT NULL,
    name TEXT UNIQUE NOT NULL,
    photo_path TEXT NOT NULL,
    gold_medals INT NOT NULL,
    silver_medals INT NOT NULL,
    bronze_medals INT NOT NULL
);