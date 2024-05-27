-- Создание таблицы person
CREATE TABLE IF NOT EXISTS person (
                                      id UUID PRIMARY KEY,
                                      name VARCHAR(255),
    email VARCHAR(255),
    bio TEXT
    );

-- Создание таблицы skill
CREATE TABLE IF NOT EXISTS skill (
                                     id UUID PRIMARY KEY,
                                     name VARCHAR(255),
    description TEXT,
    person_id UUID,
    FOREIGN KEY (person_id) REFERENCES person(id)
    );

-- Создание таблицы experience
CREATE TABLE IF NOT EXISTS experience (
                                          id UUID PRIMARY KEY,
                                          from_date DATE,
                                          to_date DATE,
                                          company VARCHAR(255),
    position VARCHAR(255),
    description TEXT,
    person_id UUID,
    FOREIGN KEY (person_id) REFERENCES person(id)
    );

-- Создание таблицы education
CREATE TABLE IF NOT EXISTS education (
                                         id UUID PRIMARY KEY,
                                         finished_at DATE,
                                         university VARCHAR(255),
    degree VARCHAR(255),
    degree_name VARCHAR(255),
    person_id UUID,
    FOREIGN KEY (person_id) REFERENCES person(id)
    );

-- Вставка данных в таблицу person
INSERT INTO person (id, name, email, bio) VALUES
                                              (UUID(), 'John Doe', 'john.doe@example.com', 'Software Engineer'),
                                              (UUID(), 'Jane Smith', 'jane.smith@example.com', 'Data Scientist');

-- Вставка данных в таблицу skill
INSERT INTO skill (id, name, description, person_id) VALUES
                                                         (UUID(), 'Java', 'Experienced in Java programming', (SELECT id FROM person WHERE email='john.doe@example.com')),
                                                         (UUID(), 'Python', 'Experienced in Python programming', (SELECT id FROM person WHERE email='jane.smith@example.com'));

-- Вставка данных в таблицу experience
INSERT INTO experience (id, from_date, to_date, company, position, description, person_id) VALUES
                                                                                               (UUID(), '2020-01-01', '2021-01-01', 'Tech Corp', 'Developer', 'Developed software solutions', (SELECT id FROM person WHERE email='john.doe@example.com')),
                                                                                               (UUID(), '2019-01-01', '2020-01-01', 'Data Inc.', 'Data Analyst', 'Analyzed data sets', (SELECT id FROM person WHERE email='jane.smith@example.com'));

-- Вставка данных в таблицу education
INSERT INTO education (id, finished_at, university, degree, degree_name, person_id) VALUES
                                                                                        (UUID(), '2018-06-01', 'MIT', 'BSc', 'Computer Science', (SELECT id FROM person WHERE email='john.doe@example.com')),
                                                                                        (UUID(), '2017-06-01', 'Stanford', 'MSc', 'Data Science', (SELECT id FROM person WHERE email='jane.smith@example.com'));
