package com.dvoinov.parsexmlshapes3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Михаил on 09.10.2015.
 */
public class MainClass {

    public static ConcurrentLinkedQueue<Shape> shapes = new ConcurrentLinkedQueue<Shape>(); //создаем коллекцию для объектов
    public static long index=1; //счетчик-нумератор обрабатываемых фигур
    public static long parsingTime = 0; //счетчик времени парсинга


    public static String getSubstring(String s)
    {
        return s.substring(s.indexOf(">")+1,s.indexOf("<",s.indexOf(">")));
    }

    public static void parse(BufferedReader inputFile) throws IOException //пока не обрабатываем все исключения
    {
        String currentFileString;


        while ((currentFileString = inputFile.readLine()) != null)
        {
                    String str = currentFileString.trim();//отбрасываем пробелы, чтобы гарантировано определить слэш

                    if (str.indexOf("/") != 1) {//если второй символ в проверяемой строке не слеш, то понимаем, что это не конец блока
                        String s1 = str.substring(str.indexOf("<") + 1, str.indexOf(">"));//извлекаем тег

                        if (s1.equals("circle")) { // если тег - circle
                            Circle circle = new Circle();// создаем объект круг
                            circle.setIndex(index);//назначаем фигуре индекс
                            circle.setColor(getSubstring(inputFile.readLine()));//смотрим на строку вперед и извлекаем цвет
                            circle.setDiameter(Double.parseDouble(getSubstring(inputFile.readLine())));//смотрим на строку вперед и извлекаем диаметр
                            shapes.add(circle);//добавляем фигуру в общий список
                            index++;
                        } else if (s1.equals("triangle")) {
                            Triangle triangle = new Triangle();
                            triangle.setIndex(index);//назначаем фигуре индекс
                            triangle.setColor(getSubstring(inputFile.readLine()));//смотрим на строку вперед и извлекаем цвет
                            triangle.addSide(Double.parseDouble(getSubstring(inputFile.readLine())));//смотрим на три строки вперед,
                            triangle.addSide(Double.parseDouble(getSubstring(inputFile.readLine())));//получаем стороны треугольника,
                            triangle.addSide(Double.parseDouble(getSubstring(inputFile.readLine())));//и добавляем стороны в список
                            shapes.add(triangle);//добавляем фигуру в общий список
                            index++;
                        } else if (s1.equals("rectangle")) {
                            Rectangle rectangle = new Rectangle();
                            rectangle.setIndex(index);//назначаем фигуре индекс
                            rectangle.setColor(getSubstring(inputFile.readLine()));//смотрим на строку вперед и извлекаем цвет
                            rectangle.addSide(Double.parseDouble(getSubstring(inputFile.readLine())));// получаем одну сторону
                            rectangle.addSide(Double.parseDouble(getSubstring(inputFile.readLine())));//получаем вторую сторону
                            shapes.add(rectangle);//добавляем фигуру в общий список
                            index++;
                        } else if (s1.equals("square")) {
                            Square square = new Square();
                            square.setIndex(index);//назначаем фигуре индекс
                            square.setColor(getSubstring(inputFile.readLine()));//смотрим на строку вперед и извлекаем цвет
                            square.setSide(Double.parseDouble(getSubstring(inputFile.readLine())));//получаем сторону квадрата
                            shapes.add(square);//добавляем фигуру в общий список
                            index++;
                        }
                    }
        }
    }



    public static void main(String[] args) throws IOException{

        BufferedReader inputFile;
        inputFile = new BufferedReader(new FileReader(args[0]));

        Thread t = new Thread(new PrintThread());//создаем второй поток для расчета площади и печати фигур
        t.start(); //запускаем второй поток для печати уже распознанных и посчитанных фигур

        Date d1 = new Date();
        parse(inputFile); //запускаем парсинг файла
        Date d2 = new Date();
        parsingTime = d2.getTime()-d1.getTime();//считаем время парсинга файла
    }
}

