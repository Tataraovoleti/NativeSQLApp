/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import java.util.Iterator;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author TATARAO
 */
public class Client {
    
    public static void main(String[] args) {
        
        Session session= new Configuration().configure().buildSessionFactory().openSession();

   /* Insertion
        
        SQLQuery query=session.createSQLQuery("insert into employee values(?,?,?)");
        query.setParameter(0,new String("125"));
        query.setParameter(1,new String("sanjay"));
        query.setParameter(2,new String("50000"));
        
        Transaction tx=session.beginTransaction();
        int x=query.executeUpdate();
        tx.commit();
        System.out.println(x+ "rows inserted");
     */   
             
        SQLQuery query=session.createSQLQuery("select * from employee");
        List l=query.list();
        Iterator itr=l.iterator();
        
        while(itr.hasNext())
        {
            Object r[]=(Object[])itr.next();
            System.out.println(r[0]+" "+r[1]+" "+r[2]); 
/*            Employee emp=(Employee)itr.next();
            System.out.println(emp.getEid()+" "+emp.getEname()+" "+emp.getSalary());   */
      }
        session.close(); 
    }
    
}
