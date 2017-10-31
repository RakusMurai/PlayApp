# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table event (
  id                            serial not null,
  name                          varchar(255) not null,
  message                       varchar(255) not null,
  constraint pk_event primary key (id)
);


# --- !Downs

drop table if exists event cascade;

