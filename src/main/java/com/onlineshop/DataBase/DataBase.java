package com.onlineshop.DataBase;

import org.apache.commons.lang.StringUtils;
import com.onlineshop.classes.*;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.engine.JoinSequence;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


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
        Good good = new Good();
        good.setTitle(title);
        good.setType(type_id);
        good.setBrand(brand_id);
        good.setAdmin(admin_id);
        good.setDescription(description);
        good.setPrice(price);
        good.setCover_url(cover_url);
        addObject(good);
    }

    /**
     * Удаление товара
     *
     * @param id
     */
    @Override
    public void removeGood(Long id) {
        Good good = (Good) session.createSQLQuery("SELECT * FROM onlineshop_db.good WHERE id="+id.toString()).addEntity(Good.class).list().get(0);
        if(good != null) removeObject(good);
    }

    /**
     * Получить список всех типов
     *
     * @return
     */
    @Override
    public List<Type> getTypesList() {
        List<Type> list = (List<Type>) session.createSQLQuery("SELECT * FROM onlineshop_db.type").addEntity(Type.class).list();
        return list;
    }

    /**
     * Получить список всех брендов
     *
     * @return
     */
    @Override
    public List<Brand> getBrandsList() {
        List<Brand> list = (List<Brand>) session.createSQLQuery("SELECT * FROM onlineshop_db.brand").addEntity(Brand.class).list();
        return list;
    }

    /**
     * Получить список товаров из каталога в диапазоне
     *
     * @param from от
     * @param to   до
     * @return список товаров
     */
    @Override
    public List<Good> getGoodsInInterval(int from, int to) {
        List<Good> list = (List<Good>) session.createSQLQuery("SELECT * FROM onlineshop_db.good").addEntity(Good.class).list();
        return list;
    }

    /**
     * Получить список товаров по указанной цене
     *
     * @param list список
     * @param min_price минимальная цена
     * @param max_price максимальная цена
     * @return коллекция
     */
    @Override
    public List<Good> getGoodsBetweenPrice(List<Good> list, double min_price, double max_price) {
        List<Good> result = new ArrayList<Good>();
        for(Good good : list){
            double price = good.getPrice();
            if( price <= max_price && price >=min_price )
                result.add(good);

        }
        return result;
    }

    /**
     * Поиск товара по бренду
     *
     * @param brandName название бренда
     * @return коллекция товаров
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<Good> searchItemsByBrand(String brandName) {
        List<Good> list = (List<Good>) session.createSQLQuery("SELECT * FROM onlineshop_db.good WHERE brand_id=(SELECT id FROM onlineshop_db.brand WHERE brand.title=\""+brandName+"\")").addEntity(Good.class).list();
        return list;
    }

    /**
     * Поиск товара по типу
     *
     * @param typeName название бренда
     * @return коллекция товаров
     */
    @Override
    public List<Good> searchItemsByType(String typeName) {
        List<Good> list = (List<Good>) session.createSQLQuery("SELECT * FROM onlineshop_db.good WHERE type_id=(SELECT id FROM onlineshop_db.type WHERE type.key=\""+typeName+"\")").addEntity(Good.class).list();
        return list;
    }

    /**
     * Поиск товара по типу и бренду
     *
     * @param brandName название бренда
     * @param typeName тип
     * @return коллекция
     */
    @Override
    public List<Good> searchItemsByBrandAndType(String brandName, String typeName) {
        if (brandName == null && typeName == null)
            return this.getGoodsInInterval(0,0);
        if ( brandName == null )
            return this.searchItemsByType(typeName);
        if ( typeName == null )
            return this.searchItemsByBrand(brandName);
        return (List<Good>) session.createSQLQuery("SELECT * FROM onlineshop_db.good WHERE type_id=(SELECT id FROM onlineshop_db.type WHERE type.key=\""+typeName+"\") AND brand_id=(SELECT id FROM onlineshop_db.brand WHERE brand.title=\""+brandName+"\")").addEntity(Good.class).list();
    }

    /**
     * Поиск товара по запросу
     *
     * @param query запрос
     * @return коллекция товаров
     */
    @Override
    public List<Good> searchItemsByQuery(String query) {
        String[] stringArray = query.split("[,. ]");
        for(int i = 0; i<stringArray.length; i++){
            stringArray[i] = "'%"+stringArray[i]+"%'";
        }
        String stringQuery = StringUtils.join(stringArray, " or ");
        List<Good> list = (List<Good>) session.createSQLQuery("SELECT * FROM onlineshop_db.good WHERE title like " + stringQuery).addEntity(Good.class).list();
        return list;
    }

    /**
     * Получить полную информацию о товаре
     *
     * @param id название товара
     * @return объект
     */
    @Override
    public Good getCatalogItem(Long id) {
        List<Good> list = (List<Good>) session.createSQLQuery("SELECT * FROM onlineshop_db.good WHERE id=\""+id.toString()+"\"").addEntity(Good.class).list();
        return list.get(0);
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

    private void removeObject(Object obj){
        session.beginTransaction();
        session.delete(obj);
        session.getTransaction().commit();
    }

    public void editGood(Long id, String title, Long type_id, String description, double price, Long admin_id, Long brand_id, String cover_url){
        session.beginTransaction();
        Good good = this.getCatalogItem(id);
        good.setTitle(title);
        good.setType(type_id);
        good.setBrand(brand_id);
        good.setAdmin(admin_id);
        good.setDescription(description);
        good.setPrice(price);
//
        if(cover_url.length() != 0)
            good.setCover_url(cover_url);
        session.update(good);
        session.getTransaction().commit();
    }

}
