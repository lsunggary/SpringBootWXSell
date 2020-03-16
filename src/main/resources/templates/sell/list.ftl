<html>
    <head>
        <meta charset="utf-8">
        <title>卖家商品列表</title>
        <link href="https://cdn.bootcss.com/twitter-bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <table class="table table-striped table-hover">
                        <thead>
                        <tr>
                            <th>订单Id</th>
                            <th>姓名</th>
                            <th>手机号</th>
                            <th>地址</th>
                            <th>金额</th>
                            <th>订单状态</th>
                            <th>支付状态</th>
                            <th>创建时间</th>
                            <th colspan="2">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list orderPage.content as orderDTO>
                            <tr>
                                <th>${orderDTO.orderId}</th>
                                <th>${orderDTO.buyerName}</th>
                                <th>${orderDTO.buyerPhone}</th>
                                <th>${orderDTO.buyerAddress}</th>
                                <th>${orderDTO.orderAmount}</th>
                                <th>${orderDTO.orderStatusEnum.message}</th>
                                <th>${orderDTO.payStatusEnum.message}</th>
                                <th>${orderDTO.createTime}</th>
                                <th>详情</th>
                                <th>取消</th>
                            </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    <script>
        var webSocket = null;
        if ('WebSocket' in window) {
            webSocket = new WebSocket('ws://localhost:8080/webSocket');
        } else {
            alert('该浏览器不支持websocket');
        }

        webSocket.onopen = function (event) {
            console.log('建立链接');
        }
        webSocket.onclone = function (event) {
            console.log('断开链接');
        }

        webSocket.onmessage = function (event) {
            console.log('收到消息' + event.data)
            alert(event.data);
        }

        webSocket.onerror = function () {
            alert("websocket通信发生错误！")
        }

        window.onbeforeunload = function () {
            webSocket.close();
        }
    </script>
    </body>
</html>