#综合sql
select * from base_attr_info where category_id=61 and  category_level = 3
union
select * from base_attr_info where category_id=(select category2_id from base_category3 where id=61) and category_level=2
union
select * from base_attr_info where category_id=(select category1_id from base_category2 where  id =(select category2_id from base_category3 where id=61)) and  category_level=1
