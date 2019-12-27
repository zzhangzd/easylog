一个开箱即用的日志模块
# 路线图
1 运行时修改主流日志框架logback/log4j日志级别<br>
2 查看日志内容 滚动日志板<br>
3 支持客制化持久化 实现了我们的provider的接口后 我们将调用客制化的持久化方法<br>
后期将fork一个spring boot项目<br>

# 快速开始
以前的写法<br>
//注入日志逻辑层LogService<br>

//业务层<br>
//引入逻辑类A<br>
A.处理（）<br>
//封装日志<br>
log = new Log<br><br>
//调用日志逻辑层持久化日志<br>
LogService.save(log)<br>
//引入逻辑类B<br>
B.处理()<br>
//封装日志<br>
log = new Log<br>
//调用日志逻辑层持久化日志<br>
LogService.save(log)<br>

现在的做法<br>
//先提下我们的约定<br>
//此模块中 我们的日志记录与业务逻辑事务处理的事务一定要确保是无关的<br>
//日志记录应该是线程安全的，异步的<br>
//默认不会提供持久化方法 我们会从应用上下文中尝试取出客制化的接口，调用其中的持久化方法<br>
//我们的项目是基于spring的<br>

现在的做法<br>
项目中通过maven引入easyLog依赖<br>
```
<dependency>
    <groupId>com.github.maketubo</groupId>
    <artifactId>easylog</artifactId>
    <version>1.0.0-RELEASE</version>
</dependency>
```
写xml注册相关bean 或扫描对应路径将相关bean加入到我们项目的上下文<br>



//不再在实际的业务处理类中注入日志逻辑层LogService<br>
//而是实现easyLog中的provider接口 在此实现类中注入LogService<br>
Class TestProvider implements Provider{<br>
     //注入日志逻辑层LogService<br>
     save(log或者logs){<br>
        LogService.save(log)<br>
     }<br>
}<br>


//业务逻辑类怎么记录日志<br>
Class ServiceA{<br>

   @LogMethod（“日志的格式”）<br>
   service（）{<br>
      LogHelper.put('某某属性名','某某具体信息');<br>
   }<br>
}<br>
