CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    hashed_password VARCHAR(60) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT (CURRENT_TIMESTAMP)
);

CREATE TABLE categories (
    category_id SERIAL PRIMARY KEY,
    name VARCHAR(100) UNIQUE NOT NULL
);


CREATE TABLE questions (
    question_id SERIAL PRIMARY KEY,
    text TEXT NOT NULL,
    category_id INT REFERENCES categories(category_id) ON DELETE CASCADE,
    difficulty INT
);

CREATE TABLE answers (
    answer_id SERIAL PRIMARY KEY,
    question_id INT REFERENCES questions(question_id) ON DELETE CASCADE,
    text TEXT NOT NULL,
    is_correct BOOLEAN NOT NULL
);


CREATE TABLE matches (
    match_id SERIAL PRIMARY KEY,
    category_id INT REFERENCES categories(category_id) ON DELETE CASCADE,
    difficulty_id INT REFERENCES difficulties(difficulty_id) ON DELETE CASCADE,
    status VARCHAR(20) NOT NULL DEFAULT 'active' CHECK (status IN ('active', 'completed', 'canceled')),
    created_at TIMESTAMP NOT NULL DEFAULT (CURRENT_TIMESTAMP),
    ended_at TIMESTAMP
);

CREATE TABLE match_participants (
    match_id INT REFERENCES matches(match_id) ON DELETE CASCADE,
    user_id INT REFERENCES users(user_id) ON DELETE CASCADE,
    score INT DEFAULT 0 CHECK (score >= 0),
    PRIMARY KEY (match_id, user_id)
);

CREATE TABLE match_questions (
    match_id INT REFERENCES matches(match_id) ON DELETE CASCADE,
    question_id INT REFERENCES questions(question_id) ON DELETE CASCADE,
    question_order INT NOT NULL,
    PRIMARY KEY (match_id, question_id)
);

CREATE TABLE player_answers (
    player_answer_id SERIAL PRIMARY KEY,
    match_id INT REFERENCES matches(match_id) ON DELETE CASCADE,
    user_id INT REFERENCES users(user_id) ON DELETE CASCADE,
    question_id INT REFERENCES questions(question_id) ON DELETE CASCADE,
    chosen_answer_id INT REFERENCES answers(answer_id) ON DELETE CASCADE,
    answered_at TIMESTAMP NOT NULL DEFAULT (CURRENT_TIMESTAMP)
);