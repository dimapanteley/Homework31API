alter table student add constraint age check ( age > 16 );

alter table student alter column name set not null;

alter table student add constraint name_unique unique (name);

alter table  vehicles drop  constraint  unique_vehicle ;



alter table student alter column age set default 20;




