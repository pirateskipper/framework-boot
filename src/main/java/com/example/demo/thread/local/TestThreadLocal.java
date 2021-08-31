package com.example.demo.thread.local;

import org.springframework.core.NamedThreadLocal;

import java.util.HashMap;
import java.util.Map;

/**
 * @author blindskipper
 * @scope 全链路压测、多租户、链路追踪等需要保存链路线程上下文隔离传递场景;局限不能跨application传递
 * @desc
 *    1.设置弱引用key:ThreadLocal
 *    2.map hashcode设置[]
 *
 */
public class TestThreadLocal {

    /**
     * 是否设置为static
     */
    private static ThreadLocal<Route> routeThreadLocal = new NamedThreadLocal<Route>("route:"){
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
        System.out.println(routeThreadLocal.get());
        routeThreadLocal.remove();
    }

   static class Route{
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
