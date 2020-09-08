#include<iostream>
using namespace std;

void calculate_codeword()
{
	int div_size, dataword_size;

	cout<<"\nEnter Divisor size:- ";
	cin>>div_size;
	int divisor[div_size];
	cout<<"\nEnter Divisor bits separated by space:- ";
	for(int i=0;i<div_size;i++)
		cin>>divisor[i];

	cout<<"\nEnter Dataword size :- ";
	cin>>dataword_size;
	int data[dataword_size + div_size - 1];
	int code[dataword_size + div_size - 1];
	cout<<"\nEnter Dataword bits separated by space:- ";
	for(int i=0;i<dataword_size;i++)
		cin>>data[i];

	for(int i=dataword_size;i<dataword_size+div_size-1;i++)
		data[i] = 0;

	int temp[dataword_size + div_size - 1];
	for(int i=0;i<dataword_size+div_size-1;i++)
		temp[i] = data[i];

	for(int i=0;i<dataword_size;i++)
	{
		if(temp[i]==1)
		{
			for(int j=0;j<div_size;j++)
			{
				if(temp[j+i]==divisor[j])
					temp[j+i] = 0;
				else
					temp[j+i] = 1;
			}
		}
	}
	for(int i=0;i<dataword_size;i++)
		code[i] = data[i];
	for(int i=dataword_size;i<dataword_size+div_size-1;i++)
		code[i] = temp[i];
	cout<<"\nCodeword is :- ";
	for(int i=0;i<dataword_size+div_size-1;i++)
		cout<<code[i];
	cout<<endl<<endl;	
}

void check_received_codeword()
{
	int div_size, codeword_size;

	cout<<"\nEnter Divisor size:- ";
	cin>>div_size;
	int divisor[div_size];
	cout<<"\nEnter Divisor bits separated by space:- ";
	for(int i=0;i<div_size;i++)
		cin>>divisor[i];
	
	cout<<"\nEnter Codeword size:- ";
	cin>>codeword_size;
	int code[codeword_size];
	cout<<"\nEnter Codeword bits separated by space:- ";
	for(int i=0;i<codeword_size;i++)
		cin>>code[i];

	int temp[codeword_size];
	for(int i=0;i<codeword_size;i++)
		temp[i] = code[i];

	for(int i=0;i<codeword_size-div_size+1;i++)
	{
		if(temp[i]==1)
		{
			for(int j=0;j<div_size;j++)
			{
				if(temp[j+i]==divisor[j])
					temp[j+i] = 0;
				else
					temp[j+i] = 1;
			}
		}
	}
	int rem[div_size-1];
	cout<<"\nRemainder bits are:- ";
	for(int i=0;i<div_size-1;i++)
	{
		rem[i] = temp[codeword_size-div_size+1+i];
		cout<<rem[i];
	}
	cout<<endl;
	int flag=0;
	for(int i=0;i<div_size-1;i++)
	{
		if(rem[i]==1)
		{
			flag = 1;
			break;
		}
	}
	if(flag==1)
	{
		cout<<"\nFrame contains Error...\n";
	}
	else
	{
		cout<<"\nFrame is correct...\n";
	}
}

int main()
{
	int ch;
	do
	{
		cout<<"\n1: Calculate Codeword";
		cout<<"\n2: Check Received Codeword";
		cout<<"\n3: Exit";
		cout<<"\nEnter your choice : ";
		cin>>ch;
		switch(ch)
		{
			case 1:
				calculate_codeword();
				break;
			case 2:
				check_received_codeword();
				break;
			case 3:
				break;
		}
	}while(ch!=3);
	return 0;
}