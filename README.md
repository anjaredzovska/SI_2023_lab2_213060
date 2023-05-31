# Втора лабораториска вежба по Софтверско
# инженерство
# Ања Реџовска, бр. на индекс 213060
# Control Flow Graph



Цикломатска комплексност
![Alt Text](./SILab2.drawio.png)
Цикломатската комплексност во овој случај е 11. Ја добив преку броење на региони но, поради дополнителна проверка и со користење на формулата: E - N + 2P, каде E е бројот на edges, N е бројот на јазли, P е бројот на поврзани компоненти.

Тест случаи според критериумот Every branch
pateka 1.new User=(null, anja, anjared.gmail.com) 2.new User=(Anja, anja3456, anjared.gmail.com) 3.new User=(Anja, anja*+34, anjared@gmail.com) 4.new User=(Anja, a nja +34, anjaredz@gmail.com) pateka new User=(null, anja, anjared.gmail.com) new User=(Anja, anja3456, anjared.gmail.com) new User=(Anja, anja+34, anjared@gmail.com new User=(Anja, a nja *+34, anjaredz@gmail.com) 5.user null-веднаш паѓа
Потребни ми беа 5 test cases. Првиот за RuntimeException, вториот за да нема @ во email, третиот за во password да има специјални знаци, и четвртиот да има празно место во password, ако user e null кодот не продолжува.
pateka	1.new User=(null, anja, anjared.gmail.com)	2.new User=(Anja, anja3456, anjared.gmail.com) 	3.new User=(Anja, anja*+34, anjared@gmail.com	4.new User=(Anja, a nja *+34, anjaredz@gmail.com)	5.user null
							
![image](https://github.com/anjaredzovska/SI_2023_lab2_213060/assets/108877884/deca8f00-cdb3-423a-95fd-0b7d862758cc)


Тест случаи според критериумот Multiple Condition
Потребни ми беа 4 тестови(за проверка Т || T || T = T, но секогаш кога на почеток на Т резултатот е Т-точен). if(user==null||user.getPassword()==null||user.getEmail()==null) 
// T || T/F || T/F = T
    // F || F || F = F
    // F || T || T/F = T
    // F || F || T = T
# Објаснување на напишаните unit tests
Unit тестовите се користат за да се исполнат сите зададени услови и да се поминат сите exceptions. Искористив assertThrows за да проверам дали фрла exception. И за двата вида на критериуми користев 4 услови:
За Every Branch прво сите патеки ги поминав, па ги користев случаевите каде корисничкото име е погрешно напишано, или лозинката има карактери, празни места, како и маилот без @. Тоа го проверував со try catch и со дадените објекти од класата.
За Every path користев 4 случаи: Бидејќи овој логички оператор дава вредност F-неточно ако и двете вредноти се неточни, пробав повеќе на точните крајни вредности да обрнам внимание. Со нивна комбинација и со assertTrue проверував дали точен е exception.
