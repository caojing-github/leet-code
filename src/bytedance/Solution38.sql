 -- 第二高的薪水 https://leetcode-cn.com/explore/interview/card/bytedance/247/bonus/1039/
-- 容易
 -- 用时最快 https://leetcode-cn.com/submissions/detail/36266683/
select Max(Salary) as SecondHighestSalary from Employee where Salary<(select Max(Salary) from Employee)
