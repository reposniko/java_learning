1. Stream是什么？
   为什么它适合Service层数据处理？
Stream是流式转换器，可以在不动原始集合数据的情况下将数据转换
2. filter() 和 map() 有什么区别？
filter是根据条件筛选数据，map()是根据需求选择需要的数据
3. sorted() 会不会改变原List的顺序？
   List.sort()呢？
sorted不会改变原List的顺序，List.sort会改变
4. map() 为什么特别适合Entity → VO？
map是用于将每个元素执行一个映射操作，并用映射结果替换为原来的元素
5. anyMatch() 适合什么业务场景？
   anyMatch()用于判断集合中是否至少存在一个满足条件的元素。

例如：
判断是否存在未成年用户；
判断订单中是否存在已退款订单；
判断用户是否拥有ADMIN权限。

返回boolean。
6. findFirst() 为什么通常返回Optional？
因为可能会出现找不到的情况，使用Optional就是提前告知了可能会返回null
7. Stream的：
   中间操作
   终止操作
   分别是什么意思？
   
-- --
中间操作：
   filter
   map
   sorted

特点：
返回新的Stream
可以继续链式调用
通常是惰性执行
中间操作：
filter
map
sorted

特点：
返回新的Stream
可以继续链式调用
通常是惰性执行
8. removeIf() 与 stream().filter()
   最大区别是什么？
removeIf会删除原始集合的数据，而stream.filter不会
9. 为什么：
   "ACTIVE".equals(user.getStatus())
   通常比：
   user.getStatus().equals("ACTIVE")
   更安全？
    user.getStatus可能会出现值为null的情况而导致空指针异常
10. 假设Controller调用Service：
    Repository返回List<User>
    最终接口应该返回List<User>还是List<UserVO>？
    为什么？
    最终会返回List<UserVO>,因为 Repository返回List<User>的会在接口的真实实现中转换为List<UserVO>