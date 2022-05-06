CREATE TABLE IF NOT EXISTS departments (
    id VARCHAR(150) PRIMARY KEY DEFAULT REPLACE(uuid_generate_v4()::text, '-',''),
    name VARCHAR(100) UNIQUE NOT NULL
);