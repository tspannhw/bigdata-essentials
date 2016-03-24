

A = LOAD 'person.txt' USING PigStorage() AS (id:long,name:chararray,gender:chararray,city:chararray,country:chararray,salary:double,credit_card:long,ssn:chararray,map_type:map[int],bag_type:bag{},tuple_type:tuple(name1:chararray,name2:chararray));


-- access map type
B = FOREACH A GENERATE map_type#'Tad';

DUMP B;

C = FILTER B BY $0 is not null;

DUMP C;

-- access bag type

A = LOAD 'person.txt' USING PigStorage() AS (id:long,name:chararray,gender:chararray,city:chararray,country:chararray,salary:double,credit_card:long,ssn:chararray,map_type:map[int],bag_type:bag{t:(name:chararray)},tuple_type:tuple(name1:chararray,name2:chararray));

B = FOREACH A GENERATE bag_type.name;

DUMP B;

-- access tuple type

B = FOREACH A GENERATE tuple_type.name1, tuple_type.$1;

DUMP B;
