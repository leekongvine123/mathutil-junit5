/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.vinh.mathutil.core;

import com.giaolang.mathutil.core.MathUtil;
//import static la danh rieng cho nhung ham static
//goi ham ma bo qua ten class
import static com.giaolang.mathutil.core.MathUtil.getFactorial;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.function.Executable;



/**
 *
 * @author Admin
 */
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runners.Parameterized;

public class MathUtilTest {
    //chơi DDT, tách data ra khỏi câu lệnh kiểm thử, tham số hóa data này 
    //vào trong câu lệnh kiểm thử
    
    
    
    //chuẩn bị bộ data
    public static Object[][] initData(){
        return new Integer[][]{
                {1,1},
                {2,2},
                {5,120},
                {6,720},
               
        };
    }
    
    
@ParameterizedTest
@MethodSource(value="initData")//tên hàm cung cấp data
//ngầm định thứ tự ủa các phần tử mảng
//,ap vào tham số hàm
public void testGetFactorialGivenRightArgReturnsWell(int input, long expected){
    assertEquals(expected,getFactorial(input));
    
    
}
    
//  @Test
//  public void testGetFactorialGivenRightArgReturnsWell(){
//    assertEquals(1,getFactorial(1));
//    
//    
//}
  //Bắt ngoại lệ khi đưa data cà chớn
   @Test
  public void testGetFactorialGivenWrongArgThrowException(){
  //Xài biểu thức Lambda
  //hàm nhận tham số thứ 2 là 1 cái object/có code implemt cái
  //functional interface tên là excutable - có 1 hàm duy nhất ko code
  // tên là excutable()
  //chơi chậm
//  Executable exobject = new Executable() {
//      @Override
//      public void execute() throws Throwable {
//
//          getFactorial(-5);
//      }
//  };
  Executable exObject = () -> getFactorial(-5);
      assertThrows(IllegalArgumentException.class,() -> getFactorial(-5));
  }

}