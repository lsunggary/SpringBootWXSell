package com.imooc.sell.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @ClassName WebSocket
 * @Description
 * @Author 47980
 * @Date 2020/3/16 23:37
 * @Version V_1.0
 **/
@Component
@ServerEndpoint("/webSocket")
@Slf4j
public class WebSocket {

    private Session session;

    /**
     * 定义容器 储存session
     */
    private static CopyOnWriteArraySet<WebSocket> webSockets = new CopyOnWriteArraySet<>();

    @OnOpen
    public void opOpen(Session session) {
        this.session = session;
        webSockets.add(this);
        log.info("[WEBSOKCET] 有新链接， 总数:{}", webSockets.size());
    }

    @OnClose
    public void onClonse () {
        webSockets.remove(this);
        log.info("[WEBSOKCET] 链接断开， 总数:{}", webSockets.size());
    }

    @OnMessage
    public void onMessage (String message) {
        log.info("[WEBSOKCET] 收到客户端发来的消息：{}", message);
    }

    public void sendMessage(String message) {
        for (WebSocket webSocket: webSockets) {
            log.info("[WEBSOKCET] 广播消息：{}", message);
            try {
                webSocket.session.getBasicRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
