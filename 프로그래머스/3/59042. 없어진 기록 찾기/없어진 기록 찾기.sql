
-- animal_ins에는 없고 animal_outs에는 있는 데이터
-- out에는 있고 in은 null 인 데이터
select  animal_outs.ANIMAL_ID, animal_outs.NAME
from animal_outs
left join animal_ins
on animal_outs.animal_id = animal_ins.animal_id
where animal_ins.animal_id is null
order by animal_outs.animal_id;
