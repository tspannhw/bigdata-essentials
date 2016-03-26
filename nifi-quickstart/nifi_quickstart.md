
# nifi quickstart

* Open the nifi web browser after installations <http://localhost:8080/nifi/>

![web browser](https://github.com/bigdataguide/bigdata-essentials/blob/master/bigdata-essentials-doc/src/main/doc/images/nifi-quickstart/01_nifi_ui.png)

* Drag the process icon(as shown below) into the ruled white board.

![Nifi processor](https://github.com/bigdataguide/bigdata-essentials/blob/master/bigdata-essentials-doc/src/main/doc/images/nifi-quickstart/02_toolbar.png)

* search getfile and select getfile processor

![Edit config](https://github.com/bigdataguide/bigdata-essentials/blob/master/bigdata-essentials-doc/src/main/doc/images/nifi-quickstart/03_add_getfile.png)

* click add and you see processor added

![processor added](https://github.com/bigdataguide/bigdata-essentials/blob/master/bigdata-essentials-doc/src/main/doc/images/nifi-quickstart/04_get_file_processor_added.png)

* Right click on the processor, click configure and enter following options as shown below.

![processor config](https://github.com/bigdataguide/bigdata-essentials/blob/master/bigdata-essentials-doc/src/main/doc/images/nifi-quickstart/05_config_get_file.png)

* In the similar way config puthdfs

![puthdfs config](https://github.com/bigdataguide/bigdata-essentials/blob/master/bigdata-essentials-doc/src/main/doc/images/nifi-quickstart/06_config_put_hdfs.png)

* Join 2 processors and click add, you can see success is the condition.

![join 2 processors](https://github.com/bigdataguide/bigdata-essentials/blob/master/bigdata-essentials-doc/src/main/doc/images/nifi-quickstart/07_join_2_processors.png)

* After join you can see as below

![after join 2 processors](https://github.com/bigdataguide/bigdata-essentials/blob/master/bigdata-essentials-doc/src/main/doc/images/nifi-quickstart/08_after_joining_processors.png)

* The processors should show Red, but puthdfs shows yellow. hover on that yellow, you see sucess & failure routes not configured.

![yellow message](https://github.com/bigdataguide/bigdata-essentials/blob/master/bigdata-essentials-doc/src/main/doc/images/nifi-quickstart/09_yellow_message.png)

* Right click -> configure -> settings -> select both checks as below

![success_failure](https://github.com/bigdataguide/bigdata-essentials/blob/master/bigdata-essentials-doc/src/main/doc/images/nifi-quickstart/10_add_failure_success.png)

* you can see process flow is constructed.

![flow constructed](https://github.com/bigdataguide/bigdata-essentials/blob/master/bigdata-essentials-doc/src/main/doc/images/nifi-quickstart/11_process_flow.png)

* select every thing and press start button (green) in tool bar and see results as below.

![results](https://github.com/bigdataguide/bigdata-essentials/blob/master/bigdata-essentials-doc/src/main/doc/images/nifi-quickstart/12_results.png)

