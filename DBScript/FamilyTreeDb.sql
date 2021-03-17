
create table person (
	person_id serial primary key,
	first_name varchar(50) not null,
	last_name varchar(50) not null
	
); 

create table relationship_type(
	relation_id serial primary key,
	relation_type varchar(50) not null
	
);

create table relationships(
	relationships_id serial primary key,
	person1_id int references person (person_id),
	person2_id int references person (person_id),
	relation_id int references relationship_type (relation_id)
);



select p.first_name, p.last_name, p2.first_name as relative_first_name, p2.last_name as relative_last_name, rt.relation_type 
from relationships rs inner join person p on p.person_id = rs.person1_id
inner join person p2 on p2.person_id = rs.person2_id
inner join relationship_type rt on rs.relation_id = rt.relation_id
where person1_id = 1;


insert into relationship_type ("relation_type") values ('father'), ('mother'),
('son'), ('daughter'),
('brother'),('sister'),
('grandfather'),('grandmother');

select * from relationship_type 

update relationships set relation_id = ? where person1_id = ? and person2_id = ?;

select * from relationships 