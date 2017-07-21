//BF code interpreter in java
//96-4-26
//this code is written in java.
//this program is translated from the original c++ program to be used by android studio.
//by efran.
//public email: ekm507@chmail.ir
//private email: ekm507@gmail.com

//

//program class.
//temporary -- for debugging.
//after releasing the experiment version you can remove todo tag below
//TODO



//these codes should be run when app starts.
public class MainActivity extends AppCompatActivity {

	private ActivityMainBinding binding;

	//The code from input.
	private String code;
	//size of interpreting memory.
	public static final int memorySize=3000;
	//Memory of system for interpreting.
	private byte[] memory = new byte[memorySize];
	//the command.
	private char statement;
	//code pointer.
	private int p;
	//memory pointer.
	private int q=0;
	//size of block stack.
	public static final int blockStack_size=100;
	//a stack that block opens' ([) positions are stored.
	private int[] blockStack = new int[blockStack_size]; 
	//number of items in stack(that make sence!).
	private int blockStack_last=0;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		binding = DataBindingUtil.setContentView(this, R.layout.activity_main);		
		binding.buttonZero.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
        		      
				//code input.
				code = binding.editText.getText().toString();//TODO
				//size of code.
				codeSize=code.length();
				//interpreting part.
				for(p = 0; p < codeSize; p++)
				{
					//read a command
					statement=code.charAt(p);
					//command case..
					//+: increase value of memory block you are at.
					if(statement == '+')
						memory[q]++;
					//-: decrease value of memory block you are at.
					else if( statement == '-')
						memory[q]--;
					//>: go to next memory block.
					else if(statement == '>')
					{
						q++;
						if(q > memorySize)
							q=0;
					}
					//<: go to previous memory block.
					else if(statement == '<')
					{
						q--;
						if(q < 0)
							q=memorySize;
					}
					//.: print value of memory block as an ASCII character.
					else if(statement == '.')
					{
						//push a char to output.TODO
					binding.infoTextView.setText(binding.infoTextView.getText().toString()+memory[q]);
					}
					//," get value of memory block as an ASCII character.
					else if(statement == ',')
					{
						//push a char input char to memory.
						//TODO
						//how to get an input?
						//whats your idea?
						memory[q]=70;//temporary
					}
					//code block start.
					else if(statement == '[')
					{
						//if memory block value is not zero enter the block.
						//and save block start position in a stack.
						if(memory[q])
						{
							blockStack[blockStack_last]=p;
							blockStack_last++;
						}
						//otherwise get out of block.
						else
						{
							int z=1;
							while(z > 0)
							{
								p++;
								statement=code.charAt(p);
								if(statement == '[')
									z++;
								else if(statement == ']')
									z--;
							}
						}
					}
					//code block end.
					else if(statement == ']')
					{
						//if memory block value is not zero go to block start.
						if(memory[q])
							p=blockStack[blockStack_last-1];
						//otherwise continue parsing from next command.
						else
							blockStack_last--;
					}
				}
		 	
        		}
		});
	}
}

// Have fun!
//coded by: efran
