1. Collections.sort() 和 List.sort() 有什么区别？
Collections.sort()是Collections类里的静态方法，而List.sort是List对象里的实例方法，
2. Comparator.comparing() 做什么？
   把“按对象的哪个属性排序”这件事，变成一个 Comparator 比较器。
3. thenComparing() 什么时候进行第二字段比较？
  当第一字段相同时，开始比较第二字段
4. reversed() 反转的是什么？
反转的是排序顺序

5. username为null时为什么可能出现排序异常？
    因为null并不是真正的字符串，在与字符串类型的数据比较时会出现空指针异常报错
6. nullsLast() 解决什么问题？
    用于解决属性值为null的元素的排序，将其排在最后一位
7. List.of() 有什么特点？
    List.of()中的元素不能为空
    List.of()创建的是不可修改的List->不允许对集合进行add,remove,set等操作
8. unmodifiableList有没有复制原List？
   为什么修改original后readonly也变化？
   nmodifiableList只是基于original创建一个不可修改视图。

readonly和original底层仍然关联同一份集合数据，
所以修改original后，
通过readonly也能观察到变化。

9. 什么是防御性复制？
   为什么Service可能不应该直接修改传入List？
    如果只是为了某一个业务需求而进行改动List的排序，则需要复制一个List进行改动而不改动原始集合
10. new ArrayList<>(users)为什么是浅拷贝？
    为什么修改List结构互不影响，
    但修改User属性仍可能互相影响？
-- --
    new ArrayList<>(users) 会创建一个新的 List，
    所以两个 List 的结构是独立的。

但是新 List 中保存的仍然是原来的 User 对象引用，
User 对象本身没有重新创建。

因此：

copy.clear()
不会影响 users 的 List 结构。

但：

copy.get(0).setUsername(...)
修改的是双方共享的 User 对象，
所以 users 中对应的 User 属性也会发生变化。

因此 new ArrayList<>(users) 属于浅拷贝。