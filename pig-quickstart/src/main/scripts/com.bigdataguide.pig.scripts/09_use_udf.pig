REGISTER pig-samples-1.0-SNAPSHOT.jar;

A = LOAD 'person.txt' USING PigStorage() AS (id:long,name:chararray,gender:chararray,city:chararray,country:chararray,salary:double,credit_card:long,ssn:chararray,map_type:map[int],bag_type:bag{t:(name:chararray)},tuple_type:tuple(name1:chararray,name2:chararray));

B = FOREACH A GENERATE com.sv.pig.udf.Capitalize(name);

DUMP B;

-- REGISTER AND DEFINE


REGISTER pig-samples-1.0-SNAPSHOT.jar;

DEFINE CAPITALIZE com.sv.pig.udf.Capitalize();

A = LOAD 'person.txt' USING PigStorage() AS (id:long,name:chararray,gender:chararray,city:chararray,country:chararray,salary:double,credit_card:long,ssn:chararray,map_type:map[int],bag_type:bag{t:(name:chararray)},tuple_type:tuple(name1:chararray,name2:chararray));

B = FOREACH A GENERATE CAPITALIZE(name);

DUMP B;