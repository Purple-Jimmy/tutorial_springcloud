### consul 安装
1. 下载:https://www.consul.io/
2. 上传:/usr/local/bin
3. 解压:
```
unzip consul_1.2.2_linux_amd64.zip 
```
4. 验证:
```
[root@VM-6e650661-ceb0-4308-9737-63dcd1f8a6b6 bin]# consul 
Usage: consul [--version] [--help] <command> [<args>]

Available commands are:
    agent          Runs a Consul agent
    catalog        Interact with the catalog
    connect        Interact with Consul Connect
    event          Fire a new event
    exec           Executes a command on Consul nodes
    force-leave    Forces a member of the cluster to enter the "left" state
    info           Provides debugging information for operators.
    intention      Interact with Connect service intentions
    join           Tell Consul agent to join cluster
    keygen         Generates a new encryption key
    keyring        Manages gossip layer encryption keys
    kv             Interact with the key-value store
    leave          Gracefully leaves the Consul cluster and shuts down
    lock           Execute a command holding a lock
    maint          Controls node or service maintenance mode
    members        Lists the members of a Consul cluster
    monitor        Stream logs from a Consul agent
    operator       Provides cluster-level tools for Consul operators
    reload         Triggers the agent to reload configuration files
    rtt            Estimates network round trip time between nodes
    snapshot       Saves, restores and inspects snapshots of Consul server state
    validate       Validate config files/directories
    version        Prints the Consul version
    watch          Watch for changes in Consul
```

#### 常用命令
* 查看版本:./consul version
* 查看成员:./consul members -detailed
```
[root@VM-6e650661-ceb0-4308-9737-63dcd1f8a6b6 ~]# consul members
Node                                     Address         Status  Type    Build  Protocol  DC   Segment
VM-6e650661-ceb0-4308-9737-63dcd1f8a6b6  127.0.0.1:8301  alive   server  1.2.2  2         dc1  <all>
```
* 相关信息:./consul info




#### 启动
* 开发模式启动:consul agent -dev
* 服务模式启动:consul agent -server


#### 开放防火墙
```
firewall-cmd --zone=public --add-port=8500/tcp --permanent
firewall-cmd --reload
firewall-cmd --query-port=8500/tcp
```


#### Consul web-ui 8500端口实现公网访问 https://my.oschina.net/longhtml/blog/1623136
1. linux安装rinetd
```
yum install -y gcc g++ autoconf make telnet 

wget http://www.boutell.com/rinetd/http/rinetd.tar.gz

tar -xvf rinetd.tar.gz  

cd rinetd

sed -i 's/65536/65535/g' rinetd.c 

mkdir -pv /usr/man && make && make install
```
2. 编辑配置文件,将所有发往本机37170端口的请求转发到127.0.0.1的8500端口
```
vi /etc/rinetd.conf

0.0.0.0 37170 127.0.0.1 8500   
logfile /var/log/rinetd.log

#格式
bindaddress   bindport   connectaddress   connectport
绑定的地址     绑定的端口   连接的地址        连接的端口
```

3. 启动:rinetd
4. 访问:http:ip:37170/ui