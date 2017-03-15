/* script to demonstrate load store in pig

Execute it with the data files provided in resource directory
 */


A = LOAD 'person.txt' USING PigStorage() AS (id:long,name:chararray,gender:chararray,city:chararray,country:chararray,salary:double,credit_card:long,ssn:chararray,map_type:map[int],bag_type:bag{},tuple_type:tuple());

describe A;

dump A;

 B = LIMIT A 10;

 STORE B INTO 'output/store' USING PigStorage();
