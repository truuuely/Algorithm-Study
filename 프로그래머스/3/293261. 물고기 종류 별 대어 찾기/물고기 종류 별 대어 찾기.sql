select fi.id as ID, name.fish_name as FISH_NAME, fi.length as LENGTH
from fish_info fi
join fish_name_info name on fi.fish_type = name.fish_type
where (fi.fish_type, fi.length) in (select fish_type, max(length) as length
        from fish_info
        group by fish_type)
order by fi.id 