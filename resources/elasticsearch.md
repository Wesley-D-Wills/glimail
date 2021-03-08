# ElasticSearch



[toc]

------

## 1. 简介

开源搜索与分析引擎

* Index (索引)

  动词，相当于MySql中的inser

  名词，相当于MySql中的Database

* Type (类型)

  在Index（索引）中，可以定义一个或多个类型

  类似于MySql中Table，每一种类型的数据放在一起；

* Document （文档）

  保存在某个索引（Index）下，某种类型（Type）的一个数据（Document），**文档是Json格式的**，Document就像是MySql中的某个Table里面的内容。



## 2. Docker安装ES

1. 下载镜像文件

   ```shell
   docker pull elasticsearch:7.4.2 # 存储和检索数据
   docker pull kibana:7.4.2 # 可视化检索数据，【也可以不装】
   ```

   

2. 创建实例

   * ElasticSearch

   ```shell
   mkdir -p /mydata/elasticsearch/config # 
   mkdir -p /mydata/elasticsearch/data # 创建数据以及配置目录 
   echo "http.host: 0.0.0.0" >> /mydata/elasticsearch/config/elasticsearch.yml # 写配置到yml文件，代表es可以被任意远程进行访问
     
   docker run --name elasticsearch -p 9200:9200 -p 9300:9300 \ # 9200：http请求  9300：es在分布式状态下，节点通信端口
   -e "discovery.type=single-node" \  # es以单节点运行
   -e ES_JAVA_OPTS="-Xms64m -Xmx128m" \ # 这一块很重要，如果不设置es启动将会把内存全部占用，虚拟机将会卡死。本语句是：初始设置64M，最大128M
   -v /mydata/elasticsearch/config/elasticsearch.yml:/usr/share/elasticsearch/config/elasticsearch.yml \
   -v /mydata/elasticsearch/data:/usr/share/elasticsearch/data \
   -v /mydata/elasticsearch/plugins:/usr/share/elasticsearch/plugins \
   -d elasticsearch:7.4.2 # 以后台的方式启动elasticsearch 利用elasticsearch:7.4.2镜像
   
   启动失败可能是因为权限没有开启 ,如果启动成功忽略下面两行：
   chmod -R /mydata/elasticsearch
   docker start [Container ID前面三位]
   
   此外以后再外面装插件即可；
   特别注意：
   -e ES_JAVA_OPTS="Xms256m -Xmx256m" \ 测试环境下，设置ES初始内存和最大内存，否则导致过大启动不了ES
   ```

   

   ```shell
   测试ElasticSearch
   1. http://192.168.56.10:9200 # 给elasticsearch发送请求，ip为虚拟机地址
   {
   	"name": "CONTAINER ID",
   	"cluster_name": "elasticsearch",
   	"cluster_uuid": "xxx",
   	"version": {
   		"number": "7.4.2",
   		...
   	}, 
   	"tagline": "You know, for search"
   }
   
   2. http://192.168.56.10:9200/_cat # 能够查询节点相关信息
   http://192.168.56.10:9200/_cat/nodes
   ```

   

   

   * Kibana

   ```shell
   docker run -name kibana -e ELASTICSEARCH_HOSTS=http://192.168.56.10:9200 -p 5601:5601 \
   -d kibana:7.4.2
   
   注意：
   http://192.168.56.10:9200 一定要改为自己虚拟机的地址
   ```

   

## 3. 初步检索

1. _cat

   ```shell
   Get /_cat/nodes # 查询所有节点    “可以使用postman---get---http://192.168.56.10:9200/_cat/nodes”
   Get /_cat/heath # 查询es健康状况
   Get /_cat/master # 查询主节点
   Get /_cat/indices # 查询所有索引，相当于MySql中的show databases
   ```

2. 索引一个文档（保存）

   ```shell
   PUT && POST
   1. PUT
   保存一个数据，保存在哪个索引的哪个类型下，指定用哪个唯一标识
   PUT customer/extern/1: 在custemer索引下的external类型下保存1号数据为
   
   PUT customer/extern/1		# “可以使用postman---PUT---http://192.168.56.10:9200/customer/extern/1”
   {
   	"name": "John Doe"
   }
   创建成功的返回信息如下: 
   带"_"的被称为元数据，反映了当前的基本信息。
   当同一命令被发送多次为更新操作。
   {
   	"_index": "customer", # 那个索引
   	"_type": "external", # 哪个类型
   	"_id": "1", # 刚保存的数据id
   	"_version": 1, # 数据版本， 当第二次提交版本不断叠加 result变成update
   	"result": "created", # 第一次保存，为新建
   	"_shards": {
   		"total": 2,
   		"successful": 1,
   		"failed": 0
   	},
   	"_seq_no": 0, 
   	"_primary_term": 1
   }
   
   2. POST
   PUT 和 POST都可以保存数据。
   POST新增。如果不指定id,会自动生成id。指定id，并且该id之前有数据就会修改这个数据，并新增版本号，若该id没有数据则新增。
   PUT可以新增可以修改。PUT必须指定id；由于PUT需要指定id，我们一般都用来做修改操作，不指定id会报错。
   ```

   