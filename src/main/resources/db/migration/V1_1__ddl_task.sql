CREATE TABLE t_task
(
    id UUID NOT NULL,
    name VARCHAR(200) NOT NULL,
    detail jsonb,
    complete boolean,
    ver integer,
    sts_cd varchar(1),
    created_dt timestamp,
    created_by VARCHAR(200) NOT NULL,
    constraint pk_task primary key (id)
);
