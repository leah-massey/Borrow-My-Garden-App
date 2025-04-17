create table if not exists gardens (
    id UUID PRIMARY KEY,
    created_timestamp VARCHAR(100),
    title VARCHAR(100),
    description VARCHAR(1000),
    garden_owner_first_name VARCHAR(100),
    garden_owner_id UUID,
    garden_status VARCHAR(100)
);