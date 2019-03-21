
>本文档主要维护"如何进行项目分支管理"，构建标准化工作流



## 分支说明



项目主要涉及分支描述：

* `master`分支 - 主分支
* `develop`分支 - 开发分支
* `feature`分支 - 功能分支
* `release`分支 - 预发布分支

## 开发流程



* 开发新功能
  1. 创建功能对应的分支`feature-xxx`
  2. 完成功能开发
  3. 完成单元测试
  4. 向master分支提交`pull request`
  5. 完成代码合并，进行项目部署操作
  6. 将新功能分支删除



* Bug修复
  1. 创建Bug对应的`issure`
  2. 创建Bug-fix对应分支`bug-xxx`
  3. 完成代码修复
  4. 向master提交`pull request`
  5. 完成代码合并并进行代码部署
  6. 将`Bug-fix`分支删除



* [参考链接](https://juejin.im/post/5b4328bbf265da0fa21a6820)
* [Git-flow流程说明](http://www.ruanyifeng.com/blog/2015/12/git-workflow.html)