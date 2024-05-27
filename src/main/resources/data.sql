-- Создание таблицы person
CREATE TABLE IF NOT EXISTS person (
                                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                      name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    bio TEXT
    );

-- Создание таблицы interest
CREATE TABLE IF NOT EXISTS interest (
                                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                        name VARCHAR(255) NOT NULL
    );

-- Создание таблицы person_interest для связи многие ко многим
CREATE TABLE IF NOT EXISTS person_interest (
                                               person_id BIGINT NOT NULL,
                                               interest_id BIGINT NOT NULL,
                                               PRIMARY KEY (person_id, interest_id),
    FOREIGN KEY (person_id) REFERENCES person(id) ON DELETE CASCADE,
    FOREIGN KEY (interest_id) REFERENCES interest(id) ON DELETE CASCADE
    );

-- Вставка данных в таблицу person
INSERT INTO person (name, email, bio) VALUES ('John Doe', 'john.doe@example.com', 'Software Developer');
INSERT INTO person (name, email, bio) VALUES ('Jane Smith', 'jane.smith@example.com', 'Data Scientist');

-- Вставка данных в таблицу interest
INSERT INTO interest (name) VALUES ('Reading');
INSERT INTO interest (name) VALUES ('Traveling');
INSERT INTO interest (name) VALUES ('Cooking');

-- Вставка данных в таблицу person_interest для связывания людей с их интересами
INSERT INTO person_interest (person_id, interest_id) VALUES (1, 1); -- John Doe likes Reading
INSERT INTO person_interest (person_id, interest_id) VALUES (1, 2); -- John Doe likes Traveling
INSERT INTO person_interest (person_id, interest_id) VALUES (2, 2); -- Jane Smith likes Traveling
INSERT INTO person_interest (person_id, interest_id) VALUES (2, 3); -- Jane Smith likes Cooking
