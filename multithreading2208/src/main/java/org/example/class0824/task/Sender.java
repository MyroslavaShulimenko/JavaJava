package org.example.class0824.task;

//Этот класс представляет отправителя данных.
//
//Создайте переменную dataToSend с типом int для хранения данных, которые будут отправлены.
//Создайте метод sendData(int data), который принимает данные в качестве аргумента и сохраняет
//их в переменную dataToSend.
//Создайте метод getDataToSend(), который возвращает текущие данные для отправки.
//
public class Sender {

  public int  dataToSend;

  public void   sendData(int data){

      dataToSend=data;
      System.out.println(getDataToSend());
  }
  public int  getDataToSend(){
      System.out.println("dataToSend = "+dataToSend);
      return dataToSend;
  }
}
