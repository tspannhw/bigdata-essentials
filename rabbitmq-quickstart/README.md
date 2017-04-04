## Rabbit MQ Quck start

### Installation

Installation on mac OSX can be easily done using [Homebrew](http://brew.sh/) with out worrying 
about conflicts.

```bash
## we are installing v3.5.1 using below command as root user.
brew install rabbitmq

## You might get one of these [errors](http://stackoverflow.com/questions/19039404/error-cowardly-refusing-to-sudo-brew-install-for-installing-glue-0-3-for-mac).

## Change to your user after the installation. Please give below permissions.

sudo chown "user" /usr/local/var/lib/rabbitmq/
sudo chown "user" /usr/local/var/log/rabbitmq/

```

You need to set the PATH variable too. Refer [here](http://stackoverflow.com/questions/23050120/rabbitmq-command-doesnt-exist)

Type "rabbitmq-server" to start the server.

You can open rabbit mq admin UI at http://localhost:15672/

Type "guest" "guest" as user and password"

![Rabbit mq installation](src/docs/images/rabbit_mq_install.png)

### 


