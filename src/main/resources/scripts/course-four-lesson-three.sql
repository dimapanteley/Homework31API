-- liquibase formatted sql

-- changeset Dpanteley:1
create index students_name_index on student (name);

-- changeset Dpanteley:2
create index facultye_and_color_index on faculty (name, color);