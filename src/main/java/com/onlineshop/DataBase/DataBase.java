package com.onlineshop.DataBase;

import com.onlineshop.classes.Brand;
import com.onlineshop.classes.Good;
import com.onlineshop.classes.Type;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;


/**
 * Created by HOME on 25.11.2014.
 */
public class DataBase implements IDataBase{

    private SessionFactory sessionFactory;
    private Session session;

    public DataBase(){
        sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
    }

    protected void finalize() {
        session.close();
    }

    /**
     * Добавление нового типа товара
     *
     * @param title имя типа
     */
    @Override
    public void addType(String title) {
        Type type = new Type();
        type.setTitle(title);
        addObject(type);
    }

    /**
     * Удаление типа
     *
     * @param id
     */
    @Override
    public void removeType(Long id) {

    }

    /**
     * Добавление нового бренда
     *
     * @param title имя бренда
     */
    @Override
    public void addBrand(String title) {
        Brand brand = new Brand();
        brand.setTitle(title);
        addObject(brand);
    }

    /**
     * Удаление бренда
     *
     * @param id
     */
    @Override
    public void removeBrand(Long id) {

    }

    /**
     * Создание нового администратора
     *
     * @param login
     * @param password
     */
    @Override
    public void addAdmin(String login, String password) {

    }

    /**
     * Удаление администратора
     *
     * @param id
     */
    @Override
    public void removeAdmin(Long id) {

    }

    /**
     * Добавление нового товара
     *
     * @param title       Имя
     * @param type_id     Тип
     * @param description Описание
     * @param price       Цена
     * @param admin_id    Id администратора, владеющего правами на данный товар
     * @param brand_id    брэнд
     * @param cover_url   url обложки
     */
    @Override
    public void addGood(String title, Long type_id, String description, double price, Long admin_id, Long brand_id, String cover_url) {

    }

    /**
     * Удаление товара
     *
     * @param id
     */
    @Override
    public void removeGood(Long id) {

    }

    /**
     * Поиск товара по бренду
     *
     * @param brandName название бренда
     * @return коллекция товаров
     */
    @Override
    public List<Good> searchItemsByBrand(String brandName) {
//        session.beginTransaction();
        List<Good> list = session.createSQLQuery("SELECT * FROM onlineshop_db.good WHERE brand_id=(SELECT id FROM onlineshop_db.brand WHERE brand.title=\""+brandName+"\")").list();
        return list;
    }

    /**
     * Начало транзакции, добавление объекта obj в БД, заверешние транзакции
     * @param obj Объект
     */
    private void addObject(Object obj){
        session.beginTransaction();
        session.save(obj);
        session.getTransaction().commit();
    }

}
