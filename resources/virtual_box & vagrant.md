# virtual box && vagrant



[toc]

------

## 1. 安装virtual box

> * 安装`virtual box`之后，可以选择下载虚拟机镜像然后通过指引将下载好的虚拟机镜像进行安装
>
> * 安装好`virtual box`后，也可以选择`vagrant` 通过命令的方式安装虚拟机
>   * 安装`vagrant` ，安装之后重启PC，然后通过命令行的形式输入`vagrant`查看是否安装成功
>   * 输入`vagrant init centos/7` 安装`centos` 虚拟机
>   * 输入`vagrant up`进行启动虚拟机，系统root用户的密码是vagrant
>   * 输入`vagrant ssh`登录虚拟机，
>     * 自动使用vagrant用户连接虚拟机
>   * 之后再启动虚拟机的，只需要输入`vagrant up` && `vagrant ssh`
> * <font color=red>问题</font>
>   * virtual box 安装的过程中，可能和本地软件存在冲突，如360，红蜘蛛，净网大师等

### 2. 虚拟机网络配置

> * `virtual box` 通过`设置`查看 虚拟机`网络`的默认链接方式为 `网络地址转换 NAT` 和 `端口转发的方式`，**对开发不方便**
> * 将虚拟机配置成通过IP地址访问，修改vagrantFile文件中，打开private_network那一行。然后重启虚拟机 `vagrant reload`
>   * 重启之后，查看虚拟机和主机是否能够ping通

### 3. 虚拟机常见命令

> * ip addr 获取虚拟机网路地址

