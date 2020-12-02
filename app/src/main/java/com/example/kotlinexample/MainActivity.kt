package com.example.kotlinexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    val num1=25
    val num2=20
    val num3=30
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ifCondition()
        whenExpression()
        forLoop()
        whileLoop()
        doWhileLoop()
        breakEx()
        continueEx()
        val sum=sum(10,20)
        Log.d("tag", "parameterized fn sum:$sum")
        val myLambda:(Int)->Unit={s:Int->Log.d("tag","$s")}
        lambda(5,10,myLambda)
        array()



    }

    private fun ifCondition(){
        val result=if(num1<num2)"$num2 is greater" else "$num1 is smaller"
        Log.d("tag", "result:$result")

        val compare=if(num1>0){
          "$num1 is positive"
        }
        else if (num1<0) {
            "$num1 is negative"
        }
        else{
            "$num1 is zero"
        }
        Log.d("tag", "compare:$compare")


        val nested=if(num1>num2){
            val max=if(num1>num3){
                "$num1 is greater"
            }
            else{
               "$num1 is smaller"
            }
            Log.d("tag", "nested max:$max")
        }
        else{
               num1
        }

    }

   private fun whenExpression(){
       var num=200
       var i = when (num) {
           1 -> "one"
           2 ->"two"
           20 ->"twenty"
           else -> "invalid"
       }
       Log.d("tag","when:number provided $i")


   }
    private fun forLoop() {
        val marks = arrayOf(60,45,34,56,47)
        for (item in marks){
            Log.d("tag", "items$item")
        }
        for (item in marks.indices){
            Log.d("tag", "marks[$item]"+marks[item])
        }
    }

    private fun whileLoop(){
        var i=1
        while(i<=5){
            Log.d("tag", "while:$i")
            i++
        }
    }

    private fun doWhileLoop(){
        var i=7
        do {
            Log.d("tag", "dowhile:$i")
            i++
        }
            while (i<=6);
    }

    private fun breakEx() {
      loop@ for (i in 1..5) {
            for (j in 1..5) {
                Log.d("tag", "break:$i and $j")

                if (i == 3) {
                    break@loop;
                }
            }
        }
      }

    private fun continueEx() {
        loop@ for (i in 1..5) {
            for (j in 1..5) {
                Log.d("tag", "continue:$i and $j")

                if (i == 3) {
                    continue@loop;
                }
            }
        }
    }

    private fun sum(numa:Int,numb:Int): Int {
        return numa+numb

    }

    private fun lambda(a:Int,b:Int,myLambda:(Int)->Unit){
        val add=a+b
        myLambda(add)

    }

    private fun array(){
        val array1= arrayOf(1,2,3,4,5)
        for(elements in array1){
            array1.set(2,4)
            array1[4]=8
            Log.d("tag","array1:$elements")
        }
        Log.d("tag","get array value:${array1.get(0)}")
    }
}