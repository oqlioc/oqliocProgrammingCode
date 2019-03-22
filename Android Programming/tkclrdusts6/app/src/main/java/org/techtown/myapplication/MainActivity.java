package org.techtown.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Random rnd; //랜덤클래스로 부터 객체 생성
    String ret;
    int num1,num2,num3;
    Button click;
    String compare;
    EditText result1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rnd = new Random();                         //랜덤클래스로부터 랜덤 값 받아오는 변수 작성.
        Button btn = (Button) findViewById(R.id.btn1);
        btn.setOnClickListener(t);
    }

    Button.OnClickListener t = new Button.OnClickListener() {
        public void onClick(View v) {
            Button button1 = (Button) findViewById(R.id.button1);
            Button button2 = (Button) findViewById(R.id.button2);
            Button but_result = (Button) findViewById(R.id.btn_result1);
            click = (Button) findViewById(R.id.btn_result1);
            Button btn = (Button) findViewById(v.getId());
            result1 = (EditText) findViewById(R.id.input_result);
            num1 = rnd.nextInt(100);
            num2 = rnd.nextInt(100);
            num3 = num1 + num2;

            compare = Integer.toString(num3);
            //Toast.makeText(getApplicationContext(), num + "", Toast.LENGTH_LONG).show();             //버튼을 누르면 0부터 100까지의 랜덤값의 메시지가 나타난다.
            String IntToString1 = Integer.toString(num1);
            String IntToString2 = Integer.toString(num2);


            button1.setText(IntToString1);
            button2.setText(IntToString2);

            Button op1 = (Button) findViewById(R.id.op1);         //  +, -, *, / 랜덤생성
            String[] chars = {"+", "-", "*", "/"};
            int r = (int) (Math.random() * 3);   // 나누기 제외함
            op1.setText(chars[r]);

            Button op0 = (Button) findViewById(R.id.op0);         // 랜덤숫자 버튼을 누르면 "="이 생성
            op0.setText("=");


            click.setOnClickListener(new Button.OnClickListener() {
                public void onClick(View v)
                {
                    Editable str = result1.getText();
                    ret = str.toString();
                    if(compare.equals(ret) )
                    {
                        Intent intent = new Intent(MainActivity.this, sub1Activity.class);
                        startActivity(intent);
                    } else
                    {
                        Toast.makeText(getApplicationContext(), "정답은"+compare+"이고 입력값은 :"+ret+"입니다.", Toast.LENGTH_LONG).show();
                    }
                }
            });
            /*
                 final Button click = (Button)findViewById(R.id.button);
        click.setOnClickListener(new Button.OnClickListener(){

         public void onClick(View v) {
          String str="검은";

          EditText edte=(EditText)findViewById(R.id.edittext);

          if(edte.getText().toString()==str) {
           Intent intent = new Intent(black1.this, Help.class);
           startActivity(intent);
          }

//          else {
//           TextView tevi;
//           int LENGTH_TO_SHOW = Toast.LENGTH_SHORT;
//           tevi=(TextView)findViewById(R.id.textview);
//           Toast.makeText(black1.this,tevi.getText().toString(),LENGTH_TO_SHOW).show();
//          }
         }
        });
             */

        /*
         //  result 정답
            Button result1 = (Button) findViewById(R.id.result1);
            int result0 = 0;
            switch (r) {
                case 0:
                    result0 = num1 + num2;
                    break;
                case 1:
                    result0 = num1 - num2;
                    break;
                case 2:
                    result0 = num1 * num2;
                    break;
                case 3:
                    result0 = (float)num1 / num2;
                    break;
            }
            String IntToString3 = Float.toString(result0);
            result1.setText(IntToString3);
            */
        }
    };
}
