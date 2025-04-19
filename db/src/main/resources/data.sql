INSERT INTO categories (name) VALUES
    ('History'), ('Movies'), ('Science'), ('Music'), ('Geography'),
    ('Sports'), ('Languages'), ('Literature');

INSERT INTO questions (text, category_id, difficulty) VALUES
               ('Who was the first President of the United States?', 1, 1),
               ('In which year did World War II end?', 1, 1),


               ('Which movie features a young wizard attending Hogwarts School of Witchcraft and Wizardry?', 2, 1),
               ('Who voiced the character of Woody in the Toy Story films?', 2, 1),


               ('What is the chemical symbol for gold?', 3, 1),
               ('Which planet is closest to the Sun?', 3, 1),


               ('Which band performed the hit song "Yellow Submarine"?', 4, 1),
               ('Which instrument does a pianist play?', 4, 1),


               ('Which is the largest ocean on Earth?', 5, 1),
               ('What is the capital city of France?', 5, 1),


               ('In which sport would you perform a slam dunk?', 6, 1),
               ('How many players are on a standard soccer/football team on the field?', 6, 1);

INSERT INTO questions (text, category_id, difficulty) VALUES
                -- History questions (category_id = 1)
                ('Which civilization built the Machu Picchu complex in Peru?', 1, 1),
                ('When was the Declaration of Independence signed?', 1, 1),
                ('Who was the first woman to fly solo across the Atlantic Ocean?', 1, 1),
                ('Which ancient wonder was located in Alexandria, Egypt?', 1, 1),
                ('Who painted the Mona Lisa?', 1, 1),

                -- Movies questions (category_id = 2)
                ('What was the first feature-length animated film released by Disney?', 2, 1),
                ('Who directed the movie "Jaws"?', 2, 1),
                ('Which actor played Iron Man in the Marvel Cinematic Universe?', 2, 1),
                ('What film won the Academy Award for Best Picture in 2020?', 2, 1),
                ('In "The Lion King", what is the name of Simba''s father?', 2, 1),

                -- Science questions (category_id = 3)
                ('Which gas do plants absorb from the atmosphere?', 3, 1),
                ('What is the hardest natural substance on Earth?', 3, 1),
                ('Which planet is known as the "Red Planet"?', 3, 1),
                ('What is the largest organ in the human body?', 3, 1),
                ('What is H2O commonly known as?', 3, 1),

                -- Music questions (category_id = 4)
                ('Which singer is known as the "Queen of Pop"?', 4, 1),
                ('What instrument did Louis Armstrong play?', 4, 1),
                ('Which of these bands is from the UK?', 4, 1),
                ('What was Elvis Presley''s first #1 hit on the Billboard charts?', 4, 1),
                ('Which music genre originated in Jamaica?', 4, 1),

                -- Geography questions (category_id = 5)
                ('Which country is home to the Great Barrier Reef?', 5, 1),
                ('What is the longest river in the world?', 5, 1),
                ('Which mountain range runs through Switzerland?', 5, 1),
                ('What is the capital of Canada?', 5, 1),
                ('Which of these countries is NOT in Europe?', 5, 1),

                -- Sports questions (category_id = 6)
                ('In which sport would you use a shuttlecock?', 6, 1),
                ('How many points is a touchdown worth in American football?', 6, 1),
                ('Which country won the FIFA World Cup in 2018?', 6, 1),
                ('In which Olympic sport would you perform a vault?', 6, 1),
                ('What is the diameter of a basketball hoop in inches?', 6, 1);

                INSERT INTO answers(question_id, text, is_correct) VALUES
                 (2, '1943', false),
                 (2, '1945', true),
                 (2, '1947', false),
                 (2, '1950', false),
                 (3, 'The Chronicles of Narnia', false),
                 (3, 'Harry Potter and the Sorcerer''s Stone', true),
                 (3, 'Percy Jackson & the Olympians', false),
                 (3, 'The Golden Compass', false),
                 (4, 'Tim Allen', false),
                 (4, 'Billy Crystal', false),
                 (4, 'Tom Hanks', true),
                 (4, 'John Goodman', false),
                 (5, 'Go', false),
                 (5, 'Gd', false),
                 (5, 'Au', true),
                 (5, 'Ag', false),
                 (6, 'Earth', false),
                 (6, 'Venus', false),
                 (6, 'Mars', false),
                 (6, 'Mercury', true),
                 (7, 'The Rolling Stones', false),
                 (7, 'The Beach Boys', false),
                 (7, 'The Beatles', true),
                 (7, 'The Monkees', false),
                 (8, 'Drums', false),
                 (8, 'Guitar', false),
                 (8, 'Piano', true),
                 (8, 'Violin', false),
                 (9, 'Atlantic Ocean', false),
                 (9, 'Indian Ocean', false),
                 (9, 'Arctic Ocean', false),
                 (9, 'Pacific Ocean', true),
                 (10, 'Berlin', false),
                 (10, 'London', false),
                 (10, 'Paris', true),
                 (10, 'Rome', false),
                 (11, 'Football', false),
                 (11, 'Basketball', true),
                 (11, 'Hockey', false),
                 (11, 'Soccer', false),
                 (12, '9', false),
                 (12, '10', false),
                 (12, '11', true),
                 (12, '12', false),
                 (13, 'Maya', false),
                 (13, 'Aztec', false),
                 (13, 'Inca', true),
                 (13, 'Olmec', false),
                 (14, '1772', false),
                 (14, '1776', true),
                 (14, '1780', false),
                 (14, '1789', false),
                 (15, 'Bessie Coleman', false),
                 (15, 'Harriet Quimby', false),
                 (15, 'Amelia Earhart', true),
                 (15, 'Amy Johnson', false),
                 (16, 'The Hanging Gardens', false),
                 (16, 'The Lighthouse (Pharos)', true),
                 (16, 'The Colossus', false),
                 (16, 'The Mausoleum', false),
                 (17, 'Vincent van Gogh', false),
                 (17, 'Michelangelo', false),
                 (17, 'Leonardo da Vinci', true),
                 (17, 'Pablo Picasso', false),
                 (18, 'Fantasia', false),
                 (18, 'Snow White and the Seven Dwarfs', true),
                 (18, 'Bambi', false),
                 (18, 'Pinocchio', false),
                 (19, 'Francis Ford Coppola', false),
                 (19, 'Martin Scorsese', false),
                 (19, 'Steven Spielberg', true),
                 (19, 'George Lucas', false),
                 (20, 'Chris Evans', false),
                 (20, 'Chris Hemsworth', false),
                 (20, 'Mark Ruffalo', false),
                 (20, 'Robert Downey Jr.', true),
                 (21, '1917', false),
                 (21, 'Joker', false),
                 (21, 'Parasite', true),
                 (21, 'Once Upon a Time in Hollywood', false),
                 (22, 'Scar', false),
                 (22, 'Mufasa', true),
                 (22, 'Rafiki', false),
                 (22, 'Zazu', false),
                 (23, 'Oxygen', false),
                 (23, 'Nitrogen', false),
                 (23, 'Carbon Dioxide', true),
                 (23, 'Hydrogen', false),
                 (24, 'Titanium', false),
                 (24, 'Diamond', true),
                 (24, 'Platinum', false),
                 (24, 'Quartz', false),
                 (25, 'Jupiter', false),
                 (25, 'Venus', false),
                 (25, 'Mars', true),
                 (25, 'Saturn', false),
                 (26, 'Brain', false),
                 (26, 'Liver', false),
                 (26, 'Skin', true),
                 (26, 'Heart', false),
                 (27, 'Hydrogen Peroxide', false),
                 (27, 'Oxygen', false),
                 (27, 'Water', true),
                 (27, 'Salt', false),
                 (28, 'Beyoncé', false),
                 (28, 'Lady Gaga', false),
                 (28, 'Madonna', true),
                 (28, 'Whitney Houston', false),
                 (29, 'Saxophone', false),
                 (29, 'Piano', false),
                 (29, 'Trumpet', true),
                 (29, 'Drums', false),
                 (30, 'AC/DC', false),
                 (30, 'The Rolling Stones', true),
                 (30, 'Nirvana', false),
                 (30, 'ABBA', false),
                 (31, 'Blue Suede Shoes', false),
                 (31, 'Heartbreak Hotel', true),
                 (31, 'Hound Dog', false),
                 (31, 'Jailhouse Rock', false),
                 (32, 'Salsa', false),
                 (32, 'Hip-hop', false),
                 (32, 'Reggae', true),
                 (32, 'Blues', false),
                 (33, 'Brazil', false),
                 (33, 'Thailand', false),
                 (33, 'Australia', true),
                 (33, 'Mexico', false),
                 (34, 'Amazon', false),
                 (34, 'Mississippi', false),
                 (34, 'Yangtze', false),
                 (34, 'Nile', true),
                 (35, 'Andes', false),
                 (35, 'Alps', true),
                 (35, 'Rockies', false),
                 (35, 'Himalayas', false),
                 (36, 'Toronto', false),
                 (36, 'Vancouver', false),
                 (36, 'Ottawa', true),
                 (36, 'Montreal', false),
                 (37, 'Portugal', false),
                 (37, 'Turkey', false),
                 (37, 'Egypt', true),
                 (37, 'Greece', false),
                 (38, 'Table Tennis', false),
                 (38, 'Badminton', true),
                 (38, 'Tennis', false),
                 (38, 'Squash', false),
                 (39, '3', false),
                 (39, '6', true),
                 (39, '7', false),
                 (39, '2', false),
                 (40, 'Brazil', false),
                 (40, 'Germany', false),
                 (40, 'France', true),
                 (40, 'Argentina', false),
                 (41, 'Swimming', false),
                 (41, 'Athletics', false),
                 (41, 'Gymnastics', true),
                 (41, 'Diving', false),
                 (42, '16', false),
                 (42, '18', true),
                 (42, '20', false),
                 (42, '22', false);

INSERT INTO questions (text, category_id, difficulty) VALUES
                -- History
                ('Who was the first president of the United States?', 1, 3),
                ('In which year did World War II end?', 1, 3),
                ('What was the name of the ship that carried the Pilgrims to America in 1620?', 1, 3),
                ('Who was the leader of the Soviet Union during the Cuban Missile Crisis?', 1, 3),
                ('What was the significance of the Magna Carta in 1215?', 1, 3),
                ('Who was the longest-reigning monarch in British history?', 1, 3),
                ('Which ancient civilization built the pyramids?', 1, 3),
                ('What was the Battle of Hastings, and when did it occur?', 1, 3),
                ('Who assassinated Archduke Franz Ferdinand?', 1, 3),
                ('In what year did the Berlin Wall fall?', 1, 3),

                -- Movies
                ('Who won the Academy Award for Best Director in 1994?', 2, 3),
                ('Which movie features a character named “Forrest Gump”?', 2, 3),
                ('What is the name of the fictional African country in the movie "Black Panther"?', 2, 3),
                ('Who directed the movie "Inception"?', 2, 3),
                ('What year was the first "Star Wars" movie released?', 2, 3),
                ('Who starred as Jack Dawson in "Titanic"?', 2, 3),
                ('What is the longest-running film series in Hollywood?', 2, 3),
                ('What is the title of the highest-grossing film of all time (as of 2025)?', 2, 3),
                ('Who played the role of the Joker in "The Dark Knight"?', 2, 3),
                ('Which movie won the Academy Award for Best Picture in 2010?', 2, 3),

                -- Science
                ('What is the chemical symbol for water?', 3, 3),
                ('Who developed the theory of general relativity?', 3, 3),
                ('What planet is known as the "Red Planet"?', 3, 3),
                ('What element does "O" represent on the periodic table?', 3, 3),
                ('What is the most abundant gas in Earth’s atmosphere?', 3, 3),
                ('What is the second-most common element in Earth’s crust?', 3, 3),
                ('What is the speed of light in a vacuum?', 3, 3),
                ('What type of animal is a Komodo dragon?', 3, 3),
                ('Who discovered the circulation of blood in the human body?', 3, 3),
                ('What is the smallest unit of life?', 3, 3),

                -- Music
                ('Who is known as the "King of Pop"?', 4, 3),
                ('Which band released the album "Abbey Road"?', 4, 3),
                ('Who wrote the famous classical piece "Fur Elise"?', 4, 3),
                ('Which artist is known for the hit song "Like a Rolling Stone"?', 4, 3),
                ('What is the name of the famous music festival held annually in Tennessee?', 4, 3),
                ('Which pop star is known for the hit "Bad Romance"?', 4, 3),
                ('Who was the lead singer of Queen?', 4, 3),
                ('What year did the Beatles break up?', 4, 3),
                ('Which composer wrote "The Four Seasons"?', 4, 3),
                ('Who was the first female artist to win a Grammy for Album of the Year?', 4, 3),

                -- Geography
                ('What is the capital city of Canada?', 5, 3),
                ('Which country has the longest coastline?', 5, 3),
                ('In which country would you find the Great Barrier Reef?', 5, 3),
                ('What is the smallest country in the world by population?', 5, 3),
                ('Which is the largest desert in the world?', 5, 3),
                ('Which river is the longest in the world?', 5, 3),
                ('What is the capital of Japan?', 5, 3),
                ('Which country has the most official languages?', 5, 3),
                ('What is the highest mountain in North America?', 5, 3),
                ('Which country has the most volcanoes?', 5, 3),

                -- Sports
                ('Who holds the record for the most goals scored in World Cup history?', 6, 3),
                ('Which country hosted the 2008 Summer Olympics?', 6, 3),
                ('What year did Michael Jordan retire from the NBA for the second time?', 6, 3),
                ('Which football team has won the most Super Bowls?', 6, 3),
                ('Who is known as "The Greatest Boxer of All Time"?', 6, 3),
                ('What sport is played at Wimbledon?', 6, 3),
                ('Which country won the 2014 FIFA World Cup?', 6, 3),
                ('Who is the most decorated Olympian of all time?', 6, 3),
                ('What is the name of the tennis tournament played at Roland Garros?', 6, 3),
                ('In which sport would you compete in the "Tour de France"?', 6, 3);


INSERT INTO questions (text, category_id, difficulty) VALUES
                -- History
                ('In which year did the French Revolution begin?', 1, 2),
                ('Who was the first emperor of Rome?', 1, 2),
                ('Which country did Napoleon Bonaparte originate from?', 1, 2),
                ('What treaty ended World War I?', 1, 2),
                ('Which country was divided into East and West during the Cold War?', 1, 2),
                ('Who was the British Prime Minister during World War II?', 1, 2),
                ('In which year did the Berlin Wall start being built?', 1, 2),
                ('Who was the first female Prime Minister of the UK?', 1, 2),
                ('Which empire was ruled by Julius Caesar?', 1, 2),
                ('In what year was the United Nations founded?', 1, 2),

                -- Movies
                ('Which movie features a character named "Darth Vader"?', 2, 2),
                ('Who directed the movie "Schindler’s List"?', 2, 2),
                ('What is the name of the wizarding school in "Harry Potter"?', 2, 2),
                ('Which movie won the Academy Award for Best Picture in 2001?', 2, 2),
                ('Who starred as the main character in "The Matrix"?', 2, 2),
                ('In which movie does the character "Rocky Balboa" appear?', 2, 2),
                ('What animated film features the character Simba?', 2, 2),
                ('Which film featured the famous line, "I’ll be back"?', 2, 2),
                ('Who is the director of the "Lord of the Rings" trilogy?', 2, 2),
                ('What is the name of the fictional spaceship in "Star Trek"?', 2, 2),

                -- Science
                ('What is the chemical symbol for oxygen?', 3, 2),
                ('What is the name of the process by which plants make food using sunlight?', 3, 2),
                ('Which planet is the closest to the Sun?', 3, 2),
                ('What is the primary gas found in Earth’s atmosphere?', 3, 2),
                ('Who is credited with developing the theory of evolution?', 3, 2),
                ('What is the smallest bone in the human body?', 3, 2),
                ('Which gas do humans exhale when breathing?', 3, 2),
                ('Which element has the atomic number 1?', 3, 2),
                ('How many planets are there in our solar system?', 3, 2),
                ('What is the name of the process by which water vapor turns into liquid?', 3, 2),

                -- Music
                ('Who is the famous composer of "The Magic Flute"?', 4, 2),
                ('Which rock band is famous for the album "The Dark Side of the Moon"?', 4, 2),
                ('Who composed the "Ode to Joy"?', 4, 2),
                ('Which musician is known for the hit song "Yesterday"?', 4, 2),
                ('What type of instrument is a piano?', 4, 2),
                ('Which band performed the song "Bohemian Rhapsody"?', 4, 2),
                ('Who composed "Symphony No. 9"?', 4, 2),
                ('Which singer is known for the hit song "Imagine"?', 4, 2),
                ('Which country did Beethoven originate from?', 4, 2),
                ('Which artist released the album "Thriller"?', 4, 2),

                -- Geography
                ('Which country is the capital city of Brussels?', 5, 2),
                ('Which European country is famous for the Eiffel Tower?', 5, 2),
                ('What is the largest country in Europe by land area?', 5, 2),
                ('Which country has the most islands in Europe?', 5, 2),
                ('What is the capital of Italy?', 5, 2),
                ('Which river runs through Paris?', 5, 2),
                ('What is the capital city of Spain?', 5, 2),
                ('Which mountain is the highest in Europe?', 5, 2),
                ('What is the longest river in Europe?', 5, 2),
                ('Which country is known for its canals and windmills?', 5, 2),

                -- Sports
                ('Which country won the 2016 UEFA European Championship in football?', 6, 2),
                ('Who won the 2016 Olympic gold medal in men’s tennis?', 6, 2),
                ('Which country hosted the 2014 FIFA World Cup?', 6, 2),
                ('In which sport would you compete in the "Tour de France"?', 6, 2),
                ('Which city hosted the 2008 Summer Olympics?', 6, 2),
                ('Which tennis player has won the most Grand Slam singles titles?', 6, 2),
                ('Who won the 2018 FIFA World Cup?', 6, 2),
                ('What country is the home of Formula 1 driver Sebastian Vettel?', 6, 2),
                ('Which European football team has won the most UEFA Champions League titles?', 6, 2),
                ('What is the most common rugby ball shape?', 6, 2);


INSERT INTO answers (question_id, text, is_correct) VALUES
                -- Question 43: Who was the first president of the United States?
                (43, 'Thomas Jefferson', false),
                (43, 'George Washington', true),
                (43, 'Abraham Lincoln', false),
                (43, 'John Adams', false),

                -- Question 44: In which year did World War II end?
                (44, '1944', false),
                (44, '1943', false),
                (44, '1945', true),
                (44, '1946', false),

                -- Question 45: What was the name of the ship that carried the Pilgrims to America in 1620?
                (45, 'Santa Maria', false),
                (45, 'Nina', false),
                (45, 'Discovery', false),
                (45, 'Mayflower', true),

                -- Question 46: Who was the leader of the Soviet Union during the Cuban Missile Crisis?
                (46, 'Joseph Stalin', false),
                (46, 'Nikita Khrushchev', true),
                (46, 'Vladimir Lenin', false),
                (46, 'Leonid Brezhnev', false),

                -- Question 47: What was the significance of the Magna Carta in 1215?
                (47, 'It established the first parliament in Europe', false),
                (47, 'It ended the Hundred Years War', false),
                (47, 'It limited the power of the monarch and established rights for citizens', true),
                (47, 'It created the modern English judicial system', false),

                -- Question 48: Who was the longest-reigning monarch in British history?
                (48, 'Queen Victoria', false),
                (48, 'King George III', false),
                (48, 'Queen Elizabeth II', true),
                (48, 'King Henry VIII', false),

                -- Question 49: Which ancient civilization built the pyramids?
                (49, 'Mayans', false),
                (49, 'Ancient Egyptians', true),
                (49, 'Romans', false),
                (49, 'Aztecs', false),

                -- Question 50: What was the Battle of Hastings, and when did it occur?
                (50, 'A naval battle in 1588 during the Spanish Armada', false),
                (50, 'A battle in 1415 during the Hundred Years War', false),
                (50, 'A battle in 1815 after Napoleon escaped from Elba', false),
                (50, 'A battle in 1066 when William the Conqueror invaded England', true),

                -- Question 51: Who assassinated Archduke Franz Ferdinand?
                (51, 'Leon Czolgosz', false),
                (51, 'John Wilkes Booth', false),
                (51, 'Gavrilo Princip', true),
                (51, 'Lee Harvey Oswald', false),

                -- Question 52: In what year did the Berlin Wall fall?
                (52, '1989', true),
                (52, '1991', false),
                (52, '1987', false),
                (52, '1985', false),

                -- Question 53: Who won the Academy Award for Best Director in 1994?
                (53, 'Quentin Tarantino', false),
                (53, 'Steven Spielberg', true),
                (53, 'Martin Scorsese', false),
                (53, 'Francis Ford Coppola', false),

                -- Question 54: Which movie features a character named "Forrest Gump"?
                (54, 'Saving Private Ryan', false),
                (54, 'The Green Mile', false),
                (54, 'Forrest Gump', true),
                (54, 'Cast Away', false),

                -- Question 55: What is the name of the fictional African country in the movie "Black Panther"?
                (55, 'Zamunda', false),
                (55, 'Wakanda', true),
                (55, 'Genovia', false),
                (55, 'Latveria', false),

                -- Question 56: Who directed the movie "Inception"?
                (56, 'Steven Spielberg', false),
                (56, 'James Cameron', false),
                (56, 'Christopher Nolan', true),
                (56, 'Martin Scorsese', false),

                -- Question 57: What year was the first "Star Wars" movie released?
                (57, '1980', false),
                (57, '1975', false),
                (57, '1983', false),
                (57, '1977', true),

                -- Question 58: Who starred as Jack Dawson in "Titanic"?
                (58, 'Brad Pitt', false),
                (58, 'Leonardo DiCaprio', true),
                (58, 'Matt Damon', false),
                (58, 'Tom Cruise', false),

                -- Question 59: What is the longest-running film series in Hollywood?
                (59, 'Star Wars', false),
                (59, 'Marvel Cinematic Universe', false),
                (59, 'James Bond', true),
                (59, 'Harry Potter', false),

                -- Question 60: What is the title of the highest-grossing film of all time (as of 2025)?
                (60, 'Avengers: Endgame', false),
                (60, 'Avatar', true),
                (60, 'Titanic', false),
                (60, 'Star Wars: The Force Awakens', false),

                -- Question 61: Who played the role of the Joker in "The Dark Knight"?
                (61, 'Joaquin Phoenix', false),
                (61, 'Jack Nicholson', false),
                (61, 'Heath Ledger', true),
                (61, 'Jared Leto', false),

                -- Question 62: Which movie won the Academy Award for Best Picture in 2010?
                (62, 'Avatar', false),
                (62, 'Up', false),
                (62, 'The Hurt Locker', true),
                (62, 'Inglourious Basterds', false),

                -- Question 63: What is the chemical symbol for water?
                (63, 'H₂O', true),
                (63, 'CO₂', false),
                (63, 'O₂', false),
                (63, 'H₂O₂', false),

                -- Question 64: Who developed the theory of general relativity?
                (64, 'Isaac Newton', false),
                (64, 'Albert Einstein', true),
                (64, 'Stephen Hawking', false),
                (64, 'Niels Bohr', false),

                -- Question 65: What planet is known as the "Red Planet"?
                (65, 'Venus', false),
                (65, 'Jupiter', false),
                (65, 'Mars', true),
                (65, 'Mercury', false),

                -- Question 66: What element does "O" represent on the periodic table?
                (66, 'Osmium', false),
                (66, 'Oxygen', true),
                (66, 'Oganesson', false),
                (66, 'Olivium', false),

                -- Question 67: What is the most abundant gas in Earth's atmosphere?
                (67, 'Oxygen', false),
                (67, 'Carbon Dioxide', false),
                (67, 'Nitrogen', true),
                (67, 'Argon', false),

                -- Question 68: What is the second-most common element in Earth's crust?
                (68, 'Silicon', true),
                (68, 'Oxygen', false),
                (68, 'Aluminum', false),
                (68, 'Iron', false),

                -- Question 69: What is the speed of light in a vacuum?
                (69, '300,000 m/s', false),
                (69, '300,000 km/s', true),
                (69, '186,000 m/s', false),
                (69, '186,000 miles/hour', false),

                -- Question 70: What type of animal is a Komodo dragon?
                (70, 'Mammal', false),
                (70, 'Amphibian', false),
                (70, 'Reptile', true),
                (70, 'Fish', false),

                -- Question 71: Who discovered the circulation of blood in the human body?
                (71, 'Louis Pasteur', false),
                (71, 'William Harvey', true),
                (71, 'Alexander Fleming', false),
                (71, 'Galen', false),

                -- Question 72: What is the smallest unit of life?
                (72, 'Atom', false),
                (72, 'Cell', true),
                (72, 'Molecule', false),
                (72, 'Organelle', false),

                -- Question 73: Who is known as the "King of Pop"?
                (73, 'Michael Jackson', true),
                (73, 'Elvis Presley', false),
                (73, 'Prince', false),
                (73, 'Justin Timberlake', false),

                -- Question 74: Which band released the album "Abbey Road"?
                (74, 'The Rolling Stones', false),
                (74, 'Led Zeppelin', false),
                (74, 'The Beatles', true),
                (74, 'Pink Floyd', false),

                -- Question 75: Who wrote the famous classical piece "Fur Elise"?
                (75, 'Ludwig van Beethoven', true),
                (75, 'Wolfgang Amadeus Mozart', false),
                (75, 'Johann Sebastian Bach', false),
                (75, 'Franz Schubert', false),

                -- Question 76: Which artist is known for the hit song "Like a Rolling Stone"?
                (76, 'Bruce Springsteen', false),
                (76, 'Bob Dylan', true),
                (76, 'Neil Young', false),
                (76, 'The Rolling Stones', false),

                -- Question 77: What is the name of the famous music festival held annually in Tennessee?
                (77, 'Coachella', false),
                (77, 'Burning Man', false),
                (77, 'Bonnaroo', true),
                (77, 'Lollapalooza', false),

                -- Question 78: Which pop star is known for the hit "Bad Romance"?
                (78, 'Beyoncé', false),
                (78, 'Katy Perry', false),
                (78, 'Lady Gaga', true),
                (78, 'Taylor Swift', false),

                -- Question 79: Who was the lead singer of Queen?
                (79, 'Freddie Mercury', true),
                (79, 'Mick Jagger', false),
                (79, 'Roger Taylor', false),
                (79, 'Brian May', false),

                -- Question 80: What year did the Beatles break up?
                (80, '1968', false),
                (80, '1970', true),
                (80, '1972', false),
                (80, '1975', false),

                -- Question 81: Which composer wrote "The Four Seasons"?
                (81, 'Johann Sebastian Bach', false),
                (81, 'Antonio Vivaldi', true),
                (81, 'Ludwig van Beethoven', false),
                (81, 'Wolfgang Amadeus Mozart', false),

                -- Question 82: Who was the first female artist to win a Grammy for Album of the Year?
                (82, 'Carole King', true),
                (82, 'Aretha Franklin', false),
                (82, 'Joni Mitchell', false),
                (82, 'Barbra Streisand', false),

                -- Question 83: What is the capital city of Canada?
                (83, 'Toronto', false),
                (83, 'Vancouver', false),
                (83, 'Ottawa', true),
                (83, 'Montreal', false),

                -- Question 84: Which country has the longest coastline?
                (84, 'Russia', false),
                (84, 'Canada', true),
                (84, 'Australia', false),
                (84, 'United States', false),

                -- Question 85: In which country would you find the Great Barrier Reef?
                (85, 'Mexico', false),
                (85, 'Philippines', false),
                (85, 'Australia', true),
                (85, 'Indonesia', false),

                -- Question 86: What is the smallest country in the world by population?
                (86, 'Monaco', false),
                (86, 'Liechtenstein', false),
                (86, 'Vatican City', true),
                (86, 'San Marino', false),

                -- Question 87: Which is the largest desert in the world?
                (87, 'Sahara Desert', false),
                (87, 'Antarctic Desert', true),
                (87, 'Arabian Desert', false),
                (87, 'Gobi Desert', false),

                -- Question 88: Which river is the longest in the world?
                (88, 'Nile', false),
                (88, 'Mississippi-Missouri', false),
                (88, 'Amazon', true),
                (88, 'Yangtze', false),

                -- Question 89: What is the capital of Japan?
                (89, 'Kyoto', false),
                (89, 'Tokyo', true),
                (89, 'Osaka', false),
                (89, 'Hiroshima', false),

                -- Question 90: Which country has the most official languages?
                (90, 'India', false),
                (90, 'South Africa', false),
                (90, 'Zimbabwe', true),
                (90, 'Switzerland', false),

                -- Question 91: What is the highest mountain in North America?
                (91, 'Denali (Mount McKinley)', true),
                (91, 'Mount Logan', false),
                (91, 'Pico de Orizaba', false),
                (91, 'Mount Whitney', false),

                -- Question 92: Which country has the most volcanoes?
                (92, 'Japan', false),
                (92, 'Indonesia', true),
                (92, 'United States', false),
                (92, 'Philippines', false),

                -- Question 93: Who holds the record for the most goals scored in World Cup history?
                (93, 'Pelé', false),
                (93, 'Cristiano Ronaldo', false),
                (93, 'Miroslav Klose', true),
                (93, 'Lionel Messi', false),

                -- Question 94: Which country hosted the 2008 Summer Olympics?
                (94, 'United States', false),
                (94, 'China', true),
                (94, 'United Kingdom', false),
                (94, 'Brazil', false),

                -- Question 95: What year did Michael Jordan retire from the NBA for the second time?
                (95, '1998', true),
                (95, '1999', false),
                (95, '2001', false),
                (95, '2003', false),

                -- Question 96: Which football team has won the most Super Bowls?
                (96, 'Dallas Cowboys', false),
                (96, 'Pittsburgh Steelers', false),
                (96, 'New England Patriots', true),
                (96, 'San Francisco 49ers', false),

                -- Question 97: Who is known as "The Greatest Boxer of All Time"?
                (97, 'Mike Tyson', false),
                (97, 'Muhammad Ali', true),
                (97, 'Floyd Mayweather', false),
                (97, 'Sugar Ray Robinson', false),

                -- Question 98: What sport is played at Wimbledon?
                (98, 'Golf', false),
                (98, 'Tennis', true),
                (98, 'Cricket', false),
                (98, 'Polo', false),

                -- Question 99: Which country won the 2014 FIFA World Cup?
                (99, 'Brazil', false),
                (99, 'Argentina', false),
                (99, 'Germany', true),
                (99, 'Spain', false),

                -- Question 100: Who is the most decorated Olympian of all time?
                (100, 'Michael Phelps', true),
                (100, 'Usain Bolt', false),
                (100, 'Carl Lewis', false),
                (100, 'Simone Biles', false),

                -- Question 101: What is the name of the tennis tournament played at Roland Garros?
                (101, 'Australian Open', false),
                (101, 'French Open', true),
                (101, 'US Open', false),
                (101, 'Wimbledon', false),

                -- Question 102: In which sport would you compete in the "Tour de France"?
                (102, 'Cycling', true),
                (102, 'Marathon Running', false),
                (102, 'Car Racing', false),
                (102, 'Triathlon', false),

                -- Question 103: In which year did the French Revolution begin?
                (103, '1789', true),
                (103, '1776', false),
                (103, '1799', false),
                (103, '1804', false),

                -- Question 104: Who was the first emperor of Rome?
                (104, 'Julius Caesar', false),
                (104, 'Augustus', true),
                (104, 'Nero', false),
                (104, 'Constantine', false),

                -- Question 105: Which country did Napoleon Bonaparte originate from?
                (105, 'France', false),
                (105, 'Corsica', true),
                (105, 'Italy', false),
                (105, 'Spain', false),

                -- Question 106: What treaty ended World War I?
                (106, 'Treaty of Paris', false),
                (106, 'Treaty of Versailles', true),
                (106, 'Treaty of Westphalia', false),
                (106, 'Treaty of Tordesillas', false),

                -- Question 107: Which country was divided into East and West during the Cold War?
                (107, 'Korea', false),
                (107, 'Vietnam', false),
                (107, 'Germany', true),
                (107, 'China', false),

                -- Question 108: Who was the British Prime Minister during World War II?
                (108, 'Winston Churchill', true),
                (108, 'Neville Chamberlain', false),
                (108, 'Clement Attlee', false),
                (108, 'Stanley Baldwin', false),

                -- Question 109: In which year did the Berlin Wall start being built?
                (109, '1961', true),
                (109, '1955', false),
                (109, '1968', false),
                (109, '1971', false),

                -- Question 110: Who was the first female Prime Minister of the UK?
                (110, 'Theresa May', false),
                (110, 'Margaret Thatcher', true),
                (110, 'Elizabeth II', false),
                (110, 'Angela Merkel', false),

                -- Question 111: Which empire was ruled by Julius Caesar?
                (111, 'Byzantine Empire', false),
                (111, 'Ottoman Empire', false),
                (111, 'Roman Empire', true),
                (111, 'Holy Roman Empire', false),

                -- Question 112: In what year was the United Nations founded?
                (112, '1945', true),
                (112, '1918', false),
                (112, '1950', false),
                (112, '1939', false),

                -- Question 113: Which movie features a character named "Darth Vader"?
                (113, 'Star Trek', false),
                (113, 'Star Wars', true),
                (113, 'Battlestar Galactica', false),
                (113, 'The Matrix', false),

                -- Question 114: Who directed the movie "Schindler's List"?
                (114, 'Martin Scorsese', false),
                (114, 'Steven Spielberg', true),
                (114, 'Francis Ford Coppola', false),
                (114, 'Quentin Tarantino', false),

                -- Question 115: What is the name of the wizarding school in "Harry Potter"?
                (115, 'Beauxbatons', false),
                (115, 'Durmstrang', false),
                (115, 'Hogwarts', true),
                (115, 'Ilvermorny', false),

                -- Question 116: Which movie won the Academy Award for Best Picture in 2001?
                (116, 'Crouching Tiger, Hidden Dragon', false),
                (116, 'Gladiator', true),
                (116, 'Traffic', false),
                (116, 'Erin Brockovich', false),

                -- Question 117: Who starred as the main character in "The Matrix"?
                (117, 'Will Smith', false),
                (117, 'Brad Pitt', false),
                (117, 'Keanu Reeves', true),
                (117, 'Tom Cruise', false),

                -- Question 118: In which movie does the character "Rocky Balboa" appear?
                (118, 'Rocky', true),
                (118, 'Rambo', false),
                (118, 'The Expendables', false),
                (118, 'Creed', false),

                -- Question 119: What animated film features the character Simba?
                (119, 'Tarzan', false),
                (119, 'The Lion King', true),
                (119, 'Aladdin', false),
                (119, 'The Jungle Book', false),

                -- Question 120: Which film featured the famous line, "I'll be back"?
                (120, 'Predator', false),
                (120, 'The Terminator', true),
                (120, 'Commando', false),
                (120, 'Total Recall', false),

                -- Question 121: Who is the director of the "Lord of the Rings" trilogy?
                (121, 'Peter Jackson', true),
                (121, 'James Cameron', false),
                (121, 'Christopher Nolan', false),
                (121, 'Steven Spielberg', false),

                -- Question 122: What is the name of the fictional spaceship in "Star Trek"?
                (122, 'Enterprise', true),
                (122, 'Discovery', false),
                (122, 'Millennium Falcon', false),
                (122, 'Galactica', false),

                -- Question 123: What is the chemical symbol for oxygen?
                (123, 'Og', false),
                (123, 'O', true),
                (123, 'Ox', false),
                (123, 'Om', false),

                -- Question 124: What is the name of the process by which plants make food using sunlight?
                (124, 'Respiration', false),
                (124, 'Photosynthesis', true),
                (124, 'Fermentation', false),
                (124, 'Transpiration', false),

                -- Question 125: Which planet is the closest to the Sun?
                (125, 'Venus', false),
                (125, 'Earth', false),
                (125, 'Mercury', true),
                (125, 'Mars', false),

                -- Question 126: What is the primary gas found in Earth's atmosphere?
                (126, 'Nitrogen', true),
                (126, 'Oxygen', false),
                (126, 'Carbon Dioxide', false),
                (126, 'Argon', false),

                -- Question 127: Who is credited with developing the theory of evolution?
                (127, 'Gregor Mendel', false),
                (127, 'Charles Darwin', true),
                (127, 'Louis Pasteur', false),
                (127, 'Alexander Fleming', false),

                -- Question 128: What is the smallest bone in the human body?
                (128, 'Stapes', true),
                (128, 'Femur', false),
                (128, 'Radius', false),
                (128, 'Coccyx', false),

                -- Question 129: Which gas do humans exhale when breathing?
                (129, 'Oxygen', false),
                (129, 'Nitrogen', false),
                (129, 'Carbon Dioxide', true),
                (129, 'Hydrogen', false),

                -- Question 130: Which element has the atomic number 1?
                (130, 'Oxygen', false),
                (130, 'Carbon', false),
                (130, 'Hydrogen', true),
                (130, 'Helium', false),

                -- Question 131: How many planets are there in our solar system?
                (131, '9', false),
                (131, '7', false),
                (131, '8', true),
                (131, '6', false),

                -- Question 132: What is the name of the process by which water vapor turns into liquid?
                (132, 'Deposition', false),
                (132, 'Condensation', true),
                (132, 'Sublimation', false),
                (132, 'Evaporation', false),

                -- Question 133: Who is the famous composer of "The Magic Flute"?
                (133, 'Ludwig van Beethoven', false),
                (133, 'Wolfgang Amadeus Mozart', true),
                (133, 'Johann Sebastian Bach', false),
                (133, 'Franz Schubert', false),

                -- Question 134: Which rock band is famous for the album "The Dark Side of the Moon"?
                (134, 'Led Zeppelin', false),
                (134, 'The Beatles', false),
                (134, 'Pink Floyd', true),
                (134, 'The Rolling Stones', false),

                -- Question 135: Who composed the "Ode to Joy"?
                (135, 'Wolfgang Amadeus Mozart', false),
                (135, 'Ludwig van Beethoven', true),
                (135, 'Johann Sebastian Bach', false),
                (135, 'Franz Schubert', false),

                -- Question 136: Which musician is known for the hit song "Yesterday"?
                (136, 'Paul McCartney', true),
                (136, 'John Lennon', false),
                (136, 'George Harrison', false),
                (136, 'Ringo Starr', false),

                -- Question 137: What type of instrument is a piano?
                (137, 'Percussion', false),
                (137, 'String', false),
                (137, 'Keyboard', true),
                (137, 'Wind', false),

                -- Question 138: Which band performed the song "Bohemian Rhapsody"?
                (138, 'The Beatles', false),
                (138, 'Led Zeppelin', false),
                (138, 'Queen', true),
                (138, 'Pink Floyd', false),

                -- Question 139: Who composed "Symphony No. 9"?
                (139, 'Ludwig van Beethoven', true),
                (139, 'Wolfgang Amadeus Mozart', false),
                (139, 'Franz Schubert', false),
                (139, 'Johannes Brahms', false),

                -- Question 140: Which singer is known for the hit song "Imagine"?
                (140, 'Paul McCartney', false),
                (140, 'George Harrison', false),
                (140, 'John Lennon', true),
                (140, 'Bob Dylan', false),

                -- Question 141: Which country did Beethoven originate from?
                (141, 'Austria', false),
                (141, 'Germany', true),
                (141, 'Italy', false),
                (141, 'France', false),

                -- Question 142: Which artist released the album "Thriller"?
                (142, 'Michael Jackson', true),
                (142, 'Prince', false),
                (142, 'Madonna', false),
                (142, 'Whitney Houston', false),

                -- Question 143: Which country is the capital city of Brussels?
                (143, 'France', false),
                (143, 'Netherlands', false),
                (143, 'Belgium', true),
                (143, 'Luxembourg', false),

                -- Question 144: Which European country is famous for the Eiffel Tower?
                (144, 'Germany', false),
                (144, 'Italy', false),
                (144, 'France', true),
                (144, 'Spain', false),

                -- Question 145: What is the largest country in Europe by land area?
                (145, 'Russia', true),
                (145, 'Ukraine', false),
                (145, 'France', false),
                (145, 'Spain', false),

                -- Question 146: Which country has the most islands in Europe?
                (146, 'Greece', false),
                (146, 'Sweden', true),
                (146, 'Finland', false),
                (146, 'Norway', false),

                -- Question 147: What is the capital of Italy?
                (147, 'Milan', false),
                (147, 'Rome', true),
                (147, 'Venice', false),
                (147, 'Florence', false),

                -- Question 148: Which river runs through Paris?
                (148, 'Thames', false),
                (148, 'Rhine', false),
                (148, 'Seine', true),
                (148, 'Loire', false),

                -- Question 149: What is the capital city of Spain?
                (149, 'Barcelona', false),
                (149, 'Seville', false),
                (149, 'Madrid', true),
                (149, 'Valencia', false),

                -- Question 150: Which mountain is the highest in Europe?
                (150, 'Mont Blanc', false),
                (150, 'Mount Elbrus', true),
                (150, 'Matterhorn', false),
                (150, 'Mount Etna', false),

                -- Question 151: What is the longest river in Europe?
                (151, 'Danube', false),
                (151, 'Volga', true),
                (151, 'Rhine', false),
                (151, 'Seine', false),

                -- Question 152: Which country is known for its canals and windmills?
                (152, 'Belgium', false),
                (152, 'Denmark', false),
                (152, 'Netherlands', true),
                (152, 'Germany', false),

                -- Question 153: Which country won the 2016 UEFA European Championship in football?
                (153, 'Germany', false),
                (153, 'France', false),
                (153, 'Portugal', true),
                (153, 'Spain', false),

                -- Question 154: Who won the 2016 Olympic gold medal in men's tennis?
                (154, 'Rafael Nadal', false),
                (154, 'Andy Murray', true),
                (154, 'Roger Federer', false),
                (154, 'Novak Djokovic', false),

                -- Question 155: Which country hosted the 2014 FIFA World Cup?
                (155, 'South Africa', false),
                (155, 'Brazil', true),
                (155, 'Germany', false),
                (155, 'Russia', false),

                -- Question 156: In which sport would you compete in the "Tour de France"?
                (156, 'Motorcycle Racing', false),
                (156, 'Cycling', true),
                (156, 'Marathon Running', false),
                (156, 'Car Racing', false),

                -- Question 157: Which city hosted the 2008 Summer Olympics?
                (157, 'London', false),
                (157, 'Rio de Janeiro', false),
                (157, 'Beijing', true),
                (157, 'Athens', false),

                -- Question 158: Which tennis player has won the most Grand Slam singles titles?
                (158, 'Roger Federer', false),
                (158, 'Rafael Nadal', false),
                (158, 'Novak Djokovic', true),
                (158, 'Serena Williams', false),

                -- Question 159: Who won the 2018 FIFA World Cup?
                (159, 'France', true),
                (159, 'Croatia', false),
                (159, 'Brazil', false),
                (159, 'Germany', false),

                -- Question 160: What country is the home of Formula 1 driver Sebastian Vettel?
                (160, 'Austria', false),
                (160, 'Switzerland', false),
                (160, 'Germany', true),
                (160, 'Italy', false),

                -- Question 161: Which European football team has won the most UEFA Champions League titles?
                (161, 'FC Barcelona', false),
                (161, 'Real Madrid', true),
                (161, 'Bayern Munich', false),
                (161, 'Liverpool FC', false),

                -- Question 162: What is the most common rugby ball shape?
                (162, 'Oval', true),
                (162, 'Round', false),
                (162, 'Rectangular', false),
                (162, 'Square', false);


