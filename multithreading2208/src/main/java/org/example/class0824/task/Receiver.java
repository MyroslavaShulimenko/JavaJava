package org.example.class0824.task;

// //Этот класс представляет получателя данных.
//    //
//    //Создайте переменную receivedData с типом int для хранения принятых данных.
//    //Создайте метод receiveData(int data), который принимает данные в качестве аргумента
//    //сохраняет их в переменную receivedData.
//    //Создайте метод getReceivedData(), который возвращает текущие принятые данные.
//    //
public  class Receiver {
 private int  receivedData=0;

  public void    receiveData(int data){
          this.receivedData  =data;
  }
   public int getReceivedData(){
       System.out.println("receivedData ="+receivedData);
        return this.receivedData ;

   }
}
