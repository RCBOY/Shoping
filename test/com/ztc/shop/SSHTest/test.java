package com.ztc.shop.SSHTest;

import org.hibernate.HibernateException;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Test;

/**
 * Description：
 * Created by ZTCJoe on 2016/9/14.
 */
public class test {
      private static Configuration configuration = null;
      private static org.hibernate.SessionFactory sessionFactory = null;
     private static ServiceRegistry serviceRegistry = null;
    @Test
         public static void main(String[] args) {
             try {
                       configuration = new Configuration().configure();
                      serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
                      sessionFactory = configuration.buildSessionFactory(serviceRegistry);
                 System.out.print(sessionFactory);
                   } catch (HibernateException e) {
                       e.printStackTrace();
                     }

         }

}
