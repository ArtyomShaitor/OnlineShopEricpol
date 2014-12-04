package com.onlineshop.DataBase;

import com.onlineshop.classes.Good;

import java.util.List;

/**
 * Created by HOME on 26.11.2014.
 */
public interface IDataBase {
    /**
     * Добавление нового типа товара
     * @param title имя типа
     */
    public void addType(String title);

    /**
     * Удаление типа
     * @param id
     */
    public void removeType(Long id);

    /**
     * Добавление нового бренда
     * @param title имя бренда
     */
    public void addBrand(String title);

    /**
     * Удаление бренда
     * @param id
     */
    public void removeBrand(Long id);

    /**
     * Создание нового администратора
     * @param login
     * @param password
     */
    public void addAdmin(String login, String password);

    /**
     * Удаление администратора
     * @param id
     */
    public void removeAdmin(Long id);

    /**
     * Добавление нового товара
     * @param title Имя
     * @param type_id Тип
     * @param description Описание
     * @param price Цена
     * @param admin_id Id администратора, владеющего правами на данный товар
     * @param brand_id брэнд
     * @param cover_url url обложки
     */
    public void addGood(String title, Long type_id, String description, double price, Long admin_id, Long brand_id, String cover_url);

    /**
     * Удаление товара
     * @param id
     */
    public void removeGood(Long id);

    /**
     * Получить список всех типов
     * @return
     */
    public List<Type> getTypesList();

    /**
     * Получить список всех брендов
     * @return
     */
    public List<Brand> getBrandsList();

    /**
     * Получить список товаров из каталога в диапазоне
     * @param from от
     * @param to до
     * @return список товаров
     */
    public List<Good> getGoodsInInterval(int from, int to);

    /**
     * Получить список товаров по указанной цене
     * @param list список
     * @param min_price минимальная цена
     * @param max_price максимальная цена
     * @return коллекция
     */
    public List<Good> getGoodsBetweenPrice(List<Good> list, double min_price, double max_price);

    /**
     * Поиск товара по бренду
     * @param brandName название бренда
     * @return коллекция товаров
     */
    public List<Good> searchItemsByBrand(String brandName);

    /**
     * Поиск товара по типу
     * @param typeName название бренда
     * @return коллекция товаров
     */
    public List<Good> searchItemsByType(String typeName);

    /**
     * Поиск товара по типу и бренду
     * @param brandName название бренда
     * @param typeName тип
     * @return коллекция
     */
    public List<Good> searchItemsByBrandAndType(String brandName, String typeName);

    /**
     * Поиск товара по запросу
     * @param query запрос
     * @return коллекция товаров
     */
    public List<Good> searchItemsByQuery(String query);

    /**
     * Получить полную информацию о товаре
     * @param id название товара
     * @return объект
     */
    public Good getCatalogItem(Long id);

}
