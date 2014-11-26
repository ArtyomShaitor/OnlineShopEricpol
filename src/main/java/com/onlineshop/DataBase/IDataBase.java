package com.onlineshop.DataBase;

import com.onlineshop.classes.*;

import java.util.List;
import java.util.Map;

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
     * Поиск товара по бренду
     * @param brandName название бренда
     * @return коллекция товаров
     */
    public List<Good> searchItemsByBrand(String brandName);
}
