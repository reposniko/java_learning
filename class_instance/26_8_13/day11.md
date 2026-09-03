1. Collections.sort() 和 List.sort() 有什么区别？
Collection.sort()是Collection类里的静态方法，而List.sort是List对象里的静态方法，
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
8. unmodifiableList有没有复制原List？
   为什么修改original后readonly也变化？

9. 什么是防御性复制？
   为什么Service可能不应该直接修改传入List？
    如果只是为了某一个业务需求而进行改动List的排序，则需要复制一个List进行改动而不改动原始集合
10. new ArrayList<>(users)为什么是浅拷贝？
    为什么修改List结构互不影响，
    但修改User属性仍可能互相影响？
new ArrayList<>()仅仅是复制了结构，实际上只是将其新建的对象指向另一个对象
    这就是浅拷贝，修改List的结构并没有真实涉及到他们所指向的对象的集合结构，而修改users会直接影响两个指向users的集合