# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table event (
  id                            bigserial not null,
  name                          varchar(255) not null,
  article                       varchar(255) not null,
  created_at                    timestamptz not null,
  updated_at                    timestamptz not null,
  constraint pk_event primary key (id)
);

create table participant (
  id                            bigserial not null,
  name                          varchar(255) not null,
  message                       varchar(255) not null,
  event_id                      bigint,
  created_at                    timestamptz not null,
  updated_at                    timestamptz not null,
  constraint pk_participant primary key (id)
);

alter table participant add constraint fk_participant_event_id foreign key (event_id) references event (id) on delete restrict on update restrict;
create index ix_participant_event_id on participant (event_id);


# --- !Downs

alter table if exists participant drop constraint if exists fk_participant_event_id;
drop index if exists ix_participant_event_id;

drop table if exists event cascade;

drop table if exists participant cascade;

