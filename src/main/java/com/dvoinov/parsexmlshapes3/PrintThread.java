package com.dvoinov.parsexmlshapes3;

import sun.applet.Main;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Date;
import java.util.Iterator;

/**
 * Created by Михаил on 11.10.2015.
 */
public class PrintThread  implements Runnable  {

    public void run() {
        Date startTime = new Date();

        try
        {
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(java.io.FileDescriptor.out), "utf-8"), 512);
            int i = 0; //счетчик циклов задержки работы второго потока
            while (i < 20) { //таким образом ждем завершения наполнения коллекции парсером

                if (!MainClass.shapes.isEmpty()){ //если в коллекции что-то есть, считаем площадь и выводим на печать

                    if(MainClass.shapes.peek() instanceof Circle)
                    {
                        double area = ((Circle) MainClass.shapes.peek()).calcShapeArea(((Circle) MainClass.shapes.peek()).getDiameter());
                        ((Circle) MainClass.shapes.peek()).setShapeArea(area);
                    }
                    else if(MainClass.shapes.peek() instanceof Rectangle)
                    {
                        double sideA = ((Rectangle) MainClass.shapes.peek()).getSide().get(0);
                        double sideB = ((Rectangle) MainClass.shapes.peek()).getSide().get(1);
                        double area = ((Rectangle) MainClass.shapes.peek()).calcShapeArea(sideA, sideB);
                        ((Rectangle) MainClass.shapes.peek()).setShapeArea(area);
                    }
                    else if(MainClass.shapes.peek() instanceof Square)
                    {
                        double area = ((Square) MainClass.shapes.peek()).calcShapeArea(((Square) MainClass.shapes.peek()).getSide());
                        ((Square) MainClass.shapes.peek()).setShapeArea(area);

                    }
                    else if(MainClass.shapes.peek() instanceof Triangle)
                    {
                        double sideA = ((Triangle) MainClass.shapes.peek()).getSide().get(0);
                        double sideB = ((Triangle) MainClass.shapes.peek()).getSide().get(1);
                        double sideC = ((Triangle) MainClass.shapes.peek()).getSide().get(1);
                        double area = ((Triangle) MainClass.shapes.peek()).calcShapeArea(sideA, sideB, sideC);
                        ((Triangle) MainClass.shapes.peek()).setShapeArea(area);
                    }

                    out.write(MainClass.shapes.peek().toString() + '\n');
                    MainClass.shapes.poll();

                        i = 0;//сбрасываем счетчик циклов ожидания

                } else {//иначе, если коллекция пуста
                    Thread.sleep(10);//ждем 10 мс
                    i++;//увеличиваем счетчик циклов ожидания
                    //System.out.println("Второй поток ждет!");
                }
            }
            out.flush();//очищаем буфер
        }
        catch (Exception e)
        {//ловим любое исключение и выводим его на печать
            System.out.println("Второй поток прерван: " + e.getLocalizedMessage() + " " + e.getCause() + " " + e.toString());
        }

        Date endTime = new Date();
        long dif = endTime.getTime() - startTime.getTime();//считаем время вывода объектов в консоль

        System.out.println("Потоком парсера обработано " + (MainClass.index - 1) + " фигур за " + MainClass.parsingTime + " мс. Поток печати работал " + dif + " мс");//сообщаем о завершении обработки
    }
    }
