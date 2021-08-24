package com.example.demo.thread.local;

import org.springframework.core.NamedThreadLocal;

import java.util.HashMap;
import java.util.Map;

/**
 * @author blindskipper
 * @scope 全链路压测、多租户、链路追踪等需要保存链路线程上下文隔离传递场景;局限不能跨application传递
 */
public class TestThreadLocal {

    private ThreadLocal<Route> routeThreadLocal = new NamedThreadLocal<Route>("route:"){
        @Override
        protected Route initialValue() {
            return new Route(0,null,null,null);
        }
    };

    {
        routeThreadLocal.set(new Route(1,"http://k8s.clusterIp.svc:8080",
                new HashMap<String,String>(){
                    {put("key","value");}
                },Thread.currentThread()));
    }

    public static void main(String[] args) {
        TestThreadLocal testThreadLocal = new TestThreadLocal();
        System.out.println(testThreadLocal.routeThreadLocal.get());
    }

    class Route{
        private int id;
        private String url;
        private Map<String,String> meteData;
        private Thread thread;

        public Route(int id, String url, Map<String, String> meteData, Thread thread) {
            this.id = id;
            this.url = url;
            this.meteData = meteData;
            this.thread = thread;
        }

        @Override
        public String toString() {
            return "Route{" +
                    "id=" + id +
                    ", url='" + url + '\'' +
                    ", meteData=" + meteData +
                    ", thread=" + thread +
                    '}';
        }
    }
}
