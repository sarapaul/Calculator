import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Calculator implements ActionListener
{
 JFrame frame;
 JPanel numberpanel;
 JTextField textfield;
 JButton numbers[] = new JButton[10];
 JButton[] functions = new JButton[7];
 JButton add, subtract, multiply, divide, decimal, equals, clear;
 
 double num1 = 0, num2 = 0, result = 0;
 char operator;
 Calculator()
 {
 frame = new JFrame("Calculator");
 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 frame.setSize(325, 440);
 frame.setLayout(null);
 textfield = new JTextField();
 textfield.setBounds(5, 5, 300, 50);
 textfield.setEditable(false);
 
 numberpanel = new JPanel();
 numberpanel.setBounds(5, 95, 300, 300);
 numberpanel.setLayout(new GridLayout(4, 4, 5, 5));
 divide = new JButton("/");
 multiply = new JButton("X");
 subtract = new JButton("-");
 add = new JButton("+");
 decimal = new JButton(".");
 equals = new JButton("=");
 clear = new JButton("CLR");
 clear.setBounds(5, 60, 300, 30);
 functions[0] = divide;
 functions[1] = multiply;
 functions[2] = subtract;
 functions[3] = add;
 functions[4] = decimal;
 functions[5] = equals;
 functions[6] = clear;
 for(int i = 0; i < 7; i++)
 {
 functions[i].addActionListener(this);
 functions[i].setFocusable(false);
 }
 for (int i = 0; i < 10; i++)
 {
 numbers[i] = new JButton(String.valueOf(i));
 numbers[i].addActionListener(this);
 numbers[i].setFocusable(false);
 }
 numberpanel.add(numbers[7]);
 numberpanel.add(numbers[8]);
 numberpanel.add(numbers[9]);
 numberpanel.add(divide);
 numberpanel.add(numbers[4]);
 numberpanel.add(numbers[5]);
 numberpanel.add(numbers[6]);
 numberpanel.add(multiply);
 numberpanel.add(numbers[1]);
 numberpanel.add(numbers[2]);
 numberpanel.add(numbers[3]);
 numberpanel.add(subtract);
 numberpanel.add(numbers[0]);
 numberpanel.add(decimal);
 numberpanel.add(equals);
 numberpanel.add(add);
 frame.add(numberpanel);
 frame.add(clear);
 frame.add(textfield);
 frame.setVisible(true);
 }
 public void actionPerformed(ActionEvent e)
 {
 for(int i = 0; i < 10; i++)
 {
 if(e.getSource() == numbers[i])
 textfield.setText(textfield.getText().concat(String.valueOf(i)));
 }
 if(e.getSource() == divide)
 {
 num1 = Double.parseDouble(textfield.getText());
 operator = '/';
 textfield.setText("");
 }
 
 if(e.getSource() == multiply)
 {
 num1 = Double.parseDouble(textfield.getText());
 operator = '*';
 textfield.setText("");
 }
 if(e.getSource() == subtract)
 {
 num1 = Double.parseDouble(textfield.getText());
 operator = '-';
 textfield.setText("");
 }
 if(e.getSource() == add)
 {
 num1 = Double.parseDouble(textfield.getText());
 operator = '+';
 textfield.setText("");
 }
 if(e.getSource() == decimal)
 textfield.setText(textfield.getText().concat("."));
 
 if(e.getSource() == equals)
 {
 num2 = Double.parseDouble(textfield.getText());
 switch(operator)
 {
 case '/': try
 {
 if(num2 == 0)
 throw new ArithmeticException();
 result = num1 / num2;
 textfield.setText(String.valueOf(result));
 }
catch(ArithmeticException ex)
{
 textfield.setText("Error");
num1 = num2 = result = 0;
 }
break;
 case '*': result = num1 * num2;
 textfield.setText(String.valueOf(result));
 break;
 case '-': result = num1 - num2;
 textfield.setText(String.valueOf(result));
break;
 
 case '+': result = num1 + num2;
 textfield.setText(String.valueOf(result));
break;
 }
 num1 = result;
 }
 if(e.getSource() == clear)
 {
 textfield.setText("");
 num1 = num2 = result = 0;
 }
 }
}
public class MainCalculator
{
 public static void main(String args[])
 {
 new Calculator();
 }
}