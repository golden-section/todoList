CREATE TABLE IF NOT EXISTS users (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(255) NOT NULL
);

INSERT INTO users(username, password, role)
VALUES
('user', '$2a$10$9kZkY90UDluBIUqnnXxaSOf/qfZS/ghuDPvo3hiMPP.lDpaNQGVha', 'USER');