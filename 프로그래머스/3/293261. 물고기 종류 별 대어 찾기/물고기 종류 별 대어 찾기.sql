select fn.fish_name as FISH_NAME, max(fi.length) as LENGTH
from fish_info fi
join fish_name_info fn on fi.fish_type = fn.fish_type
group by fn.fish_name
order by fn.fish_name