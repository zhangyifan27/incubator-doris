SET enable_vectorized_engine=true;

-- not support: because column 'name' in join_t2_dk
-- select * from join_t1_dk left join join_t2_dk on venue_id = entity_id 
--         where name match_any 'aberdeen' and dt = '2003-05-23 19:30:00';

-- select * from join_t1_dk left join join_t2_dk on venue_id = entity_id 
--         where name match_any 'aberdeen' and dt = '2003-05-23 19:30:00';


select * from join_t1_dk right join join_t2_dk on venue_id = entity_id 
        where name match_any 'aberdeen' and dt = '2003-05-23 19:30:00';

select * from join_t1_dk right join join_t2_dk on venue_id = entity_id 
        where name match_any 'aberdeen' and dt = '2003-05-23 19:30:00';