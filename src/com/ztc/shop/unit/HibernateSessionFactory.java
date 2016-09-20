package com.ztc.shop.unit;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Description：HibernateSessionFactoryUnitClass
 * Created by ZTCJoe on 2016/9/14.
 */
public class HibernateSessionFactory {
    private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
    private static org.hibernate.SessionFactory sessionFactory = null;
    private static Configuration configuration = null;
    private static ServiceRegistry serviceRegistry = null;
    //静态块，在第一次加载时创建SessionFactory
    static {
        try {
            configuration = new Configuration().configure();
            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private HibernateSessionFactory() {
    }

    //获取当前线程Session
    public static Session getSession() {
        Session session = threadLocal.get();
        if (session == null || !session.isOpen()) {
            if (sessionFactory == null) {
                rebuildSessionFactory();
            }
            session=(sessionFactory!=null)?sessionFactory.openSession():null;
        }
        return session;
    }
    //当当前线程SessionFactory不存在是调用此方法从新创建SessionFactory
    public static void rebuildSessionFactory() {
        try {
            configuration = new Configuration().configure();
            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }
        catch (Exception e){
            System.out.println("create sessionFactory error");
            e.printStackTrace();
        }
    }
    //关闭当前线程的session
    public static void closeSession(){
        Session session=threadLocal.get();
        threadLocal.set(null);
        if (session!=null){
            session.close();
        }
    }
    //返回一个SessionFactory
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
