CREATE TABLE IF NOT EXISTS users (
    id UUID PRIMARY KEY NOT NULL ,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(128) NOT NULL,
    is_active boolean NOT NULL,
    token VARCHAR(128) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    modified_at TIMESTAMP NULL,
    last_login_at TIMESTAMP NOT NULL
);

CREATE TABLE IF NOT EXISTS role (
    id UUID PRIMARY KEY NOT NULL,
    name VARCHAR(25) NOT NULL
);

CREATE TABLE IF NOT EXISTS user_role (
    user_id UUID NOT NULL,
    role_id UUID NOT NULL,
    CONSTRAINT user_role_pkey PRIMARY KEY (user_id, role_id),
    CONSTRAINT fk_user_role_role FOREIGN KEY (role_id) REFERENCES role(id),
    CONSTRAINT fk_user_role_user FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE IF NOT EXISTS phones (
    id UUID PRIMARY KEY NOT NULL ,
    user_id UUID NOT NULL,
    number VARCHAR(12) NOT NULL,
    city_code VARCHAR(6) NOT NULL,
    country_code VARCHAR(6) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    modified_at TIMESTAMP NULL
);