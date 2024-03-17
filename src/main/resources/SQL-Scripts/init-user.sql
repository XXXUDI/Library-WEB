-- Таблица пользователей --
CREATE TABLE User (
                      id BIGINT PRIMARY KEY AUTO_INCREMENT,
                      username VARCHAR(255) NOT NULL,
                      password VARCHAR(255) NOT NULL,
                      email VARCHAR(255) NOT NULL,
                      role VARCHAR(255) NOT NULL,
                      profilePicture VARCHAR(255),
                      likes INT,
                      isBanned BOOLEAN,
                      isVerified BOOLEAN
);

-- Таблица избранных постов пользователей --
CREATE TABLE user_favorite_posts (
                                     user_id BIGINT,
                                     post_id BIGINT,
                                     PRIMARY KEY (user_id, post_id),
                                     FOREIGN KEY (user_id) REFERENCES User(id) ON DELETE CASCADE,
                                     FOREIGN KEY (post_id) REFERENCES Post(id) ON DELETE CASCADE
);

-- Таблица постов --
CREATE TABLE Post (
                      id BIGINT PRIMARY KEY AUTO_INCREMENT,
                      user_id BIGINT NOT NULL,
                      title VARCHAR(255) NOT NULL,
                      subtitle VARCHAR(255),
                      content TEXT,
                      likes INT,
                      FOREIGN KEY (user_id) REFERENCES User(id)
);

-- Таблица комментариев --
CREATE TABLE Comment (
                         id BIGINT PRIMARY KEY AUTO_INCREMENT,
                         user_id BIGINT NOT NULL,
                         post_id BIGINT NOT NULL,
                         content TEXT,
                         FOREIGN KEY (user_id) REFERENCES User(id),
                         FOREIGN KEY (post_id) REFERENCES Post(id)
);
