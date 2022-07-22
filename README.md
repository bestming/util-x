# 关于 util-x
util-x ***3.x*** 是一个基于Java 8（ ***1.x*** 基于 Java 5） 编写的基础工具库，其中包含了常见的文本(字符串)、数组、集合、文件、商业计算、随机数、参数验证、日期等方面的处理工具类。目前主要方便本人在工作中快速开发使用。

该工具库的定位与 Apache 的 commons-lang3 相似，但 util-x 并没有重复实现 commons-lang3 的大部分方法，仅仅作为该工具库的补充，建议在实际开发过程中将 common-lang3 和 util-x 配合使用（由于历史原因，util-x 也重复实现了 common-lang3 的部分方法，因为 common-lang3 的部分方法在早期版本中的实现不够理想，例如：使用StringBuffer、没有按照最优逻辑处理）。

由于源代码中的每个方法都已经注明了非常详细的中文注释，因此暂不另行提供API文档。

作为底层基础工具类，util-x 尽可能在每个细节上保证最高运行性能和最低的内存占用。

如果你对工具库中的方法实现有更好的建议，欢迎及时反馈或自行修改并提交请求。

目前 util-x 中的工具方法可能并不完备，仅仅基于实际项目的需求驱动。如果其中没有你所需的常用方法，也欢迎提出建议，或自行提交新的方法实现。

# 示例

```
@Data
public class User/UserVO{
    private String name;
    private String email;
    private Integer age;
}
User user=new User();
UserVO userVO=new UserVO();
```



> 从指定的多个值依次检测并选取第一个不为null的值

```
String input= X.expectNotNull(null, null, "233"); //input="233"
```

> 对象属性对拷

```
X.use(user.getName(), userVO::setName);
```

> 避免空指针的获取对象的某个值

```
String name=X.map(user, User::getName);

String name;
相当于
if(user!=null){
	name=user.getName();
}


获取不到,则使用默认值
String name=X.mapElse(user, User::getName,"wxm");
相当于
if(user!=null){
	name=user.getName();
}else{
	name="wxm";
}
```

> 条件同时成立或者同时不成立，则为true，否则为false

```
boolean flag = X.matchAllOrNone(false, false);// true
boolean flag = X.matchAllOrNone(true, true);// true
boolean flag = X.matchAllOrNone(false, true);// false
```

# 使用
克隆仓库，构建之后，引入本库：

```xml
<dependency>
	<groupId>cn.bestming</groupId>
	<artifactId>util-x</artifactId>
	<version>3.9.1</version>
</dependency>
```

# TODO 

- [ ] 引入SpringUtil(封装异步方法,不用每次都用CompletableFuture)

