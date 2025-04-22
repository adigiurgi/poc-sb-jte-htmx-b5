-- User Management Tables

-- Table: users
CREATE TABLE IF NOT EXISTS users (
    id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    username VARCHAR2(100) NOT NULL UNIQUE,
    email VARCHAR2(255) NOT NULL UNIQUE,
    first_name VARCHAR2(100) NOT NULL,
    last_name VARCHAR2(100) NOT NULL,
    inserted_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    version NUMBER DEFAULT 0 NOT NULL
);

-- Table: user_profiles
CREATE TABLE IF NOT EXISTS user_profiles (
    id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    id_user NUMBER NOT NULL,
    profile_name VARCHAR2(100) NOT NULL,
    inserted_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    version NUMBER DEFAULT 0 NOT NULL,
    CONSTRAINT fk_user_profiles_user
        FOREIGN KEY (id_user)
        REFERENCES users(id)
        ON DELETE CASCADE
);

-- Table: user_roles
CREATE TABLE IF NOT EXISTS user_roles (
    id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    id_user NUMBER NOT NULL,
    role_name VARCHAR2(100) NOT NULL,
    role_description VARCHAR2(255),
    inserted_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    version NUMBER DEFAULT 0 NOT NULL,
    CONSTRAINT fk_user_roles_user
        FOREIGN KEY (id_user)
        REFERENCES users(id)
        ON DELETE CASCADE
);

-- Create an index for looking up profiles by user ID
CREATE INDEX IF NOT EXISTS idx_user_profiles_user_id ON user_profiles(id_user);

-- Create an index for looking up roles by user ID
CREATE INDEX IF NOT EXISTS idx_user_roles_user_id ON user_roles(id_user);
