/*
1) The orderby produces a total order of the data.
2) ASEC is the default one.
3) Triggers reduce phase
 */


A = LOAD 'person.txt' USING PigStorage() AS (id:long,name:chararray,gender:chararray,city:chararray,country:chararray,salary:double,credit_card:long,ssn:chararray,map_type:map[int],bag_type:bag{t:(name:chararray)},tuple_type:tuple(name1:chararray,name2:chararray));

B = ORDER A BY salary;

DUMP B;

B = ORDER A BY salary,country;

DUMP B;

B = ORDER A BY country,salary;

DUMP B;

B = ORDER A BY salary desc;

DUMP B;

B = ORDER A BY country desc,salary;

DUMP B;


