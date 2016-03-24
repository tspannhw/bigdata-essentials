/*
Foreach takes a set of expressions and applies them to every record in the data pipeline
It can aggregate on grouped data.
Projection operator for projecting fields from relation.
 */


-- FOREACH can be used to select a few records in a relation

A = LOAD 'person.txt' USING PigStorage(',') AS (id:long,name:chararray,gender:chararray,city:chararray,country:chararray,salary:double,credit_card:long,ssn:chararray,map_type:map[int],bag_type:bag{},tuple_type:tuple(name1:chararray,name2:chararray));

B = FOREACH A GENERATE id, name;

DUMP B;

-- Expressions in foreach
-- Increase salary by 5k

A = LOAD 'person.txt' USING PigStorage() AS (id:long,name:chararray,gender:chararray,city:chararray,country:chararray,salary:double,credit_card:long,ssn:chararray,map_type:map[int],bag_type:bag{},tuple_type:tuple(name1:chararray,name2:chararray));

B = FOREACH A GENERATE id, name, salary+5.0;

DUMP B;

-- Aggregations

A = LOAD 'person.txt' USING PigStorage() AS (id:long,name:chararray,gender:chararray,city:chararray,country:chararray,salary:double,credit_card:long,ssn:chararray,map_type:map[int],bag_type:bag{},tuple_type:tuple(name1:chararray,name2:chararray));

B = GROUP A ALL;

C = FOREACH B GENERATE SUM(A.salary);

DUMP C;

/* Reading complex data types */

A = LOAD 'person.txt' USING PigStorage() AS (id:long,name:chararray,gender:chararray,city:chararray,country:chararray,salary:double,credit_card:long,ssn:chararray,map_type:map[int],bag_type:bag{t:(name:chararray)},tuple_type:tuple(name1:chararray,name2:chararray));

-- access map type
B = FOREACH A GENERATE map_type#'Tad';

DUMP B;

-- access bag type

B = FOREACH A GENERATE bag_type.name;

DUMP B;

-- access tuple type

B = FOREACH A GENERATE tuple_type.name1, tuple_type.$1;

DUMP B;


/*
Using UDF's in foreach statement
 */

B = FOREACH A GENERATE UPPER(name) as name;

DUMP B;


/*
Nested Foreach - DISTINCT, LIMIT , FILTER, ORDER BY, CROSS, FOREACH
 */

B = GROUP A BY (country, state);

C = FOREACH B {
    GENERATE group.country, group.state, AVG(A.salary);
}








