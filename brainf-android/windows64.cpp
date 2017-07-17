#include <iostream>
#include <string>

using namespace std;

int main(void)
{
	string code;
	char statement;
	char memory[3000];
	long  p, q=0, code_size;
	long blockStack[100], blockStack_last=0;
	while(1)
	{
		cin >> code;
		code_size = code.size();
		for(p = 0; p < code_size; p++)
		{
			statement=code[p];
			if(statement == '+' )
				memory[q]++;
			else if(statement == '-' )
				memory[q]--;
			else if(statement == '>')
				q++;
			else if(statement == '<')
				q--;
			else if(statement == '.')
				cout << memory[q];
			else if(statement == ',')
				cin >> memory[q];
			else if(statement == '[')
			{
				if(!memory[q])
				{
					long z=1;
					while(z)
					{
						p++;
						if(code[p] == '[')
							z++;
						else if(code[p] == ']')
							z--;
					}
				}
				else
				{
					blockStack[ blockStack_last ] = p;
					blockStack_last++;
				}
			}
			else if(statement == ']')
			{
				if(memory[q])
                {
                    p = blockStack[ blockStack_last-1 ];
                    continue;
                }
				blockStack_last--;
			}
		}
		cout << "\n";
	}
	return 0;
}

