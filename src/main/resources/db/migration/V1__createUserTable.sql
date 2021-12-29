CREATE TABLE training_user
(
    id bigint NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    age integer,
    email character varying(255) COLLATE pg_catalog."default" NOT NULL,
    name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT training_user_pkey PRIMARY KEY (id),
    CONSTRAINT uk_tqtfkkup336suknsbw4xfwbpc UNIQUE (email)
)