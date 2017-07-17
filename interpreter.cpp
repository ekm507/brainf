/*
TODO:
s در استفاده از اشاره گر به حافظه ی فایل به برنامه و هم چنین در استفاده از پشته بدون تعریف کردنش اشتباه کرده ام.


*/
#include <iostream>
#include <fstream>
#include <stack>

using namespace std;

int main()
{
	char* memory;
	long long pointer;
    stack <long> scope_stack;
	ifstream hardware;
	hardware.open("hardware");
	long long hardware_size;
	hardware >> hardware_size;
	memory=new char sizeof(char)*hardware_size; //اصلاحش کنم اگر اشتباه است. TODO
	hardware.close();

	pointer=hardware_size/2;
	ifstream source;
	source.open("source.bf");

	char command;
	while(!source.eof())
	{
		source >> command;

			if(command=='+')
			memory[pointer]++;

		else if(command=='-')
			memory[pointer]--;

		else if(command=='>')
			pointer++;

		else if(command=='<')
			pointer--;

		else if(command=='.')
			cout << memory[pointer];

		else if(command==',')
			cin >> memory[pointer];

		else if(command=='[')
			scope_stack.push_back(source);//TODO: خط فعلی برنامه را در پشته ای ذخیره کن.

		else if(command==']')
			if((*pointer))
			{
				source=scope_stack.last()//TODO: در فایل برنامه به عقب برگرد
			}
			else
				scope_stack.pop_back();
	}
	source.close();

	return 0;
}


