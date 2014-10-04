/* 
 * File:   main.cpp
 * Author: Samael
 *
 * Created on 10 styczeń 2014, 23:42
 */

#include <cstdlib>
#include <iostream>
using namespace std;


using namespace std;

int _tmain(int argc, _TCHAR* argv[])
{
 int x;
 cout << "Podaj zmienna x: "  << endl;
 cin >> x;
 int y;
 cout << "Podaj zmienna y: "  << endl;
 cin >> y;
 int z;
 cout << "Podaj zmienna z: "  << endl;
 cin >> z;
 int w;
 __asm{
  pushf;
  mov eax, x;
  mov ebx, y;
  mov ecx, z;
  cmp eax, ebx;
  jnc Mexit:
  cmp ebx, ecx;
  jnc Mexit3:
  mov w, ecx;
Mexit:
  cmp eax, ecx;
  jnc Mexit2:
Mexit2:
  mov w, eax;
Mexit3:
  cmp ebx, ecx;
  jnc Mexit4:
Mexit4:
  mov w, ebx;
  popf;
 }
 cout << " Maksymalna to: " << w;
 system("PAUSE");
 return 0;
}

