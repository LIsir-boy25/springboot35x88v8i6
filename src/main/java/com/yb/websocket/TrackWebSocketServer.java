package com.yb.websocket;

import com.alibaba.fastjson.JSONObject;
import jakarta.websocket.*;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

@Component
@ServerEndpoint("/websocket/track/{orderId}")
public class TrackWebSocketServer {
    public static ConcurrentHashMap<String, Session> sessionPool = new ConcurrentHashMap<>();

    @OnOpen
    public void onOpen(Session session, @PathParam("orderId") String orderId) {
        sessionPool.put(orderId, session);
        System.out.println("订单连接："+orderId);
    }

    @OnClose
    public void onClose(@PathParam("orderId") String orderId) {
        sessionPool.remove(orderId);
    }

    @OnMessage
    public void onMessage(String message, @PathParam("orderId") String orderId) {}

    @OnError
    public void onError(Session session, Throwable e) {
        e.printStackTrace();
    }

    // 推送定位给前端
    public static void sendInfo(String orderId, JSONObject object) {
        Session session = sessionPool.get(orderId);
        if(session!=null && session.isOpen()){
            try {
                session.getBasicRemote().sendText(object.toJSONString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}