create table church(
    church_id uuid not null,
    denomination character varying(80),
    address jsonb not null,
    corporate_name character varying(100),
    cnpj character varying(14),
    phone character varying(17),
    email character varying(60),
    founded_in character varying(10),
    created_at timestamp not null
);

create table family(
    family_id uuid not null,
    description character varying(60),
    changed_at timestamp not null
);

create table member(
    member_id uuid not null,
    name character varying(80) not null,
    phone character varying(17) not null,
    email character varying(60) not null,
    address jsonb not null,
    cpf character varying(11),
    birth_date character varying(10) not null,
    member_since character varying(10),
    baptized boolean,
    gender int not null,
    maritalStatus int not null,
    family_id uuid not null,
    church_id uuid not null,
    ministries jsonb,
    nationality character varying(60),
    active boolean,
    picture character varying(32),
    created_at timestamp
);

alter table only church
    add constraint church_pk primary key(church_id);

alter table only family
    add constraint family_pk primary key(family_id);

alter table only member
    add constraint member_pk primary key (member_id);

alter table member
    add constraint member_family_fk foreign key (family_id) references family(family_id);

alter table member
    add constraint member_church_fk foreign key (church_id) references church(church_id);